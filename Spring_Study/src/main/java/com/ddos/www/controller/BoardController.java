package com.ddos.www.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ddos.www.domain.BoardVO;
import com.ddos.www.domain.PagingVO;
import com.ddos.www.handler.PagingHandler;
import com.ddos.www.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/board/*")
@Controller
public class BoardController {

	@Inject
	private BoardService bsv;
	
	@GetMapping("/register")
	public void register() {}
	
	@PostMapping("/register")
	public String register(BoardVO bvo) {
		log.info("register bvo check >>>> {}", bvo);
		
		int isOk = bsv.register(bvo);
		log.info("register result >>> {}", isOk > 0 ? "Ok":"Fail");
		
		return "index";
	}
	
	@GetMapping("/list")
	public String list(Model m, PagingVO pgvo) {
		log.info("list pgvo >>>> {}", pgvo);
		m.addAttribute("list", bsv.getList(pgvo));
		
		// ph 객체 생성
		int totalCount = bsv.getTotalCount(pgvo);
		log.info("totalCount >>>> {}", totalCount);
		m.addAttribute("ph", new PagingHandler(pgvo, totalCount));
		m.addAttribute("totalCount", totalCount);
		return "/board/list";
	}
	
	@GetMapping({"/detail", "/modify"})
	public void detail(Model m ,@RequestParam("bno") int bno) {
		log.info("detail >>>> {}", bno);
		m.addAttribute("bvo", bsv.getDetail(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO bvo, Model m) {
		log.info("modify bvo >>>> {}", bvo);
		bsv.modify(bvo);
		m.addAttribute("bno", bvo.getBno());
		return "redirect:/board/detail";
	}
	
	@GetMapping("/remove")
	public String remove(@RequestParam("bno") int bno, RedirectAttributes re) {
		log.info("remove bno >>>> {}", bno);
		int isOk = bsv.remove(bno);
		return "redirect:/board/list";
	}
	
}
