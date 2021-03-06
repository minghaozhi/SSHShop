package com.shop.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import freemarker.core.ReturnInstruction.Return;

/**
* @author minghaozhi 597575122@qq.com
* @version 创建时间：2016年11月29日 上午10:47:06
* 类说明
*/
public class MailUtils {
	/**
	 * 发送邮件的方法
	 * @param to :收件人
	 * @param code :激活码
	 */
	
	public static void sendMail(String to,String code){
		/**
		 * 1.获得一个Session对象
		 * 2.创建一个代表邮件对象的Message
		 * 3.发送邮件Transport
		 */
		//1.获得连接对象
		Properties props=new Properties();
		props.setProperty("mail.transport.protocol", "smtp");//协议
		props.setProperty("mail.smtp.host", "smtp.163.com");//主机名
		props.setProperty("mail.smtp.auth", "true");//是否开启权限控制
		props.setProperty("mail.debug", "true");//如果设置为true,则发送邮件时会打印发送时的信息
		Session session=Session.getInstance(props,new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("15090311731@163.com","19920207love");
				
			}
			
		});
		//2.创建一个Message对象
		Message message=new MimeMessage(session);
		//设置发件人
		
		try {
			try {
				message.setFrom(new InternetAddress("15090311731@163.com"));
				message.addRecipient(RecipientType.TO, new InternetAddress(to));
				//设置标题
				message.setSubject("用户注册激活邮件");
				//设置邮件正文
				message.setContent("<h1>用户注册的激活邮件！点击下面的连接完成注册！></h1><h3><a href='http://127.0.0.1:8080/SSHShop/user_active.action?code="+code+"'>http://127.0.0.1:8080/SSHShop/user_active.action?code="+code+"</a></h3>","text/html;charset=utf-8");
				//3.发送邮件
				Transport.send(message);
			} catch (AddressException e) {
				e.printStackTrace();
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
//	public static void main(String[] args) {
//		
//		sendMail("1296955957@qq.com", "112");
//	}

}
