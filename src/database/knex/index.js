import config from '../../../knexfile.js';
import knex from 'knex';

const conexao = knex(config); 

export default conexao;