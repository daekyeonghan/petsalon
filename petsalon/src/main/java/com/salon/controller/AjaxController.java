package com.salon.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.salon.dto.Schedule;
import com.salon.frame.CryptoUtil;
import com.salon.service.ScheduleService;
import com.salon.service.Shop_NoticeService;
import com.salon.service.UserService;

@RestController
public class AjaxController {
	@Autowired
	UserService uservice;
	@Autowired
	ScheduleService scservice;
	@Autowired
	Shop_NoticeService snservice;
	
	/*
	 * @RequestMapping("/checkUser") public Object checkUser(String useremail,
	 * String userpwd) throws NoSuchAlgorithmException,
	 * UnsupportedEncodingException, InvalidKeyException, NoSuchPaddingException,
	 * InvalidAlgorithmParameterException, IllegalBlockSizeException,
	 * BadPaddingException{ User user = null;
	 * 
	 * String enc_plainText = CryptoUtil.sha512(userpwd);
	 * System.out.println(enc_plainText);
	 * 
	 * int result = 0; try { user = uservice.get(useremail); if(user==null) { result
	 * = 1; }else { if(user.getUserpwd().equals(enc_plainText)) { //????????? ?????? ????????????
	 * enc_plainText ??? pwd??? ?????? result = 0; }else { result = 1; } }
	 * System.out.println(result); } catch (Exception e) { e.printStackTrace(); }
	 * return result; }
	 */
	
	@RequestMapping("/checkUserpwd")
	public String checkUserpwd(String userpwd) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException,
	NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
		String enc_plainText = CryptoUtil.sha512(userpwd);

		return enc_plainText;
	}
	
	@RequestMapping("/findemail")
	public Object findemail(String username, String tel) {
		String useremail = null;
		try {
			useremail = uservice.findemail(username, tel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return useremail;
	}
	@RequestMapping("/findpwd")
	public Object findpwd(String useremail) {
		String pwd = null;
		try {
			pwd = uservice.findpwd(useremail);
			System.out.println(pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pwd;
	}
	
	@RequestMapping(value = "/findpwdcorrect", method = {RequestMethod.GET})
	public @ResponseBody int findpwdcorrect(String username, String tel, String useremail) {
		if(username == null || username == "" || tel == null || tel == "" || useremail == null || useremail == "") {
			return -1;
		}else {
			return uservice.findpwdcorrect(username, tel, useremail);
			
		}
		
	}

	@RequestMapping("/weekSchedule")
	public Object weekSchedule() {
		List<Schedule> resvlist = null;
		JSONArray scharr = new JSONArray();
		SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd");
			
		try {
			resvlist = scservice.get();
			for(Schedule resv : resvlist) {
				JSONObject obj = new JSONObject();
				obj.put("title", "?????? ??????");
				obj.put("start", newDtFormat.format(resv.getSc_date()));
				scharr.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail to load schedule");
		}
		return scharr;
	}
	@RequestMapping("/scheduleCheck")
	public Object scheduleCheck(String info) {
		List<Schedule> list = null;
		SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, +2);
        String compare = newDtFormat.format(cal.getTime());
        
        int result = 0;
        
        int operation = compare.compareTo(info);
        if(operation>0) {
        	return 0;
        }
		
		try {
			list = scservice.get();
			for(int i=0;i<list.size();i++) {
				if(newDtFormat.format(list.get(i).getSc_date()).equals(info)) {
					result = 0;
					break;
				}else {
					result = 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/noticeTotalPage")
    public Object noticeTotalPage() {
        int recordsPerPage = 7;
        int totalPages = 0;

    	try {
			int totalRecords = snservice.get().size();
	        totalPages = (int) Math.ceil(totalRecords * 1.0 / recordsPerPage);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("failed to get total pages");
		}
    	
    //	System.out.println(totalPages);

        return totalPages;
    }
	
	@GetMapping("/mailCheck")
	@ResponseBody
	public String mailCheck(String email) {
		int authNumber;

		Random r = new Random();
		int checkNum = r.nextInt(888888) + 111111;
		authNumber = checkNum;
		
		String recipient = email;
 
        // 1. ???????????? ?????? ????????? ???????????? ??????
        final String user = "hdk1008@gmail.com";
        final String password = "izlhdyazgaysvtoi";
 
        // 2. Property??? SMTP ?????? ?????? ??????
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", 465);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
 
        // 3. SMTP ??????????????? ????????? ????????? ???????????? Session ???????????? ???????????? ??????
        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
 
        // 4. Message ???????????? ????????? ???????????? ???????????? ??????, ????????? ???????????? ????????????.
        // 5. Transport ???????????? ???????????? ????????? ???????????? ????????????.
 
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(user));
 
            // ????????? ?????? ??????
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
 
            // Subject
            message.setSubject("??????????????? ???????????? ??????????????????:)");
 
            // Text
            message.setText("?????????????????? ???????????????. ??????????????? ["+checkNum+"] ?????????. ???????????????.");
 
            Transport.send(message);    // send message
 
 
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        
        return Integer.toString(authNumber);
	}
		
}
