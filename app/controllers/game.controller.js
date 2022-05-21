const GameType = require("../models/gameType.model.js");



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


