package com.keud.boardproject.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keud.boardproject.dto.MemberDTO;
import com.keud.boardproject.services.MemberService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping
	public ResponseEntity<List<MemberDTO>> getAll(){
		System.out.println("전송");
		List<MemberDTO> list = memberService.seletAll();
		return ResponseEntity.ok(list);
	}
	
	//인서트 , 로그인
	@PostMapping("/login")
	public ResponseEntity<Integer> insert(@RequestBody MemberDTO dto){
		System.out.println(dto.getId() + ":" + dto.getPw());
		
		int result = memberService.loginCheck(dto);
		return ResponseEntity.ok(result);
	}
	

	

	
}
