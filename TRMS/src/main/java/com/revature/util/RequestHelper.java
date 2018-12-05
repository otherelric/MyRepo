package com.revature.util;

import javax.servlet.http.HttpServlet;

import com.revature.servlet.LoginServlet;
import com.revature.servlet.PageNotFound;

public class RequestHelper {

//	private static HttpServlet homeServ = new HomeServlet();
	private static HttpServlet logServ = new LoginServlet();
	private static HttpServlet pnfServ = new PageNotFound();
	
	public HttpServlet dispatchRequest(String path) {
		
		HttpServlet nextServ = null;
		
		switch (path) {
		
//		case "/TRMS/login":
//			nextServ = logServ;
//			break;
		
//		case "/FrontServletv2/app/home":
//			nextServ = homeServ;
//			break;
			
		default:
			nextServ = pnfServ;
		}
		
		return nextServ;
		
	}
	
}
