import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Notepad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Press the number.");
            System.out.println("1. File Import");
            System.out.println("2. New Memo");
            System.out.println("3. Exit");

            int taskNum;

            try {
                String input = scanner.nextLine();
                taskNum = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect Number.");
                continue;
            }

            if (taskNum == 1){
                System.out.println("Input the file name.");

                String fileName = scanner.nextLine();

                FileInputStream inputStream = null;

                try {
                    inputStream = new FileInputStream(fileName);
                } catch (FileNotFoundException e) {
                    System.out.println("File not exist.");
                    continue;
                }

                System.out.println(fileName + "Loading.");

                Scanner reader = new Scanner(inputStream);

                while (reader.hasNextLine()){
                    System.out.println(reader.nextLine());
                }
                System.out.println("\n");

                reader.close();
            }

            else if (taskNum == 2){
                System.out.println("Enter the file name.");

                String fileName = scanner.nextLine();

                FileWriter writer = null;

                try {
                    writer = new FileWriter(fileName);
                } catch (IOException e) {
                    System.out.println("Failed to write file.");
                    continue;
                }

                System.out.println("Input memo.");
                System.out.println("To exit: Press enter in the blank");

                while (true) {
                    String input = scanner.nextLine();

                    if (input.equals("")){
                        break;
                    }

                    try {
                        writer.write(input);
                        writer.write("\n");
                    } catch (IOException e) {
                        System.out.println("Failed to write file.");
                    }
                }

                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Failed closing file.");
                }
            }

            else if (taskNum == 3) {
                System.out.println("Closing the program.");
                break;
            }

            else {
                System.out.println("Incorrect Number.");
            }
        }
    }
}
