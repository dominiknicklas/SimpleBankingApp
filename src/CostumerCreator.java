public class CostumerCreator {
    // creating a new Costumer of the bank
    public static BankCostumer createAccount() {
        String firstName = Validation.validateName("First Name");
        String lastName = Validation.validateName("Last Name");
        int accountNumber = Validation.validateAccountNumber();
        String password = Validation.validatePassword();
        System.out.println("Congratulations you are now Costumer at the Bank!");
        return new BankCostumer(firstName, lastName,accountNumber, password);
    }
}
