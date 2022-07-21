package du.board.service;

import java.util.List;

import du.board.domain.BoardVO;
import du.common.Pagination;

public interface BoardService {

	
	public List<BoardVO> selectBoardList(Pagination pagination);
	
	public int selectBoardListCnt();

	
}
