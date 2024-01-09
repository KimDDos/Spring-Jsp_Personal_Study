package com.ddos.www.service;

import java.util.List;

import com.ddos.www.domain.CommentVO;

public interface CommentService {

	int post(CommentVO cvo);

	List<CommentVO> getList(int bno);

	int delete(int cno);

	int modify(CommentVO cvo);

}
