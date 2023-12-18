package com.ddos.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ddos.www.domain.BoardVO;
import com.ddos.www.repository.BoardDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO bdao;

	@Override
	public int register(BoardVO bvo) {
		log.info("register check 1");
		return bdao.insert(bvo);
	}

	@Override
	public List<BoardVO> getList() {
		log.info("getlist check 1");
		return bdao.selectList();
	}

	@Override
	public BoardVO getDetail(int bno) {
		log.info("getdetail check 1");
		return bdao.getDetail(bno);
	}

	@Override
	public void modify(BoardVO bvo) {
		log.info("modify check 1");
		bdao.modify(bvo);
		
	}

	@Override
	public int remove(int bno) {
		return bdao.remove(bno);
	}
	
}
