package com.epam.company;

import com.epam.company.beans.A;
import com.epam.company.beans.B;
import com.epam.company.beans.F;
import com.epam.company.interfaces.DemoBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner
{
    public static void main( String[] args )
    {
        Logger logger = LogManager.getLogger(Runner.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");
        //1. Create bean A, use DI via setters, use property placeholder for values.
        logger.info("------------1-----------");
        A a = (A) context.getBean("A");
        String valuePropertyOfA = a.getSomePropertyA();
        logger.info("Value of the a: " + valuePropertyOfA);
        // 2. Create bean B, use DI via constructor (bean A as argument of constructor).
        logger.info("------------2-----------");
        B b = (B) context.getBean("B");
        String valuePropertyOfB = b.getSomePropertyB().getSomePropertyA();
        logger.info("Value of the b: " + valuePropertyOfB);
        // 3. Create bean C with singleton scope and bean D with prototype scope.
        logger.info("------------3-----------");
        DemoBean abstractLookupBeanC = (DemoBean) context.getBean("AbstractLookupC");
        logger.info("Message from D via Abstract Lookup Method Injection in C: " + abstractLookupBeanC.getD().doSomethingD());
        DemoBean standartLookupBeanC = (DemoBean) context.getBean("StandartLookupC");
        logger.info("Message from D via Standart Lookup Method Injection in C: " + standartLookupBeanC.getD().doSomethingD());
        // 4. Create bean E and replace logic of one of his method by Method Replacement.
        logger.info("------------4-----------");
        a.helperForReplacementMethodTest();
        A e = (A)context.getBean("replacementA");
        e.helperForReplacementMethodTest();
        // 5. Create bean F and log all possible steps from his lifecycle (lifecycle of Spring bean).
        logger.info("------------5-----------");
        F f = (F) context.getBean("F");
        logger.info(f.getPointOfTask());
        ((AbstractApplicationContext)context).registerShutdownHook();
    }
}
