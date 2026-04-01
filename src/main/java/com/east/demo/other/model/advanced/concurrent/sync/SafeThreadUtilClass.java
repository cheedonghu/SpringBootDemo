package com.east.demo.other.model.advanced.concurrent.sync;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 线程安全类
 *
 * @author: east
 * @date: 2023/12/3
 */

public class SafeThreadUtilClass {
    public void array() {
        // vector能保证线程安全在于其方法通过synchronized修饰
        Vector<Integer> integers = new Vector<>();
        ArrayList<Integer> integers1 = new ArrayList<>();
    }

    public void map() {
        Hashtable<String, String> integerStringHashtable = new Hashtable<>();
        ConcurrentHashMap<String, String> stringStringConcurrentHashMap = new ConcurrentHashMap<>();

    }

    public void collect() {
//        Collections.synchronized
    }
}
