package com.company.sushchanka.PowerMock;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alt-hanny on 26.10.2016.
 */
public class Examples {
    private Map<Long, String> exampleMap;
    private final static String FILE_PATH = "moduleTesting\\resources\\test.csv";

    public Examples() {
    }

    public Examples(Map<Integer, String> exampleMap) {
        exampleMap = new HashMap<>();
    }

    public void add(final long id, final String name) {
        exampleMap.put(id, name);
    }

    public String getName (final String name) {
        return exampleMap.get(name);
    }

    private static String getMessage(){
        return "Example 1";
    }

    final public Example getExample(){
        return new Example(5);
    }

    public void createFile(){
        File file = new File(FILE_PATH);
    }
}
