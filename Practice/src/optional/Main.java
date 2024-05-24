package optional;

import java.util.Optional;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Optional<Integer> opt = getRandomNumber();
        opt.ifPresentOrElse(num -> System.out.println(num),
                () -> System.out.println("not found... got null value"));
    }

    static Optional<Integer> getRandomNumber() {
        Random random = new Random();
        int a = random.nextInt(100);
        if (a > 30) {
            return Optional.empty();
        } else return Optional.of(a);
    }
}
