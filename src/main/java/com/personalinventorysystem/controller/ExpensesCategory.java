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

import com.personalinventorysystem.bean.ExpensesCategoryBean;

import com.personalinventorysystem.dao.ExpensesCategoryDAO;

/**
 * Servlet implementation class ExpensesCategory
 */
@WebServlet("/ExpensesCategory")
public class ExpensesCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExpensesCategory() {
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
		 String name =(String)session.getAttribute("name");
		 int userid =(Integer)session.getAttribute("user");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='ISO-8859-1'>");
		out.println("<title>Banking Project</title>");
		out.println("<link rel='stylesheet' href='m1.css'>");
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
				out.println("<h2>Expenses<span>Category</span></h2>");
		out.println("<div class='cat'><form action='ExpensesCategory' method='post'>Category Name<input type='text' name='cn' required><br>");
				out.println("Category Details<input type='text' name='cd' required>");
		out.println("<h1><input type='submit' value='Add'></h1></form></div>");
		out.println("<div class='tableset'>	<table border='1'  width='600px' >");
		out.println("<tr>");
				out.println("<th>CategoryName</th>");
		out.println("<th>CategoryDetails</th>");
		out.println("<th>Edit</th>");
				out.println("<th>Delete</th>");
		out.println("</tr>");
		ExpensesCategoryDAO ex=new ExpensesCategoryDAO();
		ArrayList<ExpensesCategoryBean> al=ex.findAll(userid);
		for(ExpensesCategoryBean es:al ) {
		out.println("<tr>");
		out.println("<td>"+es.getExp_catname()+"</td>");
	out.println("<td>"+es.getExp_catdetails()+"</td>");
		/*out.println("<td>boss</td>");
		out.println("<td>bb</td>");*/
			out.println("<td> <a href='EditExpCat?exp_id="+es.getExp_catid()+"' >Edit</a></td>");
			out.println("<td> <a href='DeleteExpCat?exp_id="+es.getExp_catid()+"'>Delete</a></td>");
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
		ExpensesCategoryDAO ex=new ExpensesCategoryDAO();
		ExpensesCategoryBean ed=new ExpensesCategoryBean();
		ed.setExp_catname(catname);
		ed.setExp_catdetails(catdetails);
		ed.setUserid(userid);
		int a=ex.Create(ed);
		if(a>0) {
			response.sendRedirect("ExpensesCategory");
		}
		else {
			out.println("Not Added");
		}
			
				
	}
	}


