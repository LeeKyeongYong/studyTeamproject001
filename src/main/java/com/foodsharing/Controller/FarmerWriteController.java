package com.foodsharing.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodsharing.DAO.IFarmerDAO;
import com.foodshring.VO.FarmerVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.util.Command;

public class FarmerWriteController implements Command {

	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		  String url = "";
		  FarmerVO vo= new FarmerVO();
		  
		  
		    //List<String> fileNameList = new ArrayList<String>();
			final String uploadPath = request.getServletContext().getRealPath("/upload");
			final int maxPostSize = 10 * 1024 * 1024; // 10M
			
			MultipartRequest multipartRequest = new MultipartRequest(request,uploadPath, maxPostSize, "utf-8", new DefaultFileRenamePolicy());
			
			@SuppressWarnings("unchecked")
			Enumeration<String> enumeration = multipartRequest.getFileNames();
			while(enumeration.hasMoreElements()) {
				String name = enumeration.nextElement();
				String fileName = multipartRequest.getOriginalFileName(name);
				  //파일은 멀티파트로 저장한다.
				  vo.setPhoto(fileName);
				  vo.setProduct(multipartRequest.getParameter("product"));
				  vo.setPrice(multipartRequest.getParameter("price"));
				  vo.setCategory(multipartRequest.getParameter("category"));
				  vo.settEmail(multipartRequest.getParameter("temail"));
				  vo.setMemberCount(multipartRequest.getParameter("memberCount"));
				  vo.setBoxCount(multipartRequest.getParameter("boxCount"));
				  vo.setpDetails(multipartRequest.getParameter("pdetails"));
				  
				//fileNameList.add(fileName);
			}
		  //디비에저장
		  IFarmerDAO productDAO = IFarmerDAO.getInstance();
		  int cnt=productDAO.insertfarmer(vo);
	      if(cnt>0) {
	    	  System.out.println(vo.toString());
	    	  url = "purchaseList.do";
	    	  System.out.println("정상적으로 저장이되었습니다.");
	      }else {
	    	  url = "purchaseList.do";
	    	  System.out.println("저장이 실패되었습니다.");
	      }
		return url;
	}

}
