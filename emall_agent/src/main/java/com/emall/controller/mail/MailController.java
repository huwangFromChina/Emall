package com.emall.controller.mail;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emall.base.ApiConfig;
import com.emall.base.Base;

@Controller
@RequestMapping(value="mail")
public class MailController extends Base{

	private MimeMessage message;
	private Session session;
	private Properties properties;
	private final String host="smtp.163.com";  //smpt服务器
	private final String password="h13767005141";    //发件人的邮箱授权码
	private final String officialAddress="h13767005141@163.com";  //发件人的邮箱账号
	
	
	/**
	 * 
	 * @param user 收件人地址
	 * @param subject  邮件标题
	 * @return
	 */
	//发送邮件激活账号
	@RequestMapping(value="send")
	@ResponseBody
	public MappingJacksonValue sendEmail(String user,String subject,String activateUrl,ModelMap model)
	{
		properties=new Properties(); 
		properties.setProperty("mail.transport.protocol", "smtp"); 
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.auth", "true");
		session=Session.getDefaultInstance(properties);
		session.setDebug(true);
		message=new MimeMessage(session);
		try{
			//加载发件人地址
			message.setFrom(new InternetAddress(officialAddress));
			//加载收件人地址
			message.setRecipient(Message.RecipientType.TO,new InternetAddress(user));
			message.setSubject(subject);//加载标题
			Multipart multipart=new MimeMultipart();
			 // 设置邮件的文本内容
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setText("亲爱的用户，点击此链接激活账户\n"+activateUrl);
            multipart.addBodyPart(contentPart);

            // 将multipart对象放到message中
            message.setContent(multipart);
            // 保存邮件
            message.saveChanges();
            // 发送邮件
            Transport transport = session.getTransport("smtp");
            // 连接服务器的邮箱
            transport.connect(host, officialAddress, password);
            // 把邮件发送出去
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            return ApiConfig.RETURN(model, ApiConfig.SUCCESS);
		}
		catch(Exception e){
			e.printStackTrace();
			return ApiConfig.RETURN(model, ApiConfig.FAILD);
		}
	}
}
