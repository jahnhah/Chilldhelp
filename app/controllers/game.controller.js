const GameType = require("../models/gameType.model.js");
const Game = require("../models/game.model.js");



// Liste Game Type -------------------------------------------------

exports.listGameType = async (request,response) => {
    try {
        const doc = await GameType.find();
        if (doc[0] instanceof GameType){
            return response.status(200).send({
                status:200,
                message:"get data! OK",
                data:doc
            });
        } 
        return response.status(400).send({
            status:404,
            message:"Erreur ou Pas de donéé",
            data:{}
        })
    } catch (error) {
        response.status(500).send({
            status:500,
            message:"Erreur :"+error.message,
            data:doc
        });
    }
}


// Get Level game by Id Game
exports.getLevelGame = async (request,response) => {
    try {
        console.log(request.body);
        const doc = await Game.aggregate([
            {
              '$project': {
                'gametype': 1, 
                'level': 1
              }
            }, {
              '$match': {
                'gametype': request.body.gametype
              }
            }
        ]);
        console.log(doc.length);

        return response.status(200).send({
            status:200,
            message:"get data! OK",
            data:doc
        });
        
    } catch (error) {
        response.status(500).send({
            status:500,
            message:"Erreur :"+error.message,
            data:doc
        });
    }
}

// Get game by Id Game
exports.getGame = async (request,response) => {
    try {

        const doc = await Game.findById(request.body._id);
        console.log(doc);
        if (doc instanceof Game){
            return response.status(200).send({
                status:200,
                message:"get data! OK",
                data:doc
            });
        } 
        return response.status(400).send({
            status:404,
            message:"Erreur ou Pas de donéé",
            data:{}
        })
    } catch (error) {
        response.status(500).send({
            status:500,
            message:"Erreur :"+error.message,
            data:doc
        });
    }
}

