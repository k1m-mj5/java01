import java.util.Random;
import java.util.Scanner;

public class UpAndDownGame {
    public static void main(String[] args) {
        System.out.println("I pick a number from 0 to 255.");
        System.out.println("Guess the number I picked.");

        Random random = new Random();
        int randomNumber = random.nextInt(256);

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 8; i = i + 1){
            System.out.println(8 - i + " :Chance Left");

            System.out.println("Please input your guess.");
            String input = scanner.nextLine();
            int guess = Integer.parseInt(input);

            if (randomNumber == guess) {
                System.out.println("Great! Correct!");
                break;
            }

            else if (randomNumber < guess){
                System.out.println("Down!");
            }

            else {
                System.out.println("Up!");
            }

            if (i == 7) {
                System.out.println("No chance left.");
            }
        }
        System.out.println("The number is");
        System.out.println(randomNumber);
        System.out.println("Game Over");
    }
}
