import { Router } from "express"
import knex from "../database/knex";
import { z } from "zod";
import { hash } from "bcryptjs";
import autenticacao from "../middlewares/autenticacao";

const router = Router();

// Rota para buscar todos os alunos
router.get("/", autenticacao ,async (req, res) => {
  knex('alunos').then((alunos) => {
    return res.json(alunos);
  })
})

// Rota para buscar um aluno específico pelo ID
router.get("/:id", autenticacao ,async (req, res) => {

  const { id } = req.params;

  const aluno = await knex('alunos').where({ id }).first();

  if (!aluno) {
    res.status(404).json({
      message: "Aluno não encontrado"
    })
  }

  res.json(aluno);
})

// Rota para cadastrar um novo aluno
router.post("/cadastrar", async (req, res) => {

  const alunoSchema = z.object({
    nome: z.string(),
    email: z.string().email(),
    senha: z.string().min(6),
    telefone: z.string(),
  })

  const { nome, email, senha, telefone } = alunoSchema.parse(req.body);

  const senhaHash = await hash(senha, 8);

  const [aluno] = await knex('alunos').insert({
    nome,
    email,
    senha: senhaHash,
    telefone
  })

  if (!aluno) {
    res.status(400).json({
      message: "Erro ao cadastrar aluno"
    })
  }

  res.status(201).json({
    message: "Aluno cadastrado com sucesso",
    aluno: {
      id: aluno,
      nome,
      email,
      telefone
    }
  })

})

// Rota para editar um aluno específico pelo ID
router.put("/editar/:id",autenticacao ,async (req, res) => {

  const updateAlunoSchema = z.object({
    nome: z.string(),
    email: z.string().email(),
    senha: z.string().min(6),
    telefone: z.string()
  })

  const { id } = req.params;
  const aluno = await knex('alunos').where({ id }).first();

  updateAlunoSchema.parse(req.body);


  const { nome, email, senha, telefone } = req.body;

  
  const senhaHash = senha ? await hash(senha, 8) : undefined;


  if (!aluno) {
    res.status(404).json({
      message: "Aluno não encontrado"
    })
    return;
  }

  try {
    updateAlunoSchema.parse(req.body);
  } catch (error) {
     res.status(400).json({
      message: "Dados inválidos"
    })
    return; 
  }

  await knex('alunos').where({ id }).update({
    nome: nome || aluno.nome,
    email: email || aluno.email,
    senha: senhaHash || aluno.senha,
    telefone: telefone || aluno.telefone
  })



  res.status(200).json({
    message: "Aluno atualizado com sucesso"
  })
})

// Rota para deletar um aluno específico pelo ID
router.delete("/deletar/:id", autenticacao ,async (req, res) => {
  const { id } = req.params;

  const aluno = await knex('alunos').where({ id }).first()

  if (!aluno) {
    res.status(404).json({
      message: "Aluno não encontrado"
    })
    return;
  }

  await knex('alunos').where({ id }).delete();

  res.status(200).json({
    message: "Aluno deletado com sucesso"})
})

export default router