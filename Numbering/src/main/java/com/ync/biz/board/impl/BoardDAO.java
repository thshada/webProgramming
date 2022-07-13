package com.ync.biz.board.impl;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.ync.biz.board.BoardService;
import com.ync.biz.board.BoardVO;
import com.ync.biz.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO {
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private final String BOARD_INSERT ="insert into board(title,writer,content,upload) values(?,?,?,?)";
	private final String BOARD_UPDATE ="update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE ="delete from board where seq=?";
	private final String BOARD_GET ="select * from board where seq=?";
	private final String BOARD_CNT_UPDATE ="update board set cnt=cnt+1 where seq=?";
	private final String BOARD_LIST ="select * from board order by seq";
	private final String BOARD_SEARCH_LIST = "select * from board where title like ? or content like ? order by seq";
	
	
	
	public void insertBoard(BoardVO vo) {
		
		System.out.println("===> JDBC insertBoard() 占쏙옙占� 처占쏙옙");
		try {
			MultipartFile uploadFile = vo.getUploadFile();
			String fileName;
			if(!uploadFile.isEmpty()) {
				fileName = uploadFile.getOriginalFilename();
			}else fileName="";			
			
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.setString(4, fileName);
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		
	}

	
	public void updateBoard(BoardVO vo) {
		
		System.out.println("===> JDBC updateBoard() 占쏙옙占� 처占쏙옙");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		
	}	
	
	
	public void deleteBoard(BoardVO vo) {
		
		System.out.println("===> JDBC deleteBoard() 占쏙옙占� 처占쏙옙");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		
	}		
	
	
	
	public BoardVO getBoard(BoardVO vo) {
		
		System.out.println("===> JDBC占쏙옙 getBoard() 占쏙옙占� 처占쏙옙");
		BoardVO board = null;
		
		try {
			
			//占쏙옙회占쏙옙 카占쏙옙트 +1 占싹는곤옙
			//private final String BOARD_CNT_UPDATE ="update board set cnt=cnt+1 where seq=?";
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_CNT_UPDATE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
			// 占싯삼옙 占쏙옙占쏙옙占� 占쏙옙占쏙옙占쏙옙占쏙옙
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			if(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setFilename(rs.getString("UPLOAD"));
				board.setCnt(rs.getInt("CNT"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		
		return board;
		
	}
	
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		
		System.out.println("===> JDBC占쏙옙 getBoardList() 占쏙옙占� 처占쏙옙");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		//BOARD_SEARCH_LIST = "select * from board where title like ? or content like ? order by seq";
		try {
			conn = JDBCUtil.getConnection();
			
			if(vo.getSearchKeyword() != null) {
				stmt = conn.prepareStatement(BOARD_SEARCH_LIST);
				stmt.setString(1, "%"+vo.getSearchKeyword()+"%");
				stmt.setString(2, "%"+vo.getSearchKeyword()+"%");
				rs = stmt.executeQuery();				
			}else {
				stmt = conn.prepareStatement(BOARD_LIST);
				rs = stmt.executeQuery();
			}

			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				boardList.add(board);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		
		return boardList;
		
	}	
	
	
	
	

}
