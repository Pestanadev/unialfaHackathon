import { Router } from 'express'
import knex  from '../database/knex';

const router = Router();

// Rota para buscar os eventos
router.get('/', async (req, res) => {
    knex('evento').then((evento) => {
        res.json(evento);
    })
})

// Rota para buscar um evento específico pelo ID
router.get('/:id', async (req, res) => {
     const { id } = req.params;

  const evento = await knex('evento').where({ id }).first();

    if (!evento) {
         res.status(404).json({
            message: "Evento não encontrado"
        })
        return;
    }
    
    res.json(evento);
})

export default router