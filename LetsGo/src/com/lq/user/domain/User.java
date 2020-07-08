package com.lq.user.domain;

public class User {
   private String  id    ;
   private String  uaccount   ;
   private String  upassword  ;
   private String  uname  ;
   private String  usex ;
   private String  udegree ;
   private String  uworkexp;
   private String  utel;
   private  int    authority ;
   
   
public String getUtel() {
	return utel;
}
public void setUtel(String utel) {
	this.utel = utel;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getUaccount() {
	return uaccount;
}
public void setUaccount(String uaccount) {
	this.uaccount = uaccount;
}
public String getUpassword() {
	return upassword;
}
public void setUpassword(String upassword) {
	this.upassword = upassword;
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
public int getAuthority() {
	return authority;
}
public void setAuthority(int authority) {
	this.authority = authority;
}
   
   
}
