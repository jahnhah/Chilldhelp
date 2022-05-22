const controller = require("../controllers/game.controller.js");
const { authJwt } = require("../middleware/index.js");

module.exports = function (app) {
    app.get("/game/gametype",[authJwt.verifyToken,authJwt.isActivate],controller.listGameType);
    app.post("/game/gameLevel",[authJwt.verifyToken,authJwt.isActivate],controller.getLevelGame);
    app.post("/game/gameStart",[authJwt.verifyToken,authJwt.isActivate],controller.getGame);
}