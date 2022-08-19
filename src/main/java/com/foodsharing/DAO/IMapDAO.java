package com.foodsharing.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.foodshring.VO.MapVO;
import com.util.DbConnection;

public class IMapDAO {
	
	  private IMapDAO() {
		  
	  }
	  
	 private static IMapDAO instance = new IMapDAO();
	 
	  public static IMapDAO getInstance() {
		    return instance;
	  }
	  
	  
	  //insert 지도
	  public void insertMap(MapVO mapVO) {
		    String sql = "";
		    
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    
		    try {
		      conn = DbConnection.getConnection();
		      pstmt = conn.prepareStatement(sql);
		      pstmt.executeUpdate();
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		    	DbConnection.close(conn, pstmt);
		    }
		  }
	  
	  
	  //list 지도
	 public ArrayList<MapVO> listMap(String userId) {
		    ArrayList<MapVO> cartList = new ArrayList<MapVO>();    
		    String sql = "";
		    
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    
		    try {
		      conn = DbConnection.getConnection();
		      pstmt = conn.prepareStatement(sql);
		      pstmt.setString(1, userId);
		      rs = pstmt.executeQuery();
		      while (rs.next()) {
		    	  MapVO mv = new MapVO();
		        
		        cartList.add(mv);
		      }
		    } catch (Exception e) {
		      e.printStackTrace();
		    }finally {
		    	DbConnection.close(conn, pstmt, rs);
		    }
		    return cartList;
		  }

	 
	  //Delete 지도
		  public void deleteMap(int cseq) {
		    String sql = "";
		    
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    
		    try {
		      conn = DbConnection.getConnection();
		      pstmt = conn.prepareStatement(sql);
		      pstmt.setInt(1, cseq);
		      pstmt.executeUpdate();
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		    	DbConnection.close(conn, pstmt);
		    }
		}
}
