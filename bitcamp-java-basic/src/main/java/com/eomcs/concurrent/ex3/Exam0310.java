package com.eomcs.concurrent.ex3;

import java.util.Scanner;

public class Exam0310 {

  static class MyThread extends Thread {
    @Override
    public void run() {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("입력하세요> ");
      String input = keyboard.nextLine();
      System.out.println("입력한 문자열 => " + input);
      keyboard.close();
    }
  }

  public static void main(String[] args) {
    MyThread t = new MyThread();
    t.start();

    System.out.println("프로그램 종료!");
  }
}