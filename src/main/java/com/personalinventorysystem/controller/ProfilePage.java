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
 * Servlet implementation class ProfilePage
 */
@WebServlet("/ProfilePage")
public class ProfilePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfilePage() {
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
		int userid = (Integer) session.getAttribute("user");

		UsersDAO ed = new UsersDAO();
		UsersBean ex = ed.Find(userid);

		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='ISO-8859-1'>");
		out.println("<title>Banking Project</title>");
		out.println("<link rel='stylesheet' href='Style2.css'>");
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
		out.println("<div class='content'><br><br>");
		out.println("<h2>Pro<span>file</span></h2>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td><span>Name:</span>    " + ex.getName() + "<td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><span>Username:</span>" + ex.getUsername() + "</td>");
		out.println("	</tr>		");
		out.println("<tr>");
		out.println("<td><span>Password:</span>" + ex.getPassword() + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><span>PhoneNo.:</span>" + ex.getMobile() + "</td>");
		out.println("	</tr>");
		out.println("<tr>");
		out.println("<td><span>Email:</span>   " + ex.getEmail() + "</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><span>Address:</span> " + ex.getAddress() + "</td>");
		out.println("</tr>");
		out.println("</table>");
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
