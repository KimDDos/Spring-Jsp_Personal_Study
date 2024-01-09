package com.ddos.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ddos.www.domain.BoardDTO;
import com.ddos.www.domain.BoardVO;
import com.ddos.www.domain.FileVO;
import com.ddos.www.domain.PagingVO;
import com.ddos.www.repository.BoardDAO;
import com.ddos.www.repository.FileDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO bdao;
	
	@Inject
	private FileDAO fdao;

	@Override
	public int register(BoardDTO bdto) {
		log.info("register check 1");
		
		// 기존 보드내용 보드에 저장
		int isOk = bdao.insert(bdto.getBvo());
		
		// flist를 db에 저장
		// flist가 controller에서 안에 내용을 체크하고 오기에 null임
		
		if(bdto.getFlist() == null) {
			// 파일의 값이 없다면 
			isOk *= 1;
		} else {
			// 파일저장
			if(isOk > 0 && bdto.getFlist().size() > 0) {
				// fvo가 bno가 설정되기 전
				// 현재 bdto 시점에서는 아직 bnp가 생성되지 않음
				// insert를 통해 자동생성 => DB에서 검색해서 가져오기
				int bno = bdao.selectBno();
				log.info("bno >>>>> {}", bno);
				for(FileVO fvo : bdto.getFlist()) {
					fvo.setBno(bno);
					log.info(">>> fvo >>> {}",fvo);
					isOk *= fdao.insertFile(fvo);
				}
			}
		}
		
		return isOk;
	}

	@Override
	public List<BoardVO> getList(PagingVO pgvo) {
		log.info("getlist check 1");
		return bdao.selectList(pgvo);
	}

	@Override
	public BoardDTO getDetail(int bno) {
		log.info("getdetail check 1");
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setBvo(bdao.getDetail(bno));
		boardDTO.setFlist(fdao.getFileList(bno));
		return boardDTO;
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

	@Override
	public int getTotalCount(PagingVO pgvo) {
		// TODO Auto-generated method stub
		return bdao.total(pgvo);
	}
	
}
