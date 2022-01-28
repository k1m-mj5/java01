import java.util.Scanner;

public class Price {
    public static void main(String[] args) {
        System.out.println("Please enter a menu.");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        switch (name) {
            case "Stake":
                System.out.println("Stake is 10 USD.");
                break;
            case "Pizza":
                System.out.println("Pizza is 7 USD.");
                break;
            case "Hamburger":
                System.out.println("Hamburger is 5 USD.");
                break;
            default:
                System.out.println("No menu exist.");
        }
    }
}
