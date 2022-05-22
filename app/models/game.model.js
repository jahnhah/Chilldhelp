const mongoose = require("./index").mongoose;

const GameSchema = new mongoose.Schema({
  media: {
    type: String,
    required: true
  },
  level: {
    type: Number,
    required: true
  },
  dimension: {
    type: Number
  },
  gametype: {
    type: String,
    ref: 'GameType',
    required: true  
  },
  number_game: {  
    type: Array,
  },
  result:{
    type:String
  },
  text_game: {  
    type: String,
  },
});

const Game = mongoose.model("Game", GameSchema);

module.exports = Game;


