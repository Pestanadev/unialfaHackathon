import { Router } from 'express'
import evento from './evento.js'
import alunos from './alunos.js'
import login from './login.js'
import inscricoes from './inscricoes.js'

// Importando os módulos de rotas
const routes = Router()

// Definindo as rotas principais
routes.use('/evento', evento)
routes.use('/alunos', alunos)
routes.use('/login', login)
routes.use('/inscricoes', inscricoes)


export default routes