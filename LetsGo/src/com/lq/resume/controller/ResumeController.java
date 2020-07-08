package com.lq.resume.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.mail.HtmlEmail;

import com.google.gson.Gson;
import com.lq.resume.dao.dao.ResumeDAO;
import com.lq.resume.dao.factory.ResumeDAOFactory;
import com.lq.resume.domain.Edu;
import com.lq.resume.domain.Pexp;
import com.lq.resume.domain.ResumeManage;
import com.lq.resume.domain.Wexp;
import com.lq.resume.domain.Wjob;
import com.lq.user.domain.User;
@WebServlet("/resume")
public class ResumeController extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	this.doPost(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op=req.getParameter("op");
		if("addWjob".equals(op)) {
			addWjob(req, resp);
		}else if("addWexp".equals(op)){
			addWexp(req, resp);
		}else if("addPexp".equals(op)){
			addPexp(req, resp);
		}else if("addEdu".equals(op)){
			addEdu(req, resp);
		}else if("updateUser".equals(op)){
			updateUser(req, resp);
		}else if("queryByUid".equals(op)){
			queryByUid(req, resp);
		}else if("deliverResume".equals(op)) {
			deliverResume(req, resp);
		}
		else {
			System.out.println("无效操作！！！"+op);
		}
		
	}
protected void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	User u=new User();
	try {
		BeanUtils.populate(u, req.getParameterMap());
		ResumeDAO rdao=ResumeDAOFactory.getResumeDAO();
		User u1=rdao.updateUser(u);
		//封装成json
		Gson gson=new Gson();
		String json=gson.toJson(u1);
		resp.getWriter().println(json);
		
		/*HttpSession session=req.getSession();
		session.setAttribute("user1", u1);*/
		
		if(u1!=null) {
			System.out.println("User添加成功");
		}else {
			System.out.println("User添加失败");
		}
			
	} catch (IllegalAccessException e1) {
		e1.printStackTrace();
	} catch (InvocationTargetException e1) {
		e1.printStackTrace();
	}
}
protected void addWjob(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Wjob表
		Wjob wj = new Wjob();
		try {
			BeanUtils.populate(wj, req.getParameterMap());
			ResumeDAO rdao = ResumeDAOFactory.getResumeDAO();
			Wjob wjob = rdao.addWjob(wj);
			//封装成json
			Gson gson=new Gson();
			String json=gson.toJson(wjob);
			resp.getWriter().println(json);
			
			HttpSession session=req.getSession();
			session.setAttribute("wjob", wjob);
			
			if(wjob!=null) {
				System.out.println("Wjob添加成功");
			}else {
				System.out.println("Wjob添加失败");
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
protected void addWexp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Wexp we=new Wexp();
		try {
			BeanUtils.populate(we, req.getParameterMap());
			ResumeDAO rdao=ResumeDAOFactory.getResumeDAO();
			Wexp wexp=rdao.addWexp(we);
			//封装成json
			Gson gson=new Gson();
			String json=gson.toJson(wexp);
			resp.getWriter().println(json);
			
		/*	HttpSession session=req.getSession();
			session.setAttribute("wexp", wexp);*/
			
			if(wexp!=null) {
				System.out.println("Wexp添加成功");
			}else {
				System.out.println("Wexp添加失败");
			}
				
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
protected void addPexp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Pexp p=new Pexp();
	try {
		BeanUtils.populate(p, req.getParameterMap());
		ResumeDAO rdao=ResumeDAOFactory.getResumeDAO();
		Pexp pexp=rdao.addPexp(p);
		//封装成json
		Gson gson=new Gson();
		String json=gson.toJson(pexp);
		resp.getWriter().println(json);
		
		HttpSession session=req.getSession();
		session.setAttribute("pexp", pexp);
		
		if(pexp!=null) {
			System.out.println("Pexp添加成功");
		}else {
			System.out.println("Pexp添加失败");
		}
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
 	}
protected void addEdu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Edu e=new Edu();
	try {
		BeanUtils.populate(e, req.getParameterMap());
		ResumeDAO rdao=ResumeDAOFactory.getResumeDAO();
		Edu edu=rdao.addEdu(e);
		//封装成json
		Gson gson=new Gson();
		String json=gson.toJson(edu);
		resp.getWriter().println(json);
		
		HttpSession session=req.getSession();
		session.setAttribute("edu",edu);
		
		if(edu!=null) {
			System.out.println("Edu添加成功");
		}else {
			System.out.println("Edu添加失败");
		}
			
	} catch (IllegalAccessException e1) {
		e1.printStackTrace();
	} catch (InvocationTargetException e1) {
		e1.printStackTrace();
	}
}
protected void queryByUid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Wjob wj=new Wjob();
	String uid=req.getParameter("uid");
	ResumeDAO rdao=ResumeDAOFactory.getResumeDAO();
	Wjob wj1=rdao.queryByUid(uid);
	req.setAttribute("wjob", wj1);
	req.getRequestDispatcher("/preview.jsp").forward(req, resp);
}
protected void deliverResume(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	ResumeManage rm=new ResumeManage();
	try {
		BeanUtils.populate(rm, req.getParameterMap());
		ResumeDAO rdao=ResumeDAOFactory.getResumeDAO();
		ResumeManage rm1=rdao.addRmanage(rm);
		
		Gson gson=new Gson();
		String json=gson.toJson(rm1);
		resp.getWriter().println(json);
		
		if(rm1!=null) {
			System.out.println("投递成功！");
		}else
			System.out.println("投递失败");
		
		
		
	} catch (IllegalAccessException e) {
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		e.printStackTrace();
	}
	
}

//邮箱验证码
public static boolean sendEmail(String emailaddress,String code){
	try {
		HtmlEmail email = new HtmlEmail();//不用更改
		email.setHostName("smtp.126.com");//需要修改，126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com
		email.setCharset("UTF-8");
		email.addTo(emailaddress);// 收件地址
		
		email.setFrom("******@126.com", "aa");//此处填邮箱地址和用户名,用户名可以任意填写
		
		email.setAuthentication("******@126.com", "*******");//此处填写邮箱地址和客户端授权码
		
		email.setSubject("孙大大通讯");//此处填写邮件名，邮件名可任意填写
		email.setMsg("尊敬的用户您好,您本次注册的验证码是:" + code);//此处填写邮件内容
		
		email.send();
		return true;
	}
	catch(Exception e){
		e.printStackTrace();
		return false;
		}
	}
}
