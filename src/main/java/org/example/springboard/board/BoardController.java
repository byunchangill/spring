package org.example.springboard.board;

import org.example.springboard.UserUtils;
import org.example.springboard.board.model.BoardEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
        service.upBoardHitsUp(entity);
        model.addAttribute("data", service.selBoard(entity));
    }

    @GetMapping("/write")
    public void write() {}

    @PostMapping("/write")
    public String writeProc(BoardEntity entity, RedirectAttributes reAttr) {
        int result = service.insBoard(entity);
        if(result == 0) {
//            RedirectAttributes 는 redirect 와 관련되어 있다.
//            reAttr.addAttribute("msg", "글 등록에 실패하였습니다."); // addAttribute 는 쿼리스트링 생성
            reAttr.addFlashAttribute("msg", "글 등록에 실패하였습니다."); // addFlashAttribute 는 request 에 담에서 보내준다.
            reAttr.addFlashAttribute("data", entity);
            return "redirect:/board/write";
        }
        return "redirect:/board/list";
    }

    @GetMapping("/del")
    public String delProc(BoardEntity entity, RedirectAttributes reAttr) {
        int result = service.delBoard(entity);
        if(result == 0) {
            reAttr.addAttribute("iboard", entity.getIboard()); // 퀴리스트링 iboard = pk값
            reAttr.addFlashAttribute("msg", "글 삭제에 실패하였습니다.");
            return "redirect:/board/detail";
        }
        return "redirect:/board/list";
    }

    @GetMapping("/update")
    public void mod(Model model, BoardEntity entity, @NotNull HttpServletRequest res) throws Exception {
        Map<String, ?> map = RequestContextUtils.getInputFlashMap(res); //addFlashAttribute 했는값 가져오는 방법
        BoardEntity data = map != null ? (BoardEntity) map.get("data") : service.selBoard(entity);
        model.addAttribute("data", data);
    }

    @PostMapping("/update")
    public String updateProc(BoardEntity entity, RedirectAttributes reAttr) {
        int result = service.upBoard(entity);
        if(result == 0) {
            reAttr.addAttribute("iboard", entity.getIboard());
            reAttr.addFlashAttribute("msg", "글 수정에 실패하였습니다.");
            reAttr.addFlashAttribute("data", entity);
            return "redirect:/board/update";
        }
        return "redirect:/board/detail?iboard=" + entity.getIboard();
    }
}
