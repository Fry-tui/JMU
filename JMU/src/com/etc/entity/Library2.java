package com.etc.entity;

public class Library2 {

	private int bno;
	private String bname;
	private int days;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public Library2(int bno, String bname, int days) {
		super();
		this.bno = bno;
		this.bname = bname;
		this.days = days;
	}
	public Library2() {
		super();
	}
	@Override
	public String toString() {
		return "Library2 [bno=" + bno + ", bname=" + bname + ", days=" + days
				+ "]";
	}
	
	
}
