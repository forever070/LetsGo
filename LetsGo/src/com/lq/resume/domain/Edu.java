package com.lq.resume.domain;

import java.util.Date;
/**
 * 教育背景
 * @author dell
 *
 */
public class Edu extends ResumeManage{
	  private transient String uid;//用户id
	  private String sname  ; //学校名称	
	  private String degree  ; //学历
	  private String  pname  ;//专业名称
	  private int fromdate ;//开始年份
	  private int todate;//结束年份
	  
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getFromdate() {
		return fromdate;
	}
	public void setFromdate(int fromdate) {
		this.fromdate = fromdate;
	}
	public int getTodate() {
		return todate;
	}
	public void setTodate(int todate) {
		this.todate = todate;
	}
	
}
