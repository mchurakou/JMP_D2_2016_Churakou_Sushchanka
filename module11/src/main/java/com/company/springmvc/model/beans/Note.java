package com.company.springmvc.model.beans;

import com.company.springmvc.utils.DateHelper;

import java.io.Serializable;
import java.text.ParseException;
import java.sql.Date;

/**
 * Created by alt-hanny on 23.10.2016.
 */
public class Note implements Serializable {
    private static final long serialVersionUID = 201623101706L;
    private int id;
    private int userId;
    private String task;
    private Date date;
    private String file;
    private int status;

    public Note(int id, int userId, String task, Date date, String file,
                int status) {
        super();
        this.id = id;
        this.userId = userId;
        this.task = task;
        this.date = date;
        this.file = file;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static String getStrDate(String date) {
        return date.toString();
    }

    public void setDate(String date) throws ParseException {
        this.date = DateHelper.parseDate(date);
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
