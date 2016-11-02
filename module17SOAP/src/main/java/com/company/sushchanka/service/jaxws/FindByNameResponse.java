
package com.company.sushchanka.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "findByNameResponse", namespace = "http://service.sushchanka.company.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findByNameResponse", namespace = "http://service.sushchanka.company.com/")
public class FindByNameResponse {

    @XmlElement(name = "return", namespace = "")
    private com.company.sushchanka.model.beans.User _return;

    /**
     * 
     * @return
     *     returns User
     */
    public com.company.sushchanka.model.beans.User getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.company.sushchanka.model.beans.User _return) {
        this._return = _return;
    }

}
