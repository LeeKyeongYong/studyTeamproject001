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

public class CommunittyModifyCon implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String url="";
		if(request.getParameter("articleSeq")==null || request.getParameter("page")==null) {
			url="communittyList.do";
		} else {
			
			HttpSession session=request.getSession();
			t_memberVO vo=(t_memberVO)session.getAttribute("vo");
			String userId=vo.getMbId();
			
			t_communittyVO tvo=new t_communittyVO();
			
			final String uploadPath = request.getServletContext().getRealPath("/upload");
			final int maxPostSize = 20 * 1024 * 1024; // 20M
			
			MultipartRequest multipartRequest = new MultipartRequest(request,uploadPath, maxPostSize, "utf-8", new DefaultFileRenamePolicy());
			
			@SuppressWarnings("unchecked")
			Enumeration<String> enumeration = multipartRequest.getFileNames();
			
			while(enumeration.hasMoreElements()) {
				
				String name = enumeration.nextElement();
				String fileName = multipartRequest.getOriginalFileName(name);
				tvo.setArticleSeq(multipartRequest.getParameter("articleSeq"));
				tvo.setArticleContent(multipartRequest.getParameter("articleContent"));
				if(!"".equals(fileName)) {
					tvo.setArticleFile(fileName);
				 }
				tvo.setArticleTitle(multipartRequest.getParameter("articleTitle"));
				//tvo.setMbId(mvo.getMbId());
				tvo.setMbId("slekydz86@naver.com");
			}
			
			t_communittyDAO communitty=t_communittyDAO.getInstance();
			int cnt=communitty.updatecommunitty(tvo);
			if(cnt>0) {
				url="communittyView.do";
			}else {
				url="communittyList.do";
			}
		}
		return url;
		
	}

}
