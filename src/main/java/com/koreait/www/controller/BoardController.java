package com.koreait.www.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.www.domain.BoardVO;
import com.koreait.www.domain.PagingVO;
import com.koreait.www.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RequestMapping("/board/*")
@Slf4j
@Controller
public class BoardController {
	
	// 생성자 주입
	private final BoardService bsv;
	
	// board/register -> /board/register.jsp
	// 요청경로와 jsp의 경로가 일치하면 void
	@GetMapping("/register")
	public void register() {}
	
	@PostMapping("/insert")
	public String insert(BoardVO board) {
		log.info(" >>> insert board {}", board);
		int isOk = bsv.insert(board);
		log.info(" >>> register > {}", (isOk > 0)? "OK" : "FAIL");
		return "redirect:/";
	}
	
	@GetMapping("/list")
	public String list(Model model, PagingVO pgvo) {
		log.info(">>> pagingVO {}", pgvo);
		List<BoardVO> list = bsv.getList(pgvo);
		model.addAttribute("list", list);
		return "/board/list";
	}
	
	@GetMapping({"/detail", "/modify"})
	public void detail(Model model, @RequestParam("bno") long bno) {
		BoardVO board = bsv.getDetail(bno);
		model.addAttribute("board", board);
	}
	
	@PostMapping("/update")
	public String update(BoardVO board) {
		int isOk = bsv.update(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("bno") long bno) {
		int isOk = bsv.remove(bno);
		return "redirect:/board/list"; 
	}
	
}
