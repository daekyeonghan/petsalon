package com.salon.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

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
import com.salon.dto.User;
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
	
	@RequestMapping("/checkUser")
	public Object checkUser(String useremail, String userpwd) {
		User user = null;
		int result = 0;
		try {
			user = uservice.get(useremail);
			if(user==null) {
				result = 1;
			}else {
				if(user.getUserpwd().equals(userpwd)) {
					result = 0;
				}else {
					result = 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
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
				obj.put("title", "예약 불가");
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
		System.out.println("이메일 인증 요청이 들어옴!");
		System.out.println("이메일 인증 이메일 : " + email);
		
		Random r = new Random();
		int checkNum = r.nextInt(888888) + 111111;
		System.out.println("인증번호 : " + checkNum);
		authNumber = checkNum;
		
		String recipient = email;
 
        // 1. 발신자의 메일 계정과 비밀번호 설정
        final String user = "hdk1008@gmail.com";
        final String password = "izlhdyazgaysvtoi";
 
        // 2. Property에 SMTP 서버 정보 설정
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", 465);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
 
        // 3. SMTP 서버정보와 사용자 정보를 기반으로 Session 클래스의 인스턴스 생성
        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
 
        // 4. Message 클래스의 객체를 사용하여 수신자와 내용, 제목의 메시지를 작성한다.
        // 5. Transport 클래스를 사용하여 작성한 메세지를 전달한다.
 
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(user));
 
            // 수신자 메일 주소
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
 
            // Subject
            message.setSubject("이웃집하로 인증번호 이메일입니다:)");
 
            // Text
            message.setText("방문해주셔서 감사합니다. 인증번호는 ["+checkNum+"] 입니다. 감사합니다.");
 
            Transport.send(message);    // send message
 
 
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        
        return Integer.toString(authNumber);
	}
		
}
