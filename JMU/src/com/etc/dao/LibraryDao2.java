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
			// 1 ��������
			Class.forName("com.mysql.jdbc.Driver");
			// 2 �������ӣ�������Ӷ���
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3308/user?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true", "root", "password");

			// 3 ͨ�����Ӷ��󣬻��ִ��������
			psm = conn
					.prepareStatement("update Liborrow set days=? where bno=?");
			// ��psm�е�ռλ����ֵ
			psm.setInt(1, lib.getDays());
			psm.setInt(2, lib.getBno());
			// 4 ִ����䣨���£��� ɾ �ģ��õ����� Ӱ������
			int count = psm.executeUpdate();
			// System.out.println("count:" + count);
			return count > 0;
			// 5 �ر���Դ
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
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
