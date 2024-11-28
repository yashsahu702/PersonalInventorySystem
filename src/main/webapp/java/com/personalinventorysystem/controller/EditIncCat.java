package com.personalinventorysystem.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.personalinventorysystem.bean.IncomeCategoryBean;

import com.personalinventorysystem.dao.IncomeCategoryDAO;

/**
 * Servlet implementation class EditIncCat
 */
@WebServlet("/EditIncCat")
public class EditIncCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditIncCat() {
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
		// int userid =(Integer)session.getAttribute("user");
			
		 int incid =Integer.parseInt(request.getParameter("inc_id"));
		 
		
		IncomeCategoryDAO ed=new IncomeCategoryDAO();
		IncomeCategoryBean ex=ed.Find(incid);
		out.println("<html>");
		out.println("<head>");
				out.println("<meta charset='ISO-8859-1'>");
						out.println("<title>Banking Project</title>");
out.println("<link rel='stylesheet' href='EditInc.css'>");
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
								out.println("<h2>Update <span>IncomeCategory</span></h2><br>");
										out.println("<form action='EditIncCat' method='post'>");
										out.println("<input type='hidden' name='incid'  value='"+ex.getInc_catid()+"'>");
										out.println("Category Name:<input type='text' name='inccatname' value='"+ex.getInc_catname()+"'><br>");
										out.println("Category Details:<input type='text' name='inccatdetails' value='"+ex.getInc_catdetails()+"'><br>");
						out.println("<h1><input type='submit' value='Update' ></h1>");
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
		IncomeCategoryDAO ed=new IncomeCategoryDAO();
		IncomeCategoryBean ex=new IncomeCategoryBean();
		HttpSession session=request.getSession();
		// String name =(String)session.getAttribute("name");
		 int userid =(Integer)session.getAttribute("user");
		int inc_id =Integer.parseInt(request.getParameter("incid"));
		String inc_catname =request.getParameter("inccatname");
		String inc_catdetails =request.getParameter("inccatdetails");
		ex.setInc_catid(inc_id);
		ex.setInc_catname(inc_catname);
		ex.setInc_catdetails(inc_catdetails);
		ex.setUserid(userid);
		
		int a=ed.Edit(ex);
		if(a>0) {
			response.sendRedirect("IncomeCategory");
		}
		else {
			response.sendRedirect("EditIncCat");
		}
	}

}
