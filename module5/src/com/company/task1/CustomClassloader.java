package com.company.task1;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by alt-hanny on 07.08.2016.
 */
public class CustomClassloader extends ClassLoader {
    public CustomClassloader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public synchronized Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> result = null;
            try {
                URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[]{new URL("file:/D://"+name)});
                result = urlClassLoader.loadClass(name);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        return result;
    }
}
