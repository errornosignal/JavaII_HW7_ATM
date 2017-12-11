/**
 *
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        AccountManager accountManager = new AccountManager();
        accountManager.getAccounts();

        String acctNUM = Validator.getString("Enter account number: ");
        String acctPIN = Validator.getString("Enter your PIN: ");


    }
}
