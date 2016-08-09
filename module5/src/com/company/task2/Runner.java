package com.company.task2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created by Hanna_Sushchanka on 8/8/2016.
 */
public class Runner {
    public static void main(String[] arg) throws Throwable {
        for (;;) {
            System.out.println("Please, input the path of class: ");
            String classPath = new BufferedReader(new InputStreamReader(System.in)).readLine();
            ClassLoader classLoaderParent = CustomClassloaderReloadingAtRuntime.class.getClassLoader();
            CustomClassloaderReloadingAtRuntime classLoader = new CustomClassloaderReloadingAtRuntime(classLoaderParent);
            Class<?> semaphore = Class.forName(classPath, true, classLoader);
            Semaphore semObj = (Semaphore)semaphore.newInstance();
            makeMethodHandle(semObj);
        }
    }

    private static MethodHandle makeMethodHandle(Semaphore semObj) throws Throwable {
        MethodType description = MethodType.methodType(void.class);
        MethodHandle methodHandle = MethodHandles.lookup().findVirtual(Semaphore.class,"lever", description);
        methodHandle.invokeExact(semObj);
        return methodHandle;
    }
}
