const controller = require("../controllers/user.controller.js");
const { authJwt } = require("../middleware/index.js");

module.exports = function (app) {
    app.post("/auth/user",[authJwt.verifyToken,authJwt.isAdmin,authJwt.isActivate],controller.save);
    app.get("/auth/user",[authJwt.verifyToken,authJwt.isActivate],controller.find);
    app.put("/auth/user",[authJwt.verifyToken,authJwt.isActivate],controller.update);
    app.delete("/auth/user",[authJwt.verifyToken,authJwt.isActivate],controller.delete);
}