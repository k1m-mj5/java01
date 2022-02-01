import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> myFavoriteFruits = new HashSet<>();

        myFavoriteFruits.add("Bananas");
        myFavoriteFruits.add("Apples");
        myFavoriteFruits.add("Oranges");

        System.out.println(myFavoriteFruits);
        // [Apples, Bananas, Oranges]
    }
}
