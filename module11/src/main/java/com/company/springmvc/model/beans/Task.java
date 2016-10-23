package com.company.springmvc.model.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by alt-hanny on 23.10.2016.
 */
public class Task implements Serializable {
    private static final long serialVersionUID = 201623101706L;
    private int id;
    private int userId;
    private String task;
    private Date date;
    private String file;
    private int status;

}
