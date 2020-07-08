package com.lq.position.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;
import com.lq.position.dao.dao.PositionDAO;
import com.lq.position.dao.factory.PositionDAOFactory;
import com.lq.position.domain.Position;

import Util.UUIDUtil;

@WebServlet("/position")
public class Positionservlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op=req.getParameter("op");
		if("add".equals(op)) {
			add(req,resp);
		}else if("list".equals(op)) {
			list(req,resp);
		}else if("listByPid".equals(op)) {
			listByPid(req,resp);
		}else if("listoff".equals(op)) {
			listoff(req,resp);
		}else if("off".equals(op)) {
			off(req,resp);
		}else if("on".equals(op)) {
			on(req,resp);
		}else if("del".equals(op)) {
			del(req,resp);
		}else {
			System.out.println("无效操作"+op);
		}
	}
	
	protected void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String pid = req.getParameter("pid");
		PositionDAO pdao=PositionDAOFactory.getPositionDAO();
		boolean b = pdao.del(pid);
		if (b) {
			resp.sendRedirect(req.getContextPath() + "/positions.html");
		} else {
			System.out.println("删除失败!!!");
		}
		out.print(b);
	}
	protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out=resp.getWriter();
		Position p=new Position();
		p.setPid(UUIDUtil.getUUID());
		
		try {
			BeanUtils.populate(p, req.getParameterMap());	PositionDAO pdao=PositionDAOFactory.getPositionDAO();
			System.out.println(p.pcity);
			boolean b=pdao.add(p);
			Gson gson=new Gson();
			String json=gson.toJson(b);
			out.print(json);
			//System.out.println(json);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	private void listoff(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		resp.setDateHeader("Expires",-1);
		resp.setHeader("Cache-Control","no-cache");
		resp.setHeader("Pragma","no-cache"); 
		
		PositionDAO pdao = PositionDAOFactory.getPositionDAO();
		List<Position> plist =pdao.listoff();
		
		req.setAttribute("plist",plist);
		
		if (plist!=null) {
			System.out.println("查詢已下线！！");
			req.getRequestDispatcher("positionsOff.jsp").forward(req, resp);
			//请求转发
			//resp.sendRedirect(req.getContextPath()+"/positions.jsp");
			}
	}
	private void off(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		resp.setDateHeader("Expires",-1);
		resp.setHeader("Cache-Control","no-cache");
		resp.setHeader("Pragma","no-cache"); 
		PrintWriter out=resp.getWriter();
		String   pid= req.getParameter("pid");
		
		PositionDAO pdao = PositionDAOFactory.getPositionDAO();
		boolean b = pdao.off(pid);
		if (b) {
			System.out.println("修改成功！！！！");
		}else {
			System.out.println("修改失败！！！！");
		}
		
		out.print(b);
		
			//req.getRequestDispatcher("positions.jsp").forward(req, resp);
	}private void on(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		resp.setDateHeader("Expires",-1);
		resp.setHeader("Cache-Control","no-cache");
		resp.setHeader("Pragma","no-cache"); 
		PrintWriter out=resp.getWriter();
		String   pid= req.getParameter("pid");
		
		PositionDAO pdao = PositionDAOFactory.getPositionDAO();
		boolean b = pdao.on(pid);
		if (b) {
			System.out.println("修改成功！！！！");
		}else {
			System.out.println("修改失败！！！！");
		}
		
		out.print(b);
		
			//req.getRequestDispatcher("positions.jsp").forward(req, resp);
	}
	private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		resp.setDateHeader("Expires",-1);
		resp.setHeader("Cache-Control","no-cache");
		resp.setHeader("Pragma","no-cache"); 
		
		PositionDAO pdao = PositionDAOFactory.getPositionDAO();
		List<Position> plist =pdao.list();
		
		req.setAttribute("plist",plist);
		
		if (plist!=null) {
			System.out.println("查詢有效职位！！");
			req.getRequestDispatcher("positions.jsp").forward(req, resp);
			//请求转发
			//resp.sendRedirect(req.getContextPath()+"/positions.jsp");
			}
		
		
		
//		Gson gson=new Gson();
//		String json=gson.toJson(plist);
//		out.print(json);
	}
	private void listByPid(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
		resp.setDateHeader("Expires",-1);
		resp.setHeader("Cache-Control","no-cache");
		resp.setHeader("Pragma","no-cache"); 
		String pid=req.getParameter("pid");
		String cid=req.getParameter("cid");
		PositionDAO pdao = PositionDAOFactory.getPositionDAO();
		List<Position> plist =pdao.list();
		
		req.setAttribute("plist",plist);
		
		if (plist!=null) {
			System.out.println("查詢有效职位！！");
			req.getRequestDispatcher("positions.jsp").forward(req, resp);
		}
	}
}
