package com.ddos.www.repository;

import java.util.List;

import com.ddos.www.domain.CommentVO;

public interface CommentDAO {

	int insert(CommentVO cvo);

	List<CommentVO> getList(int bno);

	int deleteComment(int cno);

	int modify(CommentVO cvo);

}
