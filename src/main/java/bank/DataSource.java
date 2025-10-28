package bank;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {
  public static final String DB_URL = "jdbc:sqlite:resources/bank.db";

  public static Connection getConnection() {
    Connection connection = null;
    try {
      connection = java.sql.DriverManager.getConnection(DB_URL);
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }

    return connection;
  }

  public static Account getAccount(Integer accountId) {
    String sql = "SELECT * FROM accounts a where a.id = " + accountId;
    Account account = null;
    try (

        Connection conn = getConnection();
        java.sql.Statement stmt = conn.createStatement();
        java.sql.ResultSet rs = stmt.executeQuery(sql)) {

      // loop through the result set
      if (rs.next()) {
        account = new Account(
            rs.getInt("id"),
            rs.getDouble("balance"),
            rs.getString("type"));
      } else {
        System.out.println("No data found");
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return account;
  }

  public static Customer getACustomerViaCustomerId(Integer customerId) {
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
      e.printStackTrace();
    }
    return customer;
  }

  public static Customer getACustomerViaUsername(String username, String password) {
    String sql = "SELECT * FROM customers c where c.username = " + username + " AND c.password = " + password;
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
      e.printStackTrace();
    }
    return customer;
  }

}
