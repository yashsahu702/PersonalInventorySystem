package com.personalinventorysystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.personalinventorysystem.bean.BankBookBean;

import com.personalinventorysystem.dao.BankBookDAO;


/**
 * Servlet implementation class BankBook
 */
@WebServlet("/BankBook")
public class BankBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankBook() {
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
		 int i=1;
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='ISO-8859-1'>");
		out.println("<title>Banking Project</title>");
		out.println("<link rel='stylesheet' href='Style32.css'>");
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
				out.println("<h2>Bank<span>Book</span></h2>");
		out.println("<div class='cat'><form action='BankBook'>Date From<input type='date' name='sdate'><br>");
				out.println("To<input type='date' name='edate'>");
		out.println("<h1><input type='submit' value='Show'></h1></form></div>");
	
		out.println("<div class='tableset'>	<table border='1' width='600px' >");
		out.println("<tr>");
				out.println("<th>S.No.</th>");
		out.println("<th>Date</th>");
		out.println("<th>Amount</th>");
				out.println("<th>Pay/Receive</th>");
		out.println("</tr>");
		String sdate=request.getParameter("sdate");
		String edate=request.getParameter("edate");
		BankBookDAO ex=new BankBookDAO();
	
		ArrayList<BankBookBean> al=ex.findAllDateWise(sdate, edate, userid);
		for(BankBookBean es:al){
		out.println("<tr>");
		out.println("<td>'"+i+++"'</td>");
	out.println("<td>'"+es.getTransaction_date()+"'</td>");
		
			out.println("<td>'"+es.getAmount()+"'</td>");
			out.println("<td>'"+es.getOperation()+"'</td>");
		out.println("</tr>");
		}
		try {
			double total=ex.closingBalance(userid,sdate,edate);
			if(total!=0) {
			out.println("<tr>");
			out.println("<th colspan='2'>Closing Balance</th>");

	out.println("<th colspan='2'>'"+total+"'</th>");
			
	out.println("</tr>");}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		doGet(request, response);
	}

}
