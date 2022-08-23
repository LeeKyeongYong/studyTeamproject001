package com.foodsharing.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.foodshring.VO.t_communittyVO;
import com.util.DbConnection;

public class t_communittyDAO {

	private static t_communittyDAO instance = new t_communittyDAO();
	 
	public t_communittyDAO() {}
	
	public static t_communittyDAO getInstance() {
		    return instance;
	}
	
	//게시판 리스트
	
	// 리스트
		  public ArrayList<t_communittyVO> listCommunitty() {
		    ArrayList<t_communittyVO> productList = new ArrayList<t_communittyVO>();
		    String sql = "select article_seq,article_title,article_content,article_file,article_date,u_name(mb_id) AS mb_id from t_community";
		    
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    
		    try {
		      conn = DbConnection.getConnection();
		      pstmt = conn.prepareStatement(sql);
		      rs = pstmt.executeQuery();
		      while (rs.next()) {
		    	  t_communittyVO communitty = new t_communittyVO();
		    	    communitty.setArticleSeq(String.valueOf(rs.getInt("article_seq")));
		    	    communitty.setArticleTitle(rs.getString("article_title"));
		    	    communitty.setArticleContent(rs.getString("article_content"));
		    	    communitty.setArticleFile(rs.getString("article_file"));
		    	    communitty.setArticleDate(String.valueOf(rs.getDate("article_date")));
					communitty.setMbId(rs.getString("mb_id"));
		    	  productList.add(communitty);
		      }
		    } catch (Exception e) {
		    	System.err.println("listFarmer 게시판 오류입니다.\n오류메세지는: "+e.getMessage());
		    } finally {
		    	DbConnection.close(conn, pstmt, rs);
		    }
		    return productList;
		  }
	
	
	//게시판 insert
		  public int insertcommunitty(t_communittyVO communittyVO) {
			    String sql="";
			    
			    if(!"".equals(communittyVO.getArticleFile())) {
			    sql = "insert into t_community(article_seq,article_title,article_content,article_file,article_date,mb_id)values(t_community_seq.nextval"
			    		+ ",?,?,?,sysdate,?)";
			    } else {
			    	  sql = "insert into t_community(article_seq,article_title,article_content,article_date,mb_id)values(t_community_seq.nextval"
					    		+ ",?,?,sysdate,?)";	
			    }
			    Connection conn = null;
			    PreparedStatement pstmt = null;
			    int cnt=0;
			    try {
			      conn = DbConnection.getConnection();
			      pstmt = conn.prepareStatement(sql);
			      pstmt.setString(1,communittyVO.getArticleTitle());
			      pstmt.setString(2,communittyVO.getArticleContent());
			     
			      if(!"".equals(communittyVO.getArticleFile())) {
			    	  pstmt.setString(3,communittyVO.getArticleFile());
			    	  pstmt.setString(4,communittyVO.getMbId());
			      } else {
			    	  pstmt.setString(3,communittyVO.getMbId());
			      }
			      
			      cnt=pstmt.executeUpdate();
			    } catch (Exception e) {
			      System.err.println("insert 게시판 오류입니다.\n오류메세지는: "+e.getMessage());
			    } finally {
			      DbConnection.close(conn, pstmt);
			    }
			    return cnt;
		  }
		  
		//단일 Select
		  public t_communittyVO get_communittyVO(String articleSeq) {
			  t_communittyVO communitty = null;
			    String sql = "select article_seq,article_title,article_content,article_file,article_date,u_name(mb_id) AS mb_id from t_community where article_seq = ?";
			    Connection conn = null;
			    PreparedStatement pstmt = null;
			    ResultSet rs = null;
			    try {
			      conn = DbConnection.getConnection();
			      pstmt = conn.prepareStatement(sql);
			      pstmt.setString(1, articleSeq);
			      rs = pstmt.executeQuery();
			      if (rs.next()) {
			    	  communitty = new t_communittyVO();
			    	  communitty.setArticleSeq(String.valueOf(rs.getInt("article_seq")));
			    	  communitty.setArticleTitle(rs.getString("article_title"));
			    	  communitty.setArticleContent(rs.getString("article_content"));
			    	  communitty.setArticleFile(rs.getString("article_file"));
			    	  communitty.setArticleDate(String.valueOf(rs.getDate("article_date")));
					  communitty.setMbId(rs.getString("mb_id"));
			      }
			    } catch (Exception e) {
			      e.printStackTrace();
			    } finally {
			    	DbConnection.close(conn, pstmt);
			    }
			    return communitty;
		}
	//게시판 update
		  public int updatecommunitty(t_communittyVO communittyVO) {
			    String sql="";
			    
			    if(!"".equals(communittyVO.getArticleFile())) {
			    	   sql = "update t_community set"
			    		+ "article_title = ?"
			    		+ ",article_content = ?"
			    		+ ",article_file = ?"
			    		+ ",article_date = sysdate "
			    		+ "where article_seq=?"
			    		+ "and mb_id = ?";
			    } else {
			    	sql = "update t_community set"
				    		+ "article_title = ?"
				    		+ ",article_content = ?"
				    		+ ",article_date = sysdate "
				    		+ "where article_seq=?"
				    		+ "and mb_id = ?";
			    }
			    Connection conn = null;
			    PreparedStatement pstmt = null;
			    int cnt=0;
			    try {
			      conn = DbConnection.getConnection();
			      pstmt = conn.prepareStatement(sql);
			      pstmt.setString(1,communittyVO.getArticleTitle());
			      pstmt.setString(2,communittyVO.getArticleContent());
			      if(!"".equals(communittyVO.getArticleFile())) {
				      pstmt.setString(3,communittyVO.getArticleFile());
				      pstmt.setString(4,communittyVO.getArticleSeq());
				      pstmt.setString(5,communittyVO.getMbId());
			      } else {
				      pstmt.setString(3,communittyVO.getArticleSeq());
				      pstmt.setString(4,communittyVO.getMbId());
			      }
			      cnt=pstmt.executeUpdate();
			    } catch (Exception e) {
			      System.err.println("update 게시판 오류입니다.\n오류메세지는: "+e.getMessage());
			    } finally {
			      DbConnection.close(conn, pstmt);
			    }
			    return cnt;
		  }	
		  
		  
	//게시판 Delete
		  public int Deletecommunitty(t_communittyVO communittyVO) {
			    String sql = "delete from t_community where article_seq=? and mb_id = ?";
			    Connection conn = null;
			    PreparedStatement pstmt = null;
			    int cnt=0;
			    try {
			      conn = DbConnection.getConnection();
			      pstmt = conn.prepareStatement(sql);
			      pstmt.setString(1,communittyVO.getArticleTitle());
			      pstmt.setString(2,communittyVO.getArticleContent());
			      pstmt.setString(3,communittyVO.getArticleFile());
			      pstmt.setString(4,communittyVO.getArticleSeq());
			      pstmt.setString(5,communittyVO.getMbId());
			      cnt=pstmt.executeUpdate();
			    } catch (Exception e) {
			      System.err.println("update 게시판 오류입니다.\n오류메세지는: "+e.getMessage());
			    } finally {
			      DbConnection.close(conn, pstmt);
			    }
			    return cnt;
		  }	
	
}
