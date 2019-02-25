package com.study.designPattern;

/**
 * Created by one1000078 on 2019. 2. 25..
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if(instance == null)
            synchronized (Singleton.class) {
                instance = new Singleton();
            }

        return instance;
    }


}
