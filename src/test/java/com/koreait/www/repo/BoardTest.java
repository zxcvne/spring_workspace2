package com.koreait.www.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koreait.www.domain.BoardVO;
import com.koreait.www.repository.BoardDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.koreait.www.config.RootConfig.class})
public class BoardTest {
	// JUnit : test 케이스를 만들어서 실행
	// spring은 기본으로 JUnit을 내장
	// project 우클릭 -> properties -> buildpath -> Classpath -> add lib -> JUnit
	
	@Autowired
	private BoardDAO bdao;
	
	// Junit에서 제공하는 test annotation을 사용
	@Test
	public void insertBoardDummies() {
		for(int i = 0; i < 2000; i++) {
			BoardVO board = new BoardVO();
			board.setTitle("Test Title" + (int)(Math.random()*300));
			board.setWriter("tester" + (int)(Math.random()*300));
			board.setContent("test content" + i);
			bdao.insert(board);
		}
	}
}
