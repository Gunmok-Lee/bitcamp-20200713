package com.eomcs.corelib.ex02;

public class Exam0140a {
  public static void main(String[] args) {
    String s1 = new String("Hello");

    String s2 = s1.toString();

    System.out.println(s1 == s2);

    System.out.println(s2);

    System.out.println(s2.toString());

    System.out.println(s1.hashCode());
    System.out.println(s2.hashCode());
  }
}