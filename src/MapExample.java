import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        // map.put("Key", "Value");
        dictionary.put("football", "축구");
        dictionary.put("baseball", "야구");

        // System.out.println(dictionary);
        // System.out.println(dictionary.get("football"));

        if (dictionary.isEmpty()){
            System.out.println("No words exist.");
            System.exit(0);
        } else{
            System.out.println("Total: " + dictionary.size() + " words exist.");
        }

        /*
        Scanner scanner = new Scanner(System.in);
        String english = scanner.nextLine();
        String korean = dictionary.get(english);

        if (korean == null) {
            System.out.println("Not exists in the list.");
        } else {
            System.out.println(english + " is " + korean + ".");
        }
        */

        /*
        Collection<String> keys = dictionary.keySet();

        for (String english : keys) {
            System.out.println(english);
        }
        */

        Set<Map.Entry<String, String>> entries = dictionary.entrySet();

        for (Map.Entry<String, String> entry : entries) {
            String english = entry.getKey();
            String korean = entry.getValue();

            System.out.println(english + ": " + korean);
        }
    }
}
