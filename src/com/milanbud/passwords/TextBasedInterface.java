package com.milanbud.passwords;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;

public class TextBasedInterface implements UserInterface {

    private Scanner scanner = new Scanner(System.in);

    public TextBasedInterface() {
        this.scanner=new Scanner(System.in);
    }

    @Override
    public int getPasswordLength() {
        int length = 0;
        boolean isCompleted = false;
        do {
            try {
                System.out.print("Enter your password length (At least 4 characters): ");
                length = scanner.nextInt();
                isCompleted = length >=4;
            }catch (InputMismatchException e){
                System.out.println("Invalid input. Try again: ");
                scanner.next();
            }
        }while(!isCompleted);
        return length;
    }

    @Override
    public boolean useLowerCase() {
        System.out.print("Would you like to use lower case? [Y/N]:");
        return scanner.next().equalsIgnoreCase("y");
    }

    @Override
    public boolean useUpperCase() {
        System.out.print("Would you like to use upper case? [Y/N]:");
        return scanner.next().equalsIgnoreCase("y");
    }

    @Override
    public boolean useNumbers() {
        System.out.print("Would you like to use numbers? [Y/N]:");
        return scanner.next().equalsIgnoreCase("y");
    }

    @Override
    public boolean useSymbols() {
        System.out.print("Would you like to use symbols? [Y/N]:");
        return scanner.next().equalsIgnoreCase("y");
    }

    @Override
    public void displayPassword(String password) {
        System.out.println("Here is your password: "+ password);
    }

    @Override
    public boolean validateRequest(boolean useLowerCase, boolean useUpperCase, boolean useNumbers, boolean useSymbols) {
        if(!useLowerCase && !useUpperCase && !useNumbers && !useSymbols){
            System.out.println("You should select at least one of the options. Try Again!");
            return false;
        }
        return true;
    }
}
