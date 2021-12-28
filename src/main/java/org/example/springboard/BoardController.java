package org.example.springboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board") // BoardController class 아래에 있는 것들은 board 가 붙은 상태에서 뒤에 붙는다.
public class BoardController {
    @Autowired
    private BoardService service;

    @GetMapping("/list") // @RequestMapping("/list") 해도 된다.
    public void list() { // board 파일 만들지 않고 하려면, 리턴 리스트 하면 된다.

    }
}
