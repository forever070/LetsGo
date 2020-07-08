package com.lq.search.domain;


public class Position {
    private String pid;
    private String cid;
	private String ptype;
	private String pname;
	private String pdept;
	private String pstate;
	private int pfromsalary;
	private int ptosalary;
	private String pcity;
	private String pexperience;
	private String pdegree;
	private String pgood;
	private String pdescribe;
	private String paddr;
	private int state;
	
	private Company company;
	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
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
	 * @return the state
	 */
	public int getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}
	/**
	 * @return the pid
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * @param pid the pid to set
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * @return the pfromsalary
	 */
	public int getPfromsalary() {
		return pfromsalary;
	}
	/**
	 * @param pfromsalary the pfromsalary to set
	 */
	public void setPfromsalary(int pfromsalary) {
		this.pfromsalary = pfromsalary;
	}
	/**
	 * @return the ptosalary
	 */
	public int getPtosalary() {
		return ptosalary;
	}
	/**
	 * @param ptosalary the ptosalary to set
	 */
	public void setPtosalary(int ptosalary) {
		this.ptosalary = ptosalary;
	}
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
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}
	/**
	 * @param pname the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}
	/**
	 * @return the pdept
	 */
	public String getPdept() {
		return pdept;
	}
	/**
	 * @param pdept the pdept to set
	 */
	public void setPdept(String pdept) {
		this.pdept = pdept;
	}
	
	/**
	 * @return the pstate
	 */
	public String getPstate() {
		return pstate;
	}
	/**
	 * @param pstate the pstate to set
	 */
	public void setPstate(String pstate) {
		this.pstate = pstate;
	}
	
	/**
	 * @return the pcity
	 */
	public String getPcity() {
		return pcity;
	}
	/**
	 * @param pcity the pcity to set
	 */
	public void setPcity(String pcity) {
		this.pcity = pcity;
	}
	/**
	 * @return the pexperience
	 */
	public String getPexperience() {
		return pexperience;
	}
	/**
	 * @param pexperience the pexperience to set
	 */
	public void setPexperience(String pexperience) {
		this.pexperience = pexperience;
	}
	/**
	 * @return the pdegree
	 */
	public String getPdegree() {
		return pdegree;
	}
	/**
	 * @param pdegree the pdegree to set
	 */
	public void setPdegree(String pdegree) {
		this.pdegree = pdegree;
	}
	/**
	 * @return the pgood
	 */
	public String getPgood() {
		return pgood;
	}
	/**
	 * @param pgood the pgood to set
	 */
	public void setPgood(String pgood) {
		this.pgood = pgood;
	}
	/**
	 * @return the pdescribe
	 */
	public String getPdescribe() {
		return pdescribe;
	}
	/**
	 * @param pdescribe the pdescribe to set
	 */
	public void setPdescribe(String pdescribe) {
		this.pdescribe = pdescribe;
	}
	/**
	 * @return the paddr
	 */
	public String getPaddr() {
		return paddr;
	}
	/**
	 * @param paddr the paddr to set
	 */
	public void setPaddr(String paddr) {
		this.paddr = paddr;
	}
	
}
