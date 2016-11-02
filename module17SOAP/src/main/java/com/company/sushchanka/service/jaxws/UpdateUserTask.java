
package com.company.sushchanka.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "updateUserTask", namespace = "http://service.sushchanka.company.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateUserTask", namespace = "http://service.sushchanka.company.com/", propOrder = {
    "arg0",
    "arg1"
})
public class UpdateUserTask {

    @XmlElement(name = "arg0", namespace = "")
    private long arg0;
    @XmlElement(name = "arg1", namespace = "")
    private com.company.sushchanka.model.beans.Task arg1;

    /**
     * 
     * @return
     *     returns long
     */
    public long getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(long arg0) {
        this.arg0 = arg0;
    }

    /**
     * 
     * @return
     *     returns Task
     */
    public com.company.sushchanka.model.beans.Task getArg1() {
        return this.arg1;
    }

    /**
     * 
     * @param arg1
     *     the value for the arg1 property
     */
    public void setArg1(com.company.sushchanka.model.beans.Task arg1) {
        this.arg1 = arg1;
    }

}
