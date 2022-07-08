package com.ync.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ync.biz.board.BoardVO;
import com.ync.biz.board.impl.BoardDAO;

@Controller
public class GetBoardController{
	


	/*
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("GetBoardController �� �� ���� ó��");
		
		//1. �˻��� �Խñ� ��ȣ ����
		String seq = request.getParameter("seq");

		//DB ���� ó��
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);		
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("getBoard");
		return mav;
		//HttpSession session = request.getSession();
		//session.setAttribute("board", board);
		
		//return "getBoard";
			
	}
	*/

}
