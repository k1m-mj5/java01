import java.util.Arrays;
import java.util.Scanner;

public class RoomsInCave {
    public static void main(String[] args) {
        int[] rooms = {0, 1, 2, 3}; // Room number

        int[][] links = {{1, 2, 3}, {2, 3, 0}, {3, 0, 1}, {0, 1, 2}};
        // the list can take

        int currentRoom = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Now you are in Room Number: " + currentRoom);
            System.out.println("Please take a room number you want.");

            System.out.println(Arrays.toString(links[currentRoom]));

            int roomNumber = scanner.nextInt();

            currentRoom = roomNumber;
        }


    }
}
