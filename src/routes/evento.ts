import { Router } from 'express'
import knex  from '../database/knex';

const router = Router();

// Rota para buscar os eventos
router.get('/', async (req, res) => {
    knex('evento').then((evento) => {
        res.json(evento);
    })
})

export default router