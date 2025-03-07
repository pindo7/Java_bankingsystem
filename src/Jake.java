import java.util.Scanner;

public class Jake {
    public static void main(String[] args) {
        int choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Imperium Private Bank" + "\n");
        System.out.println("Press any key to continue");
        scan.nextLine();
        while (true) {
            System.out.println("Choose an option");
            System.out.println("1. Create account");
            System.out.println("2. Login to account");
            System.out.println("3. Other");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    Acc.createAccount();
                    break;
                case 2:
                    Acc.login();
                    break;
                case 3:
                    general.printOther();
                    break;
                case 4:
                    break;
            }
            if (choice == 4) {
                break;
            }
        }
    }
}
