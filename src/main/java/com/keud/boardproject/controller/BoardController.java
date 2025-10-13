package com.keud.boardproject.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.keud.boardproject.dto.BoardDTO;
import com.keud.boardproject.services.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {


	@Autowired
	private BoardService boardService;

	// 게시판 페이지 리스트 조회 & 검색 기능
	@GetMapping
	public ResponseEntity<List<BoardDTO>> getBoard(@RequestParam String title) {
		System.out.println("전달 된 값"  + title);
		
		if (title != null) {
			List<BoardDTO> list = boardService.searchBuTitle(title);
			System.out.println("검색 확인 : " + title);
			return ResponseEntity.ok(list);
			
		}else {
			List<BoardDTO> list = boardService.selectAll();
			System.out.println("요청 확인용");
			return ResponseEntity.ok(list);
		}
	}
	
	// 등록
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody BoardDTO dto){
		boardService.Boardinsert(dto);
		System.out.println(dto.getWriter() + " : " + dto.getTitle()); // 확인용
		return ResponseEntity.ok().build();
	}

}
