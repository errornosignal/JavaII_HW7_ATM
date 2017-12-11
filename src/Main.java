
public class Main {
    public static Account account = new Account();

    public static void main(String[] args) {
        AccountManager accountManager = new AccountManager();
        CSVReader csvReader = new CSVReader();
        int noAccountCounter = 0;

        //load accounts from datafile
        accountManager.getAccounts();

        String acctNUM = Validator.getString("Enter account number: ");
        String acctPIN = Validator.getString("Enter your PIN: ");

        account = AccountManager.getAccount(acctNUM, acctPIN);
        boolean accountFound = false;
        //while (!accountFound) {
        if (account != null) {
            noAccountCounter++;
            acctNUM = Validator.getString("Enter account number: ");
            acctPIN = Validator.getString("Enter your PIN: ");
            account = AccountManager.getAccount(acctNUM, acctPIN);
            if (noAccountCounter > 2) {
                System.out.println("No account found! Bye");
                System.exit(1);
            }
            //else {/*doNothing*/}
        }
        //else {

        // }


        //String pin = account.getPin();


        String accNum, pass, origBal = "error";
        int count = 0, menuOption = 0;
        double depositAmt = 0, withdrawAmt = 0, currentBal = 0.0;
        //boolean  foundNonDigit;

        //loop that will count the number of login attempts
        //you make and will exit program if it is more than 3.
        //as long as oriBal equals an error.
        //do{
//            //foundNonDigit = false;
//            System.out.println("Enter Your Account Number: ");
//            accNum = ATM.kbd.next();
//
//            System.out.println("Pin: ");
//            pass = ATM.kbd.next();
//
//            Account account = AccountManager.getAccount(accNum, pass);
//            System.out.println(account);
//
//            count++;
//
//            if (count >= 3 && origBal.equals("error")){
//                System.out.print("Maximum Login Attempts Reached.");
//                System.exit(0);
//            }
//            if (!(origBal.equals("error"))){
//                System.out.println("\nYour New Balance is: $ "+ origBal);
//            }
//            else
//                System.out.println(origBal);
//
//
//       // }while(origBal.equals("error"));
//        if (account != null) {
//            currentBal = account.getBalance();
//        }


        //this loop will keep track of the options that
        //the user inputs in for the menu. and will
        //give the option of deposit, withdraw, or logout.

        while (true) {
            menuOption = ATM.menu();
            switch (menuOption) {
                case 1:
                    if (account != null) {
                        System.out.println(ATM.displayBalance(acctNUM, acctPIN));
                    }
                    break;
                case 2:
                    System.out.print("\nEnter Amount You Wish to Deposit: $ ");
                    depositAmt = ATM.sc.nextDouble();
                    currentBal = ATM.deposit(depositAmt, currentBal);
                    break;
                case 3:
                    System.out.print("\nEnter Amount You Wish to Withdraw: $ ");
                    withdrawAmt = ATM.sc.nextDouble();

                    while (withdrawAmt > currentBal) {
                        System.out.print("ERROR: INSUFFICIENT FUNDS!! "
                                + "PLEASE ENTER A DIFFERENT AMOUNT: $");
                        withdrawAmt = ATM.sc.nextDouble();
                    }

                    currentBal = ATM.withdraw(currentBal, withdrawAmt);
                    break;
                case 4:
                    System.out.print("\nThank For Using My ATM.  Have a Nice Day.  Good-Bye!");
                    System.exit(0);
                    break;
            }
        }
    }
}




//*****************************************************************************************************************
//
//        String accNum, pass, origBal = "error";
//        int count = 0, menuOption = 0;
//        double depositAmt = 0, withdrawAmt = 0, currentBal=0;
//        //boolean  foundNonDigit;
//
//        //loop that will count the number of login attempts
//        //you make and will exit program if it is more than 3.
//        //as long as oriBal equals an error.
//        do{
//            //foundNonDigit = false;
//            System.out.println("Please Enter Your Account Number: ");
//            accNum = ATM.kbd.next();
//
//            System.out.println("Enter Your Password: ");
//            pass = ATM.kbd.next();
//
//            origBal = ATM.checkID(accNum, pass);
//
//            count++;
//
//            if (count >= 3 && origBal.equals("error")){
//                System.out.print("Maximum Login Attempts Reached.");
//                System.exit(0);
//            }
//            if (!(origBal.equals("error"))){
//                System.out.println("\nYour New Balance is: $ "+ origBal);
//            }
//            else
//                System.out.println(origBal);
//
//
//        }while(origBal.equals("error"));
//
//        currentBal = Double.parseDouble(origBal);
//        //this loop will keep track of the options that
//        //the user inputs in for the menu. and will
//        //give the option of deposit, withdraw, or logout.
//
//        while (true)
//        {
//            menuOption = ATM.menu();
//            switch (menuOption)
//            {
//                case 1:
//                    ATM.displayBalance(currentBal);
//                    break;
//                case 2:
//                    System.out.print("\nEnter Amount You Wish to Deposit: $ ");
//                    depositAmt = ATM.kbd.nextDouble();
//                    currentBal = ATM.deposit(depositAmt, currentBal);
//                    break;
//                case 3:
//                    System.out.print("\nEnter Amount You Wish to Withdraw: $ ");
//                    withdrawAmt = ATM.kbd.nextDouble();
//
//                    while(withdrawAmt > currentBal){
//                        System.out.print("ERROR: INSUFFICIENT FUNDS!! "
//                                + "PLEASE ENTER A DIFFERENT AMOUNT: $");
//                        withdrawAmt = ATM.kbd.nextDouble();
//                    }
//
//                    currentBal = ATM.withdraw(currentBal, withdrawAmt);
//                    break;
//                case 4:
//                    System.out.print("\nThank For Using My ATM.  Have a Nice Day.  Good-Bye!");
//                    System.exit(0);
//                    break;
//            }
//        }
//    }
//}
