# unialfaHackathon - PHP

Este diretório contém a camada **Front-End** do sistema de eventos UniALFA, desenvolvida em PHP orientado a objetos, com Bootstrap para o design e integração com a API Node.js.

## 📁 Estrutura das Pastas

- **PHP/classes/**  
  Classes utilitárias e de integração, como [`ApiComNode.php`](classes/ApiComNode.php) (responsável por consumir a API Node.js) e [`ViaCepService.php`](classes/ViaCepService.php) (consulta de CEP).

- **PHP/forms/**  
  Formulários de cadastro, login, edição de perfil e inscrição em eventos. Exemplo: [`cadastro.php`](forms/cadastro.php), [`login.php`](forms/login.php), [`criarUser.php`](forms/criarUser.php).

- **PHP/public/**  
  Páginas públicas acessíveis pelo usuário, como:
  - [`index.php`](public/index.php): Página inicial, lista eventos por categoria.
  - [`listar.php`](public/listar.php): Lista todos os eventos disponíveis.
  - [`eventos.php`](public/eventos.php): Detalhes de um evento.
  - [`MeusEventos.php`](public/MeusEventos.php): Eventos em que o usuário está inscrito.
  - [`certificados.php`](public/certificados.php): (em desenvolvimento) área de certificados.
  - [`evento_cadastro.php`](public/evento_cadastro.php): Processa inscrições em eventos.

- **PHP/templates/**  
  Componentes reutilizáveis de layout, como [`header.php`](templates/header.php) e [`footer.php`](templates/footer.php).

- **PHP/style/**  
  Arquivos CSS customizados para o projeto, como [`style.css`](style/style.css) e [`cadastro.css`](style/cadastro.css).

- **PHP/NodeJs/**  
  Contém a API Node.js (código fonte, rotas, middlewares e banco de dados SQL) utilizada pelo front-end PHP para operações de CRUD, autenticação e inscrições.

- **PHP/data/**  
  (Opcional) Pasta para arquivos de dados auxiliares, imagens ou exportações.

## 🚀 Funcionalidades

- Listagem e detalhamento de eventos.
- Inscrição em eventos com validação de dados e consulta automática de endereço via CEP.
- Autenticação de usuários (login/cadastro).
- Visualização dos eventos em que o usuário está inscrito.
- Integração total com a API Node.js para persistência dos dados.
- Layout responsivo com Bootstrap.

## ⚙️ Como rodar

1. Certifique-se de que a API Node.js está rodando em `localhost:3001`.
2. Configure o servidor PHP (ex: XAMPP, WAMP, PHP embutido).
3. Acesse as páginas pelo navegador, iniciando por `public/index.php`.

## 👥 Equipe

Consulte o [README principal](../README.md) para informações sobre a equipe e tecnologias.

---

Projeto desenvolvido para o Hackathon UniALFA 2025.