/**
 *
 */
public class Account {
    private String number;
    private String pin;
    private String balance;

    /**
     *
     */
    public Account() {
    };

    /**
     *
     * @param number
     * @param pin
     * @param balance
     */
    public Account(String number, String pin, String balance) {
        this.number = number;
        this.pin = pin;
        this.balance= balance;
        System.out.println("One account added!");
        System.out.println("number: " + this.number);
        System.out.println("pin : " + this.pin);
        System.out.println("balance: " + this.balance);
        System.out.println();
    }

//    /**
//     *
//     * @param number
//     * @param pin
//     * @param balance
//     */
//    public Account(String number, String pin, String balance) {
//        this.number = number;
//        this.pin = pin;
//        this.balance= Double.valueOf(balance);
//    }

    /**
     *
     * @param number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     *
     * @param pin
     */
    public void setPin(String pin) {
        this.pin = pin;
    }

    /**\
     *
     * @param bal
     */
    public void setBalance(String bal) {
        this.balance = bal;
    }

    /**
     *
     * @return
     */
    public String getNumber() {
        return this.number;
    }

    /**
     *
     * @return
     */
    public String getPin() {
        return this.pin;
    }

    /**
     *
     * @return
     */
    public String getBalance() {
        return this.balance;
    }

    /**
     *
     * @param number
     * @param pin
     * @return
     */
    public boolean isMatching(String number, String pin) {
        if (this.number.equals(getNumber())) {
            System.out.println("numberMatched");
            if (this.pin.equals(getPin())) {
                System.out.println("passwordMatched");
                return true;
            } else {System.out.println("pinNotMatched");}
        } else {System.out.println("numberNotMatched");}
        return false;
    }

    /**
     *
     * @param number
     * @return
     */
    public boolean isMatching(String number) {
        return number.equals(getNumber());
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Account {" + "\n number: " + number + ",\n pin: " + pin  + "\n balance: " + String.valueOf(balance);
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Account)) {
            return false;
        }
        Account account = (Account) o;
        return (getNumber() != null ? getNumber().equals(account.getNumber()) : account.getNumber() == null) && (getPin() != null ? getPin().equals(account.getPin()) : account.getPin() == null);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int result = getNumber() != null ? getNumber().hashCode() : 0;
        result = 31 * result + (getPin() != null ? getPin().hashCode() : 0);
        return result;
    }
}