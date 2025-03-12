import java.util.Scanner;

public class general {

    public static void bankHistory() {
        System.out.println("Bank history");
        System.out.println("Founded in 1938, Imperium Private Bank was established\n" +
                "by Isaac Rothfeld, a wealthy German-Jewish financier who\n" +
                "foresaw the dark times approaching in Europe. With a vision\n" +
                "to protect and preserve the wealth of those facing persecution,\n" +
                "he emigrated to Switzerland, a land known for its neutrality\n" +
                "and financial security.\n" +
                "\n" +
                "Isaac Rothfeld built Imperium Private Bank on the principles\n" +
                "of absolute discretion, security, and financial sovereignty.\n" +
                "Over the decades, it became a fortress of wealth, trusted\n" +
                "by aristocrats, business magnates, and families seeking\n" +
                "an unbreakable safeguard for their fortunes.");
    }

    public static void termsConditions(){
        System.out.println("Imperium Private Bank – Terms & Conditions");
        System.out.println("1. Confidentiality & Privacy\n" +
                "Imperium Private Bank ensures absolute confidentiality\n" +
                "regarding all client information and transactions.\n" +
                "Swiss banking laws protect client data.\n");
        System.out.println("\n2. Account Eligibility\n" +
                "Accounts available only to pre-approved clients meeting\n" +
                "financial and security criteria. A minimum deposit is\n" +
                "required.\n");
        System.out.println("\n3. Asset Protection & Security\n" +
                "Funds are secured with biometric access, encrypted\n" +
                "transactions, and global diversification strategies.\n");
        System.out.println("\n4. Transaction & Withdrawal Policies\n" +
                "Transactions are secure. Large transfers may require\n" +
                "advance notice and verification for security.\n");
        System.out.println("\n5. Legal Compliance & Ethical Conduct\n" +
                "We adhere to Swiss regulations. Illicit activities\n" +
                "result in account suspension.\n");
        System.out.println("\n6. Amendments & Policy Updates\n" +
                "Terms updated to comply with evolving regulations.\n" +
                "Clients will be notified of changes.\n");
        System.out.println("\nBy using our services, you accept these terms,\n" +
                "ensuring a secure banking experience.");
    }

    public static void prinFAQ() {
        System.out.println("Frequently Asked Questions");
        System.out.println("Q: What are the requirements to open an account?");
        System.out.println("A: Clients need pre-approval, meet financial criteria, and make a minimum deposit.");

        System.out.println("\nQ: How secure are my funds?");
        System.out.println("A: Your funds are secured with biometric access, encrypted transactions, and advanced diversification.");

        System.out.println("\nQ: Can I access my account internationally?");
        System.out.println("A: Yes, our services are accessible worldwide with secure online platforms.");

        System.out.println("\nQ: What happens if I forget my account PIN?");
        System.out.println("A: You must contact our support team for PIN recovery following verification.");

        System.out.println("\nQ: Are there fees for large transactions?");
        System.out.println("A: Large transactions may incur processing fees and require prior notice.");
    }

    public static void contactUs() {
        System.out.println("Contact Us");
        System.out.println("Headquarters: Bergstrasse 17, 8001 Zürich, Switzerland");
        System.out.println("Phone: +41 44 123 4567");
        System.out.println("Fax: +41 44 234 5678");
        System.out.println("Email: contact@imperiumprivatebank.ch");
        System.out.println("Instagram: @ImperiumPrivateBank");
        System.out.println("Postal Address: P.O. Box 1234, 8001 Zürich, Switzerland");
    }

    public static void branchLocations() {
        System.out.println("Branch Locations");
        System.out.println("1. New York Branch: 123 Fifth Avenue, NY 10001, USA");
        System.out.println("2. London Branch: 45 Kensington High Street, London, UK");
        System.out.println("3. Tokyo Branch: 12 Chiyoda-ku, Tokyo, Japan");
        System.out.println("4. Sydney Branch: 80 George Street, Sydney, Australia");
    }

    public static void currencyExchangeRates(){
        System.out.println("Currency Exchange Rates (as of March 2, 2025)");
        System.out.println("1 USD = 0.92 EUR");
        System.out.println("1 USD = 0.78 GBP");
        System.out.println("1 USD = 114.32 JPY");
        System.out.println("1 USD = 0.85 CHF");
        System.out.println("1 USD = 1.35 CAD");
    }

    public static void printOther(){
        Scanner scan = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("Other");
            System.out.println("1. Bank history");
            System.out.println("2. Terms & Conditions");
            System.out.println("3. Currency exchange rates");
            System.out.println("4. FAQ");
            System.out.println("5. Contact us");
            System.out.println("6. Branch locations");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = Jake.getInteger();
            switch (choice) {
                case 1:
                    bankHistory();
                    break;
                case 2:
                    termsConditions();
                    break;
                case 3:
                    currencyExchangeRates();
                    break;
                case 4:
                    prinFAQ();
                    break;
                case 5:
                    contactUs();
                    break;
                case 6:
                    branchLocations();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            if (choice == 7) {
                break;
            }
        }
    }
}


