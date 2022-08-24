package com.foodsharing.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodsharing.DAO.t_commentDAO;
import com.foodsharing.DAO.t_communittyDAO;
import com.foodshring.VO.t_commentVO;
import com.foodshring.VO.t_communittyVO;
import com.util.Command;

public class CommunittyViewCon implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String url="communitty/communittyView.jsp";
		if(request.getParameter("articleSeq")==null || request.getParameter("page")==null) {
			url="communittyList.do";
		} else {
			String articleSeq=request.getParameter("articleSeq");
			String page= request.getParameter("page");
			t_communittyDAO communitty=t_communittyDAO.getInstance();
			t_communittyVO t_vo=communitty.get_communittyVO(articleSeq);
			System.out.println("communittyView불러오는것 확인입니다. "+t_vo);
			
			t_commentDAO comment=t_commentDAO.getInstance();
			ArrayList<t_commentVO> tc_vo = comment.get_commentVO(articleSeq);
			System.out.println("tc_vo불러오는것 확인입니다. "+tc_vo);
			
			request.setAttribute("commentList",tc_vo);
			request.setAttribute("communittyView",t_vo);
		}
		return url;
	}
}
