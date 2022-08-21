package com.foodsharing.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodsharing.DAO.IFarmerDAO;
import com.foodshring.VO.FarmerVO;
import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.GeocoderStatus;
import com.google.code.geocoder.model.LatLng;
import com.util.Command;

public class FarmerViewController implements Command {

	/*
	 * private static Float[] getlocationData(String location) throws Exception{ if
	 * (location == null) return null;
	 * 
	 * Geocoder geocoder = new Geocoder();
	 * setLanguate : 인코딩 설정 GeocoderRequest geocoderRequest = new
	 * GeocoderRequestBuilder().setAddress(location).setLanguage("ko").
	 * getGeocoderRequest(); GeocodeResponse geocoderResponse; try {
	 * geocoderResponse = geocoder.geocode(geocoderRequest); if
	 * (geocoderResponse.getStatus() == GeocoderStatus.OK &
	 * !geocoderResponse.getResults().isEmpty()) { GeocoderResult
	 * geocoderResult=geocoderResponse.getResults().iterator().next(); LatLng
	 * latitudeLongitude = geocoderResult.getGeometry().getLocation(); Float[]
	 * coords = new Float[2];coords[0] = latitudeLongitude.getLat().floatValue();
	 * coords[1] = latitudeLongitude.getLng().floatValue(); return coords; } } catch
	 * (IOException ex) { ex.printStackTrace(); } return null;
	 * 
	 * }
	 */

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String url = "purchase/purchaseView.jsp";
		String farmerseq = request.getParameter("farmerseq").trim();
		IFarmerDAO productDAO = IFarmerDAO.getInstance();
		FarmerVO vo = productDAO.getFarmerVO(farmerseq);
		
		System.out.println(vo.getStateaddr());
		System.out.println(vo.toString());
		request.setAttribute("farmerVO", vo);
		return url;
	}

}
