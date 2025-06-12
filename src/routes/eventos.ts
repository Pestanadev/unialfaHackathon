import { Router } from 'express'
import knex  from '../database/knex';

const router = Router();

// Rota para buscar os eventos
router.get('/', async (req, res) => {
    knex('eventos').then((eventos) => {
        res.json(eventos);
    })
})

export default router