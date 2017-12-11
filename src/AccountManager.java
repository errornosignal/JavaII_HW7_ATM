
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Account Manager Class
 */
public class AccountManager {
    public static final String accountFile = "accounts.txt";
    public static List<Account> accounts = new ArrayList<>();


    /**
     * gets all accounts
     */
    public void getAccounts() {
        // read from a source, e.g. database, and return as a List of Account objects
        try {
            CSVReader.readFile(accountFile);
        }
        catch ( IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(accounts);
    }

    /**
     * gets one account
     * @param acctNUM acctNUM
     * @param acctPIN acctPIN
     */
    public static void getAccount(String acctNUM, String acctPIN) {
        //Arrays.fill(new String[]{acctPIN}, "");
        //simple implementation that loops through the accounts
        for (int i = 0; i < accounts.size(); i++) {
            //System.out.println(accounts.get(i).getNumber());
            if (accounts.get(i).isMatching(acctNUM, acctPIN)) {
                System.out.println(accounts.get(i).getNumber());
            }
        }
    }

    /**
     * gets balance
     * @param accountName accountName
     * @param pin pin
     */
    public static void getBalance(String accountName, String pin) {
        for (Account account : accounts) {
            //System.out.println(account.getName());
            if (account.isMatching(accountName, pin)) {
                System.out.println(account.getBalance());
            }
        }
    }
}
