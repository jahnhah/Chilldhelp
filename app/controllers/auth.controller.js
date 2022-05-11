const User = require("../models/user.model.js");
const mailer = require("../services/mailer.services.js");
const bcrypt = require("bcryptjs");
const config = require("../config/auth.config");
const jwt = require("jsonwebtoken");

const ROLES = []


// inscription -------------------------------------------------
// generate code 
// crypt your password
// sendMail

exports.inscription = async (request,response) => {
  request.body.role = "user";
  const user = new User(request.body);
  user.password = bcrypt.hashSync(user.password, 8);
  try {
    const code  =  Math.floor(1000 + Math.random() * 9000);
    user.code = ""+code;
    await user.save();
    await mailer.mail(request.body.email,code);
    response.status(200).send({
      status:200,
      message:"inscription finished!",
      data:{}
	  });
  } catch (error) {
    response.status(500).send({
      status:400,
      message:"inscription failed! error :"+error.message,
      data:{}
	  });
  }
}

// verify your email -------------[ mail , code ]------------------------------
// check email
// verify code
// create token
// save token in your session
// send token

exports.verifyEmail = async (request,response) => {
  try {
    const user = await User.findOne({email:request.body.email});
    if (user.code != ""+request.body.code || !user) {
      return response.status(400).send({
        message:"Code incorrect!",
        status:400,
        data:{}
      });
    }
    user.activate = 1;
    user.save();
    const token = jwt.sign({ id: user._id,role:user.role,activate:user.activate }, config.secret, {
      expiresIn: 86400, // 24 hours
    });
    request.session.token = token;
    const data = {
      user:user,
      token:token
    }
    response.status(200).send(data);
  } catch (error) {
    response.status(500).send(error);
  }
}

// login -------------------------------------------------------
// check user
    // find Mail
    // check password
// create token in your session
// send token

exports.login = async (request,response) => {
  try {
    const user = await User.findOne({email:request.body.email});
    if (!user) return response.status(404).send("Utilisateur non existant, Veuillez créer un compte!")
    const passwordIsValid = bcrypt.compareSync(
      request.body.password,
      user.password
    );
    if (!passwordIsValid) return response.status(404).send("Mot de passe incorrecte!");
    const token = jwt.sign({ id: user._id,role:user.role ,activate:user.activate }, config.secret, {
      expiresIn: 86400, // 24 hours
    });
    request.session.token = token
    const data = {
	status:200,
      user:user,
      token:token
    }
    response.status(200).send(data);
  } catch (err) {
    console.log(err);
    response.status(500).send(err);
  }
}

// logout
// delete token
exports.signout = async (req, res) => {
  try {
    req.session = null;
    return res.status(200).send({
      message: "You've been signed out!"
    });
  } catch (err) {
    this.next(err);
  }
};
