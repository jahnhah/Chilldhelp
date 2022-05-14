const mongoose = require("mongoose");

// raha data misy _id ny farany de objectId
// raha string de atao like
exports.generateData =  (data) =>{
    const keys = Object.keys(data);
    keys.forEach(element => {
       if (element.endsWith("_id")) {
           data[element] = mongoose.Types.ObjectId(data[element]);

       }
       if (typeof data[element] == "string") {
           data[element] = new RegExp(data[element].toLowerCase(),"i");
           console.log(data[element]);
       }
    });
    console.log(data);
    return data;
}