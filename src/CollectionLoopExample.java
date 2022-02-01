import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionLoopExample {
    public static void main(String[] args) {
        /*
        List<String> fruits = new ArrayList<>();

        fruits.add("Bananas");
        fruits.add("Apples");
        fruits.add("Oranges");

        for (String fruit : fruits) {
            System.out.println(fruit + " I Like it.");
        }
        */

        Set<String> fruits = new HashSet<>();

        fruits.add("Bananas");
        fruits.add("Apples");
        fruits.add("Oranges");

        if (fruits.isEmpty()) {
            System.out.println("This list is empty.");
        } else {
            System.out.println("Total: " + fruits.size());
        }
    }
}
