package com.epam.company.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alt-hanny on 04.09.2016.
 */
public class A {
    private static final Logger logger = LogManager.getLogger(A.class);
    private String somePropertyA;

    public String getSomePropertyA() {
        return somePropertyA;
    }

    public void setSomePropertyA(String somePropertyA) {
        this.somePropertyA = somePropertyA;
    }

    public void helperForReplacementMethodTest() {
        logger.info("Call - before Method replacement.");
        List<String> messagesList = new ArrayList<String>(5);
        for(int i=0; i<5; i++) messagesList.add(i, "Add new Line " + i);
        for (String message : messagesList) logger.info(message);
    }
}
