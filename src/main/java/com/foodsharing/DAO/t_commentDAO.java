package com.foodsharing.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.foodshring.VO.t_commentVO;
import com.foodshring.VO.t_communittyVO;
import com.util.DbConnection;

public class t_commentDAO {

	private static t_commentDAO instance = new t_commentDAO();
	public static final int comunity_per_page = 15; 
	public t_commentDAO() {}
	
	public static t_commentDAO getInstance() {
		    return instance;
	}

	public  ArrayList<t_commentVO> get_commentVO(String articleSeq) {
		ArrayList<t_commentVO> replies = new ArrayList<t_commentVO>();
		String sql = "select CMT_SEQ,ARTICLE_SEQ,CMT_CONTENT,CMT_DATE,u_name(mb_id) AS MB_ID from t_comment where ARTICLE_SEQ = ? order by CMT_SEQ asc";
	    
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	      conn = DbConnection.getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1,articleSeq);
	      rs = pstmt.executeQuery();
	      while (rs.next()) {
	    	  t_commentVO commentVO = new t_commentVO();
	    	  
	    	  commentVO.setCmtSeq(String.valueOf(rs.getInt("CMT_SEQ")));
	    	  commentVO.setArticleSeq(String.valueOf(rs.getInt("ARTICLE_SEQ")));
	    	  commentVO.setCmtContent(rs.getString("CMT_CONTENT"));
	    	  commentVO.setCmtDate(String.valueOf(rs.getDate("CMT_DATE")));
	    	  commentVO.setMbId(rs.getString("MB_ID"));
			  replies.add(commentVO);
	      }
	    } catch (Exception e) {
	    	System.err.println("get_commentVO 댓글 오류입니다.\n오류메세지는: "+e.getMessage());
	    } finally {
	    	DbConnection.close(conn, pstmt, rs);
	    }
	    return replies;
	}
	
	//게시판 insert
	  public int insertcommunitty(t_communittyVO communittyVO) {
		    String sql="";
		    
		    if(!"".equals(communittyVO.getArticleFile())) {
		    sql = "insert into t_community(article_seq,article_title,article_content,article_file,article_date,mb_id,reply)values(t_community_seq.nextval"
		    		+ ",?,?,?,sysdate,?,'0')";
		    } else {
		    	  sql = "insert into t_community(article_seq,article_title,article_content,article_date,mb_id)values(t_community_seq.nextval"
				    		+ ",?,?,sysdate,?,'0')";	
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
	  
	//댓글직접지울때
	  public int Deletecomment(String articleSeq,String cmtSeq,String mbId) {
		    String sql = "delete from t_comment where article_seq=? and cmt_seq =? and mb_id = ?";
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    int cnt=0;
		    try {
		      conn = DbConnection.getConnection();
		      pstmt = conn.prepareStatement(sql);
		      pstmt.setString(1,articleSeq);
		      pstmt.setString(2,cmtSeq);
		      pstmt.setString(3,mbId);
		      cnt=pstmt.executeUpdate();
		    } catch (Exception e) {
		      System.err.println("삭제 덧글 오류입니다.\n오류메세지는: "+e.getMessage());
		    } finally {
		      DbConnection.close(conn, pstmt);
		    }
		    return cnt;
	  }	
	  
	  //게시글을삭제할때
	  public int Deletecomment(String articleSeq,String mbId) {
		    String sql = "delete from t_comment where article_seq=? and mb_id = ?";
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    int cnt=0;
		    try {
		      conn = DbConnection.getConnection();
		      pstmt = conn.prepareStatement(sql);
		      pstmt.setString(1,articleSeq);
		      pstmt.setString(2,mbId);
		      cnt=pstmt.executeUpdate();
		    } catch (Exception e) {
		      System.err.println("삭제 덧글 오류입니다.\n오류메세지는: "+e.getMessage());
		    } finally {
		      DbConnection.close(conn, pstmt);
		    }
		    return cnt;
	  }	
}

