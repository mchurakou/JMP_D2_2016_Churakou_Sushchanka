package com.company.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Hanna_Sushchanka on 8/8/2016.
 */
public class Runner {
    public static void main(String[] arg){
        while (true) {
            System.out.println("Please, input the path of class: ");
            try {
                String name = new BufferedReader(new InputStreamReader(System.in)).readLine();
                ClassLoader parent = CustomClassloaderReloadingAtRuntime.class.getClassLoader();
                CustomClassloaderReloadingAtRuntime classLoader = new CustomClassloaderReloadingAtRuntime(parent);
                Class<?> semaphore = classLoader.loadClass(name);
                Object semObj = semaphore.newInstance();
                Method method = semaphore.getMethod("lever");
                method.invoke(semObj);
//          makeMethodHandle(semObj);
                new BufferedReader(new InputStreamReader(System.in)).readLine();
            }  catch (ClassNotFoundException | IOException | InstantiationException |
                    NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                System.out.println("Error: " + e);
            }
        }
    }

//    private static MethodHandle makeMethodHandle(Object semObj) throws Throwable {
//        MethodType description = MethodType.methodType(void.class);
//        MethodHandle methodHandle = MethodHandles.lookup().findVirtual(Semaphore.class,"lever", description);
//        methodHandle.invokeExact(semObj);
//        return methodHandle;
//    }
}
