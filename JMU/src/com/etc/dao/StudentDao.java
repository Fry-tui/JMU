package com.etc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.entity.Student;
import com.sun.org.apache.regexp.internal.recompile;


public class StudentDao {
	//登入操作 		返回值为查询到的用户名	传入参数学号密码	
	public String login(int sno,String spwd) {
		Connection con = null;//创建连接
		PreparedStatement psm = null;//查询的预结果
		ResultSet rs = null;//存放结果集
		
		try {
			//1加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2创建连接 获得链接对象
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/user?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true", "root", "password");
			//3通过连接对象，获得执行语句   执行:查询表中的  学号与密码  和 传入参数 相符之人
			psm = con.prepareStatement("select sno,sname from Student where sno=? and spwd=?");
			//给执行语句中的sql语句的占位赋值，从一开始
			psm.setInt(1, sno);
			psm.setString(2, spwd);
			
			rs = psm.executeQuery();
			//将查询的到的结果存放于结果集中
			
			//出结果
			if(rs.next()){
				return rs.getString("sname");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//比执行:关闭资源
			
			try {
				if(rs  != null)
					rs.close();
				if(psm != null)
					psm.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public List<Student> findAllStudent(){
		List<Student> list = new ArrayList<Student>();

		Connection con = null;//创建连接
		PreparedStatement psm = null;//查询的预结果
		ResultSet rs = null;//存放结果集
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/user?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true", "root", "password");
			psm = con.prepareStatement("select * from Student");
			rs = psm.executeQuery();
			
			while(rs.next()){
				Student stu = new Student();
				stu.setSno(rs.getInt("sno"));
				stu.setSname(rs.getString("sname"));
				stu.setSage(rs.getInt("sage"));
				stu.setSpwd(rs.getString("spwd"));
				stu.setFlower(rs.getInt("flower"));
				stu.setStn(rs.getString("stn"));
				stu.setBirthday(rs.getString("birthday"));
				list.add(stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//比执行:关闭资源
			
			try {
				if(rs  != null)
					rs.close();
				if(psm != null)
					psm.close();
				if(con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	//公用的访问     返回 类型为Student 函数名findStudentBySno  传入参数sno
	public Student findStudentBySno(int sno){
		Connection con = null;//创建连接
		PreparedStatement psm = null;//查询的预结果
		ResultSet rs = null;//存放结果集
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/user?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true", "root", "password");
			psm = con.prepareStatement("select sno,sname,spwd,sage,stn,flower,birthday from Student where sno = ?");
			psm.setInt(1, sno);
			
			rs = psm.executeQuery();
			//用于返回
			Student stu = null;
			
			while(rs.next()){
				stu = new Student();
				stu.setSno(rs.getInt("sno"));
				stu.setSage(rs.getInt("sage"));
				stu.setStn(rs.getString("stn"));
				stu.setSpwd(rs.getString("spwd"));
				stu.setFlower(rs.getInt("flower"));
				stu.setSname(rs.getString("sname"));
				stu.setBirthday(rs.getString("birthday"));
			}
			return stu;
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
	
	public boolean addStudent(Student stu){
		Connection con = null;
		PreparedStatement psm = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/user?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true", "root", "password");
			psm = con.prepareStatement("Insert into Student(sno,sname,spwd,sage,flower,birthday,stn) values (?,?,?,?,?,?,?)");
			psm.setInt(1, stu.getSno());
			psm.setString(2, stu.getSname());
			psm.setString(3,stu.getSpwd());
			psm.setInt(4, stu.getSage());
			psm.setInt(5, stu.getFlower());
			psm.setString(6, stu.getBirthday());
			psm.setString(7, stu.getStn());
			
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
	
	
	public boolean deleteStudentBySno(int sno){
		Connection con = null;
		PreparedStatement psm = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/user?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true", "root", "password");
			psm = con.prepareStatement("delete from student where sno = ?");
			psm.setInt(1, sno);
			
			int count = psm.executeUpdate();
			return count>0;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
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
	
	public boolean compareSno(int sno) {
		Connection con = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/user?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true", "root", "password");
			psm = con.prepareStatement("select sno from student where sno = ?");
			psm.setInt(1, sno);
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
	
	
	public boolean modifyStudent(Student stu) {

		Connection conn = null;
		PreparedStatement psm = null;
		try {
			// 1 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2 创建连接，获得连接对象
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/user?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true", "root", "password");

			// 3 通过连接对象，获得执行语句对象
			psm = conn
					.prepareStatement("update student set spwd=?,stn=? where sno=?");
			// 给psm中的占位，设值
			psm.setString(1, stu.getSpwd());
			psm.setString(2, stu.getStn());
			psm.setInt(3, stu.getSno());
			// 4 执行语句（更新：增 删 改）得到的是 影响行数
			int count = psm.executeUpdate();
			// System.out.println("count:" + count);
			return count > 0;
			// 5 关闭资源
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			try {
				if (psm != null)
					psm.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return false;

	}

	public boolean modifyStudent1(Student stu) {

		Connection conn = null;
		PreparedStatement psm = null;
		try {
			// 1 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2 创建连接，获得连接对象
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/user?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true", "root", "password");

			// 3 通过连接对象，获得执行语句对象
			psm = conn
					.prepareStatement("update student set spwd=?,sname=?,flower=? where sno=?");
			// 给psm中的占位，设值
			psm.setString(1, stu.getSpwd());
			psm.setString(2, stu.getSname());
			psm.setInt(3, stu.getFlower());
			psm.setInt(4, stu.getSno());
			// 4 执行语句（更新：增 删 改）得到的是 影响行数
			int count = psm.executeUpdate();
			// System.out.println("count:" + count);
			return count > 0;
			// 5 关闭资源
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			try {
				if (psm != null)
					psm.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return false;

	}

	
	public static void main(String[] args) {
		StudentDao sdao = new StudentDao();
		List<Student> list = sdao.findAllStudent();
		System.out.println(list);
		//sdao.login();
		Student stu1 = new Student(113,"许玉泉","113",20,5,"2000-02-19","18950238926");
		sdao.addStudent(stu1);
		System.out.println(sdao.findAllStudent());
		//sdao.deleteStudentBySno(113);
		System.out.println(list);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
