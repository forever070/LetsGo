package com.lq.resume.domain;

import java.util.Date;

/**
 * 个人简历表
 * @author dell
 *
 */
public class ResumeManage {
	public String cid;//公司id
	public String uid;//用户id
	public String pid;//职位id
	public int rform;//简历形式（在线简历 附件简历）
	//public int rstate;//简历状态
	//public Date ddate;//投递时间
	//public Date newdate;//修改时间
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public int getRform() {
		return rform;
	}
	public void setRform(int rform) {
		this.rform = rform;
	}
	
	

	
}
