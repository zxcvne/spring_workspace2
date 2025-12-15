package com.koreait.www.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koreait.www.domain.BoardVO;
import com.koreait.www.repository.UserDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.koreait.www.config.RootConfig.class})
public class UserTest {
	
	@Autowired
	private UserDAO udao;
	
//	@Test
//	public void insertUser() {
//		for(int i = 0; i < 2000; i++) {
//			User
//			board.setTitle("Test Title" + (int)(Math.random()*300));
//			board.setWriter("tester" + (int)(Math.random()*300));
//			board.setContent("test content" + i);
//			bdao.insert(board);
//		}
//	}
}
