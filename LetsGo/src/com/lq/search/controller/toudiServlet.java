package com.lq.search.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lq.search.dao.dao.toudiDAO;
import com.lq.search.dao.factory.toudiDAOFactory;
import com.lq.search.domain.Company;
import com.lq.search.domain.Position;

@WebServlet("/toudi")
public class toudiServlet extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cid=req.getParameter("cid");
		String pid=req.getParameter("pid");
		toudiDAO tdao=toudiDAOFactory.gettoudiDAO();
		Position position=tdao.queryBy(pid, cid);
		req.setAttribute("position", position);
		req.getRequestDispatcher("toudi.jsp").forward(req, resp);	
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
