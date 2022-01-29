public class ContinueExample {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i = i + 1){
            if (i % 2 == 0){
                continue;
            }
            System.out.println(i);
        }
    }
}
/*
1
3
5
7
9
*/