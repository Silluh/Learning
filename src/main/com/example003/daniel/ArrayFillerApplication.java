package main.com.example003.daniel;


import java.security.SecureRandom;

public class ArrayFillerApplication {

    public static void main(String[] args) {

        int[] array1 = fillArraySequentially(1, 49);
        int[] array2 = fillArrayRandomly(6, 1, 49);

        printArray(array1);
        printArray(array2);
    }

    private static int[] fillArraySequentially(int firstNumber, int lastNumber) {

        int[] array = new int[lastNumber - firstNumber + 1];
        for (int i = firstNumber; i <= array.length; i++) {
            array[i - 1] = i;
        }

        return array;
    }

    private static int[] fillArrayRandomly(int countOfNumber, int rangeStart, int rangeStop) {

        SecureRandom secureRandom = new SecureRandom();
        int[] array = new int[countOfNumber];

        for (int i = 0; i < countOfNumber; i++) {
            array[i] = secureRandom.nextInt(rangeStop) - rangeStart;
        }

        return array;
    }

    private static void printArray(int[] array) {

        for(int number : array) {
            System.out.print(number + "\t");
        }
        System.out.println();
    }
}
