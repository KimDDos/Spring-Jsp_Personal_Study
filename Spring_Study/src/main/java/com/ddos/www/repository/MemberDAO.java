package com.ddos.www.repository;

import com.ddos.www.domain.MemberVO;

public interface MemberDAO {

	int register(MemberVO mvo);

	MemberVO getUser(String id);

}
