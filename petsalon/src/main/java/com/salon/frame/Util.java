package com.salon.frame;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class Util {
	public static String saveFile(MultipartFile mf, String userdir, String admindir) throws Exception{
		byte [] data;
		
		UUID uuid = UUID.randomUUID();
		
		String imgname = mf.getOriginalFilename();
		
		String newImgName = imgname+"_"+uuid;
		
		try {
			data = mf.getBytes();
			FileOutputStream fo1 = new FileOutputStream(admindir + newImgName);
			FileOutputStream fo2 = new FileOutputStream(userdir + newImgName);
			fo1.write(data);
			fo2.write(data);
			fo1.close();
			fo2.close();
		}catch(Exception e) {
			throw e;
		}
		
		return newImgName;
	}
	
	public static void deleteFile(String admindir, String userdir, String filename) throws Exception{
		File f1 = new File(admindir+filename);
		File f2 = new File(userdir+filename);
		
		f1.delete();
		f2.delete();
	}
	
}




