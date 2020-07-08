package com.lq.rmanage.domain;

public class ResumeList {
	private String uid;	//用户id
	private String cid;	//公司id
	private String pid;	//公司id
	private String rstate;
	private String pname;	//
	private String pfromsalary ;	//月薪
	private String ddate;	//投递时间
	private String newdate;	//投递时间
	private String rform;	//在线0，附件1		tbl_rmanage(简历管理表)
	private String uname;	//用户姓名		tbl_user(用户表)~账号
	private String usex;	//性别			tbl_user(用户表)~账号   男(0) 女(1)
	private String udegree;	//学历		tbl_edu(用户教育背景表)
	private String sname;
	private String uworkexp;	//工作经验		(tbl_workexp:todate-fromdate)
	private String wcity;	//期望城市		 tbl_wjob(用户期望工作表)
	private String position;	//职位名称   		 tbl_workexp(用户工作经历表)
	private String cno;	//公司名称          		tbl_workexp(用户工作经历表)
	private String ccity;
	private String wposition; 	//期望职位(应聘职位)     tbl_wjob(用户期望工作表)
	private String uaccount;	//邮箱     		tbl_user(用户表)~账号
	private String utel;
	
	public String getRstate() {
		return rstate;
	}
	public void setRstate(String rstate) {
		this.rstate = rstate;
	}
	public String getCcity() {
		return ccity;
	}
	public void setCcity(String ccity) {
		this.ccity = ccity;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPfromsalary() {
		return pfromsalary;
	}
	public void setPfromsalary(String pfromsalary) {
		this.pfromsalary = pfromsalary;
	}
	public String getNewdate() {
		return newdate;
	}
	public void setNewdate(String newdate) {
		this.newdate = newdate;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getDdate() {
		return ddate;
	}
	public void setDdate(String ddate) {
		this.ddate = ddate;
	}
	public String getRform() {
		return rform;
	}
	public void setRform(String rform) {
		this.rform = rform;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public String getUdegree() {
		return udegree;
	}
	public void setUdegree(String udegree) {
		this.udegree = udegree;
	}
	public String getUworkexp() {
		return uworkexp;
	}
	public void setUworkexp(String uworkexp) {
		this.uworkexp = uworkexp;
	}
	public String getWcity() {
		return wcity;
	}
	public void setWcity(String wcity) {
		this.wcity = wcity;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getWposition() {
		return wposition;
	}
	public void setWposition(String wposition) {
		this.wposition = wposition;
	}
	public String getUaccount() {
		return uaccount;
	}
	public void setUaccount(String uaccount) {
		this.uaccount = uaccount;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getUtel() {
		return utel;
	}
	public void setUtel(String utel) {
		this.utel = utel;
	}
}                               
