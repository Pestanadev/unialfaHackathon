import { Router } from 'express'
import evento from './evento'
import alunos from './alunos'
import login from './login'


// Importando os módulos de rotas
const routes = Router()

// Definindo as rotas principais
routes.use('/evento', evento)
routes.use('/alunos', alunos)
routes.use('/login', login)


export default routes