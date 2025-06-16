import path from 'path'



export default {
  client: 'mysql2',
  connection: {
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'hackathon',
  },
  migrations: {
    directory: './src/database/knex/migrations'
  }} 
