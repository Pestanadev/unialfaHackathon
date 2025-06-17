package uniAlfa.hackathon.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {

    private Connection connection;

    /*
     * Construtor da classe Dao.
     * Inicializa a conexão com o banco de dados MySQL.
     */
    public Dao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hackathon?useTimezone=true&serverTimezone=UTC",
                    "root",
                    ""); // Sem senha para o usuário root, ajuste conforme necessário

        // Exibir mensagem de erro caso a conexão falhe
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
