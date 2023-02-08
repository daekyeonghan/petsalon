package com.salon.frame;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	
	public static void confirmEmail(String dateToStr, String useremail, String dog_name, String designer_name, String item_name) throws Exception{
		/* System.out.println("이메일 인증 요청이 들어옴!"); */
		
		
		System.out.println("이메일 : " + useremail);
		
		String recipient = useremail;
		
		String content = 
				"이웃집 하로를 방문해주셔서 감사합니다." +
                "\n" + 
                "접수해주신 예약이 확정되어 안내드립니다." +
                "\n" + 
                "\n" +
                "• 강아지 이름 : " + dog_name +
                "\n" + 
				"• 디자이너님 : " + designer_name +
				"\n" + 
				"• 시술 정보 : " + item_name +
			    "\n" + 
			    "• 확정된 예약일 : " + dateToStr + " 입니다." + 
			    "\n" + 
			    "\n" +
			    "예약정보에 이상이 있거나 추가 문의사항 있으시면" +
                "\n" + 
			    "홈페이지의 1:1 문의를 이용해주세요:)";
 
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
            message.setSubject("이웃집하로 예약확정 안내 메일입니다:)");
 
            // Text
            message.setText(content);
 
            Transport.send(message);    // send message
 
 
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}
	
	
	public static void cancelEmail(String dateToStr, String useremail, String dog_name, String designer_name, String item_name, String cancel) throws Exception{
		/* System.out.println("이메일 인증 요청이 들어옴!"); */
		
		
		System.out.println("이메일 : " + useremail);
		
		String recipient = useremail;
		
		String content = 
				"이웃집 하로를 방문해주셔서 감사합니다." +
                "\n" + 
                "접수해주신 예약이 취소되어 안내드립니다." +
                "\n" + 
                "\n" +
                "예약정보" +
                "\n" + 
                "• 강아지 이름 : " + dog_name +
                "\n" + 
				"• 디자이너님 : " + designer_name +
				"\n" + 
				"• 시술 정보 : " + item_name +
			    "\n" + 
			    "• 접수된 예약일 : " + dateToStr + " 입니다." + 
			    "\n" + 
			    "\n" +
			    "취소사유" +
                "\n" + 
                "• " + cancel +
                "\n" + 
			    "추가 문의사항 있으시면 홈페이지의 1:1 문의를 이용해주세요";

 
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
            message.setSubject("이웃집하로 예약취소 안내 메일입니다");
 
            // Text
            message.setText(content);
 
            Transport.send(message);    // send message
 
 
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
	}
	
    
}

