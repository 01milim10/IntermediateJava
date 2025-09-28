package com.milanbud.passwords;

import java.util.Random;

public class PasswordGenerator {

    String generatePassword(int length, boolean useLowerCase, boolean useUpperCase, boolean useNumbers, boolean useSymbols) {

        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*()?";
        String allChars;

        StringBuilder charOptions = new StringBuilder();
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        if(useLowerCase) {
            charOptions.append(lowerCase);
        }
        if(useUpperCase) {
            charOptions.append(upperCase);
        }
        if(useNumbers) {
            charOptions.append(numbers);
        }
        if(useSymbols) {
            charOptions.append(symbols);
        }

        allChars = charOptions.toString();


        for (int i = 0; i < length; i++) {
            if(useLowerCase && !password.toString().contains(lowerCase)) {
                password.append(lowerCase.charAt(random.nextInt(lowerCase.length())));
                length--;
            }

            if(length > 0 && useUpperCase && !password.toString().contains(upperCase)) {
                password.append(upperCase.charAt(random.nextInt(upperCase.length())));
                length--;
            }

            if(length > 0 && useNumbers && !password.toString().contains(numbers)) {
                password.append(numbers.charAt(random.nextInt(numbers.length())));
                length--;
            }

            if(length > 0 && useSymbols && !password.toString().contains(symbols)) {
                password.append(symbols.charAt(random.nextInt(symbols.length())));
                length--;
            }

            if(length > 0){
                char nextLetter = allChars.charAt(random.nextInt(allChars.length()));
                password.append(nextLetter);
            }
        }

        return password.toString();
    }


}
