const jwt = require("jsonwebtoken");
const config = require("../config/auth.config.js");

// Verify token
verifyToken = async (req,res,next) =>{

    try {
        let token = req.headers.token;
	
        if (!token) {
            return res.status(403).send({
               message: "No token provided!",
            });
        }
        await jwt.verify(token, config.secret, (err, decoded) => {
            if (err) {
              return res.status(401).send({
                message: "Unauthorized!",
              });
            }
            if (!decoded.id && !decoded.role)  return res.status(401).send({ message: "Unauthorized!"});
            req.userId = decoded.id;
            req.role = decoded.role;
            req.activate = decoded.activate;
            next();
        });
    } catch (error) {
        return res.status(500).send({
            message: "Unable to validate User token!",
        });
    }
}   


// Verify admin
isAdmin = (req,res,next) =>{
    try {
        if (req.role === "admin") {
            return next();
        }
        return res.status(403).send({
            message: "Require Admin Role!",
        });
    } catch (error) {
        return res.status(500).send({
            message: "Unable to validate User role!",
        });
    }
}


// isActivate
isActivate = (req,res,next) =>{
    try {
        if (req.activate  == "1") {
            return next();
        }
        return res.status(403).send({
            message: "Activate your account!",
        });
    } catch (error) {
        return res.status(500).send({
            message: "Unable to validate User Activation!",
        });
    }
}

const authJWT = {
    verifyToken,
    isAdmin,
    isActivate
}

module.exports = authJWT;