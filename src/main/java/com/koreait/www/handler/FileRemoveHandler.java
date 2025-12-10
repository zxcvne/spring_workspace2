package com.koreait.www.handler;

import java.io.File;

import com.koreait.www.domain.FileVO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class FileRemoveHandler {
	// 저장경로 
	 private final String DIR = "D:\\web_0826_nhs\\_myProject\\_java\\_fileUpload\\";
	 
	 public boolean removeFile(FileVO fvo) {
		 // file.delete() // 파일 삭제		
		 // image file 썸네일도 같이 삭제
		 boolean isDel = false;
		 
		 File fileDir = new File(DIR, fvo.getSaveDir());
		 String removeFile = fvo.getUuid() + "_" + fvo.getFileName();
		 File deleteFile = new File(fileDir, removeFile);
		 
		 String removeThFile = fvo.getUuid() + "_th_" + fvo.getFileName();
		 File deleteThFile = new File(fileDir, removeThFile);
		 
		 try {
			// 파일이 존재하는지 확인
			 if(deleteFile.exists()) {
				 isDel = deleteFile.delete();
				 log.info(" >>> deleteFile success >> {}", deleteFile.toString());
				 if(fvo.getFileType() == 1 && deleteThFile.exists()) {
					 isDel = deleteThFile.delete();
					 log.info(" >>> deleteThFile success >> {}", deleteThFile.toString());
				 }
			 }
		} catch (Exception e) {
			log.info(" >>> delete file error ");
			e.printStackTrace();
		}
		 
		 return isDel;
	   }
	}
