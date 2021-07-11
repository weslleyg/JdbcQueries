package com.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFac {

    private ConnectionFac() { throw new UnsupportedOperationException(); }

    public static Connection getConnection() {
        String driver = "postgresql";
        String dataBaseAddress = "localhost";
        String dataBaseName = "financas";
        String user = "root";
        String password = "root";

        StringBuilder sb = new StringBuilder("jdbc:")
            .append(driver).append("://")
            .append(dataBaseAddress).append("/")
            .append(dataBaseName);

        String urlConnection = sb.toString();

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(urlConnection, user, password);
        } catch(SQLException e) {
            System.out.println("Falha");
            e.printStackTrace();
        }

        return conn;
  }
}
