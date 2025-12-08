package com.koreait.www.repository;

import java.util.List;

import com.koreait.www.domain.BoardVO;
import com.koreait.www.domain.PagingVO;

public interface BoardDAO {

	int insert(BoardVO board);

	List<BoardVO> getList(PagingVO pgvo);

	BoardVO getDetail(long bno);

	int update(BoardVO board);

	int remove(long bno);

}
