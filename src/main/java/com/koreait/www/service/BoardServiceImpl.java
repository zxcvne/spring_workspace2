package com.koreait.www.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.koreait.www.domain.BoardVO;
import com.koreait.www.domain.PagingVO;
import com.koreait.www.repository.BoardDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class BoardServiceImpl implements BoardService{
	private final BoardDAO bdao;

	@Override
	public int insert(BoardVO board) {
		
		return bdao.insert(board);
	}

	@Override
	public List<BoardVO> getList(PagingVO pgvo) {
		return bdao.getList(pgvo);
	}

	@Override
	public BoardVO getDetail(long bno) {
		return bdao.getDetail(bno);
	}

	@Override
	public int update(BoardVO board) {
		return bdao.update(board);
	}

	@Override
	public int remove(long bno) {
		// TODO Auto-generated method stub
		return bdao.remove(bno);
	}
}
