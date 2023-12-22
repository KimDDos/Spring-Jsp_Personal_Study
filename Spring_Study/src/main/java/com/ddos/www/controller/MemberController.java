package com.ddos.www.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ddos.www.domain.MemberVO;
import com.ddos.www.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/member/*")
@Controller
public class MemberController {
	
	@Inject
	private MemberService msv;
	
	@GetMapping("/register")
	public void register() {}
	
	@PostMapping("/register")
	public String register(MemberVO mvo) {
		int isOk = msv.register(mvo);
		log.info("register result >>> {}", isOk > 0 ? "Ok":"Fail");
		return "index";
	}
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public String login(MemberVO mvo,Model m ,HttpServletRequest request) {
		log.info(">>> login mvo >>> {}",mvo);
		
		MemberVO loginMvo = msv.isUser(mvo);
		
		if(loginMvo != null) {
			HttpSession ses = request.getSession();
			ses.setAttribute("ses", loginMvo);
			ses.setMaxInactiveInterval(60*10);
		} else {
			m.addAttribute("msg_login", "1");
		}
		
		return "index";
	}
	
	@GetMapping()
	public String logout(HttpServletRequest request, Model m) {
		// 세션 객체 삭제 => 세션 끊기
		MemberVO mvo = (MemberVO)request.getSession().getAttribute("ses"); 
		msv.lastLogin(mvo.getId());
		request.getSession().removeAttribute("ses");
		request.getSession().invalidate();
		m.addAttribute("msg_logout","1");
		return "index";
	}
	
	@GetMapping("/modify")
	public void modify() {}
	
	@PostMapping("/modify")
	public String modify(MemberVO mvo, Model m, HttpServletRequest request) {
		log.info("Member modify mvo >>>>> {}",mvo);
		int isOk = msv.modify(mvo);
		
		if(isOk > 0) {
			m.addAttribute("msg_modify", "1");
			request.getSession().removeAttribute("ses");
			request.getSession().invalidate();
		} else {
			m.addAttribute("msg_modify", "2");
		}
		
		return "index";
	}
}
