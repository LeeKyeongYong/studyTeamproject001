package com.foodsharing.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodsharing.DAO.t_commentDAO;
import com.foodshring.VO.t_commentVO;
import com.foodshring.VO.t_memberVO;
import com.util.Command;

public class CommentInsertCon implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url="";
		request.setCharacterEncoding("utf-8");
		
		t_commentVO tvo = new t_commentVO();
		
		String articleSeq = request.getParameter("articleSeq");
		String cmtContent=request.getParameter("cmtContent");
		
		HttpSession session=request.getSession();
		t_memberVO vo=(t_memberVO)session.getAttribute("vo");
		
		tvo.setArticleSeq(articleSeq);
		tvo.setCmtContent(cmtContent);
		tvo.setMbId(vo.getMbId());
		
		t_commentDAO comment=t_commentDAO.getInstance();
		int cnt=comment.insertcomment(tvo);
		
		System.out.println(cnt+"communittyView불러오는것 확인입니다."+tvo);
		
		if(cnt>0) {
	    	  System.out.println(tvo.toString());
	    	  url = "communittyList.do";
	    	  System.out.println("정상적으로 저장이되었습니다.");
	      }else {
	    	  url = "communittyList.do";
	    	  System.out.println("저장이 실패되었습니다.");
	      }
		
		return url;
	}

}
