package com.company.springmvc.model.interfaces;

import com.company.springmvc.model.beans.Task;

import java.util.Date;
import java.util.List;

/**
 * Created by alt-hanny on 23.10.2016.
 */
public interface ITaskDAO {
    void add (Task task);
    void  setTaskStatus(int id, int status);
    void setTaskFile (int id, String file);
    List<Task> listUserTasks(int userId, Date date, int status);
    List<Task> listUserTasksByStatus(int userId, int status);
    void deleteTask(int id);
    void setTaskTodayDate(int id);
}
