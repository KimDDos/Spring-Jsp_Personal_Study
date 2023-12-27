package com.ddos.www.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ddos.www.domain.CommentVO;
import com.ddos.www.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/comment/*")
public class CommentController {

	@Inject
	private CommentService csv;
	
	@PostMapping(value = "/post", consumes = "application/json", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> post(@RequestParam CommentVO cvo){
		log.info("cvo >>> {}", cvo);
		int isOk = csv.post(cvo);
		return isOk > 0 ? new ResponseEntity<String>("1",HttpStatus.OK) 
			: new ResponseEntity<String>("0",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
