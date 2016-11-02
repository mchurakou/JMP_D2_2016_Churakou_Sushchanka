
package com.company.sushchanka.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "isUserExist", namespace = "http://service.sushchanka.company.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "isUserExist", namespace = "http://service.sushchanka.company.com/")
public class IsUserExist {

    @XmlElement(name = "arg0", namespace = "")
    private com.company.sushchanka.model.beans.User arg0;

    /**
     * 
     * @return
     *     returns User
     */
    public com.company.sushchanka.model.beans.User getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(com.company.sushchanka.model.beans.User arg0) {
        this.arg0 = arg0;
    }

}
