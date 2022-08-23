package com.foodsharing.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.foodshring.VO.t_reviewVO;

public class t_reviewDAO {

	// DAO - 데이터베이스의 data에 접근하기 위한 객체이며
	// 데이터베이스 접근을 하기위한 로직과 비즈니스 로직을 분리하기 위해 사용한다.
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	ArrayList<t_reviewVO> list = new ArrayList<t_reviewVO>();
	t_reviewVO vo = null;
	int cnt = 0;

	// db연결하는 공통적인 부분 만들어줘서 필요할때는 getConn(); 써서 기능만 쓰기
	public void getConn() {
		try {
			// 예외처리
			// 클래스파일 찾는거 ( Servlet 과 DB를 바로 연결할수가없어서 중간에 class파일 하나가 있어야한다)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 동적로딩

			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";

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
}
