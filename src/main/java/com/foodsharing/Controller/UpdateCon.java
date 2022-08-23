package com.foodsharing.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*import com.DAO.memberDAO;
import com.VO.memberVO;
*/
public class UpdateCon {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		//memberVO vo = (memberVO) session.getAttribute("vo");

		//String email = vo.getEmail();
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		//memberDAO dao = new memberDAO();

		/*
		 * int cnt = dao.Update(email, pw, tel, address);
		 * 
		 * if (cnt > 0) { vo.setTel(tel); vo.setAddress(address); // 세션특징 기존에 있던값을 수정하고
		 * 쓰면 덮어씌워진다 // vo라는 세션안에 vo(email,pw,tel,address등이 있다)
		 * session.setAttribute("vo", vo); } else { System.out.println("수정실패"); } return
		 * "main.jsp";
		 */
	}
}
