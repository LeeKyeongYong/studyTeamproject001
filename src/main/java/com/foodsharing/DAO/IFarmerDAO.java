package com.foodsharing.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.foodshring.VO.FarmerVO;
import com.util.DbConnection;

public class IFarmerDAO {

	private IFarmerDAO() {}
	private static IFarmerDAO instance = new IFarmerDAO();
	public static IFarmerDAO getInstance() {
		return instance;
	}
	
	// 리스트
	  public ArrayList<FarmerVO> listFarmer() {
	    ArrayList<FarmerVO> productList = new ArrayList<FarmerVO>();
	    String sql = "select * from farmertb";
	    
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    
	    try {
	      conn = DbConnection.getConnection();
	      pstmt = conn.prepareStatement(sql);
	      rs = pstmt.executeQuery();
	      while (rs.next()) {
	    	  FarmerVO product = new FarmerVO();
	    	  product.setFarmerseq(rs.getString("farmerseq"));
	    	  product.setProduct(rs.getString("product"));
	    	  product.setPrice(rs.getString("price"));
	    	  product.setEndDay(rs.getString("endday"));
	    	  product.setEndTime(rs.getString("endtime"));
	    	  product.setCategory(rs.getString("category"));
	    	  product.setPhoto(rs.getString("photo"));
	    	  product.settEmail(rs.getString("temail"));
	    	  product.setStateaddr(rs.getString("stateaddr"));
	    	  product.setRegDate(rs.getString("regdate"));
	    	  product.setMemberCount(rs.getString("membercount"));
	    	  product.setBoxCount(rs.getString("boxcount"));
	    	  product.setpDetails(rs.getString("pdetails"));
	    	  productList.add(product);
	      }
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	    	DbConnection.close(conn, pstmt, rs);
	    }
	    return productList;
	  }
	  
	  public FarmerVO getFarmerVO(String farmerseq) {
		  FarmerVO product = null;
		    String sql = "select * from farmertb where farmerseq=?";
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    try {
		      conn = DbConnection.getConnection();
		      pstmt = conn.prepareStatement(sql);
		      pstmt.setString(1, farmerseq);
		      rs = pstmt.executeQuery();
		      if (rs.next()) {
		    	  product = new FarmerVO();
		    	  product.setFarmerseq(rs.getString("farmerseq"));
		    	  product.setFarmerseq(rs.getString("farmerseq"));
		    	  product.setProduct(rs.getString("product"));
		    	  product.setPrice(rs.getString("price"));
		    	  product.setEndDay(rs.getString("endday"));
		    	  product.setEndTime(rs.getString("endtime"));
		    	  product.setCategory(rs.getString("category"));
		    	  product.setPhoto(rs.getString("photo"));
		    	  product.settEmail(rs.getString("temail"));
		    	  product.setStateaddr(rs.getString("stateaddr"));
		    	  product.setRegDate(rs.getString("regdate"));
		    	  product.setMemberCount(rs.getString("membercount"));
		    	  product.setBoxCount(rs.getString("boxcount"));
		    	  product.setpDetails(rs.getString("pdetails"));
		        /*
		        qnaVO.setQseq(seq);
		        qnaVO.setSubject(rs.getString("subject"));
		        qnaVO.setContent(rs.getString("content"));
		        qnaVO.setId(rs.getString("id"));
		        qnaVO.setIndate(rs.getTimestamp("indate"));
		        qnaVO.setReply(rs.getString("reply"));
		        qnaVO.setRep(rs.getString("rep"));
		        */
		      }
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		    	DbConnection.close(conn, pstmt);
		    }
		    return product;
		  }
	  
	  public int insertfarmer(FarmerVO farmerVO) {
		    String sql = "INSERT INTO farmertb(farmerseq,product,price,endDay,endTime,category,photo,temail,stateaddr,regDate,memberCount,boxCount,pdetails) "
		    		+ "values(farmertb_seq.NEXTVAL,?,"
		    		+ "	?,to_char(sysdate,'YYYYMMDD'),to_char(sysdate,'HH24:MI:SS'),?,"
		    		+ "?,?,?,to_char(sysdate,'YYYYMMDDHH24MISS'),?,?,?)";

		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    int cnt=0;
		    try {
		      conn = DbConnection.getConnection();
		      pstmt = conn.prepareStatement(sql);
		      pstmt.setString(1,farmerVO.getProduct());
		      pstmt.setString(2,farmerVO.getPrice());
		      pstmt.setString(3,farmerVO.getCategory());
		      pstmt.setString(4,farmerVO.getPhoto());
		      pstmt.setString(5,farmerVO.gettEmail());
		      pstmt.setString(6,farmerVO.getStateaddr());
		      pstmt.setString(7,farmerVO.getMemberCount());
		      pstmt.setString(8,farmerVO.getBoxCount());
		      pstmt.setString(9,farmerVO.getpDetails());
		      cnt=pstmt.executeUpdate();
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      DbConnection.close(conn, pstmt);
		    }
		    return cnt;
		  }

}
