package com.koreait.www.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koreait.www.domain.BoardFileDTO;
import com.koreait.www.domain.BoardVO;
import com.koreait.www.domain.FileVO;
import com.koreait.www.domain.PagingVO;
import com.koreait.www.repository.BoardDAO;
import com.koreait.www.repository.FileDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class BoardServiceImpl implements BoardService{
	private final BoardDAO bdao;
	private final FileDAO fdao;

//	@Override
//	public int insert(BoardVO board) {
//		
//		return bdao.insert(board);
//	}

	@Override
	public List<BoardVO> getList(PagingVO pgvo) {
		return bdao.getList(pgvo);
	}

	@Override
	public BoardFileDTO getDetail(long bno) {
		BoardVO board = bdao.getDetail(bno);
		List<FileVO> flist = fdao.getList(bno);
		BoardFileDTO boardFileDTO = new BoardFileDTO(board, flist);
		return boardFileDTO;
	}

	@Override
	public int remove(long bno) {
		// TODO Auto-generated method stub
		return bdao.remove(bno);
	}

	@Override
	public int getTotalCount(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return bdao.getTotalCount(pgvo);
	}

	public int readCountUp(long bno, int i) {
		// TODO Auto-generated method stub
		return bdao.readCountUp(bno, i);
	}
	
	@Transactional
	@Override
	public int insert(BoardFileDTO bfdto) {
		// board => insert => boardMapper
		// file => insert => fileMapper
		int isOk = bdao.insert(bfdto.getBoard()); // => DB에 insert가 되면 bno 생김
		if(bfdto.getFlist() == null) { // 파일이 없는 경우
			return isOk;
		}
		
		// fileDAO 생성 => fileMapper 생성 => fileVO 값을 DB로 등록
		// bno 가져오기
		if(isOk > 0) {
			long bno = bdao.getBno();
			for(FileVO fvo : bfdto.getFlist()) {
				fvo.setBno(bno);
				// 저장
				isOk *= fdao.insertFile(fvo);
			}
			isOk *= bdao.fileQtyUpdate(bno, bfdto.getFlist().size());
		}
		return isOk;
	}
	
	@Transactional
	@Override
	public int removeFile(String uuid) {
		// TODO Auto-generated method stub
		FileVO fvo = fdao.getFile(uuid);
		int isOk = fdao.removeFile(uuid);
		if(isOk > 0) {
			isOk *= bdao.fileQtyUpdate(fvo.getBno(), -1);			
		}
		return isOk;
	}

	@Override
	public FileVO getFile(String uuid) {
		// TODO Auto-generated method stub
		return fdao.getFile(uuid);
	}

	@Transactional
	@Override
	public int update(BoardFileDTO boardFileDTO) {
		int isOk = bdao.update(boardFileDTO.getBoard());
		if(boardFileDTO.getFlist() == null) {
			// 파일이 없는 경우
			return isOk;
		}
		if(isOk > 0) {
			for(FileVO fvo : boardFileDTO.getFlist()) {
				// bno 값은 없는 상태
				fvo.setBno(boardFileDTO.getBoard().getBno());
				isOk *= fdao.insertFile(fvo);
			}
			isOk *= bdao.fileQtyUpdate(boardFileDTO.getBoard().getBno(), boardFileDTO.getFlist().size());
		}
		return isOk;
	}
	
}
