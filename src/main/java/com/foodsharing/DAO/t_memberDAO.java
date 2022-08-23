package com.foodsharing.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.foodshring.VO.t_memberVO;

public class t_memberDAO {

	// DAO - 데이터베이스의 data에 접근하기 위한 객체이며
	// 데이터베이스 접근을 하기위한 로직과 비즈니스 로직을 분리하기 위해 사용한다.
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	ArrayList<t_memberDAO> list = new ArrayList<t_memberDAO>();
	t_memberVO vo = null;
	int cnt = 0;

	// db연결하는 공통적인 부분 만들어줘서 필요할때는 getConn(); 써서 기능만 쓰기
	public void getConn() {
		try {
			// 예외처리
			// 클래스파일 찾는거 ( Servlet 과 DB를 바로 연결할수가없어서 중간에 class파일 하나가 있어야한다)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 동적로딩

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String dbid = "gjai_5_5_0822";
			String dbpw = "smhrd5";

			// DB연결
			// DB에 연결시키는거 DB주소 dbid dbpw 써줘야함
			conn = DriverManager.getConnection(url, dbid, dbpw);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 연결끊는 공통적인 부분 만들어줘서 필요할때는 close(); 써서 기능만 쓰기
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public int Join(String mbId, String mbPw, String mbName, String mbPhone, String mbBirthdate, String mbGender,
			String mbGubun, String mbAddr, String mbJoindate, String adminYn) {

		try {
			getConn();
			String sql = "INSERT INTO t_member VALUES(?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?)";
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mbId);
			psmt.setString(2, mbPw);
			psmt.setString(3, mbName);
			psmt.setString(4, mbPhone);
			psmt.setString(5, mbBirthdate);
			psmt.setString(6, mbGender);
			psmt.setString(7, mbGubun);
			psmt.setString(8, mbAddr);
			psmt.setString(9, adminYn);
			// SQL준비

			cnt = psmt.executeUpdate();
			// SQL실행

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close();
		}
		return cnt;

	}

	public t_memberVO Login(String mbId, String mbPw) {
		try {
			getConn();
			String sql = "select * from t_member where mb_id = ? and mb_pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mbId);
			psmt.setString(2, mbPw);
			
			// SQL준비
			rs = psmt.executeQuery();
			// SQL실행
			if (rs.next()) {
			
				String getId = rs.getString(1);// id
				String getPw = rs.getString(2);// pw
				String getName = rs.getString(3);// id
				String getPhone = rs.getString(4);// pw
				String getBirthdate = rs.getString(5);// id
				String getGender = rs.getString(6);// pw
				String getGubun = rs.getString(7);// id
				String getAddr = rs.getString(8);// pw
				String getJoindate = rs.getString(9);// id
				String getAdminYn = rs.getString(10);// pw

				vo = new t_memberVO(getId, getPw, getName, getPhone, getBirthdate, getGender, getGubun, getAddr, getJoindate, getAdminYn);

			} else {
				System.out.println("로그인실패"); 
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();

		}
		return vo;
	
	}
}

