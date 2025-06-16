import Router from 'express'
import knex from '../database/knex'
import { z } from 'zod';
import { compare } from 'bcrypt';
import { sign } from 'jsonwebtoken';


const router = Router();

// Rota para login
router.post('/', async (req, res) => {

    const loginSchema = z.object({
        email: z.string().email(), 
        senha: z.string().min(6),
    })

    const objectLogin = loginSchema.parse(req.body);

    
    const user = await knex('alunos')
    .where({ email: objectLogin.email })
    .first();

    // Verificando se o usuário existe
    if (!user) {
        res.status(404).json({ message: "Email ou senha incorretos." });
        return;
    }

    /* Verificando se a senha está correta e usando a função 
    compare do bcrypt para comparar a senha recebida com a senha armazenada*/

    const senhaCorreta = await compare(objectLogin.senha, user.senha);

    // Se a senha estiver incorreta, retorna um erro
    if (!senhaCorreta) {
        res.status(404).json({ message: "Email ou senha incorretos" });
        return;
    }

    // Se tudo estiver correto, gera um token JWT
    const token = sign(
        { id: user.id, email: user.email },
        process.env.TOKEN_SECRET!,
        {
            expiresIn: '1d'
        })

    res.status(200).json({
        message: "Login realizado com sucesso",
        token: token,
        aluno: user
    })
    return
})

export default router;