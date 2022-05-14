const controller = require("../controllers/auth.controller.js");
const middleware = require("../middleware/index.js");

module.exports = function (app) {
    app.post("/auth/user/inscription",controller.inscription);
    app.post("/auth/user/check",controller.verifyEmail);
    app.post("/auth/user/login",controller.login);
    app.get("auth/user/signout",[middleware.authJwt.verifyToken],controller.signout);   
}