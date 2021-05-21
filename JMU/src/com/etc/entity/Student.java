package com.etc.entity;

public class Student {
	private int sno;
	private String sname;
	private String spwd;
	private int sage;
	private int flower;
	private String Birthday;
	private String stn;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSpwd() {
		return spwd;
	}
	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public int getFlower() {
		return flower;
	}
	public void setFlower(int flower) {
		this.flower = flower;
	}
	public String getBirthday() {
		return Birthday;
	}
	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
	public String getStn() {
		return stn;
	}
	public void setStn(String stn) {
		this.stn = stn;
	}
	public Student(int sno, String sname, String spwd, int sage, int flower,
			String birthday, String stn) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.spwd = spwd;
		this.sage = sage;
		this.flower = flower;
		Birthday = birthday;
		this.stn = stn;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", spwd=" + spwd
				+ ", sage=" + sage + ", flower=" + flower + ", Birthday="
				+ Birthday + ", stn=" + stn + "]";
	}
	
	
}
