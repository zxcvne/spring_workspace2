package com.koreait.www.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.www.domain.UserVO;
import com.koreait.www.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user/*")
@Controller
public class UserController {

	private final UserService usv;
	// 암호화 객체
	private final BCryptPasswordEncoder bcEncoder; 
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/insert")
	public String insert(UserVO user) {
		// 회원가입 => password 암호화
		log.info(" >>> join user >> {}", user);
		user.setPwd(bcEncoder.encode(user.getPwd()));
		log.info(" >>> join encodePW user >> {}", user);
		
		int isOk = usv.insert(user);
		
		return "redirect:/user/login";
	}
	
	@GetMapping("/login")
	public void login() {
		
	}
	
	@PostMapping("/login")
	public String loginPost(HttpServletRequest request, RedirectAttributes re) {
		// 로그인 실패시 에러메시지 전송을 위해 사용
		
		// 실제 로그인시 Security의 filter에서 가져감. => 컨트롤러 안탐.
		// 로그인 실패시 다시 로그인 페이지로 돌아와 오류메시지를 전송
		log.info(" >>> failEmail >>> {}", request.getAttribute("failEmail"));
		log.info(" >>> errMsg >>> {}", request.getAttribute("errMsg"));
		
		re.addFlashAttribute("failEmail", request.getAttribute("failEmail"));
		re.addFlashAttribute("errMsg", request.getAttribute("errMsg"));
		
		return "redirect:/user/login";
	}
}
