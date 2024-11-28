package com.personalinventorysystem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.personalinventorysystem.bean.ExpensesBean;
import com.personalinventorysystem.dao.ExpensesDAO;


/**
 * Servlet implementation class Expenses
 */
@WebServlet("/Expenses")
public class Expenses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Expenses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		//String name=request.getParameter("id");
		//int uid=Integer.parseInt(request.getParameter("user"));
	//	ExpensesDAO ed=new UsersDAO();
	//	UsersBean ex=ed.Find(uid);
		HttpSession session=request.getSession();
		//int userid =(Integer)session.getAttribute("user");
		 String name =(String)session.getAttribute("name");
		out.println("<html>");
		out.println("<head>");
				out.println("<meta charset='ISO-8859-1'>");
						out.println("<title>Banking Project</title>");
out.println("<link rel='stylesheet' href='ExpP.css'>");
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
								out.println("<h2>Ex<span>penses</span></h2><br>");
										out.println("<form action='Expenses' method='post'>");
										out.println("Expenses:<input type='text' name='exp'  value='bill/ticket/stationary' readonly ><br>");
										out.println("<label>Category:<select name='cat' required><option>Home Appliences</option><option>Ticket</option><option>bills</option><option>Other</option></select></label><br>");
										out.println("Amount:<input type='number' name='amount' required><br>");
										out.println("<label>Payby:<select name='pay' required><option>Cash</option><option>Check</option><option>UPI</option><option>Card</option></select></label><br>");
												out.println("Date:<input type='date' name='date' required><br>");
								out.println("Remark:<input type='text' name='rk' required> <br>");
								
						
								out.println("<h1><input type='submit' value='Add' ></h1>");
										out.println("</form>");
						
								out.println("</div>");
								out.println("</div><br><br>");
								out.println("<div class='id'><h4>"+name+"</h4></div>");
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
		HttpSession session=request.getSession();
		int userid =(Integer)session.getAttribute("user");
		ExpensesDAO ex=new ExpensesDAO();
		ExpensesBean ed=new ExpensesBean();
		String cat=request.getParameter("cat");
		int amount=Integer.parseInt(request.getParameter("amount"));
		String payby=request.getParameter("pay");
		String date=request.getParameter("date");
		String remark=request.getParameter("rk");
		ed.setExp_ac(cat);
		ed.setAmount(amount);
		ed.setPayby(payby);
		ed.setTransaction_date(date);
		ed.setUserid(userid);
		ed.setRemark(remark);
		int a=ex.Create(ed);
		if(a>0) {
			
			response.sendRedirect("Expenses");
		}
		else {
			out.print("<h1> Not Added Successfully</h1>");
			
			
		}

		}
	}


