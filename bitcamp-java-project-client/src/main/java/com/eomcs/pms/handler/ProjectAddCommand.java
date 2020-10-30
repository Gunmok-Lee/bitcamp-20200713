package com.eomcs.pms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.eomcs.pms.domain.Project;
import com.eomcs.util.Prompt;

public class ProjectAddCommand implements Command {


  @Override
  public void execute() {
    System.out.println("[프로젝트 등록]");

    Project project = new Project();
    project.setTitle(Prompt.inputString("프로젝트명? "));
    project.setContent(Prompt.inputString("내용? "));
    project.setStartDate(Prompt.inputDate("시작일? "));
    project.setEndDate(Prompt.inputDate("종료일? "));
    project.setOwner(Prompt.inputString("만든이? "));
    project.setMembers(Prompt.inputString("팀원? "));


    try (Connection con = DriverManager.getConnection( //
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt =
            con.prepareStatement("insert into pms_project("
                + "title,content,sdt,edt,owner,members) values(?,?,?,?,?,?)");) {

      stmt.setString(1, project.getTitle());
      stmt.setString(2, project.getContent());
      stmt.setDate(3, project.getStartDate());
      stmt.setDate(4, project.getEndDate());
      stmt.setString(5, project.getOwner());
      stmt.setString(6, project.getMembers());

      stmt.executeUpdate();

      System.out.println("프로젝트를 등록하였습니다.");

    } catch (Exception e) {
      System.out.println("프로젝트 등록 중 오류 발생!");
      e.printStackTrace();
    }
  }
}
