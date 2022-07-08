package com.ync.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ync.biz.board.BoardService;
import com.ync.biz.board.BoardVO;
import com.ync.biz.common.Log4jAdvice;
import com.ync.biz.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAOSpring boardDAO;
	

	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
		
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
		
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
		
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

}
