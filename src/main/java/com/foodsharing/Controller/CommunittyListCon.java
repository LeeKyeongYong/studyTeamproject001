package com.foodsharing.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodsharing.DAO.t_communittyDAO;
import com.foodshring.VO.t_communittyVO;
import com.util.Command;

public class CommunittyListCon implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String url="communitty/communittyList.jsp";
		t_communittyDAO communitty=t_communittyDAO.getInstance();
		ArrayList<t_communittyVO> t_communittyList = communitty.listCommunitty();
		System.out.println("ArrayList불러오는것 확인입니다. "+t_communittyList);
		request.setAttribute("communittyList",t_communittyList);
		return url;
	}
}
