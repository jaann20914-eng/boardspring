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
	
	public int insert(MemberDTO dto) {
		return mybatis.insert("Member.insert", dto);
	}
	
	public int deleteId(String id) {
		return mybatis.delete("Member.deleteId", id);
	}
	
	public int updateMember(MemberDTO dto) {
	    return mybatis.update("Member.updateMember", dto);
	}
	
	//loginCheck
	public int loginCheck (MemberDTO dto) {
		return mybatis.selectOne("Member.loginCheck", dto);
	}

}
