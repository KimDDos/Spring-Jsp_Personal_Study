package com.ddos.www.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ddos.www.domain.CommentVO;
import com.ddos.www.repository.CommentDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService{

	@Inject
	private CommentDAO cdao;

	@Override
	public int post(CommentVO cvo) {
		return cdao.insert(cvo);
	}
	
}
