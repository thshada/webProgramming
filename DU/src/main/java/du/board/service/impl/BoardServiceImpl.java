package du.board.service.impl;

import java.io.File;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.uuid.Generators;

import du.board.dao.BoardDAO;
import du.board.domain.BoardAttFileVO;
import du.board.domain.BoardVO;
import du.board.service.BoardService;
import du.common.Pagination;
import du.user.domain.UserVO;
import egovframework.rte.fdl.property.EgovPropertyService;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private EgovPropertyService propertyService;
	
	
	@Override
	public List<BoardVO> selectBoardList(Pagination pagination, String title) {
		
		HashMap<String, Object> map=new HashMap<>();
		
		map.put("startList", pagination.getStartList());
		map.put("listSize",pagination.getListSize() );
		map.put("title", title);
		
		
		return boardDAO.selectBoardList(map);
	}

	@Override
	public int selectBoardListCnt(String title) {
		
	
		return boardDAO.selectBoardListCnt(title);
		
	}
	@Override
	public BoardVO selectBoard(long idx) {
		
		return boardDAO.selectBoard(idx); 
	}
	

	@Override
	public void insertBoard(BoardVO board,HttpSession session) throws Exception {
		
		UserVO user =(UserVO) session.getAttribute("USER");
		
		
		if(user ==null) {
			return;
		}
		board.setWriterId(user.getUserId());
		
		 boardDAO.insertBoard(board);
		 insertBoardAttFile(board);
	}

	@Override
	public void deleteBoard(BoardVO board) {
		if(board.hasAttFile()) {
			boardDAO.deleteBoardAttFile(board.getCriteria());
		}
		boardDAO.deleteBoard(board.getIdx());
	}

	@Override
	public void updateBoard(BoardVO board,HttpSession session) throws Exception {
		UserVO user=(UserVO) session.getAttribute("USER");
		if(user==null) {
			return;
		}
		
		boardDAO.updateBoard(board);
		updateBoardAttFile(board);
	}
	
	private void insertBoardAttFile(BoardVO boardVO) throws Exception {
		if(!boardVO.isExistAttFile()) {
			return;
		}
		BoardAttFileVO attFileVO=new BoardAttFileVO(boardVO);
		try {
			uploadBoardAttFileVO(attFileVO);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
		boardDAO.insertBoardAttFile(attFileVO);
	}
	
	private void uploadBoardAttFileVO(BoardAttFileVO attFileVO) throws Exception{
		//1.filePath
		String fileStorePath=propertyService.getString("fileSorePath");
		String dailyPath=LocalDate.now().toString();
		String filePath=fileStorePath+dailyPath;
		
		File directory=new File(filePath);
		if(!directory.exists()) {
			directory.mkdir();
		}
		attFileVO.setFilePath(filePath);
		
		//2. oldFilename
		MultipartFile multipartFile=attFileVO.getAttFile();
		String originalFilename=multipartFile.getOriginalFilename();
		attFileVO.setOldFilename(originalFilename);
		
		//3.newFilename and fileSize
		int pos=originalFilename.lastIndexOf(".");
		String ext=originalFilename.substring(pos);
		String newFilenameBody=Generators.timeBasedGenerator().generate().toString();
		String newFilename=newFilenameBody+ext;
		attFileVO.setNewFilename(newFilename);
		attFileVO.setFileSize(multipartFile.getSize());
		
		
		//4.real file copy
		File newFile=new File(filePath+File.separator+newFilename);
		multipartFile.transferTo(newFile);
		
	}

	@Override
	public BoardAttFileVO findBoardAttFile(BoardAttFileVO criteria) {
		return boardDAO.selectBoardAttFile(criteria);
	}

	@Override
	public void deleteBoardAttFile(BoardAttFileVO criteria) throws Exception {
		BoardAttFileVO attFileVO=boardDAO.selectBoardAttFile(criteria);
		String fullFilePath=attFileVO.getFullAttFilePath();
		
		File file=new File(fullFilePath);
		if(file.exists() && !file.isDirectory()) {
			file.delete();
		}
		
		boardDAO.deleteBoardAttFile(criteria);
	}
	private void updateBoardAttFile(BoardVO boardVO) throws Exception{
		String handleType=boardVO.getHandleType();
		BoardAttFileVO criteria=boardVO.getCriteria();
		boolean hasAttFile=boardVO.hasAttFile();
		
		if("fix".equals(handleType)) {
			return;
		}
		if(hasAttFile) {
			deleteBoardAttFile(criteria);
		}
		if("del".equals(handleType)) {
			return;
		}else if("chg".equals(handleType)) {
			insertBoardAttFile(boardVO);
		}
	}
}
