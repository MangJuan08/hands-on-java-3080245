package bank;

import javax.security.auth.login.LoginException;

public class Authenticator {

  public static Customer login(String username, String password) throws LoginException {
    Customer aCustomer = DataSource.getACustomerViaUsername(username, password);
    if (aCustomer.getUsername() == null) {
      throw new LoginException("no data found");
    }
    if (password.equals(aCustomer.getPassword())) {
      /* aCustomer.setIsAuthenticated(true); */
      return aCustomer;
    } else
      throw new LoginException("login failed");
  }

  public static void logout(Customer customer) {
    /* customer.setIsAuthenticated(false); */
  }
}
