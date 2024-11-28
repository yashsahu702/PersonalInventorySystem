package com.personalinventorysystem.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.personalinventorysystem.bean.UsersBean;
import com.personalinventorysystem.dao.UsersDAO;

/**
 * Servlet implementation class UpdateExecute
 */
@WebServlet("/UpdateExecute")
public class UpdateExecute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateExecute() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String username=request.getParameter("un");
		String password=request.getParameter("pw");
		String phone=request.getParameter("ph");
		String email=request.getParameter("email");
		String address=request.getParameter("add");
		int userid=Integer.parseInt(request.getParameter("id"));
		
		UsersDAO ed=new UsersDAO();
		UsersBean en=new UsersBean();
		en.setUserid(userid);
		en.setUsername(username);
		en.setPassword(password);
		en.setName(name);
		en.setAddress(address);
		 if(phone.length()>9&&phone.length()<11) {
			 en.setMobile(phone);
		  }
		
		en.setEmail(email);
		int r=ed.Edit(en);
		if(r>0) {
			response.sendRedirect("ProfilePage?id="+username+"&user="+userid);
			//out.println("<h2>Data  Updated</h2>");
			}
			else {
			out.println("<h2>Data not Updated</h2>");
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
