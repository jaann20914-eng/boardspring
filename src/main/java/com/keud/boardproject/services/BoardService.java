package com.keud.boardproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keud.boardproject.dao.BoardDAO;
import com.keud.boardproject.dto.BoardDTO;

@Service
public class BoardService {
	
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

}
