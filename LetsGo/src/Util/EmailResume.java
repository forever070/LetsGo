package Util;

import org.apache.commons.mail.HtmlEmail;

public class EmailResume {//邮件

	public static void main(String[] args) {
		//sendEmail("3097926179@qq.com");
		System.out.println("ok");
	}
	
	
  	public static boolean sendNoticeEmail(String name,String emailaddress,String interTime,String interAdd,String linkMan,String linkPhone,String content){
  		try {
  			HtmlEmail email = new HtmlEmail();//不用更改
  			email.setHostName("smtp.163.com");//需要修改，126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com
  			email.setCharset("UTF-8");
  			email.addTo(emailaddress);// 收件地址
   
  			email.setFrom("wuzhengliang728@163.com", "正良仿拉勾网");//此处填邮箱地址和用户名,用户名可以任意填写
  			email.setAuthentication("wuzhengliang728@163.com", "HLNUENEKDHIHBSXL");//此处填写邮箱地址和客户端授权码
   
  			email.setSubject("仿拉勾网通知面试");//此处填写邮件名，邮件名可任意填写
  			email.setMsg(name+"，您好：" + 
  					"您的简历已通过我们的筛选，很高兴通知您参加我们的面试。" + "<br>"+
  					"面试时间：" + interTime+"<br>"+
  					"面试地点：" + interAdd+"<br>"+
  					"联系人：" + linkMan+"<br>"+
  					"联系电话："+linkPhone + "<br>"+
  					content );//此处填写邮件内容
   
  			email.send();
  			return true;
  		}
  		catch(Exception e){
  			e.printStackTrace();
  			return false;
  		}
  	}
  	public static boolean sendForwardEmail(String recipients,String title,String content){
  		try {
  			HtmlEmail email = new HtmlEmail();//不用更改
  			email.setHostName("smtp.163.com");//需要修改，126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com
  			email.setCharset("UTF-8");
  			email.addTo(recipients);// 收件地址
  			
  			email.setFrom("wuzhengliang728@163.com", "正良仿拉勾网");//此处填邮箱地址和用户名,用户名可以任意填写
  			email.setAuthentication("wuzhengliang728@163.com", "HLNUENEKDHIHBSXL");//此处填写邮箱地址和客户端授权码
  			
  			email.setSubject("转发简历");//此处填写邮件名，邮件名可任意填写
  			email.setMsg(title+"<br>"+content);//此处填写邮件内容
  			
  			email.send();
  			return true;
  		}
  		catch(Exception e){
  			e.printStackTrace();
  			return false;
  		}
  	}
  	public static boolean sendRefuseEmail(String emailaddress,String content){
  		try {
  			HtmlEmail email = new HtmlEmail();//不用更改
  			email.setHostName("smtp.163.com");//需要修改，126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com
  			email.setCharset("UTF-8");
  			email.addTo(emailaddress);// 收件地址
  			
  			email.setFrom("wuzhengliang728@163.com", "正良仿拉勾网");//此处填邮箱地址和用户名,用户名可以任意填写
  			email.setAuthentication("wuzhengliang728@163.com", "HLNUENEKDHIHBSXL");//此处填写邮箱地址和客户端授权码
  			
  			email.setSubject("拉勾网简历拒绝通知");//此处填写邮件名，邮件名可任意填写
  			email.setMsg(content);//此处填写邮件内容
  			
  			email.send();
  			return true;
  		}
  		catch(Exception e){
  			e.printStackTrace();
  			return false;
  		}
  	}
}
