package bank;

public class Account {
  private int id;
  private double balance;
  private String type;

  public Account(int id, double balance, String type) {
    setId(id);
    setBalance(balance);
    setType(type);
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getBalance() {
    return this.balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
