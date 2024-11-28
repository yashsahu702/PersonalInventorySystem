package com.personalinventorysystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.personalinventorysystem.bean.IncomeCategoryBean;
import com.personalinventorysystem.utility.ConnectionPool;

public class IncomeCategoryDAO {
	public int Create(IncomeCategoryBean ex) {
		//Write SQL  and create instance of Connection

		

		Connection conn=ConnectionPool.connectDB();
		String sql="insert into income_category(inc_catname,inc_catdetails,userid) values('"+ex.getInc_catname()+"','"+ex.getInc_catdetails()+"','"+ex.getUserid()+"')";

		int r=0;
		try {
		Statement stmt=conn.createStatement();
		r=stmt.executeUpdate(sql);
		} catch (SQLException e) {

		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return r;
		}

		public int Edit(IncomeCategoryBean ex) {
		//Write SQL Query and create instance ofConnection

		Connection conn=ConnectionPool.connectDB();
		String sql="update income_category set inc_catname='"+ex.getInc_catname()+"',inc_catdetails='"+ex.getInc_catdetails()+"', userid='"+ex.getUserid()+"' where inc_catid='"+ex.getInc_catid()+"'";

		int r=0;
		try {
		Statement stmt=conn.createStatement();
		r=stmt.executeUpdate(sql);
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return r;
		}

		public int Remove(int inc_catid) {
		//Write SQL Query and create instance ofConnection

		Connection conn=ConnectionPool.connectDB();

		String sql="delete from income_category where inc_catid='"+inc_catid+"' ";
		int r=0;
		try {
		Statement stmt=conn.createStatement();
		r=stmt.executeUpdate(sql);
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return r;
		}
		public ArrayList<IncomeCategoryBean>  FindAll(){
			ArrayList<IncomeCategoryBean> al=new ArrayList<IncomeCategoryBean>();
			Connection conn=ConnectionPool.connectDB();
			String sql="select * from income_category";
			try {
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next()) {
					IncomeCategoryBean em=new IncomeCategoryBean();
					em.setInc_catid(rs.getInt("inc_catid"));
					em.setInc_catname(rs.getString("inc_catname"));
					em.setInc_catdetails(rs.getString("inc_catdetails"));
					em.setUserid(rs.getInt("userid"));
					
					al.add(em);
					}
				conn.close();
			}	catch(SQLException e) {
					e.printStackTrace();
				}
		return al;
		}
		public IncomeCategoryBean  Find(int inc_catid){
			IncomeCategoryBean em=new IncomeCategoryBean();
		Connection conn=ConnectionPool.connectDB();
			String sql="select * from income_category where inc_catid='"+inc_catid+"'";
			try {
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next()) {
					em.setInc_catid(rs.getInt("inc_catid"));
					em.setInc_catname(rs.getString("inc_catname"));
					em.setInc_catdetails(rs.getString("inc_catdetails"));
					em.setUserid(rs.getInt("userid"));
					
					}
				conn.close();
			}	catch(SQLException e) {
					e.printStackTrace();
				}
		return em;
		}
		public ArrayList<IncomeCategoryBean> findAll(int userid){
			ArrayList<IncomeCategoryBean> al=new ArrayList<IncomeCategoryBean>();
			Connection conn=ConnectionPool.connectDB();
			String sql="select * from income_category where userid='"+ userid+"'";
			try {
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next()) {
					IncomeCategoryBean em=new IncomeCategoryBean();
					em.setInc_catid(rs.getInt("inc_catid"));
					em.setInc_catname(rs.getString("inc_catname"));
					em.setInc_catdetails(rs.getString("inc_catdetails"));
					em.setUserid(rs.getInt("userid"));
					
					al.add(em);
					}
				conn.close();
			}	catch(SQLException e) {
					e.printStackTrace();
				}
		return al;
		}
		public static void main(String args[]) {
	//	EmpDeo ed=new EmpDeo();
		//EmpBean ex=new EmpBean();
		/*ex.setEmpno(108);
		ex.setName("Anikartik");
		ex.setSal(90534.4f);
		int r=ed.AddEmployee(ex);
		int r=ed.UpdateEmployee(ex);
		int r=ed.DeleteEmployee(102);
		if(r>0) {
		System.out.println("Data add success");
		}
		else {
		System.out.println("Data not add");
		}*/
		//for findall()
		/*ArrayList<EmpBean>ax=ed.findAll();
		for(EmpBean eb:ax) {
		System.out.println(eb.getName()+"   "+eb.getEmpno()+"   "+eb.getSal());
		}*/
		//for findbyEmpno()
		//EmpBean eb=ed.findByEmpno(101);
		//System.out.println(eb.getName()+"   "+eb.getEmpno()+"   "+eb.getSal());
		/*IncomeBean ed=new IncomeBean();
		IncomeDAO ex=new IncomeDAO();
		ed.setInc_id(972244);
		ed.setInc_ac("Saving");
		ed.setUserid(646599);
		ed.setInc_catid(001);
		ed.setAmount(40000.00);
		ed.setTransaction_date("2022-08-20");
		ed.setReceivby("Check");
		ed.setRemark("MarkCompany");
		int r=ex.Create(ed);
		if(r>0) {
			System.out.println("Data add success");
			}
			else {
			System.out.println("Data not add");*/
		IncomeCategoryBean ed=new IncomeCategoryBean();
			IncomeCategoryDAO ex=new IncomeCategoryDAO();
			//ed.setInc_catid(18444);
			ed.setInc_catname("Normal..");
			ed.setUserid(476599);
			ed.setInc_catdetails("by BOS bank");
			
			int r=ex.Create(ed);
			if(r>0) {
				System.out.println( " Data add succesfull");
				}
				else {
				System.out.println("Data not add");}
			/*IncomeBean ed=new IncomeBean();
			IncomeDAO ex=new IncomeDAO();
			int r=ex.Remove(5465);
			if(r>0) {
			System.out.println("Deleted successfull");
			}
			else {
			System.out.println("Not Deleted successfull");*/
		/*	IncomeCategoryDAO eu=new IncomeCategoryDAO();
			
			ArrayList<IncomeCategoryBean>ax=eu.FindAll();
			
			
			
			for(IncomeCategoryBean eb:ax) {
			System.out.println(eb.getInc_catid()+"   "+eb.getInc_catname()+"   "+eb.getInc_catdetails()+"   "+eb.getUserid());	
			
			
			*/
		 /*  IncomeCategoryDAO er=new IncomeCategoryDAO();
			IncomeCategoryBean eb=er.Find(18444);
			System.out.println(eb.getInc_catid()+"   "+eb.getInc_catname()+"   "+eb.getInc_catdetails()+"   "+eb.getUserid());	
		*/
		/*	IncomeCategoryDAO eu=new IncomeCategoryDAO();

			ArrayList<IncomeCategoryBean>ax=eu.findAll(486599);
			
			for(IncomeCategoryBean eb:ax) {
			System.out.println(eb.getInc_catid()+"   "+eb.getInc_catname()+"   "+eb.getInc_catdetails()+"   "+eb.getUserid());	
			
		}*/
		}
		
		
}
