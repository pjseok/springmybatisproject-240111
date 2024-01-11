package com.pjseok.mybatis.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pjseok.mybatis.dao.MemberDao;
import com.pjseok.mybatis.dao.MybatisDao;
import com.pjseok.mybatis.dto.MemberDto;

@Controller
public class MemberController {
	
	@Autowired //의존 자동 주입
	private SqlSession sqlSession;
	
	@RequestMapping(value ="/join")
	public String join() {
		return "join";
		
	}
	
	@RequestMapping(value = "/joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		dao.joinDao(request.getParameter("mid"), request.getParameter("mpw"), request.getParameter("mname"), request.getParameter("memail"));
		model.addAttribute("memberName",request.getParameter("mname"));
		
		return "joinOk";
	}
	@RequestMapping(value="/checkId")
	public String checkId(HttpServletRequest request, Model model) {
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		
		MemberDto mDto = dao.CheckIdDao(request.getParameter("checkId"));
		
		if(mDto == null) { // 가입가능한 아이디(기존 가입된 아이디와 중복 없음)
			model.addAttribute("idFlag", "1");
			
		}else { // 이미 가입된 아이디가 있음
			model.addAttribute("idFlag", "0");
		}
		
		return "checkId";
		
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		
		return "login";
	}
	@RequestMapping(value = "/loginOk")
	public String loginOk(HttpServletRequest request, Model model, HttpSession session) {
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		int loginFlag = dao.checkIdPwDao(request.getParameter("mid"), request.getParameter("mpw"));
		// loginFlag 값이 1이면 로그인 성공, 0이면 로그인 실패
		
		if(loginFlag == 1) {
			session.setAttribute("sessionId", request.getParameter("mid"));
			
		}
		
		return "loginOk";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		
		session.invalidate(); // 모든 세션 삭제-> 로그아웃
		
		return "login";
	}
	
}
