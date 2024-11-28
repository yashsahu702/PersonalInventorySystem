package com.personalinventorysystem.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.personalinventorysystem.dao.UsersDAO;
import com.personalinventorysystem.bean.UsersBean;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("un");	
		String password=request.getParameter("pw");
		
		UsersDAO ex=new UsersDAO();
		UsersBean ed=ex.authenticate(username,password);
		int userid=ed.getUserid();
		String name=ed.getName();
		HttpSession session=request.getSession();
		session.setAttribute("name",name);
		session.setAttribute("user",userid);
		PrintWriter out=response.getWriter();
		if(userid!=0||name!=null) {
			response.sendRedirect("HomePage");
		//response.sendRedirect("HomePage?id="+username+"&user="+userid);
				
			
				
			}
			else {
				out.println("<h1>Details is wrong </h1>");
	 
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
