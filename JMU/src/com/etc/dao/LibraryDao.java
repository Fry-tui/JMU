package com.etc.dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.entity.Library;
//import com.etc.entity.Sbb;
import com.etc.util.JDBCUtil;

public class LibraryDao {
	public List<Library>  findAllLibrary(){
		List<Library> list = new ArrayList<Library>();
		ResultSet rs = JDBCUtil
				.doQuery("select bno,bname,data from libhistory");
		try {
			while (rs.next()) {

				list.add(new Library(rs.getInt("bno"), rs.getString("bname"),
						rs.getString("data")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.free(rs);

		}

		return list;


    }
}
