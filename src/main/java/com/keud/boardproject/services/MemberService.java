package com.keud.boardproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keud.boardproject.dao.MemberDAO;
import com.keud.boardproject.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	public MemberDAO memberDao;
	
	
	//전체리스트
	public List<MemberDTO> seletAll(){
		return memberDao.seletAll();
	}
	//회원가입 : insert
	public int insertMember(MemberDTO dto) {
		return memberDao.insertMember(dto);
	}
	//삭제
	public int deleteId(String id) {
		return memberDao.deleteId(id);
	}
	//업데이트
	public int updateMember(MemberDTO dto) {
		return memberDao.updateMember(dto);
	}
	//loginCheck
	public int loginCheck (MemberDTO dto) {
		return memberDao.loginCheck(dto);
	}
	

}
