import java.util.Scanner;

public class WhileExample02 {
    public static void main(String[] args) {
        String password = "abc123";
        Scanner scanner = new Scanner(System.in);

        /*
        String input;

        do {
            System.out.println("Please enter your password.");
            input = scanner.nextLine();
        } while (input.equals(password) != true);

        System.out.println("Correct password.");
       */
        while (true) {
            System.out.println("Please enter your password.");
            String input = scanner.nextLine();

            if (input.equals(password)){
                System.out.println("Correct password.");
                break;
            }

            System.out.println("Incorrect password.");
        }
    }
}
