package com.study;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by one1000078 on 2019. 2. 25..
 */
public class CompareTo {

    static ArrayList<Exam_WhitePagesItem> whitePageList = new ArrayList<Exam_WhitePagesItem>();

    @Before
    public void makeExample () {


        whitePageList.add(new Exam_WhitePagesItem("자바킹", "010-111-1111"));
        whitePageList.add(new Exam_WhitePagesItem("자바킹", "010-111-2222"));
        whitePageList.add(new Exam_WhitePagesItem("이사과", "010-222-1112"));
        whitePageList.add(new Exam_WhitePagesItem("호빵맨", "010-333-1113"));
        whitePageList.add(new Exam_WhitePagesItem("장동건", "010-444-1114"));
        whitePageList.add(new Exam_WhitePagesItem("최강치", "010-555-1115"));
        whitePageList.add(new Exam_WhitePagesItem("오동통", "010-666-1116"));
        whitePageList.add(new Exam_WhitePagesItem("김멜론", "010-777-1117"));
        whitePageList.add(new Exam_WhitePagesItem("바가지", "010-888-1118"));

    }


    @Test
    public void test1() {

        for(Exam_WhitePagesItem item : whitePageList) {

            System.err.println(item.getName() + ", " + item.getTeleNum());

        }

        System.err.println("finish");

        orderbyNameASC();

    }

    @Test
    public void test2() {

        for(Exam_WhitePagesItem item : whitePageList) {

            System.err.println(item.getName() + ", " + item.getTeleNum());

        }

        System.err.println("finish");

        //orderbyNumberASC();

        orderbyNumberDesc();

    }


    private void orderbyNameASC() {

        Collections.sort(whitePageList, new Exam_WhitePagesItem.NameAscComapre());

        for(Exam_WhitePagesItem item : whitePageList) {

            System.err.println(item.getName() + ", " + item.getTeleNum());

        }
    }

    private void orderbyNumberASC() {

        Collections.sort(whitePageList, new Exam_WhitePagesItem.NumberAscComapre());

        for(Exam_WhitePagesItem item : whitePageList) {

            System.err.println(item.getName() + ", " + item.getTeleNum());

        }
    }

    private void orderbyNumberDesc() {

        Collections.sort(whitePageList, new Exam_WhitePagesItem.NumberDESCComapre());

        for(Exam_WhitePagesItem item : whitePageList) {

            System.err.println(item.getName() + ", " + item.getTeleNum());

        }
    }
}



class Exam_WhitePagesItem {
    private String name;
    private String teleNum;

    public Exam_WhitePagesItem() {
        // TODO Auto-generated constructor stub
    }

    public Exam_WhitePagesItem(String name, String teleNum) {
        this.name = name;
        this.teleNum = teleNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeleNum() {
        return teleNum;
    }

    public void setTeleNum(String teleNum) {
        this.teleNum = teleNum;
    }


    @Override
    public String toString() {

        return "[ " +name+ "] "+teleNum;
    }


    static class NameAscComapre implements Comparator<Exam_WhitePagesItem> {


        @Override
        public int compare(Exam_WhitePagesItem arg0, Exam_WhitePagesItem arg1) {
            return arg0.getName().compareTo(arg1.getName());

        }
    }

    static class NumberAscComapre implements Comparator<Exam_WhitePagesItem> {

        @Override
        public int compare(Exam_WhitePagesItem arg0, Exam_WhitePagesItem arg1) {
            return arg0.getTeleNum().compareTo(arg1.getTeleNum());

        }
    }

    static class NumberDESCComapre implements Comparator<Exam_WhitePagesItem> {


        @Override
        public int compare(Exam_WhitePagesItem arg0, Exam_WhitePagesItem arg1) {
            return arg1.getTeleNum().compareTo(arg0.getTeleNum());

        }
    }

}