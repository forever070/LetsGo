package com.lq.resume.domain;
/**
 * 期望工作
 * @author dell
 *
 */
public class Wjob extends ResumeManage{
	private transient String uid;//用户id
	private String wcity;// 期望城市
	private int  wstate;// 工作性质
	private String wposition;// 期望职位
	private String  wsalary;//  期望月薪 
	private Wexp we;
	private Pexp p;
	private Edu e;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getWcity() {
		return wcity;
	}
	public void setWcity(String wcity) {
		this.wcity = wcity;
	}
	public int getWstate() {
		return wstate;
	}
	public void setWstate(int wstate) {
		this.wstate = wstate;
	}
	public String getWposition() {
		return wposition;
	}
	public void setWposition(String wposition) {
		this.wposition = wposition;
	}
	public String getWsalary() {
		return wsalary;
	}
	public void setWsalary(String wsalary) {
		this.wsalary = wsalary;
	}
	public Wexp getWe() {
		return we;
	}
	public void setWe(Wexp we) {
		this.we = we;
	}
	public Pexp getP() {
		return p;
	}
	public void setP(Pexp p) {
		this.p = p;
	}
	public Edu getE() {
		return e;
	}
	public void setE(Edu e) {
		this.e = e;
	}
	
	
	

}
