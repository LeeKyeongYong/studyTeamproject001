package com.foodsharing.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.Command;

public class LogoutCon implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();

		session.removeAttribute("vo");
		// 설정된 세션의 값들을 모두 사라지도록 합니다.
		// session.invalidate();
		
		return "index.jsp";
	}
	
	

	
}
