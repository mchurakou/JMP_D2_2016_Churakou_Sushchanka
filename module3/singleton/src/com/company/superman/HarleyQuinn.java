package com.company.superman;

import java.util.Arrays;
import java.util.LinkedList;

final class HarleyQuinn {

    private volatile static HarleyQuinn uniqueHarleyQuinn;
    private String[] testLetters = {"S", "u", "p", "e", "r", "m", "a", "n",
        "H", "a", "r", "l", "e", "y", " ", "Q", "u", "i", "n", "n"};

    private LinkedList<String> letterList = new LinkedList<>(Arrays.asList(testLetters));

    private static boolean firstThread = true;

    private HarleyQuinn() {
    }

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

    LinkedList getLetterList() {
        return uniqueHarleyQuinn.letterList;
    }

    LinkedList<String> getLetters(int howManyLetters) {
        LinkedList<String> lettersToSend = new LinkedList<>();
        for (int i = 0; i <= howManyLetters; i++) {
            lettersToSend.add(uniqueHarleyQuinn.letterList.remove(0));
        }
        return lettersToSend;
    }
}
