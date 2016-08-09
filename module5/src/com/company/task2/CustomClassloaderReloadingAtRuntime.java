package com.company.task2;

import com.company.task1.CustomClassloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Hanna_Sushchanka on 8/8/2016.
 */
class CustomClassloaderReloadingAtRuntime extends CustomClassloader {
    private Map<String, Class<?>> classesCash = new HashMap<>();
    private final String CLASSPATH = "module5/out/com/company/task2/";

    public CustomClassloaderReloadingAtRuntime(ClassLoader parent) {
        super(parent);
    }

    @Override
    public synchronized Class<?> loadClass(String name) throws ClassNotFoundException {
        return loadClass(name, false);
    }

    @Override
    protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> result = findClass(name);
        if (resolve) {
            resolveClass(result);
        }
        return result;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> result = classesCash.get(name);
        if (result != null) {
            System.out.println("Class" + name + "found in cache");
            return result;
        }

        File file = findFile(name.replace('.','/'),".class");
        if (file == null) {
            System.out.println("Loading through the system class loader: " + name);
            result = findSystemClass(name);
        } else {
            System.out.println("In progress. Loading file: " + name);
            byte[] classBytes = loadFileAsBytes(file);
            result = defineClass(name, classBytes, 0, classBytes.length);
        }
        classesCash.put(name, result);
        return result;
    }

    private byte[] loadFileAsBytes(File file) throws ClassNotFoundException {
        byte[] result = new byte[(int)file.length()];
        try(FileInputStream fis = new FileInputStream(file)) {
            fis.read(result, 0, result.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Error:" + e);
        }
        return result;
    }

    private File findFile(String name, String ext) {
        File file = new File(CLASSPATH + name.replace('/',File.separatorChar)+ext);
        return file.exists() ? file : null;
    }

}
