package com.ddos.www.handler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.tika.Tika;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ddos.www.domain.FileVO;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

@Slf4j
@AllArgsConstructor
@Component
public class FileHandler {
	// 파일 객체를 파라미터로 받아서 flist로 리턴
	// 파일을 저장 / fvo 생성
	
	// 실제 파일이 저장되는 경로
	private final String UP_DIR = "C:\\Users\\DoYeon Kim\\Desktop\\Gookbi\\_myProject\\_java\\_fileUpload";

	public List<FileVO> uploadFiles(MultipartFile[] files){
		
		List<FileVO> flist = new ArrayList<FileVO>();
		// multipartFile 받아서 fileVO 형태로 저장한 후 list를 리턴
		// 오늘 날짜로 경로(가변형태로 저장)
		LocalDate date = LocalDate.now();
		String today = date.toString();
		log.info(">> today >> {}",today);
		
		// 오늘 날짜(today)의 폴더 구성
		today = today.replace("-", File.separator);
		File folders = new File(UP_DIR, today);
		if(!folders.exists()) {
			folders.mkdirs();
			// 폴더생성 명령 mkdir(폴더 1개 생성)
			// 폴더생성 명령 mkdirs(폴더 여러개 생성)
		}
		
		for(MultipartFile file : files) {
			FileVO fvo = new FileVO();
			
			fvo.setSave_dir(today); // UP_DIR 제외 하위 오늘날짜 경로만 set
			fvo.setFile_size(file.getSize());
			
			log.info(">>> getName >> {}", file.getName());
			log.info(">>> getOriginalFilename >> {}", file.getOriginalFilename());
			
			// 파일 이름() : 파일 경로를 포함하고 있을 수도 있음
			String originFileName = file.getOriginalFilename();
			String onlyFileName = originFileName.substring(originFileName.lastIndexOf(File.separator)+1);
			fvo.setFile_name(onlyFileName);
			
			// uuid 생성
			UUID uuid = UUID.randomUUID();
			log.info(">> uuid >>{}", uuid);
			log.info(">> uuid.toString() >>{}", uuid.toString());
			String uuidStr = uuid.toString();
			fvo.setUuid(uuidStr);
			
			// 여기까지가 fvo setting 완료
			
			// 디스크에 저장할 파일 객체를 생성 - 저장
			// uuid_fileName / uuid_th_fileName
			String fullFileName = uuidStr + "_" + onlyFileName;
			File storeFile = new File(folders, fullFileName);
			
			// 저장 => 폴더가 없거나, 저장 파일이 없다면 IO Exception 발생
			try {
				file.transferTo(storeFile);
				// 파일 타입을 결정 => 저장 파일이 없다면 io exception 발생
				if(isImageFile(storeFile)) {
					fvo.setFile_type(1);
					File thumbNail = new File(folders, uuidStr + "_th_" + onlyFileName);
					Thumbnails.of(storeFile).size(75, 75).toFile(thumbNail);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				log.info(" >>> File 저장 에러 <<< ");
			}
			flist.add(fvo);
		}
		return flist;
	}
	
	public boolean isImageFile(File storeFile) throws IOException {
		String mimeType = new Tika().detect(storeFile);
		return (mimeType.startsWith("image") ? true : false);
	}
	
}
