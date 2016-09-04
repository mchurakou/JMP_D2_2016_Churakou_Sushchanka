package com.epam.company.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by alt-hanny on 04.09.2016.
 */
class CustomPostProcessor implements BeanPostProcessor {
    private static final Logger logger = LogManager.getLogger(CustomPostProcessor.class);
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("Bean with name " + beanName + " will be initialized.");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("Bean with name " + beanName + " was initialized.");
        return bean;
    }
}
