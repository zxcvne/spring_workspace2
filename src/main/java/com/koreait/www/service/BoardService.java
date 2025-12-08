package com.koreait.www.service;

import java.util.List;

import com.koreait.www.domain.BoardVO;
import com.koreait.www.domain.PagingVO;

public interface BoardService {

	int insert(BoardVO board);

	List<BoardVO> getList(PagingVO pgvo);

	BoardVO getDetail(long bno);

	int update(BoardVO board);

	int remove(long bno);

	int getTotalCount(PagingVO pgvo);

	int readCountUp(long bno, int i);



}
