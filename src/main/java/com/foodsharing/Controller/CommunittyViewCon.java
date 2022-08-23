package com.foodsharing.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodsharing.DAO.t_communittyDAO;
import com.foodshring.VO.t_communittyVO;
import com.util.Command;

public class CommunittyViewCon implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String url="communitty/communittyView.jsp";
		String articleSeq=request.getParameter("articleSeq");
		t_communittyDAO communitty=t_communittyDAO.getInstance();
		t_communittyVO t_vo=communitty.get_communittyVO(articleSeq);
		//ArrayList<t_communittyVO> t_communittyList = communitty.listCommunitty();
		System.out.println("communittyView불러오는것 확인입니다. "+t_vo);
		request.setAttribute("communittyView",t_vo);
		return url;
	}
}
