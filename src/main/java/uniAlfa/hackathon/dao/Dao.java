package unialfa.hackathon.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {

    private Connection connection;

    /**
     * Construtor da classe Dao responsável por inicializar a conexão com o banco de dados MySQL.
     * <p>
     * Este construtor carrega o driver JDBC do MySQL e estabelece uma conexão com o banco de dados
     * 'hackathon' localizado em localhost na porta 3306. O usuário utilizado é 'root' e a senha está vazia.
     * Caso ocorra alguma exceção durante o processo, a mensagem de erro será impressa no console.
     * </p>
     */
    public Dao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hackathon?useTimezone=true&serverTimezone=UTC",
                    "root",
                    ""); // senha vazia

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
