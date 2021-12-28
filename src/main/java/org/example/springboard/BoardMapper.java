package org.example.springboard;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardEntity entity); // interface 는 자동으로 public, abstract 추가해준다 생략 가능.
    List<BoardEntity> selBoardList();
}
