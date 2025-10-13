package com.keud.boardproject.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.keud.boardproject.dto.BoardDTO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSession mybatis;
	
	// 게시물 리스트 
	public List<BoardDTO> selectAll(){
		return mybatis.selectList("Board.selectAll");
	}
	
	// 제목 검색
	public List<BoardDTO> searchBuTitle(String title){
		return mybatis.selectList("Board.searchBuTitle", title);
	}
	
	// 등록
	public int Boardinsert(BoardDTO dto) {
		return mybatis.insert("Board.Boardinsert", dto);
	}
}
