package com.lq.user.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lq.user.dao.dao.UserDAO;
import com.lq.user.dao.factory.UserDAOFactory;
import com.lq.user.domain.User;

import Util.MD5Util;

@WebServlet("/updatePwd")
public class updatePwdServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op=req.getParameter("op");
		if("queryByAccount".equals(op)) {
			try {
				queryByAccount(req,resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if("updatePwd".equals(op)){
			updatePwd(req,resp);
		}else {
			System.out.println("无效操作"+op);
		}
	}

	private void queryByAccount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException{
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		User u1 = (User) session.getAttribute("loginname");
		String account=u1.getUaccount();
		System.out.println(account);
		UserDAO udao=UserDAOFactory.getUserDAO();
		User u=udao.queryByAccount(account);
		System.out.println(account);
		req.setAttribute("u", u);
		resp.sendRedirect(req.getContextPath()+"/updatePwd.jsp");
	}

	private void updatePwd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		User u1 = (User) session.getAttribute("loginname");
		String account=u1.getUaccount();
		System.out.println("111"+account);
		UserDAO udao=UserDAOFactory.getUserDAO();
		User u=udao.queryByAccount(account);
		String id=u.getId();
		String password=MD5Util.md5(req.getParameter("newpassword"));
		boolean b=udao.update(id, password);
		if(b) {
			System.out.println("更改成功！");
			session.invalidate();
			System.out.println("注销成功，重新登陆");
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
		}else {
			System.out.println("修改失败");
		}
		
	}

}
