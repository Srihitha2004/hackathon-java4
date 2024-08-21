import java.util.Random;
import java.util.Scanner;

public class Passystem {
    private static String textPassword = "rootpass";
    private static String graphicalPassword = "123654"; 
    private static String securityAnswer = "chicken";  

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Three-Level Password System");
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Create a new password");
            System.out.println("2. Login with existing password");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    setupPasswords(scanner);
                    break;
                case 2:
                    login(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the system. Going Back, Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void setupPasswords(Scanner scanner) {
        System.out.print("Set your textual password: ");
        textPassword = scanner.nextLine();
        System.out.print("Set your graphical password (e.g., shape name): ");
        graphicalPassword = scanner.nextLine();
        System.out.print("Set your answer to the security question 'What is your favorite food?': ");
        securityAnswer = scanner.nextLine();
        System.out.println("Passwords and security answer have been set successfully!");
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter your textual password: ");
        String userTextPassword = scanner.nextLine();
        if (!userTextPassword.equals(textPassword)) {
            System.out.println("Incorrect textual password. Access denied.");
            return;
        }
        System.out.print("Enter your graphical password (e.g., shape name): ");
        String userGraphicalPassword = scanner.nextLine();
        if (!userGraphicalPassword.equalsIgnoreCase(graphicalPassword)) {
            System.out.println("Incorrect graphical password. Access denied.");
            return;
        }
        System.out.println("What is your favorite food?");
        System.out.print("Enter your answer: ");
        String userSecurityAnswer = scanner.nextLine();
        if (!userSecurityAnswer.equalsIgnoreCase(securityAnswer)) {
            System.out.println("Incorrect answer to the security question. Access denied.");
            return;
        }
        String captcha = generateCaptcha();
        System.out.println("CAPTCHA: " + captcha);
        System.out.print("Enter the CAPTCHA: ");
        String userCaptcha = scanner.nextLine();
        if (!userCaptcha.equals(captcha)) {
            System.out.println("Incorrect CAPTCHA. Access denied.");
            return;
        }
        System.out.println("Access granted. You have successfully logged in!");
        System.exit(0); 
    }
    
    private static String generateCaptcha() {
        Random random = new Random();
        int length = 6;
        StringBuilder captcha = new StringBuilder();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < length; i++) {
            captcha.append(chars.charAt(random.nextInt(chars.length())));
        }
        return captcha.toString();
    }
}
