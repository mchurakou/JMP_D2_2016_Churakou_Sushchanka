package com.company.task2;

import com.company.task1.CustomClassloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;


/**
 * Created by Hanna_Sushchanka on 8/8/2016.
 */
class CustomClassloaderReloadingAtRuntime extends CustomClassloader {
    private Map<String, Class<?>> classesCash = new HashMap<>();
    CustomClassloaderReloadingAtRuntime(ClassLoader parent) {
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
            return findSystemClass(name);
        }

        byte[] classBytes = loadFileAsBytes(file);
        result = defineClass(name, classBytes, 0, classBytes.length);

        classesCash.put(name, result);
        return result;
    }

    private byte[] loadFileAsBytes(File file) {
        byte[] result = new byte[(int)file.length()];
        try(FileInputStream fis = new FileInputStream(file)) {
            fis.read(result, 0, result.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private File findFile(String name, String ext) {
        File file = new File((new File(name)).getPath()+File.separatorChar+name.replace('/',File.separatorChar)+ext);
        return (file.exists()) ? file : null;
    }

}
