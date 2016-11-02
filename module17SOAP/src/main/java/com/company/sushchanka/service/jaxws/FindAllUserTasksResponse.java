
package com.company.sushchanka.service.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "findAllUserTasksResponse", namespace = "http://service.sushchanka.company.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findAllUserTasksResponse", namespace = "http://service.sushchanka.company.com/")
public class FindAllUserTasksResponse {

    @XmlElement(name = "return", namespace = "")
    private List<com.company.sushchanka.model.beans.Task> _return;

    /**
     * 
     * @return
     *     returns List<Task>
     */
    public List<com.company.sushchanka.model.beans.Task> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<com.company.sushchanka.model.beans.Task> _return) {
        this._return = _return;
    }

}
