package com.company.sushchanka.PowerMock;

/**
 * Created by alt-hanny on 26.10.2016.
 */
public class Example {
    private long id;
    private String name;

    public Example(long id) {
        this.id = id;
        name = RandomTextGenerator.randomString(8);
    }

    public String getName() {
        return name;
    }
}
