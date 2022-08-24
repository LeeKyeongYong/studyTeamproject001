package com.foodsharing.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodsharing.DAO.t_commentDAO;
import com.foodsharing.DAO.t_communittyDAO;
import com.foodshring.VO.t_memberVO;
import com.util.Command;

public class CommentDeleteCon implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="communitty/communittyView.jsp";
		if(request.getParameter("articleSeq")==null) {
			url="communittyList.do";
		} else {
			String articleSeq=request.getParameter("articleSeq");
			String cmtSeq=request.getParameter("cmtSeq");
			HttpSession session=request.getSession();
			t_memberVO tvo=(t_memberVO)session.getAttribute("vo");
			
			t_communittyDAO communitty=t_communittyDAO.getInstance();
			t_commentDAO comment=t_commentDAO.getInstance();
			int cnt=comment.Deletecomment(articleSeq,cmtSeq,"slekydz86@naver.com");//,tvo.getMbId());	
			if(cnt>0) {
				System.out.println("덧글이 정상적으로 삭제가되었습니다.");
			} else {
				System.out.println("덧글이 정상적으로 삭제가 실패되었습니다.");
			}
		}
		return url;
	}
}
