package com.company.deadlock;

/**
 * Created by alt-hanny on 28.08.2016.
 */
public class Deadlock {
    static class Item {
        private final String name;
        Item(String name) {
            this.name = name;
        }
        String getName() {
            return this.name;
        }
        synchronized void take(Item item) {
            System.out.format("%s: %s"
                            + " has take pen!%n",
                    this.name, item.getName());
            item.put(this);
        }
        synchronized void put(Item item) {
            System.out.format("%s: %s"
                            + " has put pen!%n",
                    this.name, item.getName());
        }
    }

    public static void main(String[] args) {
        final Item item1 =
                new Item("Item1");
        final Item item2 =
                new Item("Item2");
        new Thread(() -> { item1.take(item2); }).start();
        new Thread(() -> { item2.take(item1); }).start();
    }
}
