package com.keud.boardproject.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.keud.boardproject.dto.MemberDTO;
import com.keud.boardproject.services.MemberService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private MemberService memberService;

	/*
	 * @GetMapping public ResponseEntity<List<MemberDTO>> getAll() {
	 * System.out.println("전송"); List<MemberDTO> list = memberService.seletAll();
	 * return ResponseEntity.ok(list); }
	 */
    
    
    //로그인
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> insert(@RequestBody MemberDTO dto, HttpSession session) {
        System.out.println(dto.getId() + ":" + dto.getPw());

        int result = memberService.loginCheck(dto);
        System.out.println("결과"+result);
        if (result > 0) {
            session.setAttribute("loginId", dto.getId());

            Map<String, Object> loginID = new HashMap<>();
            loginID.put("loginId", dto.getId());
            return ResponseEntity.ok(loginID);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
    
    
    
   //1. axios가 request에 세션을 담아서 보내주지 않음
   //2. 서버에서 크로스 오리진 상태에서는 세션키를 인정하지 않음
    @GetMapping("/test")
    public ResponseEntity<Void> test(HttpSession session) {
        String result = (String) session.getAttribute("loginId");
        System.out.println(result);
        return ResponseEntity.ok().build();
    }

    
    
    // 회원탈퇴
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteId(@PathVariable String id) {
        System.out.println(id); // 오는지 확인
        memberService.deleteId(id);
        return ResponseEntity.ok().build();
    }
    
    
    //로그아웃
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok().build();
    }
    
    
    //마이페이지 불러오기 (디티오로)
    @GetMapping
    public ResponseEntity<MemberDTO> getInforById(@RequestParam String id){
//    	String loginId =(String)session.getAttribute("loginId");
    	System.out.println("마이페이지에서 아이디 받는지 확인"+id);
    	MemberDTO target =memberService.getInforById(id);
    	return ResponseEntity.ok(target);
    }
    
    //마이페이지 업데이트용 가져오기 (디티오로)
    @PutMapping
    public ResponseEntity<Void> updateInforById (@RequestParam String id, @RequestBody MemberDTO dto){
    	System.out.println(dto.getId());
    	memberService.updateInforById(dto);
    	return ResponseEntity.ok().build();
    }
    
    
}