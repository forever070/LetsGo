package com.lq.resume.dao.dao;

import com.lq.resume.domain.Edu;
import com.lq.resume.domain.Pexp;
import com.lq.resume.domain.ResumeManage;
import com.lq.resume.domain.Wexp;
import com.lq.resume.domain.Wjob;
import com.lq.user.domain.User;

public interface ResumeDAO {
	public Wjob addWjob(Wjob wj);
	public Wexp addWexp(Wexp we);
	public Pexp addPexp(Pexp p);
	public Edu addEdu(Edu e);
	public User updateUser(User u);
	public Wjob queryByUid(String uid);
	//添加到简历管理表
	public ResumeManage addRmanage(ResumeManage rm);
	
	
}
