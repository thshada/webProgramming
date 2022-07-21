package com.ync.view.board;


import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ync.biz.board.BoardVO;
import com.ync.biz.board.FileService;
import com.ync.biz.board.impl.BoardDAO;

@Controller
public class BoardController {
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo , BoardDAO boardDAO,FileService fileService,MultipartHttpServletRequest multiRequest) throws Exception {
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String realPath = servletContext.getRealPath("/");
			
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File(realPath+"/resources/upload/"+fileName));
			
		}
		//fileService.uploadFile(multiRequest);
		boardDAO.insertBoard(vo);
		return "redirect:/getBoardList.do";
	}
	
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(BoardVO vo , BoardDAO boardDAO) {
		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo , BoardDAO boardDAO) {
		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo , BoardDAO boardDAO, Model model) {
		model.addAttribute("board", boardDAO.getBoard(vo));
		return "getBoard.jsp";
	}
	
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(BoardVO vo,BoardDAO boardDAO, Model model) {
		model.addAttribute("boardList", boardDAO.getBoardList(vo));
		return "getBoardList.jsp";
	}	
	
	
	

}
