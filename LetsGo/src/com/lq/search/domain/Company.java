package com.lq.search.domain;

public class Company {
    private String cid;
    private String uid;
    private String cname;
	private String csite;//公司网站
	private String ccity;
	private String cfield;
	private String clarge;
	private String cdevelop;
	private String cinvest;
    private String cdescribe;
    private Position position;
	
	
	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	/**
	 * @return the cid
	 */
	public String getCid() {
		return cid;
	}
	/**
	 * @param cid the cid to set
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}
	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}
	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}
	/**
	 * @return the csite
	 */
	public String getCsite() {
		return csite;
	}
	/**
	 * @param csite the csite to set
	 */
	public void setCsite(String csite) {
		this.csite = csite;
	}
	/**
	 * @return the ccity
	 */
	public String getCcity() {
		return ccity;
	}
	/**
	 * @param ccity the ccity to set
	 */
	public void setCcity(String ccity) {
		this.ccity = ccity;
	}
	/**
	 * @return the cfield
	 */
	public String getCfield() {
		return cfield;
	}
	/**
	 * @param cfield the cfield to set
	 */
	public void setCfield(String cfield) {
		this.cfield = cfield;
	}
	/**
	 * @return the clarge
	 */
	public String getClarge() {
		return clarge;
	}
	/**
	 * @param clarge the clarge to set
	 */
	public void setClarge(String clarge) {
		this.clarge = clarge;
	}
	/**
	 * @return the cdevelop
	 */
	public String getCdevelop() {
		return cdevelop;
	}
	/**
	 * @param cdevelop the cdevelop to set
	 */
	public void setCdevelop(String cdevelop) {
		this.cdevelop = cdevelop;
	}
	/**
	 * @return the cinvest
	 */
	public String getCinvest() {
		return cinvest;
	}
	/**
	 * @param cinvest the cinvest to set
	 */
	public void setCinvest(String cinvest) {
		this.cinvest = cinvest;
	}
	/**
	 * @return the cdescribe
	 */
	public String getCdescribe() {
		return cdescribe;
	}
	/**
	 * @param cdescribe the cdescribe to set
	 */
	public void setCdescribe(String cdescribe) {
		this.cdescribe = cdescribe;
	}
	
}
