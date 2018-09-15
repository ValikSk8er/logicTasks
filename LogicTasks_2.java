package com.academy.homeworks;

import java.io.IOException;

public class LogicTasks_2 extends BaseTask {

    public static void main(String[] args) throws IOException {

        while (true){
            // NOTE: uncomment necessary task and run
//            palindrome();
//            stringPartReverse();
//            frequency();
        }
    }

    public static void palindrome() throws IOException {
        System.out.println("Please enter text:");
        String inputText = readLine();

        int startIndex = 0;

        String result = palindrome(inputText, startIndex);
        System.out.println(result);
    }

    private static String palindrome(String word, int index) {
        int indexToCompare = word.length() - 1 - index;

        if (word.charAt(index) != word.charAt(indexToCompare)) {
            return "isn't palindrome";
        }
        if (index == word.length() / 2 - 1) {
            return "is palindrome";
        }
        return palindrome(word, ++index);
    }

    public static void stringPartReverse() throws IOException {
        System.out.println("Please enter parameters (example: 2 4 abcdefg)");
        String[] inputParameters = readLine().split(SPACE_TEXT);

        int i = Integer.parseInt(inputParameters[0]);
        int j = Integer.parseInt(inputParameters[1]);
        char[] chars = inputParameters[2].toCharArray();

        char[] substring = new char[(j - i) + 1];
        char[] reversedSub = new char[(j - i) + 1];

        for (int k = i; k <= j / 2; k++) {
            char buffer = chars[k];
            chars[k] = chars[j - (k - i)];
            chars[j - (k - i)] = buffer;
        }

        for (int k = i; k <= j; k++) {
            reversedSub[k - i] = chars[k];
            substring[k - i] = chars[j - (k - i)];
        }

        System.out.print(chars);
        System.out.print(" substring \"");
        System.out.print(substring);
        System.out.print("\" was reversed to \"");
        System.out.print(reversedSub);
        System.out.println("\"");
    }

    public static void frequency() throws IOException {
        System.out.println("Please enter a character:");
        char character = readLine().charAt(0);

        System.out.println("Please enter a word:");
        String inputText = readLine();

        int currentIndex = 0;
        int counter = 0;

        counter = frequency(inputText, character, currentIndex, counter);

        System.out.println(counter);
    }

    private static int frequency(String word, char character, int currentIndex, int counter) {
        if (currentIndex == word.length()) {
            return counter;
        }
        if (word.charAt(currentIndex) == character) {
            return frequency(word, character, ++currentIndex, ++counter);
        } else {
            return frequency(word, character, ++currentIndex, counter);
        }
    }
}
