package com.salon.frame;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class ImgUtil {
	

	public static String saveFile(MultipartFile mf, String admindir) throws Exception{
		byte [] data;
		
		UUID uuid = UUID.randomUUID();
		
		String imgname = mf.getOriginalFilename();
		//LocalDateTime now = LocalDateTime.now();
		
		//String newFileName = imgname + "_" + now.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		String newImgName = imgname+"_"+uuid;

		try {
			data = mf.getBytes();
		
			FileOutputStream fo = 
					new FileOutputStream(admindir+newImgName);
			fo.write(data);
			fo.close();
		}catch(Exception e) {
			throw e;
		}
		
		return newImgName;
	}
	
	
	public static void deleteFile(String admindir, String filename) throws Exception{
		

		File f = new File(admindir+filename);
		
		f.delete();
		
	}
	
}