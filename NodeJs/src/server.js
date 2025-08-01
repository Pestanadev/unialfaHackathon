import express from 'express'
import cors from 'cors'
import routes from './routes/index.js'
import { ZodError } from 'zod' 

const {Request, Response, NextFunction} = express;


// importando os módulos necessários

const app = express()

app.use(cors())
app.use(express.json())

//Definindo a porta do servidor
const PORT = 3001


//inicializando as rotas
app.use(routes)


app.use ((error, req, res, next) => {

    // Verifica se o cabeçalho já foi enviado, se já foi não envia mais resposta, apenas passa o erro para ser tratado
if (res.headersSent) {
    return next(error)
  }
  
    // Tratamento do caso de erro do headersSent
  if (error instanceof ZodError) {
    res.status(400).json({
        message: "Erro na validação dos dados",
        issues: error.format()
    })
    return
  }
  
  console.log(error)
    res.status(500).json({
        message: "Erro interno do servidor",
        error: error.message
    })  
    return
})



app.listen(PORT, () => {
console.log('Servidor rodando na porta:' + PORT)
})


