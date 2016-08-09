package com.company.task2;

import com.company.task1.CustomClassloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hanna_Sushchanka on 8/8/2016.
 *
 * Classloader for reload classes in runtime.
 */
class CustomClassloaderReloadingAtRuntime extends CustomClassloader {
    /** Cache. */
    private Map<String, Class<?>> classesCache = new HashMap<>();
    /** Class path. */
    private final String CLASSPATH = "module5/out/com/company/task2/";
    /** File name separator. Dot. */
    private final Character DOT = '.';
    /** File name separator. Slash. */
    private final Character SLASH = '/';
    /** Class extension. */
    private final String CLASS_EXT = ".class";

    public CustomClassloaderReloadingAtRuntime(ClassLoader parent) {
        super(parent);
    }

    /**
     * Loads the class by the name.
     *
     * @param name Name of the loaded class.
     * @return The call of the another protected loadClass method.
     * @throws ClassNotFoundException If the class could not be found.
     */
    @Override
    public synchronized Class<?> loadClass(String name) throws ClassNotFoundException {
        return loadClass(name, false);
    }

    /**
     *  Loads class.
     * @param name The name of the class.
     * @param resolve If <tt>true</tt> then resolve the class.
     * @return The resulting <tt>Class</tt> object.
     * @throws ClassNotFoundException If the class could not be found.
     */
    @Override
    protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> result = findClass(name);
        if (resolve) {
            resolveClass(result);
        }
        return result;
    }

    /**
     * Finds the class with the specified <a href="#name">binary name</a>.
     * @param name The <a href="#name">binary name</a> of the class.
     * @return The resulting <tt>Class</tt> object.
     * @throws ClassNotFoundException If the class could not be found.
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> result = classesCache.get(name);
        if (result != null) {
            System.out.println("Class" + name + "found in cache");
            return result;
        }

        File file = findFile(name.replace(DOT, SLASH), CLASS_EXT);
        if (file == null) {
            System.out.println("Loading through the system class loader: " + name);
            result = findSystemClass(name);
        } else {
            System.out.println("In progress. Loading file: " + name);
            byte[] classBytes = loadFileAsBytes(file);
            result = defineClass(name, classBytes, 0, classBytes.length);
        }
        classesCache.put(name, result);
        return result;
    }

    /**
     * Loads the file as bytes.
     *
     * @param file Loaded file.
     * @return File as bytes.
     * @throws ClassNotFoundException If the file could not found.
     */
    private byte[] loadFileAsBytes(File file) throws ClassNotFoundException {
        byte[] result = new byte[(int)file.length()];
        try(FileInputStream fis = new FileInputStream(file)) {
            fis.read(result, 0, result.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Error:" + e);
        }
        return result;
    }

    /**
     * Finds file.
     *
     * @param name Name of the file.
     * @param ext Extension of the file.
     * @return Founded file.
     */
    private File findFile(String name, String ext) {
        File file = new File(CLASSPATH + name.replace(SLASH, File.separatorChar)+ ext);
        return file.exists() ? file : null;
    }

}
