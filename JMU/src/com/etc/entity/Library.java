package com.etc.entity;

public class Library {
	private int bno;
	private String bname;
	private String data;
	
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
	public String getData() {
		return data;
	}
	public void setData(int days) {
		this.data = data;
	}
	public Library(int bno, String bname, String data) {
		super();
		this.bno = bno;
		this.bname = bname;
		this.data = data;
	}
	public Library() {
		super();
	}
	@Override
	public String toString() {
		return "Library [bno=" + bno + ", bname=" + bname + ", data=" + data
				+ "]";
	}
	
	
	
	

}
