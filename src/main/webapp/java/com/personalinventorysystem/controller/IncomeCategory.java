package com.personalinventorysystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.personalinventorysystem.bean.IncomeCategoryBean;
import com.personalinventorysystem.dao.IncomeCategoryDAO;

/**
 * Servlet implementation class IncomeCategory
 */
@WebServlet("/IncomeCategory")
public class IncomeCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncomeCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		int userid =(Integer)session.getAttribute("user");
		 String name =(String)session.getAttribute("name");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='ISO-8859-1'>");
		out.println("<title>Banking Project</title>");
		out.println("<link rel='stylesheet' href='Style24.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='main'>"); 
		out.println("<div class='navbar'>");
		out.println("	<div class='icon'>");
		out.println("	<h2 class='logo'>Personal InventorySystem</h2>");
				out.println("</div>");
		out.println("<div class='menu'><ul>");
	
		out.println("<li><a href='HomePage'>HOME</a></li>");
		out.println("<li><a href='ProfilePage'>Profile</a></li>");
		out.println("<li><a href='UpdatePage'>UpdateProfile</a></li>");
				out.println("<li><a href='LogoutPage'>Logout</a></li>");
		out.println("</ul>");
				out.println("</div>");
		out.println("<div class='content'><br><br>");
				out.println("<h2>Income<span>Category</span></h2>");
		out.println("<div class='cat'><form action='IncomeCategory' method='post'>Category Name<input type='text' name='cn' required><br>");
				out.println("Category Details<input type='text' name='cd' required>");
		out.println("<h1><input type='submit' value='Add'></h1></form></div>");
		out.println("<div class='tableset'>	<table border='1' width='600px' >");
		out.println("<tr>");
				out.println("<th>CategoryName</th>");
		out.println("<th>CategoryDetails</th>");
		out.println("<th>Edit</th>");
				out.println("<th>Delete</th>");
		out.println("</tr>");
		IncomeCategoryDAO ex=new IncomeCategoryDAO();
		ArrayList<IncomeCategoryBean> al=ex.findAll(userid);
		for(IncomeCategoryBean es:al ) {
		out.println("<tr>");
		out.println("<td>"+es.getInc_catname()+"</td>");
	out.println("<td>"+es.getInc_catdetails()+"</td>");
		
			out.println("<td> <a href='EditIncCat?inc_id="+es.getInc_catid()+"' >Edit</a></td>");
			out.println("<td> <a href='DeleteIncCat?inc_id="+es.getInc_catid()+"'>Delete</a></td>");
		out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");
		out.println("	</div>");
		out.println("</div><br><br>");
				out.println("<div class='id'><h4>'"+name+"'</h4></div>");
				out.println("<div class='master'>");
				out.println("<br><br><br>");
					out.println("<h2>Master</h2>");
					out.println("<ul >");
					out.println("<li><a href='ExpensesCategory'>ExpensesCategory</a></li>");
					out.println("<li><a href='IncomeCategory'>IncomeCategory</a></li>");
					out.println("<li><a href='Expenses'>Expenses</a></li>");
					out.println("<li><a href='Income'>Income</a></li>");
					out.println("<li><a href='CashBook'>CashBook</a></li>");
					out.println("<li><a href='BankBook'>BankBook</a></li>");
					out.println("<li><a href='DayB'>DayBook</a></li>");
					out.println("<li><a href='DayBook'>BalanceSheet</a></li>");
					out.println("</ul>");
					out.println("</div>");
					out.println("</div>");
			
			out.println("</body>");
		out.println("</html>");
		}
	

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String catname=request.getParameter("cn");
		String catdetails=request.getParameter("cd");
		HttpSession session=request.getSession();
		int userid =(Integer)session.getAttribute("user");
		IncomeCategoryDAO ex=new IncomeCategoryDAO();
		IncomeCategoryBean ed=new IncomeCategoryBean();
		ed.setInc_catname(catname);
		ed.setInc_catdetails(catdetails);
		ed.setUserid(userid);
		int a=ex.Create(ed);
		if(a>0) {
			response.sendRedirect("IncomeCategory");
		}
		else {
			out.println("Not Added");
		}
			
				
	}

}
