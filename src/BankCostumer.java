import java.util.ArrayList;
import java.util.Scanner;

// not enough amount exception and wrong password exeption
public class BankCostumer {
    private String firstName;
    private String lastName;
    private final int accountNumber;
    private String password;
    private int amount;

    protected static ArrayList<Integer> numbers = new ArrayList<Integer>();
    public BankCostumer(String firstName, String lastName, int accountNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        // checking if account number is valid
        if(numbers.contains(accountNumber)) throw new IllegalArgumentException("Account number is already used");
        this.accountNumber = accountNumber;
        numbers.add(accountNumber);
        this.password = password;
        this.amount = 0;
    }

    // Getter and Setter
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void withdrawal() throws NotEnoughAmountException, WrongPasswordException {
        Scanner input = new Scanner(System.in);
        if(Validation.checkPassword(this.password)) {
            System.out.println("Enter the amount of money you want to withdrawal:");
            int n = input.nextInt();

            if(Validation.checkForEnoughAmount(this.amount, n)) {
                setAmount(getAmount() - n);
                System.out.println("Withdrawal done new amount: " + this.getAmount());
            } else {throw new NotEnoughAmountException("You don't have enough credit to withdraw the amount!");}
        } else {throw new WrongPasswordException("You have entered a wrong password!");}
    }

    public void deposit() throws WrongPasswordException {
        Scanner input = new Scanner(System.in);
        if(Validation.checkPassword(this.password)) {
            System.out.println("Enter the amount of money you want to deposit:");
            int n = input.nextInt();
            setAmount(getAmount() + n);
            System.out.println("Deposit done new amount: " + this.getAmount());
        } else {throw new WrongPasswordException("You have entered a wrong password!");}
    }

    public void transfer(BankCostumer other) throws NotEnoughAmountException, WrongPasswordException {
        if(Validation.checkPassword(this.password)) {
            System.out.println("Enter amount you want to transfer to: " + other.getAccountNumber());
            Scanner input = new Scanner(System.in);
            int tAmount = input.nextInt();
            if(Validation.checkForEnoughAmount(this.amount, tAmount)) {
                this.setAmount(this.getAmount() - tAmount);
                other.setAmount(other.getAmount() + tAmount);
                System.out.println("Transfer successful your new amount: " + this.getAmount());
            } else {throw new NotEnoughAmountException("You don't have enough credit to transfer the amount!");}
        } else {throw new WrongPasswordException("You have entered a wrong password!");}
    }
}
