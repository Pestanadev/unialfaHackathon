import { Request, Response, NextFunction } from "express";
import { verify } from "jsonwebtoken";
import 'dotenv/config';

function autenticacao(req: Request, res: Response, next: NextFunction) {
    const authHeader = req.headers.authorization;

    if (!authHeader) {
        res.status(401).json({ message: "Token inválido" })
        return;
    }

    const [, token] = authHeader.split(" ");

    try {
        const decoded = verify(token, process.env.TOKEN_SECRET!);

        next();
        return;
    }
    catch (error) {
        res.status(401).json({ message: "Token inválido" });
        return;
    }
}

export default autenticacao;
