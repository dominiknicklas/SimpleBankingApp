import java.util.Scanner;

public class CostumerCreator {
    public static BankCostumer createAccount() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your First Name:");
        String firstName = input.next();
        System.out.println("Enter your Last Name:");
        String lastName = input.next();
        int accountNumber = Validation.validateAccountNumber();
        String password = Validation.validatePassword();
        System.out.println("Congratulations you are now Costumer at the Bank!");
        return new BankCostumer(firstName, lastName,accountNumber, password);
    }
}
