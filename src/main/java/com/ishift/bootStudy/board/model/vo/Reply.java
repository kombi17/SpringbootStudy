package com.ishift.bootStudy.board.model.vo;

import lombok.Data;

@Data
public class Reply {

  private int replyNo;
  private String replyContent;
  private String replyDate;
  private String replyStatement;
  
  private int boardNo;
  
  private int userNo;
  private String userId;
  private String userNickname;
}
