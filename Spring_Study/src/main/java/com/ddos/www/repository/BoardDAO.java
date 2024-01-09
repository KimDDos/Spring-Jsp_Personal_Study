package com.ddos.www.repository;

import java.util.List;

import com.ddos.www.domain.BoardVO;
import com.ddos.www.domain.PagingVO;

public interface BoardDAO {

	int insert(BoardVO bvo);

	List<BoardVO> selectList(PagingVO pgvo);

	BoardVO getDetail(int bno);

	void modify(BoardVO bvo);

	int remove(int bno);

	int total(PagingVO pgvo);

	int selectBno();

	BoardVO getBvo(int bno);

}
