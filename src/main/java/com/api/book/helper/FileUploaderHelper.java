package com.api.book.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploaderHelper {
//public final String upload_dir="D:\\springBoot\\bootRestApiBook\\src\\main\\resources\\static\\image";
	public final String upload_dir=new ClassPathResource("static/image/").getFile().getAbsolutePath();
	public FileUploaderHelper() throws IOException
	{
		
	}
	public boolean uploadFile(MultipartFile file)
{
	boolean f=false;
	try {
//		InputStream is=file.getInputStream();
//		byte[] data=new byte[is.available()];
//		is.read(data);
//		//write
//		FileOutputStream fos=new FileOutputStream(upload_dir+"\\"+file.getOriginalFilename());
//		System.out.println(fos);
//		fos.write(data);
//		fos.close();
		
		Files.copy(file.getInputStream(),Paths.get(upload_dir+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
		f=true;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	return f;
}
}
