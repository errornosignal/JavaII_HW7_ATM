
import java.util.List;

/** Created by errornosignal on 12/08/2017.
 * AccountDAO Interface
 * Interface for Account Class
 * @author Reid Nolan
 * @since 12/08/2017
 * @version 1.0
 */
interface AccountDAO
{
    /**
     * gets all accounts
     * @return accounts
     */
    List<Account> getAllAccounts();

    /**
     * gets a customer
     * @param number number
     * @return i / 0
     */
    int getAccount(String number);

    /**
     * adds a account
     * @param account account
     */
    void addAccount(Account account);

    /**
     * deletes a account
     * @param account account
     */
    void deleteAccount(Account account);

    /**
     * sorts accounts by number
     */
    void sortAccount_number();

    /**
     * sorts accounts by pin
     */
    void sortAccount_pin();

    /**
     * sorts accounts by balance
     */
    void sortAccount_balance();

    /**
     * updates a account
     * @param account account
     */
    void updateAccount(Account account);

    /**
     * displays account details
     * @param account account
     */
    String printAccountDetails(Account account);
}