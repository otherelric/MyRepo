package com.revature.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.domain.Account;
import com.revature.domain.Form;
import com.revature.service.AuthService;

@WebServlet("/addReqServlet")
public class AddRequestServlet extends HttpServlet {  

	private Form f = new Form();
	private AuthService authServ = new AuthService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesh = request.getSession();
		Account a = (Account)sesh.getAttribute("curAccount");
		
		Timestamp timestamp = (Timestamp) new Date();
		Timestamp dT = (Timestamp) new Date();
		Timestamp startDateTime = null;
		
		try {
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		    Date parsedDate = dateFormat.parse(request.getParameter("startDate"));
		    timestamp = new Timestamp(parsedDate.getTime());
		} catch(Exception e) { 
			
		}

		if(timestamp != dT)
			startDateTime = timestamp;
		
		f.setAddress(request.getParameter("address"));
		f.setCost(Float.parseFloat(request.getParameter("cost")));
		f.setDateTime(dT);
		f.setComment(request.getParameter("adtnlStuff"));
		f.setEventType(request.getParameter("eventType"));
		f.setGradeType(request.getParameter("gradeFormat"));
		f.setStatus(1);
		f.setStartDateTime(startDateTime);
		
		authServ.makeNewForm(f, a.getAcntID());
		if(f != null) {
			System.out.println("Form has been made!");
			response.sendRedirect("./pages/Requests.html");
        } else {
        	System.out.println("Form was not made :(");
        	//response.getWriter().write("<h1></h1>");
        }
	}

}
