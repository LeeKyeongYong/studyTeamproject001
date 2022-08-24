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
		//업데이트할 내용 뿌려주세요~ 흔들어주세요~
		request.setCharacterEncoding("utf-8");
		String url="communitty/communittyUpdate.jsp";
		String articleSeq=request.getParameter("articleSeq");
		t_communittyDAO communitty=t_communittyDAO.getInstance();
		t_communittyVO t_vo=communitty.get_communittyVO(articleSeq);
		//ArrayList<t_communittyVO> t_communittyList = communitty.listCommunitty();
		System.out.println("communittyView불러오는것 확인입니다. "+t_vo);
		request.setAttribute("communittyView",t_vo);
		return url;
	}
}
