package bank;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionDB {
  public static final String DB_URL = "jdbc:sqlite:resources/bank.db";

  public static Connection getConnection() {
    Connection connection = null;
    try {
      connection = java.sql.DriverManager.getConnection(DB_URL);
      System.out.println("Connection Established");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }

  public static void closeConnection(Connection connection) {
    try {
      if (connection != null && !connection.isClosed()) {
        connection.close();
        System.out.println("Connection Closed");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
