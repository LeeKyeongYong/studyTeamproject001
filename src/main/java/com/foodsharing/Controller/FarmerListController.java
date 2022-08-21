package com.foodsharing.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodsharing.DAO.IFarmerDAO;
import com.foodshring.VO.FarmerVO;
import com.util.Command;

public class FarmerListController implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="purchase/purchaseList.jsp";
	    //String pseq=request.getParameter("pseq").trim();
	    IFarmerDAO productDAO=IFarmerDAO.getInstance();
	    ArrayList<FarmerVO> orderList = productDAO.listFarmer();
	    System.out.println(orderList);
	    request.setAttribute("farmerList",orderList);
		/*
		 * RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		 * dispatcher.forward(request, response);
		 */
	    return url;
	}
}
