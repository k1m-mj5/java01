import java.util.Scanner;

public class StringToInteger {
    public static void main(String[] args) {
        System.out.println("Please enter a number.");
        Scanner scanner = new Scanner(System.in);
        String intInput = scanner.nextLine();

        try{
            int intValue = Integer.parseInt(intInput);
            System.out.println(intValue + 1);
        } catch (Exception e) {
            System.out.println("Enter digits.");
        }
    }
}

/*
Please enter a number.
100
101
 */
