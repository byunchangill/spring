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
        model.addAttribute("list", service.selBoardList());
    }

    @GetMapping("/detail")
    public void detail(Model model, BoardEntity entity) {
        model.addAttribute("data", service.selBoard(entity));
    }

    @GetMapping("/write")
    public void write() {}

    @PostMapping("/write")
    public String writeProc(BoardEntity entity) {
        int result = service.insBoard(entity);
        return "redirect:/board/list";
    }

    @GetMapping("/del")
    public String delProc(BoardEntity entity) {
        int result = service.delBoard(entity);
        return "redirect:/board/list";
    }
}
