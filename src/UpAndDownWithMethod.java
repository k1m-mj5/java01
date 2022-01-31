import java.util.Random;
import java.util.Scanner;

public class UpAndDownWithMethod {

    public static int ramdomNumber;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Random random = new Random();
        ramdomNumber = random.nextInt(256);

        int attempt = 0;

        while (attempt < 8) {
            boolean isCorrect = play();

            if (isCorrect) {
                break;
            }

            attempt = attempt + 1;
            System.out.println(attempt + " :times tried.");
        }
        System.out.println(ramdomNumber);
        System.out.println("Game Over.");
    }

    public static boolean play() {
        System.out.println("Input the number.");
        int input = scanner.nextInt();

        if (input == ramdomNumber) {
            System.out.println("Great! Correct!");
            return true;
        } else if (input > ramdomNumber) {
            System.out.println("Down");
        } else {
            System.out.println("Up");
        }

        return false;
    }
}
