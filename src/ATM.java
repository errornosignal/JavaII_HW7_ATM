import java.io.File;
import java.io.IOException;

/** Created by errornosignal on 12/08/2017.
 * Reid_Nolan_HW7_ATM_[PROG 1403]
 * ATM Class
 * Class for manipulation of bank records
 * @author Reid Nolan
 * @since 12/08/2017
 * @version 1.0
 */
public class ATM
{
    private static AccountDAO accountDAO = new AccountDAOimpl();
    public static final String fileToOpen= "customers.txt";

    /**
     * main method
     * @param args args
     * @throws InterruptedException IEx
     */
    public static void main(String[] args) throws InterruptedException
    {
        displayProgramHeader();

        try
        {
            //create new file object
            File file = new File(fileToOpen);

            //check for file in directory
            if (!file.exists())
            {
                System.out.println("[" + fileToOpen + "] was not found in the current working directory.");
            }
            else
            {
                //do nothing
            }

            //creates file if it does not exist
            if (file.createNewFile())
            {
                System.out.println("[" + fileToOpen + "] was successfully created in the current working directory.");
            }
            else
            {
                System.out.println("[" + fileToOpen + "] was found in the current working directory.");
            }

            //read contents of file into memory
            CSVReader.readFile(fileToOpen);
        }
        catch ( IOException | InterruptedException IEx)
        {
            IEx.printStackTrace();
            //display error on thrown custom exception
            System.err.println(IEx.getMessage());
            Thread.sleep(CSVReader.kTIMER_DELAY);
            System.out.println();
        }

        //display command menu
        System.out.println("-----------------------------------------------\n");
        System.out.println("Welcome to the Account Maintenance application\n");
        displayCommandMenu();

        //menu options
        String command = "";
        while (!command.equalsIgnoreCase("exit"))
        {
            //prompt for command menu input
            command = Validator.getString("Enter a command: ");

            if (command.equalsIgnoreCase("list"))
            {
                //list all customers************************************************************************************
                System.out.println("\n-Print All:");
                printAllAccounts();
            }
            else if (command.equalsIgnoreCase("add"))
            {
                //add customer******************************************************************************************
                System.out.println("\n-Add Customer...");
                String number = Validator.getString("Enter account number: ");
                String pin = Validator.getString("Enter pin: ");
                String balance = Validator.getString("Enter balance: ");
                Account customer = new Account(number, pin, balance);
                accountDAO.addAccount(customer);
            }
            else if (command.equalsIgnoreCase("del"))
                {
                    //delete customer***************************************************************************************
                    System.out.println("\n-Delete Account:");
                    String number = Validator.getString("Enter account number to delete: ");
                    Account account = accountDAO.getAllAccounts().get(accountDAO.getAccount(number));

                    if (accountDAO.getAccount(number) != 0)
                    {
                        accountDAO.deleteAccount(account);
                    }
                    else
                    {
                        displayNoMatch();
                    }
                }
                else if (command.equalsIgnoreCase("upd"))
                    {
                        //update customer***************************************************************************************
                        System.out.println("\n-Update Account:");
                        String number = Validator.getString("Enter account number to update: ");
                        Account account = accountDAO.getAllAccounts().get(accountDAO.getAccount(number));
                        if (accountDAO.getAccount(number) != 0)
                        {
                            accountDAO.updateAccount(account);
                        }
                        else
                        {
                            displayNoMatch();
                        }
                    }
                    else if (command.equalsIgnoreCase("sort"))
                        {
                            displaySortMenu();

                            //prompt for sort menu input
                            String sortBy = Validator.getString("Sort by: ");

                            if (sortBy.equalsIgnoreCase("number"))
                            {
                                accountDAO.sortAccount_number();
                            }
                            else if (sortBy.equalsIgnoreCase("pin"))
                            {
                                accountDAO.sortAccount_pin();
                            }
                            else if (sortBy.equalsIgnoreCase("balance"))
                                {
                                    accountDAO.sortAccount_balance();
                                }
                                else
                                {
                                    //do nothing
                                }
                        }
                        else if (command.equalsIgnoreCase("help"))
                            {
                                displayHelp();
                                displayCommandMenu();
                            }
                            else if (command.equalsIgnoreCase("exit"))
                                {
                                    //exit program and write contents of memory to file
                                    CSVReader.writeToFile(fileToOpen);
                                    System.out.println("\nGoodBye...\n");
                                }
                                else
                                {
                                    System.out.println("Error! Not a valid command.\n");
                                }
        }
    }

    /**
     * displays program header
     */
    private static void displayProgramHeader()
    {
        System.out.println("JavaII_HW7_ATM\n");
    }

    /**
     * displays main menu
     */
    private static void displayCommandMenu()
    {
        System.out.println("COMMAND MENU");
        System.out.println("list    - List all accounts");
        System.out.println("add     - Add an account");
        System.out.println("del     - Delete an account");
        System.out.println("upd     - Update an account");
        System.out.println("sort    - Sort by balance, pin, and number");
        System.out.println("help    - Show this menu");
        System.out.println("exit    - Exit this application\n");
    }

    private  static void displaySortMenu()
    {
        System.out.println("\nSORT OPTIONS");
        System.out.println("email   - sort by number");
        System.out.println("first   - sort by pin");
        System.out.println("last    - sort by balance");
    }

    /**
     * prints all customers
     */
    private static void printAllAccounts()
    {
        try
        {
            for (int i = 0; i < AccountDAOimpl.accounts.size(); i++)
            {
                System.out.println(accountDAO.printAccountDetails(AccountDAOimpl.accounts.get(i)));
            }
            System.out.println();
        }
        catch (NullPointerException NPEx)
        {
            NPEx.printStackTrace();
        }
    }

    /**
     * displays help details
     */
    private static void displayHelp()
    {
        System.out.println("\nMENU DETAILS");
        System.out.println("list    - List all accounts: Displays a list containing all account records in the database. These\n\t\t\trecords contain pin, balance, and number fields for each account.");
        System.out.println("add     - Add an account: Provides options for adding a new account record to the database.");
        System.out.println("del     - Delete an account: Provides options for removing an account record from the database.");
        System.out.println("update  - Update an account: Provides options for updating an existing account record in the database.");
        System.out.println("sort    - Sort account: Sorts the records stored in the database, in ascending alphabetical order,\n\t\t\tby either last name, first name, or email address.");
        System.out.println("help    - Show this menu: Shows details for each of the main menu options.");
        System.out.println("exit    - Exit this application: Self-explanatory.\n");
    }

    /**
     * displays no match found message
     */
    private static void displayNoMatch()
    {
        System.out.println("Sorry, there are no accounts with that number.\n");
    }
}