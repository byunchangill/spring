package org.example.springboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board") // BoardController class 아래에 있는 것들은 board 가 붙은 상태에서 뒤에 붙는다.
public class BoardController {
    @Autowired
    private BoardService service;

    @GetMapping("/list") // @RequestMapping("/list") 해도 된다.
    public void list(Model model) {
        List<BoardEntity> list = service.selBoardList();
        model.addAttribute("list", list);
    }

    @GetMapping("/write")
    public void write() {}

    @PostMapping("/write")
    public String writeProc(BoardEntity entity) {
        int result = service.insBoard(entity);
        return "redirect:/board/list";
    }
}
