package com.ync.biz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.ync.biz.board.BoardVO;

@Repository
public class BoardDAOSpring {
	
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
	private final String BOARD_INSERT ="insert into numbering(reception,reference,subject,money,manager,date) values(?,?,?,?,?,?)";
	private final String BOARD_UPDATE ="update numbering set reception=?, reference=? where seq=?";
	private final String BOARD_DELETE ="delete from numbering where seq=?";
	private final String BOARD_GET ="select * from numbering where seq=?";
	private final String BOARD_LIST ="select * from numbering order by seq";
	
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC insertBoard() ���ó�� ");
		jdbcTemplate.update(BOARD_INSERT,vo.getReception(),vo.getReference(),vo.getSubject(),vo.getMoney(),vo.getManager(),vo.getDate());
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC updateBoard() ���ó�� ");
		jdbcTemplate.update(BOARD_UPDATE,vo.getReception(),vo.getReference(),vo.getSeq());
	}	
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC deleteBoard() ���ó�� ");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC getBoard() ���ó�� ");
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("===> Spring JDBC getBoardList() ���ó�� ");
		return jdbcTemplate.query(BOARD_LIST,new BoardRowMapper());
	}
		
}

class BoardRowMapper implements RowMapper<BoardVO>{
	public BoardVO mapRow(ResultSet rs , int rowNum) throws SQLException{
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("SEQ"));
		board.setReception(rs.getString("RECEPTION"));
		board.setReference(rs.getString("REFERENCE"));
		board.setSubject(rs.getString("SUBJECT"));
		board.setMoney(rs.getString("MONEY"));
		board.setManager(rs.getString("MANAGER"));
		board.setDate(rs.getDate("DATE"));
		board.setFilename(rs.getString("UPLOAD"));
		board.setCnt(rs.getInt("CNT"));
		return board;
	}
}
