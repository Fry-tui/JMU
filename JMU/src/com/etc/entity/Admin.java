package com.etc.entity;

public class Admin {
	private int ano;
	private String aname;
	private String apwd;
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	public Admin(int ano, String aname, String apwd) {
		super();
		this.ano = ano;
		this.aname = aname;
		this.apwd = apwd;
	}
	public Admin() {
		super();
	}
	@Override
	public String toString() {
		return "Admin [ano=" + ano + ", aname=" + aname + ", apwd=" + apwd
				+ "]";
	}
	
	
}
