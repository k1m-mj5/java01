public class If02 {
    public static void main(String[] args) {
        /*
        int age = 15;
        if (age >=10 && age < 20) { // and
            System.out.println("Teenager");
        } else {
            System.out.println("Not Teenager");
        } // result: Teenager
        */

        int age = 25;
        if (age < 10 || age >= 20) { // or
            System.out.println("Not Teenager");
        } else {
            System.out.println("Teenager");
        } // result: Not Teenager
    }
}
