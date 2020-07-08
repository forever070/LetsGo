package com.lq.search.controller;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.lq.search.domain.Company;
import com.lq.search.domain.CompanyQueryCondition;
import com.lq.search.domain.Position;
import com.lq.search.domain.PositionQueryCondition;
import com.lq.search.service.PositionConditionService;
@WebServlet("/SearchList")
public class SearchServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op=req.getParameter("spc")+"op";
		if("4op".equals(op))
		{
			queryCompany(req,resp);
		}else if("op".equals(op)||"1op".equals(op)){
			queryPosition(req,resp);
		}
	}
	private void queryCompany(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		PositionConditionService service =new PositionConditionService();
		CompanyQueryCondition condition=new CompanyQueryCondition();
		try {
			BeanUtils.populate(condition, req.getParameterMap());
		    List<Company> clist=service.queryByComCondition(condition);
		    if(clist!=null) {
		    	req.setAttribute("clist",clist);
			    req.getRequestDispatcher("list.jsp").forward(req, resp);
		    }
		
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		}		
	}
	private void queryPosition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PositionConditionService service =new PositionConditionService();
		PositionQueryCondition condition=new PositionQueryCondition();
		try {
			BeanUtils.populate(condition, req.getParameterMap());
		    List<Position> plist=service.queryByCondition(condition);
		    if(plist!=null) {
		    	req.setAttribute("plist",plist);
			    req.getRequestDispatcher("list.jsp").forward(req, resp);
		    }
		
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
