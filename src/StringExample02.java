public class StringExample02 {
    public static void main(String[] args) {
        String chicken = "delicious ";
        String me = "my favorite food";

        /*

        System.out.println(chicken);
        System.out.println(me);

        System.out.println(chicken.length()); // 10
        int length = chicken.length();
        System.out.println(length); // 10

         */


        /*

        String chickenAndMe = chicken + me;
        System.out.println(chickenAndMe);

         */

        String replaced = me.replaceAll("my", "your");
        System.out.println(replaced);
    }
}
