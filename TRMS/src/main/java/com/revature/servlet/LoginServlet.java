package com.revature.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.AccountDAO;
import com.revature.domain.Account;
import com.revature.service.AuthService;
 
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	
	private AuthService authServ = new AuthService();
	
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");
         
        System.out.println(username + " and " + password);
        
        Account acnt = authServ.validateAccount(username, password);
        
        if(acnt != null) {
        	System.out.println("Sign in success!");
        	HttpSession s = request.getSession();
			s.setAttribute("curAccount", acnt);
			//redirect to home page
			response.sendRedirect("./pages/Requests.html");
			//send a forward to maintain request scope between servlets
			//RequestDispatcher rd = request.getRequestDispatcher("Requests.html");
			//rd.forward(request, response);
        } else {
        	System.out.println("Sign in fail");
        	response.getWriter().write("<h1>Wrong Login</h1>");
        }  
        
    }
}