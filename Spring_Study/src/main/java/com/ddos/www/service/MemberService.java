package com.ddos.www.service;

import com.ddos.www.domain.MemberVO;

public interface MemberService {

	int register(MemberVO mvo);

	MemberVO isUser(MemberVO mvo);

	void lastLogin(String id);

	int modify(MemberVO mvo);

}
