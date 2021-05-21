package com.etc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC������
 * 
 * @author Administrator
 * 
 */
public class JDBCUtil {
	// ��̬����
	//jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true", "root", "123456"
	//"jdbc:mysql://127.0.0.1:3308/user?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true", "root", "password"
	private static final String URL = "jdbc:mysql://127.0.0.1:3308/user?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true";
	private static final String USER_NAME = "root";
	private static final String USER_PWD = "password";
	private static final String CLASS_NAME = "com.mysql.jdbc.Driver";

	/**
	 * ��ȡ���ݿ�����
	 * 
	 * @return
	 */
	private static Connection getConnection() {
		Connection conn = null;
		try {
			// ��������
			Class.forName(CLASS_NAME);
			// ��ȡ����
			conn = DriverManager.getConnection(URL, USER_NAME, USER_PWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
 
	/**
	 * ��ѯ�Ĺ��߷���
	 * 
	 * @param sql
	 *            Ҫִ�е����
	 * @param args
	 *            Ҫ���õĲ���
	 * @return ��ѯ���Ľ����
	 */
	public static ResultSet doQuery(String sql, Object... args) {
		// public static ResultSet doQuery(String sql, String[] args) {
		Connection conn = getConnection();
		// �ж��Ƿ����ӳɹ�
		if (conn == null) {
			return null;
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// args.length > 0�д���������Ҫ���ò���
			if (args != null && args.length > 0) {
				for (int i = 0; i < args.length; i++) {
					pstmt.setObject(i + 1, args[i]);
				}
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// finally {
		// free(conn, pstmt, rs);
		// }
		// �Ȳ��ر����ӣ��ڵ��õĵط��ر�
		return rs;
	}

	/**
	 * ���µĹ��߷���
	 * 
	 * @param sql
	 *            Ҫִ�е����
	 * @param args
	 *            Ҫ���õĲ���
	 * @return ��Ӱ�������
	 */
	public static int doUpdate(String sql, Object... args) {
		Connection conn = getConnection();
		int result = -1;
		// �ж��Ƿ����ӳɹ�
		if (conn == null) {
			return result;
		}
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// args.length > 0�д���������Ҫ���ò���
			if (args != null && args.length > 0) {
				for (int i = 0; i < args.length; i++) {
					pstmt.setObject(i + 1, args[i]);
				}
			}
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// free(conn, pstmt, null);
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}
		return result;
	}

	/**
	 * �ر�����
	 * 
	 * @param conn
	 * @param stmt
	 * @param rs
	 * @throws SQLException
	 */
	public static void free(ResultSet rs) {
		Statement stmt = null;
		Connection conn = null;
		try {
			stmt = rs.getStatement();
			conn = stmt.getConnection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
public static void main(String[] args) {
	
}
/*	public static void main(String[] args) {

		ResultSet rs = JDBCUtil.doQuery("select * from t_user");
		try {
			if (rs.next()) {
				System.out.println(rs.getString(2));
			} else {
				System.out.println(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.free(rs);
		}
	}*/
}
