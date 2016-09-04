package com.epam.company.beans;

import com.epam.company.interfaces.DemoBean;

/**
 * Created by alt-hanny on 04.09.2016.
 */
public abstract class AbstractLookupC implements DemoBean {
    public abstract D getD();

    public void someOperation() {
        getD().doSomethingD();
    }
}
