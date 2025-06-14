const config = require('../../../knexfile');
import knex from 'knex';

const conexao = knex(config.development)

export default conexao