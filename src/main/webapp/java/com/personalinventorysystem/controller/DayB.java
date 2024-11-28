
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

import com.personalinventorysystem.bean.ExpensesBean;
import com.personalinventorysystem.bean.IncomeBean;

import com.personalinventorysystem.dao.ExpensesDAO;
import com.personalinventorysystem.dao.IncomeDAO;

/**
 * Servlet implementation class DayB
 */
@WebServlet("/DayB")
public class DayB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DayB() {
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
		out.println("<link rel='stylesheet' href='Style36.css'>");
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
		out.println("<div class='content'><br>");
				out.println("<h2>Day<span>Book</span></h2>");
		out.println("<div class='cat'><form action='DayB'>Date From<input type='date' name='sdate'><br>");
				out.println("To<input type='date' name='edate'>");
		out.println("<h1><input type='submit' value='Show'></h1></form></div>");
		out.println("<div class='tableset'>	<table border='1' width='550px' >");
		out.println("<tr>");
				out.println("<th>Expenses</th>");
		out.println("<th>Date</th>");
		out.println("<th>Amount</th>");
		out.println("<th>Pay/Receive</th>");
				out.println("<th>Remark</th>");
		out.println("</tr>");
		String stdate=request.getParameter("sdate");
		String eddate=request.getParameter("edate");
		ExpensesDAO ed=new ExpensesDAO();
		ArrayList<ExpensesBean> ap=ed.findAllDateWise(stdate,eddate,userid);
		for(ExpensesBean es:ap ) {
		out.println("<tr>");
		out.println("<td>'"+es.getExp_ac()+"'</td>");
	out.println("<td>'"+es.getTransaction_date()+"'</td>");
	out.println("<td>'"+es.getAmount()+"'</td>");
			out.println("<td>'"+es.getPayby()+"'</td>");
			out.println("<td>'"+es.getRemark()+"'</td>");
		out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");
		out.println("<div class='tableset2'><div class='fix2'><table border='1' width='550px' >");
		out.println("<tr>");
				out.println("<th>Incomes</th>");
		out.println("<th>Date</th>");
		out.println("<th>Amount</th>");
		out.println("<th>Pay/Receive</th>");
				out.println("<th>Remark</th>");
		out.println("</tr>");
		IncomeDAO ex=new IncomeDAO();
		ArrayList<IncomeBean> al=ex.findAllDateWise(stdate,eddate,userid);
		for(IncomeBean es:al ) {
		out.println("<tr>");
		out.println("<td>'"+es.getInc_ac()+"'</td>");
	out.println("<td>'"+es.getTransaction_date()+"'</td>");
	out.println("<td>'"+es.getAmount()+"'</td>");
			out.println("<td>'"+es.getReceivby()+"'</td>");
			out.println("<td>'"+es.getRemark()+"'</td>");
		out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");
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
