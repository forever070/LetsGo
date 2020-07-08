package com.lq.resume.domain;

import java.util.Date;
/**
 * 工作经历
 * @author dell
 *
 */
public class Wexp extends ResumeManage{
	private transient String uid;//用户id
	private String cno ;//公司名称 varchar2(40)
	private String  position;//职位名称varchar2(40)
	private int  startYear ;//开始年份
	private int  startMonth ;//结束年份
	private int  endYear ;//结束年份
	private int  endMonth ;//结束月份
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getStartYear() {
		return startYear;
	}
	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}
	public int getStartMonth() {
		return startMonth;
	}
	public void setStartMonth(int startMonth) {
		this.startMonth = startMonth;
	}
	public int getEndYear() {
		return endYear;
	}
	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}
	public int getEndMonth() {
		return endMonth;
	}
	public void setEndMonth(int endMonth) {
		this.endMonth = endMonth;
	}
	

}
