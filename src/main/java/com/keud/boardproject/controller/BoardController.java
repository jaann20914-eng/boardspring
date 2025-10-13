package com.keud.boardproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//보드리스트 전체 꺼내오기
    //마이페이지 불러오기 (디티오로)
    @GetMapping
    public ResponseEntity<List<BoardDTO>> getAllBoardList(){
    	List<BoardDTO> list = boardService.getAllBoardList();
    	return ResponseEntity.ok(list);
    }
	
    //디테일보드 이동
    @GetMapping("/{seq}")
    public ResponseEntity<BoardDTO> getTargetBoard(@PathVariable int seq){
    	BoardDTO dto= boardService.getTargetBoard(seq);
    	return ResponseEntity.ok(dto);
    }
    
    //인서트
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody BoardDTO dto){
    	boardService.insert(dto);
    	return ResponseEntity.ok().build();
    }
    
    //삭제
    @DeleteMapping("/{seq}")
    public ResponseEntity<Void> delete(@PathVariable int seq){
    	System.out.println(seq);
    	boardService.delete(seq);
    	return ResponseEntity.ok().build();
    }
	
    //업데이트
    @PutMapping("/board/{seq}")

    public ResponseEntity<Void> update(@RequestParam BoardDTO dto){
    	System.out.println(dto.getTitle());
    	System.out.println(dto.getContent());
    	return ResponseEntity.ok().build();
    }

}
