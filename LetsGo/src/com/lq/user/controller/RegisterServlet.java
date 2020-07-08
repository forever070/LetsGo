package com.lq.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;
import com.lq.user.dao.dao.UserDAO;
import com.lq.user.dao.factory.UserDAOFactory;
import com.lq.user.domain.User;

import Util.MD5Util;
import Util.UUIDUtil;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = req.getParameter("op");
		if("register".equals(op)) {
			register(req,resp);
		}else if("logincheck".equals(op)) {
			logincheck(req,resp);
		}else if("login".equals(op)) {
			login(req,resp);
		}else if("check".equals(op)) {
			check(req,resp);
		}else if("check1".equals(op)) {
			check1(req,resp);
		}else if("check2".equals(op)) {
			check2(req,resp);
		}
		else if("kill".equals(op)) {
			kill(req,resp);
		}else{
			System.out.println("无效操作"+op);
		}
	}
	private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		String uaccount = new String(req.getParameter("email").getBytes("utf-8"), "utf-8");
		
		
		resp.setContentType("text/html;charset=utf-8");
	//	PrintWriter out= resp.getWriter();
		resp.setDateHeader("Expires",-1);
		resp.setHeader("Cache-Control","no-cache");
		resp.setHeader("Pragma","no-cache"); 
		
	//	String uaccount=req.getParameter("email");
		String upassword=MD5Util.md5(req.getParameter("password"));//接收页面的账号密码
		System.out.println(uaccount+"="+upassword);
		UserDAO udao = UserDAOFactory.getUserDAO();
		User u = udao.logincheck(uaccount, upassword);
		HttpSession session = req.getSession();
		
		if (u!=null) {
			System.out.println("登陆成功！！");
			
//			Timer timer = new Timer();// 实例化Timer类
//	        timer.schedule(new TimerTask() {
//	            public void run() {
//	              //  System.out.println("退出");
//	                this.cancel();
//	            }
//	        }, 2000);// 这里百毫秒
	        
			if (u.getAuthority()==0) {
				resp.sendRedirect(req.getContextPath()+"/jianli.jsp");
			}else if(u.getAuthority()==1){
				if(session.getAttribute("cid")!=null) {
					resp.sendRedirect(req.getContextPath()+"/index.jsp");
				}else {
					resp.sendRedirect(req.getContextPath()+"/index01.jsp");
				}
			}
		}else {
			System.out.println("登陆失败！！");
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
		}
		
		
	}
	private void logincheck(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out= resp.getWriter();
		resp.setDateHeader("Expires",-1);
		resp.setHeader("Cache-Control","no-cache");
		resp.setHeader("Pragma","no-cache"); 
		String uaccount = new String(req.getParameter("account").getBytes("utf-8"), "utf-8");
		String upassword = new String(req.getParameter("password").getBytes("utf-8"), "utf-8");
		
	//	System.out.println(uaccount+"="+upassword);
		
		UserDAO  udao = UserDAOFactory.getUserDAO();
		User u = udao.logincheck(uaccount, MD5Util.md5(upassword));//
		HttpSession session = req.getSession();
		if(u!=null&&0==u.getAuthority()) {
			System.out.println("普通用户"+u.getUaccount());
			session.setAttribute("loginname",u);
		}else if(u!=null&&1==u.getAuthority()) {
			System.out.println("公司用户");
			String cid=udao.getCid(u.getId());
			String  cname=udao.getCname(u.getId());
			System.out.println(cname);
			session.setAttribute("cid",cid);
			session.setAttribute("cname",cname);
			session.setAttribute("loginname",u);
		}
	
		Gson gson=new Gson();
		String json=gson.toJson(u);
		out.print(json);
	}
	private void check(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("验证账号是否可以注册！！");
		PrintWriter out= resp.getWriter();
		resp.setDateHeader("Expires",-1);
		resp.setHeader("Cache-Control","no-cache");
		resp.setHeader("Pragma","no-cache"); 
		String uaccount = req.getParameter("account");
		UserDAO  udao = UserDAOFactory.getUserDAO();
		boolean u = udao.checkByAccount(uaccount);
		Gson gson=new Gson();
		String json=gson.toJson(u);
		out.print(json);
	}

	private void kill(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("清除session！！");
		resp.setDateHeader("Expires",-1);
		resp.setHeader("Cache-Control","no-cache");
		resp.setHeader("Pragma","no-cache"); 
		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect(req.getContextPath()+"/login.jsp");
	}
	private void check2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("index--->register");
		resp.setDateHeader("Expires",-1);
		resp.setHeader("Cache-Control","no-cache");
		resp.setHeader("Pragma","no-cache"); 
		
		HttpSession session = req.getSession();
		String loginname = (String)session.getAttribute("loginname");
		System.out.println(session.getAttribute("loginname"));
		System.out.println(loginname);
		if (loginname!=null) {
			resp.sendRedirect(req.getContextPath()+"/index.html");
		}else {
			req.getRequestDispatcher("register.jsp")
			.forward(req, resp);
		//	resp.sendRedirect(req.getContextPath()+"");
			//������ǵ�½�û�������
		}
	}
	private void check1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setDateHeader("Expires",-1);
		resp.setHeader("Cache-Control","no-cache");
		resp.setHeader("Pragma","no-cache"); 
		
		HttpSession session = req.getSession();
		String loginname = (String)session.getAttribute("loginname");
		if (loginname!=null) {
			System.out.println("index--->index");
			//	resp.sendRedirect(req.getContextPath()+"");
				resp.sendRedirect(req.getContextPath()+"/index.html");
		}else {

			System.out.println("index--->login");
			System.out.println(session.getAttribute("loginname"));
			req.getRequestDispatcher("login.jsp")
			.forward(req, resp);
		}
		
	}
	
	private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// TODO Auto-generated method stub
		String account = new String(req.getParameter("email").getBytes("utf-8"), "utf-8");
		String password=req.getParameter("password");
		String authority=req.getParameter("type");
		User u =new User();
		u.setId(UUIDUtil.getUUID());
		u.setUaccount(account);
		u.setUpassword(MD5Util.md5(password));
		u.setAuthority(Integer.parseInt(authority));
			UserDAO udao=UserDAOFactory.getUserDAO();
			boolean b=udao.register(u);
			if(b)
			{//
				System.out.println("注册成功！！");
				resp.sendRedirect(req.getContextPath()
										+"/login.jsp");
			}else {//
				System.out.println("注册失败！！！");
			}
		} 
	

}

