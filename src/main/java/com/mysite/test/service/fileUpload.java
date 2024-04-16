package com.mysite.test.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class fileUpload {
	private static final String UPLOAD_DIR = "src/main/resources/static/images";
	public static String upFile(MultipartFile file) throws IOException {
		
		//디렉토리 생성
		File uploadtDir = new File(UPLOAD_DIR);
		//없을경우 에만 생성
		if(!uploadtDir.exists()) {
			uploadtDir.mkdirs();
		}
		
		//리턴할 파일명 저장
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		//파일저장 경로 설정
		Path filePath = Paths.get(UPLOAD_DIR + File.separator + fileName);
		//파일을 지정한 경로에 저장
		Files.copy(file.getInputStream(), filePath);

		return fileName;
	}
}
