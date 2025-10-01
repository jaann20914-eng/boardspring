package com.keud.boardproject.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.keud.boardproject.dto.MemberDTO;

@Repository
public class MemberDAO {
	@Autowired
	public SqlSession mybatis;
	
	public List<MemberDTO> seletAll(){
		return mybatis.selectList("Member.seletAll");
		// bao.seletAll
	}
	
	//회원가입 : insert
	public int insertMember(MemberDTO dto) {
		return mybatis.insert("Member.insert", dto);
	}
	
	//회원탈퇴
	public int deleteId(String id) {
		return mybatis.delete("Member.deleteId", id);
	}
	
	//업데이트
	public int updateMember(MemberDTO dto) {
	    return mybatis.update("Member.updateMember", dto);
	}
	
	//loginCheck
	public int loginCheck (MemberDTO dto) {
		return mybatis.selectOne("Member.loginCheck", dto);
	}
	
	//아이디로 마이페이지 꺼내오기
	public MemberDTO getInforById(String id) {
		return mybatis.selectOne("Member.getInforById", id);
	}
	
	//아이디로 마이페이지 수정하기
	public int updateInforById(MemberDTO dto) {
		return mybatis.update("Member.updateInforById", dto);
	}
}
