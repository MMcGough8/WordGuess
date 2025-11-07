package com.github.zipcodewilmington;

import java.util.Scanner;

/**
 * Marc McGough
 * Date: 11/03/2025
 *
 * AlphabetValue - Assigns numerical values to letters (a=1, b=2, etc.)
 */
public class AlphabetValue {

    /**
     * Returns the numerical value of a letter (a=1, b=2, c=3, etc.)
     * @param letter the letter to get the value for
     * @return the numerical value (1-26), or 0 if not a valid letter
     */
    public static int getLetterValue(char letter) {
        letter = Character.toLowerCase(letter);
        if (letter >= 'a' && letter <= 'z') {
            return letter - 'a' + 1;
        }
        return 0;
    }

    /**
     * Calculates the sum of all letter values in a word
     * @param word the word to calculate the value for
     * @return the sum of all letter values
     */
    public static int getWordValue(String word) {
        int total = 0;
        for (char c : word.toCharArray()) {
            total += getLetterValue(c);
        }
        return total;
    }

    /**
     * Displays the alphabet with corresponding numerical values
     */
    public static void displayAlphabet() {
        System.out.println("\nAlphabet Numerical Values:");
        System.out.println("==========================");
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.printf("%c = %d%n", c, getLetterValue(c));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Alphabet Value Calculator!");

        displayAlphabet();

        System.out.println("\nEnter a letter or word to get its numerical value (or 'quit' to exit):");

        while (true) {
            System.out.print("\n> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye!");
                break;
            }

            if (input.isEmpty()) {
                continue;
            }

            if (input.length() == 1) {
                char letter = input.charAt(0);
                int value = getLetterValue(letter);
                if (value > 0) {
                    System.out.println("Letter '" + letter + "' has a value of: " + value);
                } else {
                    System.out.println("Invalid letter. Please enter a letter from a-z.");
                }
            } else {
                int wordValue = getWordValue(input);
                System.out.println("Word '" + input + "' has a total value of: " + wordValue);

                // Show individual letter values
                System.out.print("Breakdown: ");
                for (int i = 0; i < input.length(); i++) {
                    char c = input.charAt(i);
                    int value = getLetterValue(c);
                    if (value > 0) {
                        System.out.print(c + "=" + value);
                        if (i < input.length() - 1) {
                            System.out.print(" + ");
                        }
                    }
                }
                System.out.println();
            }
        }

        scanner.close();
    }
}
