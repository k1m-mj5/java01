import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class HazardInRoom {
    public static void main(String[] args) {
        int[] rooms = {0, 1, 2, 3};

        String BAT = "Bat";
        String PIT = "Pit";
        String WUMPUS = "Wumpus";
        String NOTHING = "Nothing";

        String[] hazards = {NOTHING, BAT, PIT, WUMPUS};

        HashMap<String, String> hazardMessages = new HashMap<>();

        hazardMessages.put(WUMPUS, "\"Smell unusually bad.\"");
        hazardMessages.put(BAT, "\"Hear a rustling sound.\"");
        hazardMessages.put(PIT, "\"You will feel a breeze.\"");
        hazardMessages.put(NOTHING, "\"Seems to be nothing there.\"");

        int[][] links = {{1,2,3}, {2,3,0}, {3,0,1}, {0,1,2}};

        int currentRoom = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Now you are in Room Number: " + currentRoom);

            int[] nextRooms = links[currentRoom];

            for (int nextRoom: nextRooms) {
                String hazard = hazards[nextRoom];
                String message = hazardMessages.get(hazard);
                System.out.println(message);
            }

            System.out.println("Please take a room number you want.");
            System.out.println(Arrays.toString(nextRooms));

            int roomNumber = scanner.nextInt();

            currentRoom = roomNumber;
        }

    }
}
