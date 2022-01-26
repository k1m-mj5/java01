public class StringExample03 {
    public static void main(String[] args) {
        String birthday = "1996/09/13";
        String year =  birthday.substring(0, 4);
        String day = birthday.substring(8);

        System.out.println(year); // 1996
        System.out.println(day);  // 13
    }
}
