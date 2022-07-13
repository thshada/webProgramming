package com.ync.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ync.biz.board.BoardVO;
import com.ync.biz.board.impl.BoardDAO;

@Controller
public class DeleteBoardController {
	


	/*
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("deleteBoardController �� ���� ó��");
		
		//1. �˻��� �Խñ� ��ȣ ����
		String seq = request.getParameter("seq");
		
		//DB ���� ó��
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(vo);
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		return mav;
		
		//return "getBoardList.do";	
	}
	*/

}
