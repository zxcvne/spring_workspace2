package com.koreait.www.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.www.domain.BoardFileDTO;
import com.koreait.www.domain.BoardVO;
import com.koreait.www.domain.FileVO;
import com.koreait.www.domain.PagingVO;
import com.koreait.www.handler.FileHandler;
import com.koreait.www.handler.FileRemoveHandler;
import com.koreait.www.handler.PagingHandler;
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
	private final FileHandler fh;
	
	// board/register -> /board/register.jsp
	// 요청경로와 jsp의 경로가 일치하면 void
	@GetMapping("/register")
	public void register() {}
	
	//첨부 파일 추가 => multipart/form-data => MultipartFile
	// multiple => 파일이 여러개 가능 => MultipartFile[]
	@PostMapping("/insert")
	public String insert(BoardVO board, MultipartFile[] files) {
		List<FileVO> flist = null;
		// files에 값이 있다면 flist를 생성
		if(files[0].getSize() > 0) {
			// 파일이 내용이 있다면...
			// MultipartFile[] => DB에 저장할 값 생성 => FileVO의 List로 생성
			// 실제 파일을 저장 => fileHandler
			flist = fh.uploadFile(files);
			log.info(" >>> flist >> {}", flist);
		}
		
		BoardFileDTO bfdto = new BoardFileDTO(board, flist);
		int isOk = bsv.insert(bfdto);
		
//		int isOk = bsv.insert(board);
		log.info(" >>> insert > {}", (isOk > 0)? "OK" : "FAIL");
		return "redirect:/";
	}
	
	@GetMapping("/list")
	public String list(Model model, PagingVO pgvo) {
		log.info(">>> pagingVO {}", pgvo);
		List<BoardVO> list = bsv.getList(pgvo);
		int totalCount = bsv.getTotalCount(pgvo);
		PagingHandler ph = new PagingHandler(totalCount, pgvo);
		model.addAttribute("list", list);
		model.addAttribute("ph", ph);
		return "/board/list";
	}
	
	@GetMapping({"/detail", "/modify"})
	public void detail(Model model,
			@RequestParam("bno") long bno, HttpServletRequest request) {
		String path = request.getServletPath(); 
		if(path.equals("/board/detail")) {
			// readCountUp + 1
			int isOk = bsv.readCountUp(bno, 1);
		}		
		BoardFileDTO board = bsv.getDetail(bno);
		model.addAttribute("boardFileDTO", board);
	}
	
	@PostMapping("/update")
	public String update(BoardVO board,
			@RequestParam(value="files", required = false) MultipartFile[] files) {
		List<FileVO> flist = null;
		if(files[0].getSize() > 0) {
			// 첨부파일이 있는 경우
			flist = fh.uploadFile(files);
		}
		int isOk = bsv.update(new BoardFileDTO(board, flist));
		return "redirect:/board/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("bno") long bno) {
		int isOk = bsv.remove(bno);
		return "redirect:/board/list"; 
	}
	
	@ResponseBody
	@DeleteMapping("/file/{uuid}")
	public String fileDelete(@PathVariable("uuid") String uuid) {
		
		// 폴더에 있는 파일도 삭제
		FileRemoveHandler fr = new FileRemoveHandler();
		FileVO fvo = bsv.getFile(uuid);
		fr.removeFile(fvo);
		
		// uuid 보내서 DB의 파일 삭제
		int isOk = bsv.removeFile(uuid);
		return isOk > 0 ? "1" : "0";
	}
	
}
