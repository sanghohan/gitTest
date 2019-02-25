package com.study.filehandler;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by one1000078 on 2019. 2. 25..
 */
public class FileStream {

    @Test
    public void readFileTest() {

        readFile();


    }

    private void readFile() {

        try {
            File file = new File("/Users/one1000078/Desktop/passwd");
            FileReader fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";

            while( (line = bufferedReader.readLine()) != null){

                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
