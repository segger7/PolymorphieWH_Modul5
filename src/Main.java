import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        for(int i = 0; i < 20; i++) {
            int chance = ThreadLocalRandom.current().nextInt(5,11);
            System.out.println(chance);
        }
    }
}