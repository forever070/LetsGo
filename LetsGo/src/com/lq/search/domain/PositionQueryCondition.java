package com.lq.search.domain;


public class PositionQueryCondition {
	private String kd;//输入框里面的�?
	private int spc;
	private String ptype;
	private String pl;
	private String gj;//工作经验
	private String xl;//学历
	private String yx;//月薪范围
	private String gx;//工作性质
	private String st;//发布时间
	private String labelWords;//是否在list页面搜索，不是的话null	
	private int lc;//选择有城市的话为1，否则为null
	private String workAddress;	
	private String city;//工作城市
	
	/**
	 * @return the ptype
	 */
	public String getPtype() {
		return ptype;
	}
	/**
	 * @param ptype the ptype to set
	 */
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	/**
	 * @return the kd
	 */
	public String getKd() {
		return kd;
	}
	/**
	 * @param kd the kd to set
	 */
	public void setKd(String kd) {
		this.kd = kd;
	}
	/**
	 * @return the spc
	 */
	public int getSpc() {
		return spc;
	}
	/**
	 * @param spc the spc to set
	 */
	public void setSpc(int spc) {
		this.spc = spc;
	}
	/**
	 * @return the pl
	 */
	public String getPl() {
		return pl;
	}
	/**
	 * @param pl the pl to set
	 */
	public void setPl(String pl) {
		this.pl = pl;
	}
	/**
	 * @return the gj
	 */
	public String getGj() {
		return gj;
	}
	/**
	 * @param gj the gj to set
	 */
	public void setGj(String gj) {
		this.gj = gj;
	}
	/**
	 * @return the xl
	 */
	public String getXl() {
		return xl;
	}
	/**
	 * @param xl the xl to set
	 */
	public void setXl(String xl) {
		this.xl = xl;
	}
	/**
	 * @return the yx
	 */
	public String getYx() {
		return yx;
	}
	/**
	 * @param yx the yx to set
	 */
	public void setYx(String yx) {
		this.yx = yx;
	}
	/**
	 * @return the gx
	 */
	public String getGx() {
		return gx;
	}
	/**
	 * @param gx the gx to set
	 */
	public void setGx(String gx) {
		this.gx = gx;
	}
	/**
	 * @return the st
	 */
	public String getSt() {
		return st;
	}
	/**
	 * @param st the st to set
	 */
	public void setSt(String st) {
		this.st = st;
	}
	/**
	 * @return the labelWords
	 */
	public String getLabelWords() {
		return labelWords;
	}
	/**
	 * @param labelWords the labelWords to set
	 */
	public void setLabelWords(String labelWords) {
		this.labelWords = labelWords;
	}
	/**
	 * @return the lc
	 */
	public int getLc() {
		return lc;
	}
	/**
	 * @param lc the lc to set
	 */
	public void setLc(int lc) {
		this.lc = lc;
	}
	/**
	 * @return the workAddress
	 */
	public String getWorkAddress() {
		return workAddress;
	}
	/**
	 * @param workAddress the workAddress to set
	 */
	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	

}
