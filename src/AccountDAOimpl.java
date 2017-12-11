
import java.util.ArrayList;
        import java.util.Comparator;
        import java.util.List;

/** Class to run AccountDAO
 * @author Reid Nolan
 * @since 04/25/2017
 * @version 1.0
 */
public class AccountDAOimpl implements AccountDAO {
    static List<Account> accounts = new ArrayList<>();

    /**
     * @return accounts
     */
    public List<Account> getAllAccounts() {
        return accounts;
    }

    /**
     * gets index of a account object
     *
     * @param number number
     * @return i / 0
     */
    @Override
    public int getAccount(String number) {
        for (int i = 0; i < accounts.size(); i++) {
            if (number.equals(accounts.get(i).getNumber())) {
                return i;
            }
            else {
                //do nothing
            }
        }
        return 0;
    }

    /**
     * adds a account
     *
     * @param account account
     */
    @Override
    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("\n" + account.getPin() + " " + account.getBalance() +
                " was added to the database.\n");
    }

    /**
     * deletes a account
     *
     * @param account account
     */
    @Override
    public void deleteAccount(Account account) {
        accounts.remove(account);
        System.out.println("\n" + account.getPin() + " " + account.getBalance() + " has been deleted.\n");
    }

    /**
     * sorts accounts by number
     */
    @Override
    public void sortAccount_number() {
        if (accounts.size() > 0) {
            accounts.sort(Comparator.comparing(Account::getNumber));
        }
    }

    /**
     * sorts accounts by pin
     */
    @Override
    public void sortAccount_pin() {
        if (accounts.size() > 0) {
            accounts.sort(Comparator.comparing(Account::getPin));
        }
    }

    /**
     * sorts accounts by balance
     */
    @Override
    public void sortAccount_balance() {
        if (accounts.size() > 0) {
            accounts.sort(Comparator.comparing(Account::getBalance));
        }
    }

    /**
     * updates a account
     *
     * @param account account
     */
    @Override
    public void updateAccount(Account account) {
        account.setNumber(Validator.getString("Number: "));
        account.setBalance(Validator.getString("Balance: "));
        System.out.println("\n" + account.getPin() + " " + account.getBalance() +
                " was updated in the database.\n");
    }

    /**
     * displays account details
     *
     * @param account account
     * @return string
     */
    @Override
    public String printAccountDetails(Account account) {
        return StringUtils.padWithSpaces(account.getNumber(), AccountConstants.get_kPIN_SIZE()) +
                StringUtils.padWithSpaces(account.getPin(), AccountConstants.get_kPIN_SIZE()) +
                StringUtils.padWithSpaces(String.valueOf(account.getBalance()), AccountConstants.get_kBALANCE_SIZE());
    }
}