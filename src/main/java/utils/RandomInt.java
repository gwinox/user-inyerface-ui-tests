package utils;

import java.util.Random;

public class RandomInt {
    private static final Random RANDOM = new Random();

    private RandomInt() {
    }

    public static int getRandomInt(int bound) {
        return RANDOM.nextInt(bound);
    }
}