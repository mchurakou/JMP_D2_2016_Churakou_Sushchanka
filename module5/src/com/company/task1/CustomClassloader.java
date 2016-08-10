package com.company.task1;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by alt-hanny on 07.08.2016.
 */
public class CustomClassloader  {
    /**
     *  Loads class.
     * @param name The name of the class.
     * @return The resulting <tt>Class</tt> object.
     * @throws ClassNotFoundException If the class could not be found.
     */
    public synchronized Class<?> loadClass(String name) throws ClassNotFoundException, MalformedURLException {
        URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[]{new URL("file:/D://"+name)});
        Class<?> result = urlClassLoader.loadClass(name);
        System.out.println("In progress.");
        return result;
    }
}
