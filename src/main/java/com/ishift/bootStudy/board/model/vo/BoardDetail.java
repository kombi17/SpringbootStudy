package com.ishift.bootStudy.board.model.vo;

import java.util.List;
import lombok.Data;

@Data
public class BoardDetail {
  
  private int boardNo;
  private String boardTitle;
  private String boardContent;
  private String createDate;
  private String updateDate;
  private int readCount;
  private String boardStatement;

  private int userNo;
  private String userId;
  private String userNickname;
  
  List<BoardImage> imageList;

}
