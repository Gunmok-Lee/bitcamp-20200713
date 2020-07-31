package com.eomcs.pms;

// 클래스의 패키지 정보를 미리 선언하여 컴파일러에게 알려준다.
import java.sql.Date;
import java.util.Scanner;
// 1) 낱개의 변수를 사용하여 여러 회원 정보 처리하기
// 2) 조건문을 사용하여 입출력 제어하기
// - 필요한 만큼만 입력 받고 출력하고 싶다.
// 3) 배열을 사용하여 여러 개의 값을 다루기
// - 배열을 사용하면 간단하게 여러 개의 변수를 선언할 수 있다.
// 4) 반복문을 사용하여 여러 개의 값을 다루기
// - 반복문을 사용하면 같은 코드를 중복해서 작성할 필요가 없다.
// 5) 배열 개수를 변수에서 관리하기
// - 변수의 값만 바꾸면 배열 개수를 바로 변경할 수 있어 편하다.
// 6) 상수를 사용하여 초기 값을 변경하지 못하게 막기
// - 변수는 중간에 값을 바꿀 수 있기 때문에 값을 바꾸지 말아야 하는 경우
//   상수로 선언한다.
public class App {

  public static void main(String[] args) {

    class Member {
      int no;
      String name;
      String email;
      String password;
      String photo;
      String tel;
      Date createdDate;
    }

    final int LENGTH = 100;
    Member[] members = new Member[LENGTH];


    Scanner keyInput = new Scanner(System.in);

    System.out.println("[회원]");


    long currentMillis = 0;
    int count = 0;

    for (int i = 0; i < LENGTH; i++) {
      count++;

      Member m = new Member();

      System.out.print("번호? ");
      m.no = keyInput.nextInt();
      keyInput.nextLine();

      System.out.print("이름? ");
      m.name = keyInput.nextLine();

      System.out.print("이메일? ");
      m.email = keyInput.nextLine();

      System.out.print("암호? ");
      m.password = keyInput.nextLine();

      System.out.print("사진? ");
      m.photo = keyInput.nextLine();

      System.out.print("전화? ");
      m.tel = keyInput.nextLine();

      currentMillis = System.currentTimeMillis(); // 1970-1-1 00:00:00 에서경과된 밀리초
      m.createdDate = new Date(currentMillis);
      System.out.println();

      members[i] = m;

      System.out.print("계속 입력하시겠습니까?(y/N) ");
      String response = keyInput.nextLine();

      if (response.equalsIgnoreCase("y") == false) {
        break; // 반복문을 멈춰라.
      }
    }

    keyInput.close();

    System.out.println("---------------------------");

    for (int i = 0; i < count; i++) {
      Member m = members[i];
      System.out.printf("%d, %s, %s, %s, %s\n",
          m.no,
          m.name,
          m.email, m.tel,
          m.createdDate.toString());
    }

  }
}









