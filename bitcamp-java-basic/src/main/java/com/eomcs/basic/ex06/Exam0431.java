package com.eomcs.basic.ex06;


public class Exam0431 {
  public static void main(String[] args) {
    // break
    for (int i = 1; i <=10; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.println(j + " ");
        if (j == 5)
          break; // 현재 소속되어 있는 반복문을 멈춘다.
      }
      System.out.println();
    }
  }
}
