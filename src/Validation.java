import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    // checking if the entered password equals the password from the costumer
    protected static Boolean checkPassword(String password){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your Password:");
        String n = input.next();
        return password.equals(n);
    }

    //checking if the costumer has enough money for withdrawal or transfer
    protected static Boolean checkForEnoughAmount(int amount, int n) {
        return amount > n;
    }

    // validate if the entered last or first name is a name and not a number
    protected static String validateName(String type) {
        String regex = "^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]+$";
        Pattern pat = Pattern.compile(regex);
        String name;
        boolean valid = true;
        Scanner input = new Scanner(System.in);
        do{
            if(!valid){
                System.out.println("This can't be a name");
            }
            System.out.println("Enter your " + type);
            name = input.next();
            Matcher mat = pat.matcher(name);
            valid = mat.matches();
        } while(!valid);
        return name;
    }

    // validating if the entered account number is a 3 digital number and not used by a other costumer
    protected static int validateAccountNumber() {
        int accountNumber;
        Boolean doubleUse;
        do{
            System.out.println("Enter a valid 3 digital Account Number you would like to have:");
            accountNumber = Validation.enterInt();
            if(BankCostumer.numbers.contains(accountNumber)){
                System.out.println("The number you wanted exists already");
                doubleUse = true;
            } else {
                doubleUse = false;
            }
        } while(accountNumber < 100 || accountNumber > 1000 || doubleUse);
        return accountNumber;
    }

    // validating password to the outpointed requirements
    protected static String validatePassword() {
        final String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        System.out.println(
                "Password must contain at least one digit [0-9].\n" +
                "Password must contain at least one lowercase Latin character [a-z].\n" +
                "Password must contain at least one uppercase Latin character [A-Z].\n" +
                "Password must contain at least one special character like ! @ # & ( ).\n" +
                "Password must contain a length of at least 8 characters and a maximum of 20 characters.");
        String password;
        boolean valid = true;
        Pattern pat = Pattern.compile(regex);
        Scanner input = new Scanner(System.in);
        do{
            if(!valid){
                System.out.println("Your password didn't match");
            }
            System.out.println("Enter a password of your choice that matches the requirements:");
            password = input.next();
            Matcher mat = pat.matcher(password);
            valid = mat.matches();
        } while(!valid);

        return password;
    }

    // handling the exception when entering a String or Character instead of an Integer
    protected static int enterInt() {
        Scanner input = new Scanner(System.in);
        int number = 0;
        boolean valid = true;
        do {
            try{
                number = input.nextInt();
                valid = false;
            } catch(Exception e) {
                input.next();
                System.out.println("The input must be of type Integers!");
            }
        } while(valid);

        return number;
    }
}
