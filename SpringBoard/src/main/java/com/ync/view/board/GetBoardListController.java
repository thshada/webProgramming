package com.ync.view.board;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ync.biz.board.BoardVO;
import com.ync.biz.board.impl.BoardDAO;

@Controller
public class GetBoardListController {
	

	
	/*
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("GetBoardListController �� ��� ó��");
		
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);	
		
		//HttpSession session = request.getSession();
		//session.setAttribute("boardList", boardList);
		//return "getBoardList";
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);
		mav.setViewName("getBoardList");
		return mav;
	}
	*/
	

}
