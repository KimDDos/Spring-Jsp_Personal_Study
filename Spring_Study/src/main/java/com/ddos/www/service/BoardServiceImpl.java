package com.ddos.www.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ddos.www.repository.BoardDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO bdao;
	
}