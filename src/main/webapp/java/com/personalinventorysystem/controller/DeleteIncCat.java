package com.personalinventorysystem.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.personalinventorysystem.dao.IncomeCategoryDAO;

/**
 * Servlet implementation class DeleteIncCat
 */
@WebServlet("/DeleteIncCat")
public class DeleteIncCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteIncCat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		IncomeCategoryDAO ed=new IncomeCategoryDAO();
	
		int inc_id =Integer.parseInt(request.getParameter("inc_id"));
		int a=ed.Remove(inc_id);
		if(a>0) {
			response.sendRedirect("IncomeCategory");
		}
		else {
			out.print("<h1>Something went Wrong</h1>");
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
