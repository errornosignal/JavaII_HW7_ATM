
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AccountManager {
    public static final String accountFile = "accounts.csv";
    public static List<Account> accounts = new ArrayList<>();


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

    public static void getBalance(String accountName, String pin) {
        for (Account account : accounts) {
            //System.out.println(account.getName());
            if (account.isMatching(accountName, pin)) {
                System.out.println(account.getBalance());
            }
        }
    }
}

       // Account account = new Account();

        //boolean balancesRead = false;
//        for (Map.Entry<String, String> entry1 : CSVReader.treeMap1.entrySet())
//        {
//            //System.out.println("Crap2");
//            String key1 = entry1.getKey();
//            String value1 = entry1.getValue();
//            String value2 = "";
//
//            account.setName(key1);
//            account.setEncryptedPassword(value1);
//            account.setBalance(value2);

//            while (!balancesRead)
//            {
//                try
//                {
//                    CSVReader.readFile(balanceFile);
//                    balancesRead = true;
//                }
//                catch (MaximumColumnsExceededException | IOException | InterruptedException e)
//                {
//                    e.printStackTrace();
//                }
//            }

            //System.out.println("accounts.size() = " + Account.accounts.size());

//            for (int i = 0; i < accounts.size(); i++) {
//                System.out.println(String.format(account.getName(), account.getEncryptedPassword(), account.getBalance()));
//                System.out.println("Crap3");
//            }

            //System.out.print("\n" + account.getName() + " - " + key1);

//
//            for (Map.Entry<String, Map<String, String>> entry2 : CSVReader.treeMap3.entrySet())
//            {
//                if (account.getName().equals(key1) && account.getEncryptedPassword().equals(value1))
//                {
//                    System.out.println(" --Match");
//
//                    if (account.getName().equals(key1))
//                    {
//                        //account = new Account(" ", " ", 0.00);
//                        //assert false;
//                        value2 = String.valueOf(entry2.getValue());
//                        //System.out.println(key + " - " + value);
//                        account.setBalance(value2);
//                        Account.accounts.add(account);
//                        //System.out.println(account);
//                        //String accountName = account.getName();
//                        //String accountPassword = account.getEncryptedPassword();
//                        //System.out.println(accountName + " - " + accountPassword);
//                        //}
//
//                        //break;
//                    }
//                    else
//                    {
//                        System.out.println("No match");
//                    }
//                }
//
//
//                //System.out.println();
//
//
//            }
//
//            //print map values
//            System.out.println(CSVReader.treeMap3);
//
//        }
//        return null;
//    }
//}