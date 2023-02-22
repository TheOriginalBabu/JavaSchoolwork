import java.util.Scanner;

public class Boringloops {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("Please choose an option:");
            System.out.println("1. Menu (WHILE LOOP)");
            System.out.println("2. Postal Code Verification (FOR LOOP)");
            System.out.println("3. Multiplication Table (FOR LOOP)");
            System.out.println("4. Quit");
            System.out.print("Enter your choice (1-4): ");

            if (input.hasNextInt()) {
                choice = input.nextInt();

                switch (choice) {
                    case 1:
                        while (true) {
                            System.out.println("Please select an option:");
                            System.out.println("A. Option A");
                            System.out.println("B. Option B");
                            System.out.println("C. Option C");
                            System.out.print("Enter your choice (A-C): ");

                            String menuChoice = input.next().toUpperCase();

                            if (menuChoice.equals("A")) {
                                System.out.println("You selected Option A.");
                                break;
                            } else if (menuChoice.equals("B")) {
                                System.out.println("You selected Option B.");
                                break;
                            } else if (menuChoice.equals("C")) {
                                System.out.println("You selected Option C.");
                                break;
                            } else {
                                System.out.println("Invalid option selected. Please try again.");
                            }
                        }
                        break;

                    case 2:
                        while (true) {
                            System.out.print("Please enter a postal code: ");
                            String postalCode = input.next();

                            if (postalCode.matches("[A-Z][0-9][A-Z] [0-9][A-Z][0-9]")) {
                                System.out.println("Valid postal code entered.");
                                break;
                            } else {
                                System.out.println("Invalid postal code entered. Please try again.");
                            }
                        }
                        break;

                    case 3:
                        while (true) {
                            System.out.print("Please enter an integer: ");

                            if (input.hasNextInt()) {
                                int num = input.nextInt();

                                for (int i = 1; i <= 999999999; i++) {
                                    System.out.println(num + " x " + i + " = " + (num * i));
                                }

                                break;
                            } else {
                                System.out.println("Invalid input entered. Please enter an integer.");
                                input.next();
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("Invalid option selected. Please try again.");
                        break;
                }
            } else {
                System.out.println("Invalid input entered. Please enter a number.");
                input.next();
            }

            System.out.println();
        } while (choice != 4);

        input.close();
    }
}
