package com.Net;

import java.util.Properties;

import org.apache.log4j.Logger;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.Dao.MailMan;

public class MailUtil {
	
	public static Logger logger = Logger.getLogger(MailUtil.class);
	
	/**
	 * @author davedaiw
	 * @param MailMan
	 * @see send result by mail
	 */
	public static void sendMail(MailMan mailMan){
		
		final String host = mailMan.getHost();
		final String uname = mailMan.getUname();
		final String upswd = mailMan.getUpswd();
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.host", host);
		
		
		Session session = Session.getDefaultInstance(properties);
		session.setDebug(true);
		//
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(mailMan.getSender()));
			//send only one
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailMan.getRecever()));
			//send to many
			//message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailMan.getRecever()));
			message.setSubject(mailMan.getSubject());
			
			Multipart multipart = new MimeMultipart();
			if (null != mailMan.getMcontent()) {
				BodyPart body = new MimeBodyPart();
				body.setContent(mailMan.getMcontent(), "text/html;charset=UTF-8");
				multipart.addBodyPart(body);
			}		
			
			if (null != mailMan.getAttachfile()) {
				BodyPart attchment = new MimeBodyPart();
				DataSource source = new FileDataSource(mailMan.getAttachfile());
				attchment.setDataHandler(new DataHandler(source));
				attchment.setFileName(mailMan.getAttachfile());
				multipart.addBodyPart(attchment);
			}	
					
			message.setContent(multipart);
			message.saveChanges();
			
//			Transport.send(message);//用这个方法会导致一定的失败；可能的原因是地址信息相关内容不能识别
			
			Transport transport = session.getTransport("smtp");
			transport.connect(host, uname, upswd);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			
		} catch (AddressException e) {
			
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
				
	}
}
