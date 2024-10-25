package com.stjean.operation;

import java.util.Arrays;

public class OperationMathematique {

    public static boolean estPositif(int nombre) {
        return nombre > 0;
    }

    public static int factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number cannot be negative.");
        }

        if (number == 0 || number == 1) {
            return 1;
        }

        return number * factorial(number - 1);
    }

    public static int[] sortDescending(int[] list) {
        Arrays.sort(list);
        reverseArray(list);
        return list;
    }

    private static void reverseArray(int[] list) {
        int left = 0;
        int right = list.length - 1;

        while (left < right) {
            int temp = list[left];
            list[left] = list[right];
            list[right] = temp;
            left++;
            right--;
        }
    }
}