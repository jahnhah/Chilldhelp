const mongoose = require("mongoose");

const config = require('../config/db.config.js').dbConfig;

// prod
// mongoose.connect(
//     `mongodb+srv://${config.PROJECT}:${config.PASSWORD}@${config.CLUSTER}.mongodb.net/${config.DB}?retryWrites=true&w=majority`, 
//     {
//       useNewUrlParser: true,
//       useUnifiedTopology: true
//     }
// );

// dev
mongoose.connect(
  `mongodb://localhost:27017/i-asa`, 
  {
    useNewUrlParser: true,
    useUnifiedTopology: true
  }
);


exports.mongoose =  mongoose;    