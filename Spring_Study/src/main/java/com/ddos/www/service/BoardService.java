package com.ddos.www.service;

import java.util.List;

import com.ddos.www.domain.BoardVO;

public interface BoardService {

	int register(BoardVO bvo);

	List<BoardVO> getList();

	BoardVO getDetail(int bno);

	void modify(BoardVO bvo);

	int remove(int bno);
	
}
