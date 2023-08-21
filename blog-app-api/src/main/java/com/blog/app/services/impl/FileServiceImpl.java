package com.blog.app.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.blog.app.services.FileService;
@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		//getting file name i-e: abc.png
		String name=file.getOriginalFilename();
		//generating randomId i-e: 3232423
		String randomId=UUID.randomUUID().toString();
		//fileName i-e: 3232423abc where 3232423 is randomId and abc is name before . 
		String fileName1 =randomId.concat(name.substring(name.lastIndexOf(".")));
		//file path = path/3232423abc
		String filePath=path+File.separator+fileName1;
		//crating folder if not created
		File f=new File(path);
		if(!f.exists()) {
			f.mkdir();
		}
		//file copy
		Files.copy(file.getInputStream(), Paths.get(filePath));
		
		return fileName1;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		String fullPath=path+File.separator+fileName;
		InputStream is=new FileInputStream(fullPath);
		return is;
	}

}
