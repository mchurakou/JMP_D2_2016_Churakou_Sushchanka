package com.epam.company.beans;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Created by alt-hanny on 04.09.2016.
 */
public class F implements ApplicationContextAware, BeanClassLoaderAware, BeanFactoryAware, BeanNameAware,
        DisposableBean, InitializingBean {
    private static final Logger logger = LogManager.getLogger(F.class);
    private static final String DEFAULT = "Bean lifecycle.";
    private String beanName;
    private String pointOfTask;
    private ApplicationContext context;
    private BeanFactory beanFactory;

    public String getPointOfTask() {
        return pointOfTask;
    }

    public void setPointOfTask(String pointOfTask) {
        this.pointOfTask = pointOfTask;
    }

    public void printName() {
        logger.info("Bean [" + beanName + "] - printName()");
    }

    public void init() {
        logger.info(pointOfTask + "The init method was called .");
    }

    public void destroy() {
        logger.info(pointOfTask + "The destroy method was called.");
    }

    public void afterPropertiesSet() throws Exception {
        logger.info("InitializingBean ||| Initializing the bean F.");
        if (pointOfTask == null) {
            logger.info("Using the default property.");
            pointOfTask = DEFAULT;
        }
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
        logger.info("BeanNameAware ||| BeanName F was set.");
    }

    public void setBeanClassLoader(ClassLoader classLoader) {
        logger.info("BeanClassLoaderAware ||| setBeanClassLoader was called.");
    }

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        logger.info("ApplicationContextAware ||| setApplicationContext was called.");
    }


    public void setBeanFactory(final BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        logger.info("BeanFactoryAware || setBeanFactory was called.");
    }

    public void useBeanFactory() {
        logger.info("Using the beanFactory: " + beanFactory.toString());
    }
}
