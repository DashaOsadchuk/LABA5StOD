package com.main;

import java.util.ArrayList;

public class HashTable<K, V> {
    private ArrayList<Node<K,V>> array;
    private int nodesFilled, fullFill;

    public HashTable() {
        nodesFilled = 0;
        fullFill = 0;
        array = new ArrayList<>(2000000);
        for (int i = 0; i < 2000000; i++) {
            array.add(null);
        }
    }

    public void put(K key, V data) {
        int hashKey = convert(key);
        Node<K,V> newOne = new Node<>(key, data);
        Node<K, V> parent = this.array.get(hashKey);
        if (parent == null) {
            this.array.set(hashKey, newOne);
            this.nodesFilled++;
            this.fullFill++;
        } else {
            while (parent.getNext() != null) {
                parent = parent.getNext();
            }
            parent.setNext(newOne);
            newOne.setPrev(parent);
            this.fullFill++;
        }
    }

    public boolean contains(K key) {
        return this.array.get(convert(key)) != null;
    }

    public int capacity() {
        return this.array.size();
    }

    public int size() {
        return this.nodesFilled;
    }

    public int amount() {
        return this.fullFill;
    }

    private int convert(K key) {
        return Math.abs(key.hashCode()*7+17)%2000000;
    }
}
