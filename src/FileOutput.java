import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOutput {
    public static void main(String[] args) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("src/output01.txt", true);
        } catch (IOException e) {
            System.out.println("File creation failed.");
            System.exit(1);
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Press enter to exit.");

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("")){
                System.out.println("End of file input.");
                break;
            }

            try {
                writer.write(input + "\n");
            } catch (IOException e) {
                System.out.println("Failed to write file.");
                System.exit(2);
            }
        }

        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("Failed closing file.");
        }
    }
}
