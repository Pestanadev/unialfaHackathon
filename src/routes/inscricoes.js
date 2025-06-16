import { Router } from 'express'
import knex  from '../database/knex/index.js';
import autenticacao from "../middlewares/autenticacao.js";
import { z } from "zod";

const router = Router();

router.post("/:id", autenticacao, async (req, res) => {
  
    const { idEvento} = req.params;
    const userId = req.user.id;
    
    const inscricaoSchema = z.object({
        evento_id: z.number(),
        aluno_id: z.number(),
        data_inscricao: z.string().email()
    })

    const { evento_id, aluno_id, email, telefone } = inscricaoSchema.parse(req.body);

    const [inscricao] = await knex('inscricoes').insert({
        evento_id: idEvento,
        aluno_id: userId,
        data_inscricao: knex.fn.now(),
    });

    if (!inscricao){
        res.status(404).json({
            message: "não foi feita nenhuma inscrição"
        })
        return;
    }

    res.status(201).json({
        message: "Inscrição realizada com sucesso",
        inscricao: {
            id: inscricao,
            curso_id,
            nome,
            email,
            telefone
        }
    });
})

router.get("/", async (req, res) => {
    const inscritos = await knex('evento').whereIn('id', function() {
        this.select('evento_id').from('inscricoe').where('aluno_id', req.user.id)
    })
    
})

router.delete('/:id', autenticacao, async (req, res) => {

    const { id } = req.params;

    const inscricao = await knex('inscricoes').where({ id }).first();

    if (!inscricao) {
         res.status(404).json({
            message: "Inscrição não encontrada"
        })
        return
    }

    await knex('inscricoes').where({ id }).delete();

    res.status(200).json({
        message: "Inscrição deletada com sucesso"
    })


})

export default router;