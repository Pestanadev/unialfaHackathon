import { Router } from 'express'
import evento from './evento'

const routes = Router()

routes.use('/evento', evento)

export default routes