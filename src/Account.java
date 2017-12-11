
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String name;
    private String pin;
    private Double balance;

    public Account() {
    }

    public static List<Account> accounts = new ArrayList<>();

    public Account(String name, String pin, Double balance) {
        this.name = name;
        this.pin = pin;
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getName() {
        return this.name;
    }

    public String getPin() {
        return this.pin;
    }

    public Double getBalance() {
        return this.balance;
    }

    public boolean isMatching(String name, String pin) {
        if (name.equals(getName())) {
            //System.out.println("nameMatched");
            if (pin.equals(getPin())) {
                //System.out.println("passwordMatched");
                return true;
            } else {/*System.out.println("pinNotMatched");*/}
        } else {/*System.out.println("nameNotMatched");*/}
        return false;
    }

    public boolean isMatching(String name) {
        return name.equals(getName());
    }

    @Override
    public String toString() {
        return "Account {" + "\n name: " + name + ",\n pin: " + pin  + "\n balance: " + String.valueOf(balance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Account)) {
            return false;
        }
        Account account = (Account) o;
        return (getName() != null ? getName().equals(account.getName()) : account.getName() == null) && (getPin() != null ? getPin().equals(account.getPin()) : account.getPin() == null);
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getPin() != null ? getPin().hashCode() : 0);
        return result;
    }
}