package org.example.springboard;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {     // interface 는 자동으로 public, abstract 추가해준다 생략 가능.

    int insBoard(BoardEntity entity); // 글 등록
    List<BoardEntity> selBoardList(); // 리스트 화면
    BoardEntity selBoard(BoardEntity entity); // 디테일 화면
    int delBoard(BoardEntity entity); // 게시글 삭제.

}
