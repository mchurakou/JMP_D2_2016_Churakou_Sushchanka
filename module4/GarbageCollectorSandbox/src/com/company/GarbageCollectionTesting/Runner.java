package com.company.GarbageCollectionTesting;

import java.util.*;

/**
 * Created by Hanna_Sushchanka on 7/31/2016.
 */
public class Runner {
    public static void main(String[] arg) throws InterruptedException {
        System.out.println("Start time:"+ new Date().getTime());
        Map map = new HashMap<>();
        Integer count = 0;
        while (count < 3000) {
            List<Code> codeList = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                if (!codeList.contains(new Code(i))) {
                    codeList.add(i, new Code(i));
                }
            }
            map.put(count, codeList);
            Thread.sleep(100);
            count++;
        }
        System.out.println(map.size());
        System.out.println("Map is filled with ArrayLists.");
        System.out.println("Nulling.");
        for(int i = 0; i < map.size(); i++ ) {
            map.put(i, null);
        }
        System.out.println(map.size() + " arrayLists was nulled.");

        System.gc();
        System.out.println("GC called");
        System.out.println("Finish time:"+ new Date().getTime());
    }
}

class Code {
    private Integer id;
    private String string = "Test test test test test test test test test test test test!!! ";

    Code (Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
