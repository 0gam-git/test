package com.urong.email;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MyAuthentication extends Authenticator {

	PasswordAuthentication pa;

	private final static String id = "Latis.FaaS@gmail.com";
	private final static String pw = "!@#$faas";

	public MyAuthentication() {
		pa = new PasswordAuthentication(id, pw);
	}

	// 시스템에서 사용하는 인증정보
	public PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}

	public static void main(String[] args) {
		Properties p = System.getProperties();
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.port", "587");

		Authenticator auth = new MyAuthentication();
		Session session = Session.getDefaultInstance(p, auth);
		MimeMessage msg = new MimeMessage(session);

		try {
			String name = "이름";
			String link = "링크";
			
			msg.setSentDate(new Date());
			InternetAddress from = new InternetAddress();
			from = new InternetAddress("FaaS<" + id + ">");

			// 이메일 발신자
			msg.setFrom(from);
			// 이메일 수신자
			InternetAddress to = new InternetAddress("dudwns519@daum.net");
			msg.setRecipient(Message.RecipientType.TO, to);

			// 이메일 제목
			msg.setSubject("<FaaS>회원 인증 메일 보내드립니다.", "UTF-8");

			// 이메일 내용
			msg.setText("안녕하세요. " + name + "님 <br/><br/>" + 
			"Faas에 등록한 메일주소가 올바른지 확인하기 위한 메일입니다. <br/>" + 
			"메일등록을 완료하시려면 아래 링크를 누르세요. <br/><br/>" + 
			link + "<br/><br/>" +
			"감사합니다. <br/>" + 
			"FaaS팀 드림. <br/>"  
			/* + "FaaS 서비스에 대한 자세한 내용은 http://www.FaaS.com 에서 확인할 수 있습니다. "*/
			, "UTF-8");

			// 이메일 헤더
			msg.setHeader("content-Type", "text/html");

			// 메일보내기
			javax.mail.Transport.send(msg);
			System.out.println("send email");

		} catch (AddressException addr_e) {
			addr_e.printStackTrace();
		} catch (MessagingException msg_e) {
			msg_e.printStackTrace();
		}
	}
}
