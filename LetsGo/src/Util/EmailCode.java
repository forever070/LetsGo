package Util;

import java.util.Random;

import org.apache.commons.mail.HtmlEmail;

public class EmailCode {//邮箱验证码

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String code=createCode();
		sendEmail("1561970608@qq.com", createCode());
		System.out.println(code);
		System.out.println("ok");
	}
	
	public static String createCode() {
		String code = String.valueOf(new Random().nextInt(899999) + 100000);//nextInt（）是无范围的随机数,但是nextInt（n）是从0到n的随机数
		return code;
	}
	//邮箱验证码
  	public static boolean sendEmail(String emailaddress,String code){
  		try {
  			HtmlEmail email = new HtmlEmail();//不用更改
  			email.setHostName("smtp.163.com");//需要修改，126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com
  			email.setCharset("UTF-8");
  			email.addTo(emailaddress);// 收件地址
  			email.setFrom("wuzhengliang728@163.com", "正良仿拉勾网");//此处填邮箱地址和用户名,用户名可以任意填写
  			email.setAuthentication("wuzhengliang728@163.com", "HLNUENEKDHIHBSXL");//此处填写邮箱地址和客户端授权码
  			email.setSubject("仿拉勾网密码找回");//此处填写邮件名，邮件名可任意填写
  			email.setMsg("尊敬的用户:您好,您本次密码找回的验证码是:" + code);//此处填写邮件内容
  			email.send();
  			return true;
  		}
  		catch(Exception e){
  			e.printStackTrace();
  			return false;
  		}
  	}
}
