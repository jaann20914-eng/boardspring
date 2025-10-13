package com.keud.boardproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keud.boardproject.dao.BoardDAO;
import com.keud.boardproject.dto.BoardDTO;

@Service
public class BoardService {
<<<<<<< HEAD
	
	@Autowired
	private BoardDAO boardDao;
	
	// 전체 리스트 
	public List<BoardDTO> selectAll(){
		return boardDao.selectAll();
	}
	
	
	//검색용
	public List<BoardDTO> searchBuTitle(String title){
		return boardDao.searchBuTitle(title);
	}
	
	// 등록
	public int Boardinsert(BoardDTO dto) {
		return boardDao.Boardinsert(dto);
	}

=======

	@Autowired
    private BoardDAO boardDao;
	
	//보드리스트 뽑아오기
	public List<BoardDTO> getAllBoardList(){
		return boardDao.getAllBoardList();
	}
	
	//타겟 보드 뽑아오기 : 1개
	public BoardDTO getTargetBoard(int seq) {
		return boardDao.getTargetBoard(seq);
	}
	
	//인서트
	public int insert(BoardDTO dto) {
		return boardDao.insert(dto);
	}
	
	//삭제
	public int delete(int seq) {
		return  boardDao.delete(seq);
	}
	
>>>>>>> 56883e14a5733fdb353b11adcd1c39ec11dadf84
}
