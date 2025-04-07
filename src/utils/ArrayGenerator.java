package utils;

import java.util.Random;

public class ArrayGenerator {
    public static int[] generateArray(int n){ //generates a randomly filled matrix of size n
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }
}
