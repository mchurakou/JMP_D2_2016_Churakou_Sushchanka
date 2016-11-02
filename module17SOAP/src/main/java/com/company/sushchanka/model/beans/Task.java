package com.company.sushchanka.model.beans;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by alt-hanny on 30.10.2016.
 */
@XmlRootElement(name="task")
public class Task {
    private long id;
    private String name;
    private String description;
    private Date creationDate;
    private Date deadLine;

    public Task() {
    }

    public Task(long id, String name, String description, Date creationDate, Date deadLine) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.deadLine = deadLine;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }


}
