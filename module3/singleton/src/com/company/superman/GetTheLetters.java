package com.company.superman;

import java.util.LinkedList;

class GetTheLetters implements Runnable {

    public void run() {
        HarleyQuinn harleyQuinn = HarleyQuinn.getInstance();
        System.out.println("Instance ID: " + System.identityHashCode(harleyQuinn));
        System.out.println(harleyQuinn.getLetterList());
        LinkedList<String> lettersOne  = harleyQuinn.getLetters(7);
        System.out.println("HarleyQuinn message: " + lettersOne);
        System.out.println(harleyQuinn.getLetterList());
        System.out.println("******************************");
    }
}
