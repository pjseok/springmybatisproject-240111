package com.pjseok.mybatis.dao;

import com.pjseok.mybatis.dto.MemberDto;

public interface MemberDao {
	
	public void joinDao(String mid, String mpw, String mname, String memail); //회원가입
	public MemberDto CheckIdDao (String checkId);
	public int checkIdPwDao(String mid, String mpw);
	//아이디와 비밀번호 존재 및 일치여부 확인 -> 아이디와 비밀번호 일치하면(로그인 성공) 1이 반환되고 아니면 0이 반환
}
