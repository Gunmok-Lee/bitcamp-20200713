package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Member;
import com.eomcs.util.ArrayList;
import com.eomcs.util.Prompt;

public class MemberHandler {

  //Member 객체 목록을 저장할 ArrayList 객체를 준비한다.
  ArrayList<Member> memberList = new ArrayList<>();

  // 다른 패키지에서 이 메서드를 사용할 수 있도록 public 으로 사용 범위를 공개한다.
  public void add() {
    System.out.println("[회원 등록]");

    Member member = new Member();
    member.setNo(Prompt.inputInt("번호? "));
    member.setName(Prompt.inputString("이름? "));
    member.setEmail(Prompt.inputString("이메일? "));
    member.setPassword(Prompt.inputString("암호? "));
    member.setPhoto(Prompt.inputString("사진? "));
    member.setTel(Prompt.inputString("전화? "));
    member.setRegisteredDate(new java.sql.Date(System.currentTimeMillis()));

    // 제네릭 문법에 따라 add()를 호출할 때 넘겨줄 수 있는 값은
    // Member 또는 그 하위 타입의 인스턴스만 가능하다.
    // 다른 타입은 불가능하다.
    memberList.add(member);
  }

  public void list() {
    System.out.println("[회원 목록]");

    // 제네릭 문법에 따라 리턴 타입이 'Member[]' 이기 때문에
    // 따로 형변환 할 필요가 없다.
    // 대신 Member[] 배열을 리턴해 달라는 의미로 배열의 타입 정보를 넘긴다.

    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      System.out.printf("%d, %s, %s, %s, %s\n",
          member.getNo(),
          member.getName(),
          member.getEmail(),
          member.getTel(),
          member.getRegisteredDate());
    }
  }

  public Member findByName(String name) {
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (member.getName().equals(name)) {
        return member;
      }
    }
    return null;
  }


  public void detail() {
    System.out.println("[회원 상세보기]");
    int no = Prompt.inputInt("번호? ");
    Member member = findByNo (no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("이메일: %s\n", member.getEmail());
    System.out.printf("사진: %s\n", member.getPhoto());
    System.out.printf("전화: %s\n", member.getTel());
    System.out.printf("등록일: %s\n", member.getRegisteredDate());
  }

  public void update() {
    System.out.println("[회원 변경]");
    int no = Prompt.inputInt("번호? ");
    Member member = findByNo (no);

    if (member == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    String name = Prompt.inputString(
        String.format("이름(%s)? ", member.getName()));
    String email = Prompt.inputString(
        String.format("이메일(%s)? ", member.getEmail()));
    String photo = Prompt.inputString(
        String.format("사진(%s)? ", member.getPhoto()));
    String tel = Prompt.inputString(
        String.format("전화(%s)? ", member.getTel()));

    String response = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (!response.equalsIgnoreCase("y")) {
      System.out.println("회원 변경을 취소하였습니다.");
      return;
    }

    member.setName(name);
    member.setEmail(email);
    member.setPhoto(photo);
    member.setTel(tel);
    System.out.println("회원을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[회원 삭제]");
    int no = Prompt.inputInt("번호? ");
    int index = indexOf (no);

    if (index == -1) {
      System.out.println("해당 번호의 회원이 없습니다.");
    } else {
      String response = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
      if (response.equalsIgnoreCase("y")) {
        memberList.remove(index);
        System.out.println("회원 삭제하였습니다.");
      } else {
        System.out.println("회원 삭제를 취소하였습니다.");
      }
    }
  }

  private int indexOf(int no) {
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (member.getNo() == no) {
        return i;
      }
    }
    return -1;
  }


  private Member findByNo (int no) {
    for (int i = 0; i < memberList.size(); i++) {
      Member member = memberList.get(i);
      if (member.getNo() == no) {
        return member;
      }
    }
    return null;
  }
}
