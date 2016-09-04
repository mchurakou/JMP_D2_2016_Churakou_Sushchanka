package com.epam.company.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alt-hanny on 04.09.2016.
 */
public class E implements MethodReplacer{
    private static final Logger logger = LogManager.getLogger(E.class);
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        logger.info("After replacement");
        List <String> messagesList = new ArrayList<String>(10);
        for (int i = 10; i>0; i--) messagesList.add("New Line: " + i);
        for (String message: messagesList) logger.info(message);
        return o;
    }
}
