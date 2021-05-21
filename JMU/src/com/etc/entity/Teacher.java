package com.etc.entity;

public class Teacher {
	private int tno;
	private String tname;
	private int tage;
	private String tpwd;
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getTage() {
		return tage;
	}
	public void setTage(int tage) {
		this.tage = tage;
	}
	public String getTpwd() {
		return tpwd;
	}
	public void setTpwd(String tpwd) {
		this.tpwd = tpwd;
	}
	public Teacher(int tno, String tname, int tage, String tpwd) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.tage = tage;
		this.tpwd = tpwd;
	}
	public Teacher() {
		super();
	}
	@Override
	public String toString() {
		return "Teacher [tno=" + tno + ", tname=" + tname + ", tage=" + tage
				+ ", tpwd=" + tpwd + "]";
	}
	
	
}
