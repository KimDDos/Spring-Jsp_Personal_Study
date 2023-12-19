package com.ddos.www.service;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ddos.www.domain.MemberVO;
import com.ddos.www.repository.MemberDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService{

	@Inject
	private MemberDAO mdao;

	@Inject 
	BCryptPasswordEncoder passwordEncoder;
	// pw를 암호화하는 메서드

	@Override
	public int register(MemberVO mvo) {
		// 아이디 중복체크(원래는 다른 버튼으로 먼저 함)
		// 아이디만 주고 DB에서 일치하는 Mvo 객체를 리턴
		// 일치하는 유저가 있다면 가입 실패, 없다면 가입 가능하게
		MemberVO tempMvo = mdao.getUser(mvo.getId()); 
		
		if(tempMvo != null) {
			// 기존 아이디가 있는 경우
			return 5;
		}
		
		// id가 중복되지 않는다면 회원가입 진행
		// password가 null이거나 값이 없다면 가입 불가
		if(mvo.getId() == null || mvo.getId().length() == 0) {
			return 6;
		}
		if(mvo.getPw() == null || mvo.getPw().length() == 0) {
			return 7;
		}
		
		// 회원가입 진행
		// password는 암호화하여 가입
		/* String encodePw = passwordEncoder.encode(mvo.getPw()); */
		/* mvo.setPw(encodePw); */
		return mdao.register(mvo);
		// 1 : 회원가입 성공 / 5 : 일치하는 아이디 / 6 : Id가 null / 7 : Pw가 null
	}
	
}
