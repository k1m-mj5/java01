public class Switch01 {
    public static void main(String[] args) {
        int month = 5;
        switch (month) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 5:
                System.out.println("May");
                break;
            default:
                System.out.println("Not matched.");
        } // result: May
    }
}
