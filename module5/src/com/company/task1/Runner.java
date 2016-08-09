package com.company.task1;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Scanner;

/**
 * Created by alt-hanny on 07.08.2016.
 */
public class Runner {
    public static void main(String[] arg) {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please, input the path of class: ");
            String classPath = scanner.nextLine();
            loadingClass(classPath);
        } catch (ClassNotFoundException e) {
            System.out.println("Error. Class not found.");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private static void loadingClass(String path) throws Throwable {
        System.out.println("Start loading");
        ClassLoader parent = CustomClassloader.class.getClassLoader();
        CustomClassloader customClassloader = new CustomClassloader(parent);
        Class<?> semaphore = customClassloader.loadClass(path);
        Semaphore semObj = (Semaphore) semaphore.newInstance();
        makeMethodHandle(semObj);
    }

    private static MethodHandle makeMethodHandle(Semaphore semObj) throws Throwable {
        MethodType description = MethodType.methodType(void.class);
        MethodHandle methodHandle = MethodHandles.lookup().findVirtual(Semaphore.class,"lever", description);
        methodHandle.invokeExact(semObj);
        return methodHandle;
    }
}
