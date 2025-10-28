package bank;

public class Customer {
  private int id;
  private String name;
  private String username;
  private String password;
  private Integer accountId;
  /* private Boolean isAuthenticated; */

  public Customer(int id, String name, String username, String password, Integer accountId) {
    this.id = id;
    this.name = name;
    this.username = username;
    this.password = password;
    this.accountId = accountId;
    /* setIsAuthenticated(false); */
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getAccountId() {
    return this.accountId;
  }

  public void setAccountId(Integer accountId) {
    this.accountId = accountId;
  }
  /*
   * public Boolean getIsAuthenticated() {
   * return this.isAuthenticated;
   * }
   * 
   * public void setIsAuthenticated(Boolean isAuthenticated) {
   * this.isAuthenticated = isAuthenticated;
   * }
   */

}
