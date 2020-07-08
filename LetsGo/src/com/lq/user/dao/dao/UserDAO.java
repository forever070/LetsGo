package com.lq.user.dao.dao;

import com.lq.user.domain.User;

public interface UserDAO {
	public boolean register(User u);//ע��
	
	public User logincheck(String uaccount,String upassword);//��֤�˺�������ȷ��
	public boolean login(String uaccount,String upassword);//��ʽ��½
	
	public User queryById(String id);//��id��
	public boolean update(String id,String pasword);//�޸�����
	//ajax ����ֵΪ User
	public User queryByAccount(String uaccount);
	boolean updateByEmail(String email, String password);
	public boolean checkByAccount(String uaccount);//����˺�
	public String getCid(String uid);
	public String getCname(String uid);
}
