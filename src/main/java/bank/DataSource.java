package bank;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {
  public static final String DB_URL = "jdbc:sqlite:resources/bank.db";

  public static Connection getConnection() {
    Connection connection = null;
    try {
      connection = java.sql.DriverManager.getConnection(DB_URL);
      System.out.println("Connection Established");
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }

    return connection;
  }

  public static void main(String[] args) {
    getConnection();
  }
}
