package com.eomcs.exception.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam0520 {
  static void m (int i) throws Exception{
    if (i == 0)
      throw new Exception();
    else if (i == 1)
      throw new RuntimeException();
    else if (i == 2)
      throw new SQLException();
    else if (i == 3)
      throw new IOException();
  }
  public static void main(String[] args) throws Exception{
    try {
      m(1);
    } finally {
      System.out.println("마무리 작업실행");
    }
  }
}