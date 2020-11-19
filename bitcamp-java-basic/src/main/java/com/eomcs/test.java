package com.eomcs;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class test {

  public static void main(String[] args) {
    // Jsoup를 이용해서 http://www.cgv.co.kr/movies/ 크롤링
    String url = "https://movie.naver.com/movie/bi/mi/photoView.nhn?code=136900"; //크롤링할 url지정
    Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다

    try {
      doc = Jsoup.connect(url).get();
    } catch (IOException e) {
      e.printStackTrace();
    }
    //select를 이용하여 원하는 태그를 선택한다. select는 원하는 값을 가져오기 위한 중요한 기능이다.
    //    Elements element = doc.select("div.sect-movie-chart");
    //    Elements element = doc.select("div.mv_info_area");

    Elements elements = doc.select("div.rolling_list");
    System.out.println(elements.select("img").attr("src"));
  }
}


