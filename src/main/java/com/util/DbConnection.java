package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 	20220819 작성자 이경용
 	디비 연결하는 클래스
  
 */
public class DbConnection { //디비 연결하는 클래스

	private static String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:XE";
	private static String uid = "gjai_5_5_0822";
	private static String pwd = "smhrd5";
	
	// 카넥션 얻어오기
		public static Connection getConnection() {
			Connection conn = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, uid, pwd);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return conn;
		}
		
		//read용
		public static void close(Connection conn, PreparedStatement pstmt,
				ResultSet rset) {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		
		//cud용
		public static void close(Connection conn, PreparedStatement pstmt) {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		
}
