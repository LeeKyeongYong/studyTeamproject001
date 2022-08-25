package com.foodsharing.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Servlet implementation class Test001
 */
@WebServlet("/Test001")
public class Test001 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.println(getCoordData("광주 동구 경양로247번길 26","x"));
			System.out.println(getCoordData("광주 동구 경양로247번길 26","y"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public String getCoordData(String address, String loc) throws Exception {

		HashMap<String, String> mapData = new HashMap<String, String>();
		String resultLoc = null;
		address = URLEncoder.encode(address, "UTF-8");
		String url = "https://dapi.kakao.com/v2/local/search/address.json?query=" + address;
		String jsonString = new String();
		String buf;
		URL Url = new URL(url);
		HttpsURLConnection conn = (HttpsURLConnection) Url.openConnection();
		String auth = "KakaoAK 717be1ab4cdb773577e144a4f6bd287c";
		conn.setRequestMethod("GET");
		conn.setRequestProperty("X-Requested-With", "curl");
		conn.setRequestProperty("Authorization", auth);
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		while ((buf = br.readLine()) != null) {
			jsonString += buf;
		}
		JSONParser paser = new JSONParser();
		JSONObject J = (JSONObject) paser.parse(jsonString);

		JSONObject meta = (JSONObject) J.get("meta");
		JSONArray data = (JSONArray) J.get("documents");
		long size = (long) meta.get("total_count");
		if (size > 0) {
			JSONObject jsonX = (JSONObject) data.get(0);
			resultLoc = jsonX.get(loc).toString().replace(" ", "");
		}
		return resultLoc;
	}
}
