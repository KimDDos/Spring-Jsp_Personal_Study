package com.ddos.www.service;

import java.util.List;

import com.ddos.www.domain.BoardDTO;
import com.ddos.www.domain.BoardVO;
import com.ddos.www.domain.PagingVO;

public interface BoardService {

	int register(BoardDTO bdto);

	List<BoardVO> getList(PagingVO pgvo);

	BoardDTO getDetail(int bno);

	void modify(BoardVO bvo);

	int remove(int bno);

	int getTotalCount(PagingVO pgvo);
	
}
