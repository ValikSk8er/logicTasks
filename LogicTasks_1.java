package com.academy.homeworks;

import java.io.IOException;
import java.util.Arrays;

public class LogicTasks_1 extends BaseTask {

    public static void main(String[] args) throws IOException {

        while (true){
            // NOTE: uncomment necessary task and run
//            LogicTasks_1.arrayRotation();
//            LogicTasks_1.restoreArray();
//            LogicTasks_1.ranges();
        }
    }

    public static void arrayRotation() throws IOException {
        System.out.println("Please enter an array length and 'k' value:");
        String[] parameters = readLine().split(SPACE_TEXT);

        System.out.println("Please enter values, one by one:");
        String[] stringValues = readLine().split(SPACE_TEXT);

        int arrayLength = Integer.parseInt(parameters[0]);
        int k = Integer.parseInt(parameters[1]);
        int startIndex = k;
        int[] values = Arrays.stream(stringValues)
                .limit(arrayLength)
                .mapToInt(Integer::parseInt)
                .toArray();

        arrayRotation(values, k, startIndex);
        System.out.println();
    }

    private static void arrayRotation(int[] values, int currentIndex, int startIndex) {
        if (currentIndex == values.length) {
            currentIndex = 0;
            arrayRotation(values, currentIndex, startIndex);
        } else {
            System.out.print(values[currentIndex] + SPACE_TEXT);

            if (currentIndex + 1 == startIndex) {
                return;
            } else {
                arrayRotation(values, ++currentIndex, startIndex);
            }
        }
    }

    public static void restoreArray() throws IOException {
        System.out.println("Please enter an array length:");
        int arrayLenght = Integer.parseInt(readLine());

        System.out.println("Please enter values, one by one:");
        String[] stringValues = readLine().split(SPACE_TEXT);

        int[] values = Arrays.stream(stringValues)
                .limit(arrayLenght)
                .mapToInt(Integer::parseInt)
                .toArray();
        int startIndex = 0;
        restoreArray(values, startIndex);
        System.out.println();
    }

    private static void restoreArray(int[] values, int currentIndex) {
        if (currentIndex == values.length) {
            return;
        } else {
            int currentValue = values[currentIndex];
            if (currentValue < 0) {
                if (values[currentIndex - 1] > values[currentIndex + 1]) {
                    currentValue = values[currentIndex - 1] - 1;
                } else {
                    currentValue = values[currentIndex - 1] + 1;
                }
            } else {
                currentValue = values[currentIndex];
            }
            System.out.print(currentValue + SPACE_TEXT);
            restoreArray(values, ++currentIndex);
        }
    }

    public static void ranges() throws IOException {
        System.out.println("Please enter an array length:");
        int arrayLenght = Integer.parseInt(readLine());

        System.out.println("Please enter values, one by one:");
        String[] stringValues = readLine().split(SPACE_TEXT);

        int[] values = Arrays.stream(stringValues)
                .limit(arrayLenght)
                .mapToInt(Integer::parseInt)
                .toArray();

        int min = values[0];
        int max = min;

        for (int i = 1; i <= values.length; i++) {
            if (i == values.length || values[i] - 1 != max) {
                if (min == max) {
                    System.out.printf("[%d]", min);
                } else {
                    System.out.printf("[%d %d]", min, max);
                }
                if (i == values.length) {
                    break;
                }
                min = values[i];
            }
            max = values[i];
        }
        System.out.println();
    }
}
