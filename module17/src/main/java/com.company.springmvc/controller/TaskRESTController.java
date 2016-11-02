package com.company.springmvc.controller;

import com.company.springmvc.model.beans.Task;
import com.company.springmvc.model.beans.User;
import com.company.springmvc.service.TaskService;
import com.company.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by alt-hanny on 02.11.2016.
 */
@RestController
public class TaskRESTController {
    @Autowired
    TaskService taskService;
    @Autowired
    UserService userService;

    private static List<Task> tasks;

    /**
     * Retrieve all user's tasks.
     */
    @RequestMapping(value = "/user/{userId}/task/", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> listAllTasksOfUser(@PathVariable("userId") long userId ) {
        tasks = taskService.findAllUserTasks(userId);
        if(tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    /**
     * Retrieve user task by id.
     */
    @RequestMapping(value = "/user/{userId}/task/{taskId}", method = RequestMethod.GET)
    public ResponseEntity<Task> userTaskByIdTask(@PathVariable("userId") long userId, @PathVariable("taskId") long taskId) {
        Task task = taskService.findUserTaskByIdTask(userId, taskId);
        if(task == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    /**
     * Create task.
     */
    @RequestMapping(value = "/user/{userId}/task/", method = RequestMethod.POST)
    public ResponseEntity<Void> createTask(@PathVariable("userId") long userId, @RequestBody Task task, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Task " + task.getName());
        if (taskService.isTaskExist(userId, task)) {
            System.out.println("A User with name " + task.getName() + " already exist");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        taskService.saveTask(userId, task);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/task/{idTask}").buildAndExpand(task.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    /**
     * Update task.
     */
    @RequestMapping(value = "/user/{userId}/task/{taskId}", method = RequestMethod.PUT)
    public ResponseEntity<Task> updateUser(@PathVariable("userId") long userId, @PathVariable("taskId") long taskId, @RequestBody Task task) {
        System.out.println("Updating Task " + taskId);
        Task currentTask = taskService.findUserTaskByIdTask(userId, taskId);
        if (currentTask == null) {
            System.out.println("Task with id " + taskId + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentTask.setName(task.getName());
        currentTask.setDescription(task.getDescription());
        currentTask.setCreationDate(task.getCreationDate());
        currentTask.setDeadLine(task.getDeadLine());
        taskService.updateUserTask(userId, currentTask);
        return new ResponseEntity<>(currentTask, HttpStatus.OK);
    }

    /**
     * Delete user task by id.
     */
    @RequestMapping(value = "/user/{userId}/task/{taskId}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteTask(@PathVariable("userId") long userId, @PathVariable("taskId") long taskId) {
        System.out.println("Deleting Task with id " + taskId);
        Task task = taskService.findUserTaskByIdTask(userId, taskId);
        if (task == null) {
            System.out.println("Unable to delete. Task with id " + taskId + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        taskService.deleteTaskOfUserById(userId, taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Delete all users.
     */
    @RequestMapping(value = "/user/{userId}/task/", method = RequestMethod.DELETE)
    public ResponseEntity<Task> deleteAllTasks(@PathVariable("userId") long userId) {
        System.out.println("Deleting All Tasks");
        taskService.deleteAllUserTasks(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
