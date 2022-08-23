package com.frontController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodsharing.Controller.JoinCon;
import com.foodsharing.Controller.LoginCon;
import com.foodsharing.Controller.LogoutCon;
import com.util.Command;

@WebServlet("*.do") //자바파일이다.
public class FronController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		//실제 사용자가 입력한 주소
		System.out.println("Url실행: "+request.getRequestURI());
		
		//사이트주소
		String requestUri=request.getRequestURI().toString();
		
		//프로젝트명
		String requestContextPath=request.getContextPath();
		
		//뒷경로
		String command=requestUri.substring(requestContextPath.length(),requestUri.length());
		
		System.out.println("클라이언트가 요청한 주소: "+command);
		
		Command cmm=null; //command Upcasting을 한다..
		
		//url경로 호출경우
			if(command.equals("/index.do")) {
				System.out.println("클라이언트가 요청한 메인 주소: "+requestUri);
				//cmm = new index();
			} else if(command.equals("/purchaseList.do")) {
				System.out.println("클라이언트가 요청한 메인 주소: "+requestUri);
				//cmm = new purchaseList();
			} else if(command.equals("/purchaseView.do")) {
				System.out.println("클라이언트가 요청한 메인 주소: "+requestUri);
				//cmm = new FarmerViewController();
			} else if(command.equals("/purchaseWrite.do")) {
				System.out.println("클라이언트가 요청한 메인 주소: "+requestUri);
				//cmm = new FarmerWriteController();
			} else if(command.equals("/MapController.do")) {
				System.out.println("클라이언트가 요청한 메인 주소: "+requestUri);
				//cmm = new FarmerListController();
			} else if(command.equals("/checkout.do")) {
				System.out.println("클라이언트가 요청한 메인 주소: "+requestUri);
				//cmm = new FarmerListController();
				
			} else if(command.equals("/LoginCon.do")) {
				System.out.println("클라이언트가 요청한 메인 주소: "+requestUri);
				cmm = new LoginCon();
				
			}  else if(command.equals("/LogoutCon.do")) {
				System.out.println("클라이언트가 요청한 메인 주소: "+requestUri);
				cmm = new LogoutCon();
				
			}else if(command.equals("/JoinCon.do")) {
				System.out.println("클라이언트가 요청한 메인 주소: "+requestUri);
				cmm = new JoinCon();
				
			}else if(command.equals("/shop-grid.do")) {
				System.out.println("클라이언트가 요청한 메인 주소: "+requestUri);
				//cmm = new FarmerListController();
			} else if(command.equals("/shop-details.do")) {
				System.out.println("클라이언트가 요청한 메인 주소: "+requestUri);
				//cmm = new FarmerListController();
			} else if(command.equals("/shoping-cart.do")) {
				System.out.println("클라이언트가 요청한 메인 주소: "+requestUri);
				//cmm = new FarmerList ();
			} 
		
			String moveUrl=cmm.execute(request, response);
			//response.sendRedirect(moveUrl);
			request.getRequestDispatcher(moveUrl).forward(request, response);
	
	}
}
