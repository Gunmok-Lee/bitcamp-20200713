// Worker 구현체 사용
package com.eomcs.oop.ex09.a.before;

public class Exam01 {

  public static void main(String[] args) {

    BlueWorker w1 = new BlueWorker();
    WhiteWorker w2 = new WhiteWorker();
    JubuWorker w3 = new JubuWorker();

    // 각 노동자에게 일을 시키는 방법이 다르다.
    // 왜?
    // => 메서드 호출 방법이 다르기 때문에
    w1.doFight();
    w2.doZingZing();
    w3.doSsingSsing();

    // 객체에 일을 시키는 방식은 엇비슷한데,
    // 메서드 시그너처가 다르기 때문에
    // 호출할 때 일관성이 없다.
    // 즉 worker 객체를 사용하는 입장에서는
    // 각 worker에 어떤 메서드가 있는지 확인해서
    // 그 형식에 맞춰야 하기 때문에
    // 객체를 사용하기가 불편한다.
    // 또한,
    // 앞으로 worker를 추가 제작할 경우
    // 개발자의 입맛에 맞춰 메서드 이름과 파라미터 형식이 결정될 것이기 때문에
    // 점점 더 worker 객체를 사용하기 힘들어진다.
    //
    // 결론!
    // => 유사한 일을 하는데 객체 사용법이 다르다면 쓰기가 매우 불편하다.
    //
    // 해결책!
    // => 유사한 일을 하는 객체에 대해 사용법을 통일하자.
    //
    // 방법!
    // => 객체 사용 규칙을 정의한다.
    // => 그리고 클래스를 정의할 때 그 규칙에 따라 만든다.
    // => 그러면 규칙에 따라 만든 클래스를 사용할 때는
    //    일관된 방법으로 메서드를 호출할 수 있어
    //    코딩하기가 훨씬 편해지고,
    //    유지보수가 쉬워진다.
    //
    // 이렇게 객체의 사용 규칙을 정의하는 문법이 "인터페이스(interface)"이다.
    //
    //
  }
}



