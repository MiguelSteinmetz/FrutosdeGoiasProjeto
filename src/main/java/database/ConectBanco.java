package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectBanco {

    private static final String URL = "jdbc:mysql://localhost:3306/sorveteria";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection conectar() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
