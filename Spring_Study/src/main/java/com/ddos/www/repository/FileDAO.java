package com.ddos.www.repository;

import java.util.List;

import com.ddos.www.domain.FileVO;

public interface FileDAO {

	int insertFile(FileVO fvo);

	List<FileVO> getFileList(int bno);

}