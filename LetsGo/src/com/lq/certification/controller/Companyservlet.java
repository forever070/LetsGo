package com.lq.certification.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.lq.certification.dao.dao.CompanyDAO;
import com.lq.certification.dao.factory.CompanyDAOFactory;
import com.lq.certification.domain.Company;

import Util.UUIDUtil;

@WebServlet("/company")
public class Companyservlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op=req.getParameter("op");
		if("add".equals(op)) {
			add(req,resp);
		}else {
			System.out.println("无效操作"+op);
		}
	} 
	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Company c=new Company();
		c.setCid(UUIDUtil.getUUID());
		resp.setContentType("text/html;charset=utf-8"); 
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		try {
			BeanUtils.populate(c, req.getParameterMap());
			CompanyDAO cdao=CompanyDAOFactory.getCompanyDAO();
			boolean b=cdao.add(c);
			if(b) {
				resp.sendRedirect(req.getContextPath()+"/success.jsp");
				}else {
				System.out.println("失败!!!!!!!!!!!");
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
}
