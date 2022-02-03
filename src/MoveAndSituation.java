import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MoveAndSituation {
    public static int[] rooms = {0, 1, 2, 3};

    public static int[][] links = {{1,2,3}, {2,3,0}, {3,0,1}, {0,1,2}};

    public static String BAT = "Bat";
    public static String PIT = "Pit";
    public static String WUMPUS = "Wumpus";
    public static String NOTHING = "Nothing";

    public static String[] hazards = {NOTHING, BAT, PIT, WUMPUS};

    public static int currentRoom = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Now you are in Room Number: " + currentRoom);

            int[] nextRooms = links[currentRoom];

            System.out.println("Please take a room number you want.");
            System.out.println(Arrays.toString(nextRooms));

            int roomNumber = scanner.nextInt();

            move(roomNumber);
        }
    }

    private  static void move(int room) {
        // move to the room taken
        currentRoom = room;

        String hazardInRoom = hazards[currentRoom];

        if (hazardInRoom.equals(WUMPUS)) {
            System.out.println("WUPUS eats you.");
        }
        else if (hazardInRoom.equals(PIT)){
            System.out.println("You fall it.");
        }
        else if (hazardInRoom.equals(BAT)){
            System.out.println("Bat catches you and drops another room.");

            Random random = new Random();

            do {
                currentRoom = random.nextInt(rooms.length);
            } while (hazards[currentRoom].equals(BAT));

            hazards[room] = NOTHING;

            while(true){
                int newBatRoom = random.nextInt(rooms.length);

                if (newBatRoom == currentRoom) {
                    continue;
                }
                if (hazards[newBatRoom].equals(NOTHING)){
                    hazards[newBatRoom] = BAT;
                    break;
                }
            }

            move(currentRoom);
        }
    }
}
