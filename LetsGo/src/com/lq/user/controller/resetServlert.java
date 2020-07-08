package com.lq.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.lq.user.domain.User;
import com.lq.user.dao.dao.UserDAO;
import com.lq.user.dao.factory.UserDAOFactory;

import Util.EmailCode;
import Util.MD5Util;

@WebServlet("/reset")
public class resetServlert extends HttpServlet {
	public String code;
	public String email;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op=req.getParameter("op");
		if("reset".equals(op)) {
			reset(req,resp);
		}else if("reset2".equals(op)){
			reset2(req,resp);
		}else if("reset3".equals(op)){
			reset3(req,resp);
		}else if("exist".equals(op)){
			exist(req, resp);
		}else {
			System.out.println("无效操作"+op);
		}
	}

	private void reset(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String semail=req.getParameter("email");
		email=semail;
		System.out.println(email);
		EmailCode ec=new EmailCode();
		code=ec.createCode();
		ec.sendEmail(email,code);
		resp.sendRedirect(req.getContextPath()+"/reset2.html");
		
	}

	private void exist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter out= resp.getWriter();
		String uaccount = req.getParameter("email");
		System.out.println(1+uaccount);
		UserDAO  udao = UserDAOFactory.getUserDAO();
		User u = udao.queryByAccount(uaccount);
		System.out.println(u.getUaccount());
		Gson gson=new Gson();
		String json=gson.toJson(u);
		out.print(json);
		
	}
	
	private void reset2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// TODO Auto-generated method stub
		System.out.println(email);
		String scode=req.getParameter("code");
		if(scode.equals(code)) {
			System.out.println(code);
			resp.sendRedirect(req.getContextPath()+"/reset3.html");
		}else {
			System.out.println("验证码输入错误"+scode);
			
		}
	}

	private void reset3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String newpassword=req.getParameter("newpassword");
		UserDAO udao=UserDAOFactory.getUserDAO();
		boolean b=udao.updateByEmail(email,MD5Util.md5(newpassword));
		System.out.println(MD5Util.md5(newpassword));
		if(b) {
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
		}else {
			System.out.println("更新失败");
		}
	}
	
}
