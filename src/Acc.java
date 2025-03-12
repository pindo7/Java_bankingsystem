import javax.sql.rowset.spi.SyncProvider;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class Account {
    String lastName;
    String firstName;
    double balance;
    String pincode;
    int accountNumber;

    //Constructor
    Account(String lastName, String firstName, String pincode, int accountNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.pincode = pincode;
        this.balance = 0.0;
        this.accountNumber = accountNumber;

        // Print account details when created
        System.out.println("=== New Account Created ===");
        System.out.println("Owner: " + firstName + " " + lastName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
        System.out.println("Pincode: " + pincode);
    }

    public void accountInfo() {
        System.out.println("\n\n\n=== Account info ===");
        System.out.println("First Name: " + this.firstName);
        System.out.println("Last Name: " + this.lastName);
        System.out.println("Pincode: " + this.pincode);
        System.out.println("Balance: " + this.balance + '€');
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("\n");
    }

    public void depositMoney(double amount) {
        System.out.println("\n\n\n=== Money deposit ===");
        this.balance += amount;
        System.out.println("Balance: " + this.balance + "€");
    }

    public void withdrawMoney(double amount, String pincode) {
        System.out.println("\n\n\n");
        System.out.println("=== Money withdraw ===");
            if (this.balance - amount < 0 || this.balance == 0.0) {
                System.out.println("Insufficient Balance");
            } else {
                this.balance -= amount;
                System.out.println("Balance: " + this.balance);
        }
    }

    public void changePincode(String pincode) {
        this.pincode = pincode;
        System.out.println("Pincode: " + this.pincode);
    }
}
public class Acc {
    static Map<Integer, Account> accounts = new HashMap<>();
    static Account account;
    static Scanner sc = new Scanner(System.in);
    static int accountNumber, choice;
    static String pincode;
    static double amount;

    public static String getPincode(){
        String pin;
        while(true){
            System.out.println("Enter 4 digits pincode: ");
            pin = sc.nextLine();

            if (pin.length() != 4 || !pin.matches("\\d{4}")) {
                System.out.println("Incorrect format. Try again");
            }
            else{
                break;
            }
        }
        return pin;
    }

    public static void createAccount() {
        Random rand = new Random();
        accountNumber = rand.nextInt(9000000) + 1000000;
        String lastName, firstName;
        System.out.println("Create Account");
        System.out.print("Enter your first name: ");
        firstName = sc.nextLine(); //First name of account owner
        System.out.print("Enter your last name: ");
        lastName = sc.nextLine(); //Last name of account owner
        do {
            System.out.print("Enter your 4 digits pin code: ");
            pincode = sc.nextLine();
        } while (pincode.length() != 4 || !pincode.matches("\\d{4}")); //checks if pincode has length of 4 digits and if those 4 digits are within 0-9
        System.out.println("Accepted pincode: " + pincode); //Pincode to access the account
        account = new Account(firstName, lastName, pincode, accountNumber);
        accounts.put(accountNumber, account);
        System.out.println("Account created successfully");
        accountMenu();
    }

    public static void deleteAccount(int accountNumber) {
        account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account " + accountNumber + " not found");
        } else {
            accounts.remove(accountNumber);
            System.out.println("Account " + accountNumber + " deleted");
        }
    }

    public static void showAllAccounts() {
        int count = 0;
        System.out.println("=== All Accounts ===");
        for (Map.Entry<Integer, Account> entry : accounts.entrySet()) {
            System.out.println(count + ". Account number: " + entry.getKey());
            count++;
        }
        while (true) {
            System.out.println("Choose action");
            System.out.println("1. Show account info");
            System.out.println("2. Exit to menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    accountNumber = sc.nextInt();

                    break;
                case 2:
                    System.out.println("Exiting to menu");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            if (choice == 2) {
                break;
            }
        }
    }

    public static void login() {
        int count = 3;
        System.out.print("Enter account number: ");
        accountNumber = sc.nextInt();
        sc.nextLine();
        account = accounts.get(accountNumber);
        while (true) {
            if (account != null){
                System.out.print("Enter pincode:");
                pincode = sc.nextLine();
                if (account.pincode.equals(pincode)) {
                    System.out.println("Login successful");
                    accountMenu();
                    break;
                } else {
                    System.out.println("Wrong pincode");
                    System.out.println("You have " + (count - 1) + " attempts left");
                    count--;
                    if(count == 0){
                        System.out.println("You have no more attempts");
                        break;
                    }
                }
            }
            else{
                System.out.println("Account not found");
                break;
            }
            if (count == 0) {
                break;
            }
        }
    }

    public static void transferMoney(int fromAccountNumber, int toAccountNumber, double amount) {
        account = accounts.get(fromAccountNumber);
        int counter = 3;
        pincode = getPincode();
        while(true){
            if(account.pincode.equals(pincode)) {
                if (account.balance >= amount) {
                    account.balance -= amount;
                    account = accounts.get(toAccountNumber);
                    account.balance += amount;
                    System.out.println("Transaction successful");
                    break;
                } else {
                    System.out.println("Transaction failed. Insufficient Balance");
                    break;
                }
            }
            else{
                if(counter>0) {
                    System.out.println("You entered wrong pin. You have " + counter + " attempts left");
                    pincode = getPincode();
                    counter--;
                }
                else{
                    System.out.println("You have no more attempts");
                    System.out.println("Transaction failed");
                    break;
                }
            }
            }
        }

        public static void accountSettings(){
        while(true) {
            System.out.println("=== Account settings ===");
            System.out.println("1. Change password");
            System.out.println("2. Delete account");
            System.out.println("3. Exit");
            choice = Jake.getInteger();
            switch (choice) {
                case 1:
                    int counter = 3;
                    String newPincode;
                    System.out.print("Enter account number: ");
                    accountNumber = Jake.getInteger();
                    account = accounts.get(accountNumber);
                    if (account != null) {
                        while (true) {
                            pincode = getPincode();
                            if (account.pincode.equals(pincode)) {
                                System.out.print("Enter new pincode: ");
                                newPincode = getPincode();
                                account.changePincode(newPincode);
                                break;
                            } else {
                                System.out.println("Wrong pincode");
                                counter--;
                                if (counter == 0) {
                                    System.out.println("You have no more attempts");
                                    break;
                                }
                                System.out.print("Enter correct pincode " + counter + "attempts left: ");
                            }
                        }
                        break;
                    }
                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = Jake.getInteger();
                    deleteAccount(accountNumber);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            if(choice == 3){
                break;
            }
        }
    }

        public static void accountMenu() {
            int receiverAccountNumber;
            while (true) {
                System.out.println("=== Account Menu ===");
                System.out.println("1. Show account info");
                System.out.println("2. Deposit money");
                System.out.println("3. Withdraw money");
                System.out.println("4. Transfer money");
                System.out.println("5. Account settings");
                System.out.println("6. Other");
                System.out.println("7. Back to main menu");
                System.out.print("Enter your choice: ");
                choice = Jake.getInteger();
                switch (choice) {
                    case 1:
                        System.out.print("Enter account number: ");
                        accountNumber = Jake.getInteger();
                        account = accounts.get(accountNumber);
                        if(account != null){
                            account.accountInfo();
                            break;
                        }
                        else{
                            System.out.println("Account " + accountNumber + " not found");
                            break;
                        }
                    case 2:
                        System.out.print("Enter account number: ");
                        accountNumber = Jake.getInteger();
                        account = accounts.get(accountNumber);
                        if(account != null){
                            System.out.print("Enter amount to deposit: ");
                                amount = Jake.getDouble();
                                if (amount < 1) {
                                    System.out.println("Deposit failed! Minimal deposit is 1€");
                                }
                                else {
                                    account.depositMoney(amount);
                                    break;
                                }
                        }
                        else{
                            System.out.println("Account " + accountNumber + " not found");
                            break;
                        }
                    case 3:
                        int pincodeCounter = 3;
                        System.out.print("Enter account number: ");
                        accountNumber = Jake.getInteger();
                        account = accounts.get(accountNumber);
                        if(account != null){
                            while(true){
                                pincode = getPincode();
                                if(account.pincode.equals(pincode)) {
                                    System.out.print("Enter amount to withdraw: ");
                                    amount = Jake.getDouble();
                                    account.withdrawMoney(amount, pincode);
                                    break;
                                }
                                else{
                                    System.out.println("Wrong pincode");
                                    pincodeCounter--;
                                    if(pincodeCounter == 0){
                                        System.out.println("You have no more attempts");
                                        break;
                                    }
                                    System.out.println("Enter correct pincode - " + pincodeCounter + " attempts left");
                                }
                            }
                            break;
                        }
                        else{
                            System.out.println("Account " + accountNumber + " not found");
                            break;
                        }
                    case 4:
                        System.out.print("Enter account number: ");
                        accountNumber = Jake.getInteger();
                        System.out.print("Enter reciever account: ");
                        receiverAccountNumber = Jake.getInteger();
                        account = accounts.get(accountNumber);
                        System.out.print("Enter amount: ");
                        amount = Jake.getDouble();
                        if(account != null){
                            account = accounts.get(receiverAccountNumber);
                            if(account != null) {
                                transferMoney(accountNumber, receiverAccountNumber, amount);
                            }
                            else{
                                System.out.println("Account " + receiverAccountNumber + "not found" );
                            }
                        }
                        else{
                            System.out.println("Account " + accountNumber + " not found");
                        }
                        break;
                    case 5:
                        accountSettings();
                        break;
                    case 6:
                        general.printOther();
                        break;
                    case 7:
                        break;
                    default: System.out.println("Invalid choice");
                }
                if (choice == 7) {
                    break;
                }
            }
        }
    }