const path = require('path');


module.exports = {
    development: {
        client: 'mysql2',

        // define a conexão com o banco de dados
        connection: {
            host: 'localhost',
            user: 'root',
            password: '',
            database: 'hackathon'
        },

        // define o numero de conexões simultâneas
        pool: {
            min: 2,
            max: 10
        },

        //define a localização dos arquivos de migração
        migrations: {
            directory: path.resolve(__dirname, 
                'src', 
                'database', 
                'knex',
                'migrations')
        }
    }
}
