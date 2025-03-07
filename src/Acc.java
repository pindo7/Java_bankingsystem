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

    public void accountInfo(Account account) {
        System.out.println("\n\n\n=== Account info ===");
        System.out.println("First Name: " + this.firstName);
        System.out.println("Last Name: " + this.lastName);
        System.out.println("Pincode: " + this.pincode);
        System.out.println("Balance: " + this.balance + '€');
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("\n");
    }

    public void depositMoney(Account account, double amount) {
        System.out.println("\n\n\n=== Money deposit ===");
        this.balance += amount;
        System.out.println("Balance: " + this.balance + "€");
    }

    public void withdrawMoney(Account account, double amount, String pincode) {
        System.out.println("\n\n\n");
        System.out.println("=== Money withdraw ===");
        if (this.pincode.equals(pincode)) {
            if (this.balance - amount < 0) {
                System.out.println("You don't have enough money");
            } else if (this.balance == 0) {
                System.out.println("Your account is empty");
            } else {
                this.balance -= amount;
                System.out.println("Balance: " + this.balance);
            }
        } else {
            System.out.println("Wrong pincode");
        }
    }
}

public class Acc {
    static Map<Integer, Account> accounts = new HashMap<>();

    public static void createAccount() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int accountNumber = rand.nextInt(9000000) + 1000000;
        String lastName, firstName, pincode;

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
        Account account = new Account(firstName, lastName, pincode, accountNumber);
        accounts.put(accountNumber, account);
        System.out.println("Account created successfully");
        accountMenu();
    }

    public static void printAccountInfo(int accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account " + accountNumber + " not found");
        } else {
            account.accountInfo(account);
        }
    }

    public static void depositMoney(int accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account " + accountNumber + " not found");
        } else {
            account.depositMoney(account, amount);
        }
    }

    public static void withdrawMoney(int accountNumber, double amount, String pincode) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account " + accountNumber + " not found");
        } else {
            account.withdrawMoney(account, amount, pincode);
        }
    }

    public static void deleteAccount(int accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println("Account " + accountNumber + " not found");
        } else {
            accounts.remove(accountNumber);
            System.out.println("Account " + accountNumber + " deleted");
        }
    }

    public static void showAllAccounts() {
        Scanner sc = new Scanner(System.in);
        int choice, accountNumber, count = 0;
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
                    printAccountInfo(accountNumber);
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
        int accountNumber;
        String pincode;
        int count = 3;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter account number: ");
        accountNumber = sc.nextInt();
        sc.nextLine();
        Account account = accounts.get(accountNumber);
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
            }
            if (count == 0) {
                break;
            }
        }
    }

        public static void accountMenu() {
            int choice;
            int accountNumber;
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("=== Account Menu ===");
                System.out.println("1. Show account info");
                System.out.println("2. Deposit money");
                System.out.println("3. Withdraw money");
                System.out.println("4. Transfer money");
                System.out.println("5. Loan application");
                System.out.println("7. Create a savings account");
                System.out.println("8. Account settings");
                System.out.println("9. Other");
                System.out.println("10. Logout");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter account number: ");
                        accountNumber = sc.nextInt();
                        Account account = accounts.get(accountNumber);
                        printAccountInfo(accountNumber);
                        break;
                    case 2:
                        System.out.print("Enter account number: ");
                        accountNumber = sc.nextInt();
                        double amount;
                        System.out.print("Enter amount: ");
                        amount = sc.nextDouble();
                        depositMoney(accountNumber, amount);
                        break;
                    case 3:
                        break;
                }
                if (choice == 3) {
                    break;
                }
            }
        }
    }