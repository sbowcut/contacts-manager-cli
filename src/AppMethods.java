import java.util.Scanner;

public class AppMethods {
    private final Scanner scanner;

    public AppMethods() {
        this.scanner = new Scanner(System.in);
    }

    public String getString() {
        return this.scanner.nextLine();
    }

    public String getString(String prompt) {
        System.out.println(prompt);
        return this.scanner.nextLine();
    }

    public int getInt() {
        return this.scanner.nextInt();
    }

    public long getInt(String prompt) {
        long number;
        try {
            number = Long.parseLong(getString(prompt));
            return number;
        } catch (NumberFormatException nfe) {
            System.out.println("Not a valid number, try again.");
            return getInt(prompt);
        }
    }

    public int getInt(String prompt, int min, int max) {
        System.out.println(prompt);
        int userNumber = this.scanner.nextInt();

        if (userNumber >= min && userNumber <= max) {
            return userNumber;
        } else {
            System.out.println("Not a valid selection, try again.");
            return getInt();
        }
    }
}