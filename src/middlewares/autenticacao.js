import express from "express";
import  jwt from "jsonwebtoken";
import 'dotenv/config';

const { verify } = jwt;
const {Request, Response, NextFunction} = express;

function autenticacao(req, res, next) {
    const authHeader = req.headers.authorization;

    if (!authHeader) {
        res.status(401).json({ message: "Token inválido" })
        return;
    }

    const [, token] = authHeader.split(" ");

    try {
        const decoded = verify(token, process.env.TOKEN_SECRET)

         return next();
    }
    catch (error) {
        res.status(401).json({ message: "Token inválido" });
        return;
    }
}

export default autenticacao;
