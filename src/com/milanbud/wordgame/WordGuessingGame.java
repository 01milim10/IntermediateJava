package com.milanbud.wordgame;

import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {
    private final String wordToGuess;
    private final char[] guessedLetters;
    private int attempts;

    public WordGuessingGame(String[] wordList, int maxAttempts) { //constructor for new instance of the game
        Random rand = new Random();
        this.wordToGuess = wordList[rand.nextInt(wordList.length)].toLowerCase();
        this.guessedLetters = new char[this.wordToGuess.length()];
        for (int i = 0; i < this.guessedLetters.length; i++) {
            this.guessedLetters[i] = '_';
            this.attempts = maxAttempts;
        }
    }

    public String play(){
        Scanner scanner = new Scanner(System.in);

        while(attempts > 0){
            displayState();
            System.out.println("You have " + attempts + " attempts left.");
            System.out.print("Guess a letter: ");

            char guess = scanner.nextLine().toLowerCase().charAt(0);

            if(processGuess(guess)){
                System.out.println("Bravo! You got that right.");
                if(new String(guessedLetters).equals(wordToGuess)){
                    System.out.println("Congratulations! You win!");
                    return "Win";
                }
            }
            else{
                System.out.println("That guess was incorrect.");
                attempts--;
            }
        }
        return "Loss";
    }

    private boolean processGuess(char letter){
        boolean letterFound = false;
        for(int i = 0; i < wordToGuess.length() ; i++){
            if(wordToGuess.toLowerCase().charAt(i) == letter){
                guessedLetters[i] = letter;
                letterFound = true;
            }
        }
        return letterFound;
    }

    private void displayState(){
        System.out.println("Guessed Letters: " + new String(guessedLetters));
    }
}
