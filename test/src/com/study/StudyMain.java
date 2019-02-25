package com.study;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StudyMain {


    public static void main(String args[]) throws IOException {

        Path path = Paths.get("/Users/one1000078/Desktop/source/sems.zip");

        AsyncFileChannelTest asyncFileChannelTest = new AsyncFileChannelTest();
        asyncFileChannelTest.asyncFileChannel(path, false);

        System.out.println("test branch1");


    }


}