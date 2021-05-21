package com.etc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.etc.entity.Admin;
import com.etc.entity.Student;
//"jdbc:mysql://127.0.0.1:3308/user?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true", "root", "password"
public class AdminDao {
	Connection con = null;
	PreparedStatement psm = null;
	ResultSet rs = null;
	
	public String login(int ano,String apwd){
		try {//"jdbc:mysql://127.0.0.1:3308/user?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true", "root", "password"
			Class.forName("com.mysql.jdbc.Driver");//"jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true", "root", "123456"
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/user?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true", "root", "password");
			psm = con.prepareStatement("select ano,aname,apwd from Admin where ano = ? and apwd = ?");
			psm.setInt(1, ano);
			psm.setString(2, apwd);
			rs = psm.executeQuery();
			//为什么条件时next
			if(rs.next()){
				return rs.getString("aname");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs != null)
					rs.close();
				if(psm != null)
					psm.close();
				if(con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return null;
	}
	
	public boolean addAdmin(Admin adm){
		Connection con = null;
		PreparedStatement psm = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/user?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true", "root", "password");
			psm = con.prepareStatement("Insert into Admin(ano,aname,apwd) values (?,?,?)");
			psm.setInt(1, adm.getAno());
			psm.setString(2, adm.getAname());
			psm.setString(3,adm.getApwd());
			
			int count = psm.executeUpdate();
			
			return count>0;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(psm != null)
					psm.close();
				if(con!=null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}
	
	
	public boolean compareAno(int ano) {
		Connection con = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/user?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true", "root", "password");
			psm = con.prepareStatement("select ano from admin where ano = ?");
			psm.setInt(1, ano);
			rs = psm.executeQuery();
			while(rs.next()){
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs !=null)
					rs.close();
				if(psm!=null)
					psm.close();
				if(con!=null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}
}
