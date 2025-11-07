package com.github.zipcodewilmington;
import java.util.Scanner;

/**
 * Marc McGough
 * Date: 11/03/2025

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class WordGuess {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
        System.out.println("Lets play Wordguess");
        String[] words = {"hollywood", "paris", "tokyo", "philadelphia", "cairo", "dublin"};
        String secretWord = words[(int) (Math.random() * words.length)];

        char[] guessedWord = new char[secretWord.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        
        int wrongGuesses = 0;
        int maxWrongGuesses = 6;

        while (wrongGuesses < maxWrongGuesses && new String(guessedWord).contains("_")){
            System.out.println("\nWord: " + String.valueOf(guessedWord));
            System.out.println("Wrong guesses: " + wrongGuesses + "/" + maxWrongGuesses);
            System.out.print("Guess a letter: ");

            char guess = scanner.nextLine().toLowerCase().charAt(0);

            boolean found = false;
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    found = true;
                }
            }

            if (!found) {
                wrongGuesses++;
                System.out.println("Wrong!!!");
        }
    }    

    if (!new String(guessedWord).contains("_")) {
        System.out.println("\nYou Win!! The word was: " + secretWord); 
    } else {
        System.out.println("\nYou Lose!!! The word was: "+ secretWord);
    }

        System.out.println("\nWant to play again?");

    scanner.close();
    }
}
}