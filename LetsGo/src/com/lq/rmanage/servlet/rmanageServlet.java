package com.lq.rmanage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.lq.rmanage.dao.dao.ResumeListDAO;
import com.lq.rmanage.dao.factory.ResumeListDAOFactory;
import com.lq.rmanage.domain.ReseiveId;
import com.lq.rmanage.domain.ResumeList;
import com.lq.rmanage.service.rmanageService;

import Util.EmailResume;

@WebServlet("/rmanage")
public class rmanageServlet extends HttpServlet {

	private rmanageService rservice = new rmanageService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		if ("queryByCid".equals(op)) {
			queryByCid(req, resp);
		} else if ("updateByUid".equals(op)) {
			updateByUid(req, resp);
		} else if ("noticeEmail".equals(op)) {
			noticeEmail(req, resp);
		} else if ("forwardEmail".equals(op)) {
			forwardEmail(req, resp);
		} else if ("refuseEmail".equals(op)) {
			refuseEmail(req, resp);
		} else{
			System.out.println("无效操作:" + op);
		}
	}

	private void queryByCid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReseiveId ri=new ReseiveId();
		String pid=req.getParameter("pid");
		String cid = req.getParameter("cid");
		String uid = req.getParameter("uid");
		String rstate = req.getParameter("rstate");
		ri.setPid(pid);
		ri.setCid(cid);
		ri.setId(uid);
		ri.setRstate(rstate);
		ResumeListDAO rdao = ResumeListDAOFactory.getResumeListDAO();
		int rstate1=0;
		if(pid!=null&&!"".equals(pid.trim())) {
			rstate1=rdao.queryForCount(ri);
		}
		rstate1=rdao.queryRstate1(cid);
		int rstate3=rdao.queryRstate3(cid);
		List<ResumeList> rlist = rdao.queryByCid(ri);
		req.setAttribute("rlist", rlist);
		req.setAttribute("rstate1", rstate1);
		req.setAttribute("rstate3", rstate3);
		if(cid!=null&&pid==null&&!"".equals(cid.trim())) {
			if ("1".equals(rstate)) {
				req.getRequestDispatcher("/toBeProcessedResume.jsp")// 1
				.forward(req, resp);
			} else if ("2".equals(rstate)) {
				req.getRequestDispatcher("/canInterviewResumes.jsp")// 2
				.forward(req, resp);
			} else if ("3".equals(rstate)) {
				req.getRequestDispatcher("/autoFilterResumes.jsp")// 3
				.forward(req, resp);
			} else if ("4".equals(rstate)) {
				req.getRequestDispatcher("/haveNoticeResumes.jsp")// 4
				.forward(req, resp);
			} else if ("5".equals(rstate)) {
				req.getRequestDispatcher("/haveRefuseResumes.jsp")// 5
				.forward(req, resp);
			}
		}else if(uid!=null&&!"".equals(uid.trim())) {
			req.getRequestDispatcher("/delivery.jsp")
			.forward(req, resp);
		}else if(pid!=null&&!"".equals(pid.trim())) {
			req.getRequestDispatcher("/toBeProcessedResume.jsp")// 1
			.forward(req, resp);
		}
	}

	private void updateByUid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String cid = req.getParameter("cid");
		String rstate = req.getParameter("rstate");
		String[] uids = req.getParameterValues("uid");
		String[] pids = req.getParameterValues("pid");
		boolean b = rservice.updateRstate(cid, rstate, uids,pids);
		Gson gson = new Gson();
		String json = gson.toJson(b);
		out.println(json);
	}

	private void noticeEmail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String name=req.getParameter("name");
		String emailaddress=req.getParameter("email");
		String interTime=req.getParameter("interTime");
		String interAdd=req.getParameter("interAdd");
		String linkMan=req.getParameter("linkMan");
		String linkPhone=req.getParameter("linkPhone");
		String content=req.getParameter("content");
		boolean b=EmailResume.sendNoticeEmail(name, emailaddress, interTime, interAdd, linkMan, linkPhone, content);
		Gson gson=new Gson();
		String json=gson.toJson(b);
		out.println(json);
	}
	private void forwardEmail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String recipients=req.getParameter("recipients");
        String title= req.getParameter("title");
        String content= req.getParameter("content");
		boolean b=EmailResume.sendForwardEmail(recipients, title, content);
		Gson gson=new Gson();
		String json=gson.toJson(b);
		out.println(json);
	}
	private void refuseEmail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String emailaddress=req.getParameter("email");
		String content= req.getParameter("content");
		boolean b=EmailResume.sendRefuseEmail(emailaddress, content);
		Gson gson=new Gson();
		String json=gson.toJson(b);
		out.println(json);
	}
}
