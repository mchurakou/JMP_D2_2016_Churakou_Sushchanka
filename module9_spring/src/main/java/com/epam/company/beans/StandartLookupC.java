package com.epam.company.beans;

import com.epam.company.interfaces.DemoBean;

/**
 * Created by alt-hanny on 04.09.2016.
 */
public class StandartLookupC implements DemoBean {
    private D d;

    public void setD(D d) {
        this.d = d;
    }

    public D getD() {
        return d;
    }

    public void someOperation() {
        d.doSomethingD();
    }
}
