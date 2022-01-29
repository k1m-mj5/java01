public class ArrayExample {
    public static void main(String[] args) {
        String[] days = {"Mon","Tues","Wednes","Thurs","Fri","Satur","Sun"};
        /*
        System.out.println(days[0]);
        System.out.println(days[6]);
        */

        /*
        int lengthOfDays = days.length;
        System.out.println(lengthOfDays);
        */

        /*
        for (int i = 0; i < days.length; i = i + 1){
            System.out.println(days[i] + "day");
        }
        */

        for (String day : days) {
            System.out.println(day + "day");
        }
    }
}
