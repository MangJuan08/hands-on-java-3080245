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

  public static void getAccounts() {
    String sql = "SELECT * FROM accounts a where a.id = 10385";

    try (

        Connection conn = getConnection();
        java.sql.Statement stmt = conn.createStatement();
        java.sql.ResultSet rs = stmt.executeQuery(sql)) {

      // loop through the result set
      while (rs.next()) {
        System.out.println(
            rs.getInt("id") + "\t" +
                rs.getDouble("balance") + "\t" +
                rs.getString("type"));

      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public static Customer getACustomer(Integer customerId) {
    String sql = "SELECT * FROM customers c where c.id = " + customerId;
    Customer customer = null;
    try (
        Connection conn = getConnection();
        java.sql.Statement stmt = conn.createStatement();
        java.sql.ResultSet rs = stmt.executeQuery(sql)) {

      if (rs.next()) {

        customer = new Customer(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("username"),
            rs.getString("password"),
            rs.getInt("account_id"));

      } else {
        System.out.println("No data found.");
      }
      // loop through the result set

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return customer;
  }

  public static void main(String[] args) {
    Customer aCustomer = getACustomer(1109);
    System.out.println(
        aCustomer.getId() + "\t" +
            aCustomer.getName() + "\t" +
            aCustomer.getUsername() + "\t" +
            aCustomer.getPassword() + "\t" +
            aCustomer.getAccountId());
  }

}
