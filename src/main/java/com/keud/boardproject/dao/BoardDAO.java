package com.keud.boardproject.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.keud.boardproject.dto.BoardDTO;

@Repository
public class BoardDAO {
<<<<<<< HEAD

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
=======
	@Autowired
	public SqlSession mybatis;
	
	//보드 전체 리스트 뽑아오기
	public List<BoardDTO> getAllBoardList(){
		return mybatis.selectList("Board.getAll");
	}
	
	//타겟 보드 뽑아오기 : 1개
	public BoardDTO getTargetBoard(int seq) {
		return mybatis.selectOne("Board.getOne", seq);
	}
	
	//인서트
	public int insert (BoardDTO dto) {
		return mybatis.insert("Board.insert", dto);
	}
	
	//삭제
	public int delete (int seq) {
		return mybatis.delete("Board.delete", seq);
>>>>>>> 56883e14a5733fdb353b11adcd1c39ec11dadf84
	}
}
