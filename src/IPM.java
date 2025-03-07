//import java.util.HashMap;
//import java.util.Map;
//import java.util.Random;
//import java.util.Scanner;
//
//
//public class IPM {
//
//    public static void createAccount() {
//        Scanner sc = new Scanner(System.in);
//        Random rand = new Random();
//        int accountNumber = rand.nextInt(9000000) + 1000000;
//        String lastName, firstName, pincode;
//
//        System.out.println("Create Account");
//        System.out.print("Enter your first name: ");
//        firstName = sc.nextLine(); //First name of account owner
//        System.out.print("Enter your last name: ");
//        lastName = sc.nextLine(); //Last name of account owner
//        do {
//            System.out.print("Enter your 4 digits pin code: ");
//            pincode = sc.nextLine();
//        }while(pincode.length() != 4 || !pincode.matches("\\d{4}")); //checks if pincode has length of 4 digits and if those 4 digits are within 0-9
//        System.out.println("Accepted pincode: "+pincode); //Pincode to access the account
//        Account account = new Account(firstName, lastName, pincode, accountNumber);
//        accounts.put(accountNumber, account);
//    }
//
//    public static void printAccountInfo (int accountNumber) {
//        Account account = accounts.get(accountNumber);
//        if (account == null) {
//            System.out.println("Account " + accountNumber + " not found");
//        } else {
//            account.accountInfo(account);
//        }
//    }
//
//    public static void depositMoney (int accountNumber, double amount) {
//        Account account = accounts.get(accountNumber);
//        if (account == null) {
//            System.out.println("Account " + accountNumber + " not found");
//        }
//        else {
//            account.depositMoney(account, amount);
//        }
//    }
//
//    public static void withdrawMoney (int accountNumber, double amount, String pincode) {
//        Account account = accounts.get(accountNumber);
//        if (account == null) {
//            System.out.println("Account " + accountNumber + " not found");
//        }
//        else {
//            account.withdrawMoney(account, amount, pincode);
//        }
//    }
//
//    public static void deleteAccount(int accountNumber) {
//        Account account = accounts.get(accountNumber);
//        if (account == null) {
//            System.out.println("Account " + accountNumber + " not found");
//        }
//        else {
//            accounts.remove(accountNumber);
//            System.out.println("Account " + accountNumber + " deleted");
//        }
//    }
//
//    public static void showAllAccounts() {
//        Scanner sc = new Scanner(System.in);
//        int choice, accountNumber, count = 0;
//        System.out.println("=== All Accounts ===");
//        for (Map.Entry<Integer, Account> entry : accounts.entrySet()) {
//            System.out.println(count + ". Account number: " + entry.getKey());
//            count++;
//        }
//        while (true) {
//            System.out.println("Choose action");
//            System.out.println("1. Show account info");
//            System.out.println("2. Exit to menu");
//            System.out.print("Enter your choice: ");
//            choice = sc.nextInt();
//            switch (choice) {
//                case 1:
//                    System.out.print("Enter account number: ");
//                    accountNumber = sc.nextInt();
//                    printAccountInfo(accountNumber);
//                    break;
//                case 2:
//                    System.out.println("Exiting to menu");
//                    break;
//                default:
//                    System.out.println("Invalid choice");
//            }
//            if (choice == 2) {
//                break;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int choice, accountNumber;
//        double amount;
//        String pincode;
//        while (true) {
//            System.out.println("Menu");
//            System.out.println("1. Create Account");
//            System.out.println("2. Show Account");
//            System.out.println("3. Deposit money");
//            System.out.println("4. Withdraw money");
//            System.out.println("5. Delete account");
//            System.out.println("6. Show All Accounts");
//            System.out.println("7. Exit");
//            System.out.print("Enter your choice: ");
//            choice = scan.nextInt();
//            switch (choice) {
//                case 1:
//                    createAccount();
//                    break;
//                case 2:
//                    System.out.print("Enter your account number: ");
//                    accountNumber = scan.nextInt();
//                    printAccountInfo(accountNumber);
//                    break;
//                case 3:
//                    System.out.print("Enter your account number: ");
//                    accountNumber = scan.nextInt();
//                    System.out.print("Enter your amount to deposit: ");
//                    amount = scan.nextDouble();
//                    depositMoney(accountNumber, amount);
//                    break;
//                case 4:
//                    System.out.print("Enter your account number: ");
//                    accountNumber = scan.nextInt();
//                    scan.nextLine();
//                    System.out.print("Enter account pincode: ");
//                    pincode = scan.nextLine();
//                    System.out.print("Enter your amount to withdraw: ");
//                    amount = scan.nextDouble();
//                    withdrawMoney(accountNumber, amount, pincode);
//                    break;
//                case 5:
//                    System.out.print("Enter your account number: ");
//                    accountNumber = scan.nextInt();
//                    deleteAccount(accountNumber);
//                    break;
//                case 6:
//                    showAllAccounts();
//                    break;
//                case 7:
//                    break;
//                default: System.out.println("Invalid choice");
//            }
//            if (choice == 7) {
//                break;
//            }
//        }
//
//    }
//}
