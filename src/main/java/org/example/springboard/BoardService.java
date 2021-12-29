package org.example.springboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper mapper;

    public int insBoard(BoardEntity entity) {
        return mapper.insBoard(entity);
    }

    public List<BoardEntity> selBoardList() {
        return mapper.selBoardList();
    }

    public BoardEntity selBoard(BoardEntity entity) {
        return mapper.selBoard(entity);
    }

    public int delBoard(BoardEntity entity) {
        return mapper.delBoard(entity);
    }
}
