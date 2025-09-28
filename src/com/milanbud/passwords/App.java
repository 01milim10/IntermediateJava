package com.milanbud.passwords;

public class App {

    static void main(String[] args) {

        UserInterface ui = new TextBasedInterface();

        int length = ui.getPasswordLength();
        boolean useLowerCase;
        boolean useUpperCase;
        boolean useNumbers;
        boolean useSymbols;

        do{
            useLowerCase = ui.useLowerCase();
            useUpperCase = ui.useUpperCase();
            useNumbers = ui.useNumbers();
            useSymbols = ui.useSymbols();
        }while(!ui.validateRequest(useLowerCase,useUpperCase,useNumbers,useSymbols));

        PasswordGenerator gen = new PasswordGenerator();
        String password = gen.generatePassword(length, useLowerCase, useUpperCase, useNumbers, useSymbols);

        ui.displayPassword(password);
    }

}
