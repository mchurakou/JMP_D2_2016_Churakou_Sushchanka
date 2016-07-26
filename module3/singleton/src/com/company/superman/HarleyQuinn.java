package com.company.superman;

import java.util.Arrays;
import java.util.LinkedList;

final class HarleyQuinn {
    /** Variable for unique object. */
    private volatile static HarleyQuinn uniqueHarleyQuinn;
    /** Array of the test letters.*/
    private String[] testLetters = {"S", "u", "p", "e", "r", "m", "a", "n",
        "H", "a", "r", "l", "e", "y", " ", "Q", "u", "i", "n", "n"};

    private LinkedList<String> letterList = new LinkedList<>(Arrays.asList(testLetters));

    private static boolean firstThread = true;

    private HarleyQuinn() {
    }

    /**
     * Singleton.
     * @return unique object.
     */
    static HarleyQuinn getInstance() {

        if (firstThread) {
            firstThread = false;
            System.out.println("First: " + Thread.currentThread());
        } else {
            System.out.println("Second: " + Thread.currentThread());
        }
        if (uniqueHarleyQuinn == null) {
            synchronized (HarleyQuinn.class) {
                if (uniqueHarleyQuinn == null) {
                    uniqueHarleyQuinn = new HarleyQuinn();
                }
            }
        }
        return uniqueHarleyQuinn;
    }

    /**
     * Gets the letters list of the instance.
     * @return letters list of the uniqInstance.
     */
    LinkedList getLetterList() {
        return uniqueHarleyQuinn.letterList;
    }

    /**
     * Removes letters from the list.
     * @param howManyLetters Number of the removing letters from list.
     * @return list letters.
     */
    LinkedList<String> getLetters(int howManyLetters) {
        LinkedList<String> lettersToSend = new LinkedList<>();
        for (int i = 0; i <= howManyLetters; i++) {
            lettersToSend.add(uniqueHarleyQuinn.letterList.remove(0));
        }
        return lettersToSend;
    }
}
