package com.ddos.www.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ddos.www.domain.BoardVO;
import com.ddos.www.repository.BoardDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardTest {
	// DB 정보를 몇백개 정도를 쌓아서 확인 해보려고 할때
	// file 연결은 root-context를 연결해줘야함
	// RunWith는 테스트할 때 반드시 필요한 어노테이션임
	
	@Inject
	private BoardDAO bdao;
	
	@Test
	public void insertBoard() {
		log.info(">>>>> TEST insert in <<<<<");
		
		for(int i=0; i<300; i++) {
			BoardVO bvo = new BoardVO();
			bvo.setTitle("Test Title " + i);
			bvo.setWriter("tester");
			bvo.setContent("Test Content " + i);
			
			bdao.insert(bvo);
		}
	}
}
