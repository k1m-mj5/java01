import java.util.Scanner;

public class PriceOfFood01 {
    public static void main(String[] args) {
        System.out.println("Please enter a number.");
        System.out.println("1. Stake");
        System.out.println("2. Pizza");
        System.out.println("3. Hamburger");

        Scanner scanner = new Scanner(System.in);
        int menuNumber;

        try {
            menuNumber = scanner.nextInt();
        } catch (Exception e) {
            menuNumber = -1;
        }

        switch (menuNumber) {
            case 1:
                System.out.println("Stake is 10 USD.");
                break;
            case 2:
                System.out.println("Pizza is 7 USD.");
                break;
            case 3:
                System.out.println("Hamburger is 5 USD.");
                break;
            default:
                System.out.println("Please check the number.");
                break;
        }
    }
}
