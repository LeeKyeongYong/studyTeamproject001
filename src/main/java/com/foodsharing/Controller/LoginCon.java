package com.foodsharing.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.foodsharing.DAO.t_memberDAO;
import com.foodshring.VO.t_memberVO;
import com.util.Command;

public class LoginCon implements Command{

	// execute 메서드를 통해서 로그인을 할꺼다
		// class 파일에서는 request와 response를 쓸수없기때문에 쓸수있게
		// HttpServletRequest request,HttpServletRequest response 가져온거임
		// return String으로 한이유는 "main.jsp" , "LoginF.html" 를 리턴값으로 쓰기위해서
		public String execute(HttpServletRequest request, HttpServletResponse response) {

			// 사용자가 보내주는 email.pw 받아주는거
			String mbId = request.getParameter("mbId");
			String mbPw = request.getParameter("mbPw");

			// DAO 한테 이메일 PW 를 보내주기위해 만든거
			t_memberVO vo = new t_memberDAO().Login(mbId, mbPw);
			
			if (vo != null) {
				HttpSession session = request.getSession();
				session.setAttribute("vo", vo);
				return "index.jsp";
				
			} else {
				return "LoginF.html";
			}

		}
}
