import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        /*
        List<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<>();
        */
        list.add("Pasta");
        list.add("Pizza");

        // list.remove(0);
        // list.set(0,"Hamburger");

        // System.out.println(list);
        System.out.println(list.get(0));
    }
}
