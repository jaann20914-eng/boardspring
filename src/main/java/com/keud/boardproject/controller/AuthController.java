package com.keud.boardproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping
	public ResponseEntity<List<MemberDTO>> getAll() {
		System.out.println("전송");
		List<MemberDTO> list = memberService.seletAll();
		return ResponseEntity.ok(list);
	}

	// 인서트 , 로그인
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> insert(@RequestBody MemberDTO dto, HttpSession session) {
		System.out.println(dto.getId() + ":" + dto.getPw());
		int result = memberService.loginCheck(dto);

		if (result > 0) {
			session.setAttribute("loginId", dto.getId());

			Map<String, Object> loginID = new HashMap<>();
			loginID.put("loginId", dto.getId());
			return ResponseEntity.ok(loginID);
		}
		return ResponseEntity.ok().build();
	}

	@GetMapping("/test")
	public ResponseEntity<Void> test(HttpSession session) {
		String result = (String) session.getAttribute("loginId");
		System.out.println(result);

		return ResponseEntity.ok().build();
	}

	// 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteId(@PathVariable String id){
		System.out.println(id); //오는지 확인
		memberService.deleteId(id);
		return ResponseEntity.ok().build();
	}
	
	// 로그아웃
	@PostMapping("/logout")
	public ResponseEntity<Void> logout(HttpSession session){
		session.invalidate();
		return ResponseEntity.ok().build();
	}
	
}
