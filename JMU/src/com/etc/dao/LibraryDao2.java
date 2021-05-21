package com.etc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.entity.Library;
import com.etc.entity.Library2;
import com.etc.util.JDBCUtil;

public class LibraryDao2 {
	public List<Library>  findAllLibrary(){
		List<Library> list = new ArrayList<Library>();
		ResultSet rs = JDBCUtil
				.doQuery("select bno,bname,days from liborrow");
		try {
			while (rs.next()) {

				list.add(new Library(rs.getInt("bno"), rs.getString("bname"),
						rs.getString("days")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.free(rs);

		}

		return list;


    }
	
	public Library2 findLibraryByBno(int bno) {
		Library2 lib = null;
		ResultSet rs = JDBCUtil.doQuery(
				"select bno,bname,days from liborrow  where bno=?", bno);
		try {
			while (rs.next()) {

				lib = new Library2(rs.getInt("bno"), rs.getString("bname"),
						rs.getInt("days"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.free(rs);

		}

		return lib;
	}
	public boolean modifyLibrary2(Library2 lib) {

		Connection conn = null;
		PreparedStatement psm = null;
		try {
			// 1 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2 创建连接，获得连接对象
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/user?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true", "root", "password");

			// 3 通过连接对象，获得执行语句对象
			psm = conn
					.prepareStatement("update Liborrow set days=? where bno=?");
			// 给psm中的占位，设值
			psm.setInt(1, lib.getDays());
			psm.setInt(2, lib.getBno());
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
	
}
