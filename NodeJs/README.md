# API RESTful em Node 

## Tree da minha API

```
 NodeJs/
├── src/
│   │   ├── database/      
│   │   │   │
│   │   │   ├── knex/
│   │   │   │   ├── migrations/
│   │   │   │   └── index.ts
│   │   │   └── hackaton.sql
│   │   │
│   │   ├── middleware/
│   │   │   └── autenticacao.ts
│   │   │
│   │   └── routes/
│   │       ├── alunos.ts
│   │       ├── evento.ts
│   │       ├── index.ts
│   │       └── login.ts
│   │
│   └── server.ts
├── .env
├── .gitignore
├── knexfile.js
├── package-lock.json
├── package.json
├── README.md
└── tsconfig.json 
```

## Explicação

### Src: principal pasta do Node, guarda as rotas, middlewares, database e o arquivo principal

#### database: fica o arquivo do banco mysql e a pasta knex que tem as migrations

#### middlewares: fica o arquivo de autenticação, onde é feito a autenticacao do token jwt 

#### routes: contém as rotas utilizadas pelo PHP para mostrar eventos, cadastrar alunos etc...

#### server.js: é onde se inicia o servidor, arquivo principal do projeto

### .env: contém o token 

### .gitignore: para ignorar a node_modules

### knexfile.js: configuração do knex para conectar ao banco e onde fica as migrations

### package-lock e package são onde ficam declarados os scripts e dependencias


