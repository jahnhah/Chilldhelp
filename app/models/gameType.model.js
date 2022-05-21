const mongoose = require("./index").mongoose;

const GameTypeSchema = new mongoose.Schema({
  name: {
    type: String,
    required: true,
    unique: true
  },
  image: {  
    type: String,
    required:true
  },
});

const GameType = mongoose.model("GameType", GameTypeSchema);

module.exports = GameType;


