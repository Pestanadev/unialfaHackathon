package uniAlfa.hackathon.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {

    private Connection connection;

    public Dao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hackathon?useTimezone=true&serverTimezone=UTC",
                    "root",
                    "YES");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public Connection getConnection() {
        return connection;
    }
}
