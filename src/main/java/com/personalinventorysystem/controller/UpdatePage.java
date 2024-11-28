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
 * Servlet implementation class UpdatePage
 */
@WebServlet("/UpdatePage")
public class UpdatePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		int uid = (Integer) session.getAttribute("user");
		UsersDAO ed = new UsersDAO();
		UsersBean ex = ed.Find(uid);
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='ISO-8859-1'>");
		out.println("<title>Banking Project</title>");
		out.println("<link rel='stylesheet' href='Update.css'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='main'>");
		out.println("<div class='navbar'>");
		out.println("<div class='icon'>");
		out.println("<h2 class='logo'>Personal InventorySystem</h2>");
		out.println("</div>");
		out.println("<div class='menu'><ul>");
		out.println("<li><a href='HomePage'>HOME</a></li>");
		out.println("<li><a href='ProfilePage'>Profile</a></li>");
		out.println("<li><a href='UpdatePage'>UpdateProfile</a></li>");
		out.println("<li><a href='LogoutPage'>Logout</a></li>");
		out.println("</ul>");
		out.println("</div>");
		out.println("<div class='content'><br>");
		out.println("<h2>Update <span>Profile</span></h2><br>");
		out.println("<form action='UpdateExecute'>");
		out.println("<input type='hidden' name='id'  value='" + ex.getUserid() + "'>");
		out.println("Name:<input type='text' name='name' value='" + ex.getName() + "'><br>");
		out.println("Username:<input type='text' name='un' value='" + ex.getUsername() + "'><br>");
		out.println("Pasword:<input type='password' name='pw' value='" + ex.getPassword() + "'><br>");
		out.println("PhoneNo:<input type='number' name='ph' value='" + ex.getMobile() + "'><br>");

		out.println("Email:<input type='email' name='email'  value='" + ex.getEmail() + "'><br>	");
		out.println("Address:<input type='text' name='add'  value='" + ex.getAddress() + "'><br>");
		out.println("<h1><input type='submit' value='Submit' ></h1>");
		out.println("</form>");

		out.println("</div>");
		out.println("</div><br><br>");
		out.println("<div class='id'><h4>" + name + "</h4></div>");
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
