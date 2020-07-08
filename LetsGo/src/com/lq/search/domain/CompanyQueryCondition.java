package com.lq.search.domain;

public class CompanyQueryCondition {
	private String kd;
	private  int spc;
	private int lc;
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
	private String city;
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
