
import java.util.*;

public class ATM {

    public static Scanner sc = new Scanner(System.in);
    Account account = new Account();

    // The checkID method determines if acctNum is a valid account number
    // and pwd is the correct password for the account.  If the account information
    // is valid, the method returns the current account balance, as a string.
    // If the account information is invalid, the method returns the string "error".
    public static String checkID(String acctNum, String pwd) {
        String result = "error";

        // Strings a, b, and c contain the valid account numbers and passwords.
        // For each string, the account number is listed first, followed by
        // a space, followed by the password for the account, followed by a space,
        // followed by the current balance.
        String a = "44567-5 mypassword 520.36";
        String b = "1234567-6 anotherpassword 48.20";
        String c = "4321-0 betterpassword 96.74";

        if (acctNum.equals(a.substring(0, a.indexOf(" "))) &&
                pwd.equals(a.substring(a.indexOf(" ") + 1, a.lastIndexOf(" "))))
            return result = a.substring(a.lastIndexOf(" ") + 1);
        if (acctNum.equals(b.substring(0, b.indexOf(" "))) &&
                pwd.equals(b.substring(b.indexOf(" ") + 1, b.lastIndexOf(" "))))
            return result = b.substring(b.lastIndexOf(" ") + 1);
        if (acctNum.equals(c.substring(0, c.indexOf(" "))) &&
                pwd.equals(c.substring(c.indexOf(" ") + 1, c.lastIndexOf(" "))))
            return result = c.substring(c.lastIndexOf(" ") + 1);

        return result;
    }

    public static int menu() {
        int menuChoice;
        do {
            System.out.print("\nPlease Choose From the Following Options:"
                    + "\n 1. Display Balance \n 2. Deposit"
                    + "\n 3. Withdraw\n 4. Log Out\n\n");
            menuChoice = sc.nextInt();
            if (menuChoice < 1 || menuChoice > 4) {
                System.out.println("error");
            }
        } while (menuChoice < 1 || menuChoice > 4);
        return menuChoice;
    }

    public static Double displayBalance(String acctNum, String acctPin) {
        return AccountManager.getBalance(acctNum, acctPin);
    }

    public static double deposit(double x, double y)
   {
        double newBalance = y + x;
        System.out.printf("Your New Balance is $%.2f\n", newBalance);
        return newBalance;
    }

    public static double withdraw(double x, double y) {
        double newBalance;
        newBalance = x - y;
        System.out.printf("Your New Balance is %.2f\n", newBalance);
        return newBalance;
    }
}
