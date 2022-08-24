package com.foodsharing.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodsharing.DAO.t_communittyDAO;
import com.foodshring.VO.t_communittyVO;
import com.util.Command;

public class communittyUpdateCon implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url="communitty/communittyUpdate.jsp";
		if(request.getParameter("articleSeq")==null || request.getParameter("page")==null) {
			url="communittyList.do";
		} else {
			String articleSeq=request.getParameter("articleSeq");
			String page= request.getParameter("page");
			t_communittyDAO communitty=t_communittyDAO.getInstance();
			t_communittyVO t_vo=communitty.get_communittyVO(articleSeq);
			System.out.println("communittyView불러오는것 확인입니다. "+t_vo);
			request.setAttribute("communittyView",t_vo);
			request.setAttribute("communittyView",page);
		}
		return url;
	}
}
