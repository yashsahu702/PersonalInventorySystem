package com.personalinventorysystem.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.personalinventorysystem.bean.ExpensesCategoryBean;
import com.personalinventorysystem.utility.ConnectionPool;

public class ExpensesCategoryDAO {
	
	
	
		public int Create(ExpensesCategoryBean ex) {
			//Write SQL  and create instance of Connection

			

			Connection conn=ConnectionPool.connectDB();
			String sql="insert into expenses_category(exp_catname,exp_catdetails,userid) values('"+ex.getExp_catname()+"','"+ex.getExp_catdetails()+"','"+ex.getUserid()+"')";

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

			public int Edit(ExpensesCategoryBean ex) {
			//Write SQL Query and create instance ofConnection

			Connection conn=ConnectionPool.connectDB();
			String sql="update expenses_category set exp_catname='"+ex.getExp_catname()+"',exp_catdetails='"+ex.getExp_catdetails()+"',userid='"+ex.getUserid()+"'where exp_catid='"+ex.getExp_catid()+"' ";

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

			public int Remove(int exp_catid) {
			//Write SQL Query and create instance ofConnection

			Connection conn=ConnectionPool.connectDB();

			String sql="delete from expenses_category where exp_catid='"+exp_catid+"' ";
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
			public ArrayList<ExpensesCategoryBean>  FindAll(){
				ArrayList<ExpensesCategoryBean> al=new ArrayList<ExpensesCategoryBean>();
				Connection conn=ConnectionPool.connectDB();
				String sql="select * from expenses_category";
				try {
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next()) {
						ExpensesCategoryBean em=new ExpensesCategoryBean();
						em.setExp_catid(rs.getInt("exp_catid"));
						em.setExp_catname(rs.getString("exp_catname"));
						em.setExp_catdetails(rs.getString("exp_catdetails"));
						em.setUserid(rs.getInt("userid"));
						
						al.add(em);
						}
					conn.close();
				}	catch(SQLException e) {
						e.printStackTrace();
					}
			return al;
			}
			public ExpensesCategoryBean  Find(int exp_catid){
				ExpensesCategoryBean em=new ExpensesCategoryBean();
			Connection conn=ConnectionPool.connectDB();
				String sql="select * from expenses_category where exp_catid='"+exp_catid+"'";
				try {
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next()) {
						em.setExp_catid(rs.getInt("exp_catid"));
						em.setExp_catname(rs.getString("exp_catname"));
						em.setExp_catdetails(rs.getString("exp_catdetails"));
						em.setUserid(rs.getInt("userid"));
						
						}
					conn.close();
				}	catch(SQLException e) {
						e.printStackTrace();
					}
			return em;
			}
			public ArrayList<ExpensesCategoryBean> findAll(int userid){
				ArrayList<ExpensesCategoryBean> al=new ArrayList<ExpensesCategoryBean>();
				Connection conn=ConnectionPool.connectDB();
				String sql="select * from expenses_category where userid='"+ userid+"'";
				try {
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next()) {
						ExpensesCategoryBean em=new ExpensesCategoryBean();
						em.setExp_catid(rs.getInt("exp_catid"));
						em.setExp_catname(rs.getString("exp_catname"));
						em.setExp_catdetails(rs.getString("exp_catdetails"));
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
		ExpensesCategoryBean ed=new ExpensesCategoryBean();
				ExpensesCategoryDAO ex=new ExpensesCategoryDAO();
			//	ed.setExp_catid(23844);
				ed.setExp_catname("Normal..");
				ed.setUserid(236599);
				ed.setExp_catdetails("by WWE bank");
				
				int r=ex.Create(ed);
				if(r>0) {
					System.out.println( "Data add success");
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
				/*ExpensesCategoryDAO eu=new 	ExpensesCategoryDAO();
				ArrayList<ExpensesCategoryBean>ax=eu.FindAll();
				
				for(ExpensesCategoryBean eb:ax) {
				System.out.println(eb.getExp_catid()+"   "+eb.getExp_catname()+"   "+eb.getExp_catdetails()+"   "+eb.getUserid());	}
				
				*/
				
			/*ExpensesCategoryDAO eu=new 	ExpensesCategoryDAO();
				ExpensesCategoryBean eb=eu.FindAll(236599);
				System.out.println(eb.getExp_catid()+"   "+eb.getExp_catname()+"   "+eb.getExp_catdetails()+"   "+eb.getUserid());	}*/
			/*ExpensesCategoryDAO eu=new 	ExpensesCategoryDAO();
			ArrayList<ExpensesCategoryBean>ax=eu.findAll(236599);
			
			for(ExpensesCategoryBean eb:ax) {
			System.out.println(eb.getExp_catid()+"   "+eb.getExp_catname()+"   "+eb.getExp_catdetails()+"   "+eb.getUserid());	}
			*/
			}
				
			
			}



