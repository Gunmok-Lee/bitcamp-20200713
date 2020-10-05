package com.eomcs.net.ex03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server0160 {
  public static void main(String[] args) {
    try(Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888)){

      System.out.println("클라이언트의 연결을 기다리고 있음.");

      try(Socket socket = serverSocket.accept();
          Scanner in = new Scanner(new BufferedInputStream(socket.getInputStream()));
          PrintStream out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()))){

        System.out.println("클라이언트가 보낸 한 줄의 문자열을 기다리고 있음!");

        String str = in.nextLine();
        System.out.println(str);

        System.out.print(">");
        keyboard.nextLine();

        out.println(str);
        out.flush();

        System.out.println("클라이언트에게 데이터를 보냈음.");
      }
      System.out.println("클라이언트와의 연결을 끊었음.");
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버 종료");
  }
}
