package com.eomcs.basic.ex07;

//# 메서드 : 스택 메모리 응용 II - 재귀호출
//
public class Exam0450a {

  static int sum(int value) {
    if (value == 1)
      return 1;

    return value + sum(value - 1);
  }

  public static void main(String[] args) {

    System.out.println(sum(5));
  }
}
