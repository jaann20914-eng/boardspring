package com.keud.boardproject.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keud.boardproject.dto.MemberDTO;
import com.keud.boardproject.services.MemberService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private MemberService memberService;
	
//	@GetMapping
//	public ResponseEntity<List<MemberDTO>> getAll(){
//		System.out.println("전송");
//		List<MemberDTO> list = memberService.seletAll();
//		return ResponseEntity.ok(list);
//	}
	
	
//1. axios가 request에 세션이크를 담아서 보내주지 않음
//2. 서버에서 크로스 오리진 상태에서는 세션키를 인정하지 않음
	@GetMapping("/test")
	public void test(HttpSession session){
		String loginId = (String)session.getAttribute("loginId");
		System.out.println(loginId);
	}
	
	
	
	//인서트 , 로그인
	@PostMapping("/login")
	public ResponseEntity<Map<String,String>> insert(@RequestBody MemberDTO dto, HttpSession session){
		System.out.println(dto.getId() + ":" + dto.getPw());
		
		int isExist = memberService.loginCheck(dto);// 0이면 로그인 불가
		
		if(isExist>0) {
			session.setAttribute("loginId", dto.getId());
			Map<String,String> result = new HashMap<>();
			result.put("loginId", (String)session.getAttribute("loginId"));
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.ok().build();
	}
	
	//회원가입 : 인서트
	@PostMapping
	public ResponseEntity<Void> insertMember(@RequestBody MemberDTO dto){
		System.out.println(dto.getId() + ":" + dto.getPw() + ":" +dto.getName() + ":" +dto.getEmail());
		
		memberService.insertMember(dto);
		return ResponseEntity.ok().build();
	}

	

	
}
