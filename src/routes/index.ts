import { Router } from 'express'
import eventos from './eventos'

const routes = Router()

routes.use('/eventos', eventos)

export default routes