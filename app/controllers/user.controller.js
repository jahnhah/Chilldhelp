const User = require("../models/user.model.js");
const bcrypt = require("bcryptjs");


exports.save = async (request,response) =>{
    const user = new User(request.body);
    user.password = bcrypt.hashSync(user.password, 8);
    try { 
      await user.save();
      response.status(200).send("User inserted!");
    } catch (error) {
      response.status(500).send(error);
    }
}

exports.find = async (request,response) =>{
  try {
    const doc = await User.findOne({_id:request.userId});
    if (doc instanceof User){
        return response.status(200).send(doc);
    } 
    return response.status(400).send("No data!")
  } catch (error) {
    response.status(500).send(error);
  }
}

exports.update = async (request,response) =>{
  try {
    const result = await User.findOneAndUpdate({_id:request.userId}, request.body, {
      returnOriginal: false
    });
    response.status(200).send(result);
  } catch (error) {
    response.status(500).send(error);
  }
}

exports.delete = async (request,response) =>{
  try {
    await User.deleteOne({_id:request.userId});
    response.status(200).send("Deleted completed")
  } catch (error) {
    response.status(500).send(error);
  }
}



