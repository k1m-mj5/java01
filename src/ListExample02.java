import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListExample02 {
    public static void main(String[] args) {
        System.out.println("Input a food name. (Exit: 0)");
        List<String> foods = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String food = scanner.nextLine();

            if (food.equals("0")) {
                break;
            }

            if (foods.contains(food)) {
                System.out.println("Already Exists");
            } else {
                foods.add(food);
            }
        }

        Collections.sort(foods);
        Collections.reverse(foods);
        Collections.shuffle(foods);

        System.out.println(foods);
    }
}
