package bank;

public class Main {
  public static void main(String[] args) {
    Customer aCustomer = null;
    aCustomer = DataSource.getACustomerViaCustomerId(1109);
    System.out.println(
        aCustomer.getId() + "\t" +
            aCustomer.getName() + "\t" +
            aCustomer.getUsername() + "\t" +
            aCustomer.getPassword() + "\t" +
            aCustomer.getAccountId());

    Account anAccount = null;
    anAccount = DataSource.getAccount(aCustomer.getAccountId());
    System.out.println(
        anAccount.getBalance());

    /*
     * Customer c = null;
     * c = DataSource.getACustomerViaUsername(aCustomer.getUsername(),
     * aCustomer.getPassword());
     * 
     * System.out.println(c);
     */

  }
}
