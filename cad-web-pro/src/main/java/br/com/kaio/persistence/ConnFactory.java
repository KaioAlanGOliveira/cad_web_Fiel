package br.com.kaio.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/dizimistas";
    private static final String USER = "dizimistas";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver MySQL não encontrado", e);
        }
    }
}
