import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class HuntTheWumpus {

    public static Integer[] rooms = {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19
    };

    public static Integer[][] links = {
            {1, 7, 4}, {8, 9, 2}, {1, 11, 3}, {2, 13, 4}, {3, 8, 5},
            {4, 14, 6}, {5, 16, 7}, {6, 0, 8}, {7, 17, 9}, {8, 1, 10},
            {9, 18, 11}, {10, 2, 12}, {11, 19, 13}, {12, 3, 14}, {13, 5, 15},
            {14, 19, 16}, {15, 6, 17}, {16, 8, 18}, {17, 10, 19}, {18, 12, 15}
    };

    public static String WUPUS = "Wumpus";
    public static String BAT = "Bat";
    public static String PIT = "Pit";
    public static String NOTHING = "Nothing";

    public static ArrayList<String> hazards = new ArrayList<>();
    public static HashMap<String, String> hazardMessages = new HashMap<>();

    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    public static boolean gameOver = true;

    public static int currentRoom;
    public static int arrowCount;
    public static int wumpusRoom;

    public static void main(String[] args) {
        showIntro();

        initializeStaticValues();

        while (true) {
            initializePlayVariables();

            setupHazards();

            delay(1000L);
            System.out.println("\n...");
            delay(1000L);
            System.out.println("...");
            delay(1000L);
            System.out.println("You are in a cave.");
            delay(1000L);
            System.out.println("\"It's a creepy place.\"");
            delay(1000L);

            game();

            selectReplay();
        }
    }

    public static void delay(Long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {
        }
    }

    private static void showIntro() {
        try {
            FileInputStream inputStream = new FileInputStream("src/intro.txt");
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
                delay(500L);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Leave out, can not loading the intro.");
        }
    }

    private static void initializePlayVariables() {
        gameOver = false;

        currentRoom = random.nextInt(rooms.length);
        arrowCount = 5;
    }

    public static void initializeStaticValues() {
        hazardMessages.put(WUPUS, "\"Smell unusually bad.\"");
        hazardMessages.put(BAT, "\"Hear a rustling sound.\"");
        hazardMessages.put(PIT, "\"You will feel a breeze.\"");
        hazardMessages.put(NOTHING, "\"Seems to be nothing there.\"");
    }

    public static void setupHazards() {
        if (hazards.size() == 0) {
            for (int i = 0; i < rooms.length; i = i + 1) {
                hazards.add(NOTHING);
            }
        }

        for (int i = 0; i < rooms.length; i = i + 1) {
            hazards.set(i, NOTHING);
        }

        String[] ordinals = {WUPUS, BAT, BAT, BAT, PIT, PIT};

        for (String hazard : ordinals) {
            int room;

            while (true) {
                room = random.nextInt(rooms.length);

                if (isTooCloseWithPlayer(room)) {
                    continue;
                }

                if (hazards.get(room).equals(NOTHING)){
                    break;
                }
            }

            hazards.set(room, hazard);

            if (hazard.equals(WUPUS)) {
                wumpusRoom = room;
            }
        }
    }

    public static boolean isTooCloseWithPlayer(int room) {
        if (currentRoom == room) {
            return true;
        }

        List<Integer> linkedRooms = Arrays.asList(links[currentRoom]);
        if (linkedRooms.contains(room)) {
            return true;
        }

        return false;
    }

    private static void selectReplay() {
        System.out.println("Game Over. Replay?");

        while (true) {
            System.out.println("(0: Exit, 1: Replay)");
            String action = scanner.nextLine();

            if (action.equals("0")) {
                System.out.println("Exit");
                System.exit(0);
            }

            else if (action.equals("1")){
                System.out.println("Replay");
                break;
            }

            else {
                System.out.println("Wrong Input");
            }
        }
    }

    private static void game() {
        while (gameOver == false) {
            System.out.println("\nYou are in Room Number: " + currentRoom );
            System.out.println("Choose one");
            System.out.println("1. Move");
            System.out.println("2. Shoot");
            System.out.println("3. Patyway list");
            System.out.println("0. Play closing");

            String action = scanner.nextLine();

            if (action.equals("1")) {
                Integer[] nextRooms = links[currentRoom];

                System.out.println("\nWhich room do you want to move?");
                System.out.println(Arrays.toString(nextRooms));

                String nextRoomInput = scanner.nextLine();
                int nextRoom = parseIntegerOrNegative1(nextRoomInput);

                if (Arrays.asList(nextRooms).contains(nextRoom)) {
                    move(nextRoom);
                } else {
                    System.out.println("You can not move to that room number.");
                }
            }

            else if (action.equals("2")){
                Integer[] nextRooms = links[currentRoom];

                System.out.println("\nWhich Room do you want to shoot?");
                System.out.println(Arrays.toString(nextRooms));

                String targetRoomInput = scanner.nextLine();
                int targetRoom = parseIntegerOrNegative1(targetRoomInput);

                if (Arrays.asList(nextRooms).contains(targetRoom)) {
                    shoot(targetRoom);
                } else {
                    System.out.println("You can not shoot that room.");
                }
            }

            else if (action.equals("3")){
                System.out.println("This is the pathway list in current room.");
                System.out.println(Arrays.asList(links[currentRoom]));
            }

            else if (action.equals("0")){
                System.out.println("The play will be end.");
                gameOver = true;
            }

            else {
                System.out.println("Wrong Input.");
            }
        }
    }

    public static int parseIntegerOrNegative1(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void move(int room) {
        currentRoom = room;
        System.out.println("You moved to Room Number: " + currentRoom);

        String hazard = hazards.get(currentRoom);

        delay(1000L);

        if (hazard.equals(WUPUS)) {
            System.out.println("\"Nooooo!\"");
            delay(300L);
            System.out.println("Wumpus ate you.");
            gameOver = true;
        }

        else if (hazard.equals(PIT)) {
            System.out.println("\"Nooooo!\"");
            delay(1000L);
            System.out.println("CRASH!");
            delay(300L);
            System.out.println("You fell into a pit");
            delay(300L);
            System.out.println("You can not hunt any more.");
            gameOver = true;
        }

        else if (hazard.equals(BAT)) {
            System.out.println("CRASH!");
            delay(300L);
            System.out.println("Bat catches you and drops another room.");

            do {
                currentRoom = random.nextInt(rooms.length);
            } while (hazards.get(currentRoom).equals(BAT));

            hazards.set(room, NOTHING);

            while (true) {
                int newBatRoom = random.nextInt(rooms.length);

                if (newBatRoom == currentRoom) {
                    continue;
                }

                if (hazards.get(newBatRoom).equals(NOTHING)){
                    hazards.set(newBatRoom, BAT);
                    break;
                }
            }

            move(currentRoom);
        }
        else {
            List<Integer> nextRooms = Arrays.asList(links[currentRoom]);

            System.out.println("\n(Check pathways.)");
            for (int nextRoom : nextRooms) {
                delay(700L);
                String hazardAround = hazards.get(nextRoom);
                System.out.println(hazardMessages.get(hazardAround));
            }
            Collections.shuffle(nextRooms);
        }
    }

    public static void shoot(int room) {
        arrowCount = arrowCount -1;

        delay(1000L);
        System.out.println("shhhhh");
        delay(300L);

        if (hazards.get(room).equals(WUPUS)) {
            System.out.println("floooop");
            delay(100L);
            System.out.println("kwaooooo");
            delay(1000L);
            System.out.println("Great! You killed wumpus!");
            gameOver = true;
        }

        else {
            System.out.println("(...)");
            delay(1000L);
            System.out.println("\"Just wasted a shoot.\"");

            if (arrowCount == 0) {
                delay(300L);
                System.out.println("\"Oh, I don't have chances more.\"");
                delay(300L);
                System.out.println("Sorry. You failed.");
                gameOver = true;
            }

            else if (random.nextInt(4) !=0) {
                System.out.println("You wake wumpus up.");
                delay(1000L);

                Integer[] nextRooms = links[wumpusRoom];

                int nextRoom = nextRooms[random.nextInt(3)];

                if (hazards.get(nextRoom).equals(NOTHING)){
                    hazards.set(wumpusRoom, NOTHING);
                    hazards.set(nextRoom, WUPUS);
                    wumpusRoom = nextRoom;
                }

                if (wumpusRoom == currentRoom) {
                    System.out.println("\"Nooooo!\"");
                    delay(500L);
                    System.out.println("Wumpus ate you.");
                    gameOver = true;
                }

                else if (wumpusRoom == nextRoom) {
                    System.out.println("Wumpus ran way.");
                }
            }
        }
    }

}
