package du.board.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import du.board.dao.BoardDAO;
import du.board.domain.BoardAttFileVO;
import du.board.domain.BoardVO;
import du.common.Pagination;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository
public class BoardDAOImpl extends EgovAbstractMapper implements BoardDAO{

	

	@Override
	public int selectBoardListCnt(String title) {
		return selectOne("Board.selectBoardListCnt",title);
	}

	@Override
	public List<BoardVO> selectBoardList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return selectList("Board.selectBoardList",map);
	}
	@Override
	public BoardVO selectBoard(long idx) {

		return selectOne("Board.selectBoard",idx);
	}

	@Override
	public void insertBoard(BoardVO board) {
		
		 insert("Board.insertBoard",board);
	}

	@Override
	public void deleteBoard(long idx) {
		delete("Board.deleteBoard",idx);
		
	}

	@Override
	public void updateBoard(BoardVO board) {
		update("Board.updateBoard",board);
	}

	@Override
	public void insertBoardAttFile(BoardAttFileVO attFileVO) {
		insert("Board.insertBoardAttFile",attFileVO);
	}

	@Override
	public BoardAttFileVO selectBoardAttFile(BoardAttFileVO criteria) {
		return selectOne("Board.selectBoardAttFile",criteria);
		
		
		
		
	}

	@Override
	public void deleteBoardAttFile(BoardAttFileVO criteria) {
		delete("Board.deleteBoardAttFile",criteria);
	}
	

}
