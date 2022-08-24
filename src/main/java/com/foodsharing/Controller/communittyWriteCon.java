package com.foodsharing.Controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodsharing.DAO.t_communittyDAO;
import com.foodshring.VO.t_communittyVO;
import com.foodshring.VO.t_memberVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.util.Command;

public class communittyWriteCon implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url="";
		request.setCharacterEncoding("utf-8");
		
		t_communittyVO vo=new t_communittyVO();
		
		HttpSession session = request.getSession();	
		
		t_memberVO mvo=(t_memberVO)session.getAttribute("vo");
		
		final String uploadPath = request.getServletContext().getRealPath("/upload");
		final int maxPostSize = 20 * 1024 * 1024; // 20M
		
		MultipartRequest multipartRequest = new MultipartRequest(request,uploadPath, maxPostSize, "utf-8", new DefaultFileRenamePolicy());
		@SuppressWarnings("unchecked")
		Enumeration<String> enumeration = multipartRequest.getFileNames();
		while(enumeration.hasMoreElements()) {
		
			String name = enumeration.nextElement();
			String fileName = multipartRequest.getOriginalFileName(name);
			vo.setArticleContent(multipartRequest.getParameter("articleContent"));
			if(!"".equals(fileName)) {
				vo.setArticleFile(fileName);
			 }
			vo.setArticleTitle(multipartRequest.getParameter("articleTitle"));
			//vo.setMbId(mvo.getMbId());
			vo.setMbId("slekydz86@naver.com");
		
		}
		
		t_communittyDAO communitty=t_communittyDAO.getInstance();
		int cnt=communitty.insertcommunitty(vo);
		System.out.println(cnt+"communittyView불러오는것 확인입니다."+vo);
		if(cnt>0) {
	    	  System.out.println(vo.toString());
	    	  url = "communittyList.do";
	    	  System.out.println("정상적으로 저장이되었습니다.");
	      }else {
	    	  url = "communittyList.do";
	    	  System.out.println("저장이 실패되었습니다.");
	      }
		
		
		return url;
	}
}
