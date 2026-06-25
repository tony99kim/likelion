package org.example.board.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.board.dto.BoardRequestDto;
import org.example.board.dto.BoardResponseDto;
import org.example.board.exception.PasswordMismatchException;
import org.example.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping({"/", "/list"})
    public String list(Model model) {
        model.addAttribute("boards", boardService.getBoardList());
        return "board/list";
    }

    @GetMapping("/view")
    public String view(@RequestParam Long id, Model model) {
        model.addAttribute("board", boardService.getBoard(id));
        return "board/view";
    }

    @GetMapping("/writeform")
    public String writeForm(Model model) {
        model.addAttribute("board", new BoardRequestDto());
        return "board/writeform";
    }

    @PostMapping("/write")
    public String write(
            @Valid @ModelAttribute("board") BoardRequestDto board,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            return "board/writeform";
        }

        Long id = boardService.createBoard(board);

        redirectAttributes.addFlashAttribute("message", "게시글이 등록되었습니다.");

        return "redirect:/view?id=" + id;
    }

    @GetMapping("/updateform")
    public String updateForm(@RequestParam Long id, Model model) {
        BoardResponseDto board = boardService.getBoard(id);

        BoardRequestDto requestDto = new BoardRequestDto();
        requestDto.setName(board.getName());
        requestDto.setTitle(board.getTitle());
        requestDto.setContent(board.getContent());

        model.addAttribute("boardId", id);
        model.addAttribute("board", requestDto);

        return "board/updateform";
    }

    @PostMapping("/update")
    public String update(
            @RequestParam Long id,
            @Valid @ModelAttribute("board") BoardRequestDto board,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("boardId", id);
            return "board/updateform";
        }

        try {
            boardService.updateBoard(id, board);
        } catch (PasswordMismatchException e) {
            model.addAttribute("boardId", id);
            model.addAttribute("errorMessage", e.getMessage());
            return "board/updateform";
        }

        redirectAttributes.addFlashAttribute("message", "게시글이 수정되었습니다.");

        return "redirect:/view?id=" + id;
    }

    @GetMapping("/deleteform")
    public String deleteForm(@RequestParam Long id, Model model) {
        model.addAttribute("boardId", id);
        return "board/deleteform";
    }

    @PostMapping("/delete")
    public String delete(
            @RequestParam Long id,
            @RequestParam String password,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        try {
            boardService.deleteBoard(id, password);
        } catch (PasswordMismatchException e) {
            model.addAttribute("boardId", id);
            model.addAttribute("errorMessage", e.getMessage());
            return "board/deleteform";
        }

        redirectAttributes.addFlashAttribute("message", "게시글이 삭제되었습니다.");

        return "redirect:/list";
    }
}