package com.study;

import org.junit.Test;

/**
 * Created by one1000078 on 2019. 2. 25..
 */
public class Syncronized {


    static int i = 0;
    static int j = 0;

    @Test
    public synchronized void add1() {
        /*
        인스턴스 메소드의 동기화는 이 메소드를 가진 인스턴스(객체)를 기준으로 이루어진다. 그러므로,
        한 클래스가 동기화된 인스턴스 메소드를 가진다면, 여기서 동기화는 이 클래스의 한 인스턴스를 기준으로 이루어진다.
        그리고 한 시점에 오직 하나의 쓰레드만이 동기화된 인스턴스 메소드를 실행할 수 있다. 결국, 만일 둘 이상의 인스턴스가 있다면, 한 시점에, 한 인스턴스에, 한 쓰레드만 이 메소드를 실행할 수 있다.
         */
        i = i + 1;
        j = j + 1;
    }

    @Test
    public static synchronized void add2() {

        /*
        스태틱 메소드 동기화는 이 메소드를 가진 클래스의 클래스 객체를 기준으로 이루어진다. JVM 안에 클래스 객체는 클래스 당 하나만 존재할 수 있으므로, 같은 클래스에 대해서는 오직 한 쓰레드만 동기화된 스태틱 메소드를 실행할 수 있다.
            만일 동기화된 스태틱 메소드가 다른 클래스에 각각 존재한다면, 쓰레드는 각 클래스의 메소드를 실행할 수 있다.

        클래스 (쓰레드가 어떤 스태틱 메소드를 실행했든 상관없이-)당 한 쓰레드이다. */

        i = i + 2;
        j = j + 2;

    }

    /*
    이렇게 메소드 안에 동기화 블록을 따로 작성할 수 있다. 메소드 안에서도 이 블록 안의 코드만 동기화하지만, 이 예제에서는 메소드 안의 동기화 블록 밖에 어떤 다른 코드가 존재하지 않으므로,
    동기화 블록은 메소드 선언부에 synchronized 를 사용한 것과 같은 기능을 한다.

    동기화 블록이 괄호 안에 한 객체를 전달받고 있음에 주목하자. 예제에서는 'this' 가 사용되었다.
    이는 이 add() 메소드가 호출된 객체를 의미한다. 이 동기화 블록 안에 전달된 객체를 모니터 객체(a monitor object) 라 한다.
    이 코드는 이 모니터 객체를 기준으로 동기화가 이루어짐을 나타내고 있다. 동기화된 인스턴스 메소드는 자신(메소드)을 내부에 가지고 있는 객체를 모니터 객체로 사용한다.

    같은 모니터 객체를 기준으로 동기화된 블록 안의 코드를 오직 한 쓰레드만이 실행할 수 있다.

    다음 예제의 동기화는 동일한 기능을 수행한다. */

    public synchronized void log1(String msg1, String msg2){
        System.console().printf(msg1);
        System.console().printf(msg2);
    }


    public void log2(String msg1, String msg2){
        synchronized(this){
            System.console().printf(msg1);
            System.console().printf(msg2);
        }
    }
}
