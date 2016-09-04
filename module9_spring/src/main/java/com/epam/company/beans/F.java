package com.epam.company.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by alt-hanny on 04.09.2016.
 */
public class F {
    private static final Logger logger = LogManager.getLogger(F.class);

    private String pointOfTask;

    public String getPointOfTask() {
        return pointOfTask;
    }

    public void setPointOfTask(String pointOfTask) {
        this.pointOfTask = pointOfTask;
    }

    public void init() {
        logger.info(pointOfTask + "The init method was called .");
    }

    public void destroy() {
        logger.info(pointOfTask + "The destroy method was called.");
    }
}
