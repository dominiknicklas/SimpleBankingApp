// doppelte account numbers

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        boolean repeat = true;
        ArrayList<BankCostumer> costumers = new ArrayList<BankCostumer>();

        // as long as the user wants to do something this loop is running
        do {
            System.out.println("If you want to perform an action press 1 otherwise press 2");
            do {
                n = input.nextInt();
            } while (n < 1 || n > 2);
            System.out.println(n);

            if (n == 1) {
                System.out.println("What action do you want to perform?");
                System.out.println("Press 1 if you are an new Costumer and want to create an account");
                System.out.println("Press 2 if you want to withdrawl money");
                System.out.println("Press 3 if you want to deposit money");
                System.out.println("Press 4 if you want to transfer money to another existing account");
                System.out.println("Press 5 if you want to see your account balance");
                int m;
                do {
                    m = input.nextInt();
                } while (m < 1 || m > 5);
                System.out.println(n);
                switch (m) {
                    case 1:
                        costumers.add(CostumerCreator.createAccount());
                        break;
                    case 2:
                        int accountNumber2 = enterAccountNumber();
                        BankCostumer c1 = null;
                        for(BankCostumer i : costumers) {
                            if(i.getAccountNumber() == accountNumber2) {
                                c1 = i;
                            }
                        }
                        try {
                            if (c1 != null) {
                                c1.withdrawal();
                            } else {
                                System.out.println("The account number doesn't exist you have to create a new account!");
                            }
                        } catch(Exception e) {
                            System.out.println(e);
                        }
                        break;
                    case 3:
                        int accountNumber3 = enterAccountNumber();
                        for(BankCostumer i : costumers) {
                            try {
                                if (i.getAccountNumber() == accountNumber3) {
                                    i.deposit();
                                    break;
                                } else {
                                    System.out.println("The account number doesn't exist, you have to create an new account!");
                                }
                            } catch(Exception e) {
                                System.out.println(e);
                            }
                        }
                        break;
                    case 4:
                        int accountNumber4 = enterAccountNumber();
                        BankCostumer c2 = null;
                        BankCostumer c3 = null;
                        for(BankCostumer i : costumers) {
                            if(i.getAccountNumber() == accountNumber4) {
                                c2 = i;
                                System.out.println("Enter the account number to which you want to transfer the money");
                                int otherAccountNumber = enterAccountNumber();
                                for(BankCostumer o : costumers) {
                                    if(o.getAccountNumber() == otherAccountNumber) {
                                        c3 = o;
                                    }
                                }
                            }
                        }
                        try {
                            if (c2 != null && c3 != null) {
                                c2.transfer(c3);
                            } else if (c2 != null && c3 == null) {
                                System.out.println("The account you want to transfer to doesn't exist");
                            } else if (c2 == null) {
                                System.out.println("The account you want to transfer from doesn't exist");
                            }
                        }catch(Exception e) {
                            System.out.println(e);
                        }
                        break;
                    case 5:
                        int accountNumber5 = enterAccountNumber();
                        for(BankCostumer i : costumers) {
                            try {
                                if (i.getAccountNumber() == accountNumber5) {
                                    System.out.println(i.getAmount());
                                    break;
                                } else {
                                    System.out.println("The account number doesn't exist, you have to create an new account!");
                                }
                            } catch(Exception e) {
                                System.out.println(e);
                            }
                        }
                        break;
                }
            }
            if (n == 2) {
                repeat = false;
            }
        } while(repeat);
    }

    // methode to enter the Account number and checking if its valid
    public static int enterAccountNumber() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter account number:");
        int accountNumber = input.nextInt();
        if(accountNumber < 100 || accountNumber > 1000) {
            throw new IllegalArgumentException ("Account number must be a 3 digit number!");
        } else {
            return accountNumber;
        }
    }
}