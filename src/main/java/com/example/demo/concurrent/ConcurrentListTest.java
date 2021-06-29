package com.example.demo.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author gino
 * 2021-06-28
 */
public class ConcurrentListTest {

    public static void main(String[] args) {
        List vector=new Vector<String>();
        vector.add("vector1");
        vector.add("vector2");
        vector.add("vector3");
        vector.add("vector4");

        List arrayList=new ArrayList<String>();
        arrayList.add("arrayList1");
        arrayList.add("arrayList2");
        arrayList.add("arrayList3");
        arrayList.add("arrayList4");

    }
}
