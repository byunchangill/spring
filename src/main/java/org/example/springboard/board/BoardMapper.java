package org.example.springboard.board;

import org.apache.ibatis.annotations.Mapper;
import org.example.springboard.board.model.BoardEntity;
import org.example.springboard.board.model.BoardVO;

import java.util.List;

@Mapper
public interface BoardMapper {     // interface 는 자동으로 public, abstract 추가해준다 생략 가능.

    int insBoard(BoardEntity entity); // 글 등록
    List<BoardVO> selBoardList(); // 리스트 화면
    BoardVO selBoard(BoardEntity entity); // 디테일 화면
    int delBoard(BoardEntity entity); // 게시글 삭제.
    int upBoard(BoardEntity entity); // 게시글 수정.

}
