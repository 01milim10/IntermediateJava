package com.milanbud.wordgame;

import java.util.Scanner;

public class App {
    static void main() {
        String[] words = {"Java", "Programming", "Class", "Computer", "Method"};
        WordGuessingGame game = new WordGuessingGame(words, 10);

        Scanner scanner = new Scanner(System.in);
        boolean shouldPlayAgain;

        int wins = 0;
        int losses = 0;

        do{
            String result = game.play();
            if(result.equals("Win")){
                wins++;
            }else{
                losses++;
            }

            System.out.println("Wins: " + wins + " Losses: " + losses);
            System.out.print("Would you like to play again? (y/n)");
            char playAgain = scanner.nextLine().toLowerCase().charAt(0);
            shouldPlayAgain = playAgain == 'y';
        }while(shouldPlayAgain);
    }
}