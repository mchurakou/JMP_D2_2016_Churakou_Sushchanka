package com.company.superman;

/**
 * Runs the threads for testing singleton work.
 */
public class Main {

    public static void main(String[] args) {

        Runnable getLetters = new GetTheLetters();
        Runnable getLettersAgain = new GetTheLetters();

        new Thread(getLetters).start();
        new Thread(getLettersAgain).start();
    }
}
