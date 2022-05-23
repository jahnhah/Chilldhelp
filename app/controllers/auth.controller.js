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
  console.log(request);
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
    let user = await User.findOne({email:request.body.email});
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
    console.log(token);
    user = {...user._doc,token:token};
    let data = user;
    response.status(200).send({
      message:"Code correct!",
      status:200,
      data:data
    });
  } catch (error) {
    response.status(500).send({
      message:"Code incorrect!"+error.message,
      status:400,
      data:{}
    });
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
    console.log(request.body);
    let user = await User.findOne({email:request.body.email});
    if (!user) return response.status(200).send({
      status:403,
      data:{},
      message:"User not recognize , Please create your account"
    })
    const passwordIsValid = bcrypt.compareSync(
      request.body.password,
      user.password
    );
    if (!passwordIsValid) return response.status(200).send({
      status:403,
      data:{},
      message:"Password incorrect!"
    });
    const token = jwt.sign({ id: user._id,role:user.role ,activate:user.activate }, config.secret, {
      expiresIn: 86400, // 24 hours
    });
    request.session.token = token;
    user = {...user._doc,token:token};
    const data = {
      status:200,
      data:user,
      message:"You are logged now!",
    }
    response.status(200).send(data);
  } catch (err) {
    console.log(err);
    response.status(200).send({
      status:500,
      data:{},
      message:"Error : "+err
    });
  }
}

// logout
// delete token                                                                                                            ,,,,,,,,,,,,,
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
