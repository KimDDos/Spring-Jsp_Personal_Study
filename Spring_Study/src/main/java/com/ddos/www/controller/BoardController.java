package com.ddos.www.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ddos.www.domain.BoardDTO;
import com.ddos.www.domain.BoardVO;
import com.ddos.www.domain.FileVO;
import com.ddos.www.domain.PagingVO;
import com.ddos.www.handler.FileHandler;
import com.ddos.www.handler.PagingHandler;
import com.ddos.www.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/board/*")
@Controller
public class BoardController {

	@Inject
	private BoardService bsv;
	
	@Inject
	private FileHandler fhd;
	
	@GetMapping("/register")
	public void register() {}
	
	@PostMapping("/register")
	public String register(BoardVO bvo, @RequestParam(name="files", required=false) MultipartFile[] files) {
		log.info("register bvo check >>>> {}", bvo);
		
		List<FileVO> flist = null;
		
		if(files[0].getSize() > 0) {
			flist = fhd.uploadFiles(files);
			log.info(">>> flist >>> {}", flist);
		} else {
			log.info("file null");
		}
		
		BoardDTO bdto = new BoardDTO(bvo, flist);
		
		int isOk = bsv.register(bdto);
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
		m.addAttribute("boardDTO", bsv.getDetail(bno));
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
		re.addFlashAttribute("msg_remove",isOk);
		return "redirect:/board/list";
	}
	
}
