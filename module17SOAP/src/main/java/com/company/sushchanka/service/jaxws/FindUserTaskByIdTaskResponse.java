
package com.company.sushchanka.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "findUserTaskByIdTaskResponse", namespace = "http://service.sushchanka.company.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findUserTaskByIdTaskResponse", namespace = "http://service.sushchanka.company.com/")
public class FindUserTaskByIdTaskResponse {

    @XmlElement(name = "return", namespace = "")
    private com.company.sushchanka.model.beans.Task _return;

    /**
     * 
     * @return
     *     returns Task
     */
    public com.company.sushchanka.model.beans.Task getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.company.sushchanka.model.beans.Task _return) {
        this._return = _return;
    }

}
