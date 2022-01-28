public class If01 {
    public static void main(String[] args) {
        /*
        int money = 15;
        if (money >= 10) {
            System.out.println("Great!");
        } // result : Great!
        */

        /*
        int money = 5;
        if (money >= 10) {
            System.out.println("Great!");
        } else {
            System.out.println("Poor.");
        } // result : Poor.
        */

        int money = 6;
        if (money >= 10) {
            System.out.println("Great!");
        } else if (money >= 5) {
            System.out.println("Not bad.");
        }
        else {
            System.out.println("Poor.");
        } // result : Not bad.

    }
}
