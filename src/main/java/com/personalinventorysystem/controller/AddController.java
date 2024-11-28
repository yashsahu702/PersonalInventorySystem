package com.personalinventorysystem.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.personalinventorysystem.bean.UsersBean;
import com.personalinventorysystem.dao.UsersDAO;


/**
 * Servlet implementation class AddController
 */
@WebServlet("/AddController")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddController() {
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
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		
		PrintWriter out=response.getWriter();
		UsersBean i = new UsersBean();
		UsersDAO ex=new UsersDAO();
		i.setUsername(username);
		i.setPassword(password);
		i.setName(name);
		i.setAddress(address);
		/*if(phone.matches("[0-9]{3}[-]{1}[0-9]{3}[-]{1}[0-9]{4}")) {
		
		}*/
		 if(phone.length()>9&&phone.length()<11) {
			 i.setMobile(phone);
		  }
		i.setEmail(email);
		
		int x=ex.createUser(i);
		int userid=ex.checkAvailability(username);
		HttpSession session=request.getSession();
		session.setAttribute("name",name);
		session.setAttribute("user",userid);
			if(x>0) {
				//response.sendRedirect("HomePage?id="+username+"&user="+userid);
				response.sendRedirect("HomePage");
				
			}
			else {
				out.println("<h1>Data Not Added</h1>");
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
