import java.util.Scanner;

public class Jake {

    public static Double getDouble(){
        Scanner sc = new Scanner(System.in);
        double number;
        while(true){
            while (!sc.hasNextDouble()) {
                System.out.println("Enter an correct number");
                sc.nextLine();
            }
            number = sc.nextDouble();
            if(number < 0){
                System.out.println("Enter positive number");
            }
            else{
                break;
            }
        }
        return number;
    }

    public static Integer getInteger(){ //funkcia na prijatie správneho int
        Scanner sc = new Scanner(System.in);
        int number;
        while(true){
            while (!sc.hasNextInt()) {
                System.out.println("Enter an integer");
                sc.nextLine();
            }
            number = sc.nextInt();
            if(number < 0){
                System.out.println("Enter positive integer");
            }
            else{
                break;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        int choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Imperium Private Bank" + "\n");
        System.out.println("Press ENTER  to continue");
        scan.nextLine();
        while (true) {
            System.out.println("Choose an option");
            System.out.println("1. Create account");
            System.out.println("2. Login to account");
            System.out.println("3. Other");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = getInteger();
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
