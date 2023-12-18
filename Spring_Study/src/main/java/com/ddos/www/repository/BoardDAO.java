package com.ddos.www.repository;

import java.util.List;

import com.ddos.www.domain.BoardVO;

public interface BoardDAO {

	int insert(BoardVO bvo);

	List<BoardVO> selectList();

	BoardVO getDetail(int bno);

	void modify(BoardVO bvo);

	int remove(int bno);

}
