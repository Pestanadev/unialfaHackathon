# unialfaHackathon-JavaBackOffice

Projeto Java para gerenciamento de eventos, desenvolvido para o Hackathon UniAlfa.

## Resumo

Esta aplicação permite o cadastro, consulta, atualização e remoção de eventos em um sistema de gerenciamento. Possui interface gráfica para interação do usuário, camada de acesso a dados, lógica de negócio e integração com banco de dados relacional. O objetivo é facilitar a administração de eventos acadêmicos ou corporativos de forma simples e eficiente.

## Estrutura do Projeto

```
.
├── .gitignore
├── pom.xml
├── .idea/
├── src/
│   ├── db/
│   ├── main/
│   │   ├── java/
│   │   │   └── uniAlfa/
│   │   │       └── hackathon/
│   │   │           ├── Main.java
│   │   │           ├── dao/
│   │   │           │   ├── Dao.java
│   │   │           │   ├── DaoInterface.java
│   │   │           │   └── EventoDao.java
│   │   │           ├── gui/
│   │   │           │   ├── EventoGui.java
│   │   │           │   └── GuiUtil.java
│   │   │           ├── model/
│   │   │           │   └── Evento.java
│   │   │           └── service/
│   │   │               └── EventoService.java
│   │   └── resources/
│   │       └── banco-dados.sql
│   └── test/
│       └── java/
└── target/
```

## Principais Componentes

- **Main.java**: Classe principal para execução da aplicação.
- **dao/**: Camada de acesso a dados (Data Access Object).
- **gui/**: Interface gráfica do usuário.
- **model/**: Definição das entidades do sistema.
- **service/**: Lógica de negócio.
- **resources/banco-dados.sql**: Script SQL para criação do banco de dados.

## Como Executar

1. Clone o repositório:
    ```bash
    git clone <url-do-repositorio>
    ```
2. Importe o projeto em sua IDE Java (recomendado: IntelliJ IDEA).
3. Certifique-se de ter o Java e o Maven instalados.
4. Execute:
    ```bash
    mvn clean install
    mvn exec:java -Dexec.mainClass="uniAlfa.hackathon.Main"
    ```

## Requisitos

- [JDK 21 LTS](https://www.oracle.com/java/technologies/downloads/#jdk21) (necessário para compilação e execução)
- Maven

## Observações

- O projeto utiliza uma estrutura modular para facilitar a manutenção e evolução.
- O script `banco-dados.sql` deve ser executado para criar as tabelas necessárias no banco de dados.

---
