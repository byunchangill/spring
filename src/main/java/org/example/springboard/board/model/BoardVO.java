package org.example.springboard.board.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO extends BoardEntity { // 주가 자료 넣을때 쓰는 곳.
    private String writerNm;
    private String profileImg;
}
