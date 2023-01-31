package com.salon.frame;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class Util {
	public static String saveFile(MultipartFile mf, String userdir) throws Exception{
		byte [] data;
		
		UUID uuid = UUID.randomUUID();
		
		String imgname = mf.getOriginalFilename();
		
		String newImgName = imgname+"_"+uuid;
		
		try {
			data = mf.getBytes();
			FileOutputStream fo = 
					new FileOutputStream(userdir+newImgName);
			fo.write(data);
			fo.close();
		}catch(Exception e) {
			throw e;
		}
		
		return newImgName;
	}
	
	public static void deleteFile(String userdir, String filename) throws Exception{
		File f = new File(userdir+filename);
		
		f.delete();
	}
	
}




