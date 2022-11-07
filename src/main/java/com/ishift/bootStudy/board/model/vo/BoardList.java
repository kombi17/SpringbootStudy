package com.ishift.bootStudy.board.model.vo;

import lombok.Data;

@Data
public class BoardList {

  private int boardNo;
  private String boardTitle;

  private String userId;
  private String userNickname;

  private String createDate;
  private int readCount;
  
  private int userNo;
}
