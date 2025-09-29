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

	public List<MemberDTO> seletAll(){
		return memberDao.seletAll();
	}
	
	public int insert(MemberDTO dto) {
		return memberDao.insert(dto);
	}
	
	public int deleteId(int id) {
		return memberDao.deleteId(id);
	}
	
	public int updateMember(MemberDTO dto) {
		return memberDao.updateMember(dto);
	}

}
