package com.eomcs.basic.ex07;

//# JVM 아규먼트
//
public class Exam0610a {

  public static void main(String[] 변수명은상관없다) {


    String value1 = System.getProperty("a");
    String value2 = System.getProperty("b");
    String value3 = System.getProperty("c");

    System.out.println(value1);
    System.out.println(value2);
    System.out.println(value3);
  }
}