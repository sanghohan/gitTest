package com.study.designPattern;

import org.junit.Test;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by han on 2019-03-06.
 */
public class Adaptor {


    @Test
    public void testAdaptorPattern() {

        int i[] = {1,2,3,4,5};

        List<Integer> test = Adaptor.intArrayAsList(i);

        System.out.println("size : " + test.size());

        System.out.println("index 3 : " + test.get(3));

        Iterator iter = test.iterator();

        while(iter.hasNext()) {

            System.out.println(iter.next());

        }



    }

    static List<Integer> intArrayAsList(final int[] a) {
        if (a == null)
            throw new NullPointerException();

        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return a[index];
            }

            @Override
            public int size() {
                return a.length;
            }

            @Override
            public Integer set(int i, Integer val) {
                int oldval = a[i];
                a[i] = val;

                return oldval;
            }


        };

    }
}
