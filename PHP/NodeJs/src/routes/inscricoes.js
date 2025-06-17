import { Router } from 'express'
import knex from '../database/knex/index.js';

const router = Router();

// POST /inscricoes  (sem autenticação para inscrições abertas)
router.post("/", async (req, res) => {
    const {
        evento_id,
        nome,
        email,
        cep,
        estado,
        cidade,
        bairro,
        logradouro,
        aceito_termos
    } = req.body;

    // Validação simples (adicione Zod se quiser)
    if (!evento_id || !nome || !email) {
        return res.status(400).json({ erro: "Dados obrigatórios faltando" });
    }

    try {
        const [id] = await knex('inscricoes').insert({
            cod_evento: evento_id, // <-- campo correto para o join depois!
            nome_aluno: nome,
            email,
            cep,
            estado,
            cidade,
            bairro,
            logradouro,
            aceito_termos: aceito_termos ? 1 : 0,
            data_inscricao: knex.fn.now()
        });

        res.status(201).json({
            message: "Inscrição realizada com sucesso",
            inscricao: {
                id,
                cod_evento: evento_id,
                nome_aluno: nome,
                email,
                cep,
                estado,
                cidade,
                bairro,
                logradouro
            }
        });
    } catch (error) {
        res.status(400).json({ erro: error.message });
    }
});

// GET /inscricoes?email=...
router.get("/", async (req, res) => {
    const { email } = req.query;
    if (!email) {
        return res.status(400).json({ message: "Email é obrigatório" });
    }

    try {
        const eventos = await knex('inscricoes')
            .join('evento', 'inscricoes.cod_evento', '=', 'evento.cod')
            .where('inscricoes.email', email)
            .select(
                'evento.cod',
                'evento.nome',
                'evento.valor',
                'evento.urlImg',
                'evento.endereco',
                'evento.descricao',
                'evento.palestrante',
                'evento.organizacao',
                'evento.patrocinador',
                'evento.modalidade',
                'evento.data'
            );
        return res.json(eventos);
    } catch (error) {
        return res.status(500).json({ message: "Erro ao buscar eventos do usuário", error: error.message });
    }
});

export default router; 