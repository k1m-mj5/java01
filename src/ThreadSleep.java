public class ThreadSleep {
    public static void main(String[] args) {
        System.out.println("Guess your thinking.");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Happy!");
    }
}
