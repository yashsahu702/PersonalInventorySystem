package com.personalinventorysystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.personalinventorysystem.bean.CashBookBean;
import com.personalinventorysystem.utility.ConnectionPool;

public class CashBookDAO {
	




		
			public int Create(CashBookBean ex) {
				//Write SQL  and create instance of Connection

				

				Connection conn=ConnectionPool.connectDB();
				String sql="insert into cash_book(account, transaction_date, amount, userid, operation) values('"+ex.getAccount()+"','"+ex.getTransaction_date()+"','"+ex.getAmount()+"','"+ex.getUserid()+"','"+ex.getOperation()+"')";

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

				public int Edit(CashBookBean ex) {
				//Write SQL Query and create instance ofConnection

				Connection conn=ConnectionPool.connectDB();
				String sql="update cash_book set account='"+ex.getAccount()+"',transaction_date='"+ex.getTransaction_date()+"',amount='"+ex.getAmount()+"',userid='"+ex.getUserid()+"',operation= '"+ex.getOperation()+"'where  acid='"+ex.getAcid()+"'";

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

				public int Remove(int acid) {
				//Write SQL Query and create instance ofConnection

				Connection conn=ConnectionPool.connectDB();

				String sql="delete from cash_book where acid='"+acid+"' ";
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
				public ArrayList<CashBookBean>  FindAll(){
					ArrayList<CashBookBean> al=new ArrayList<CashBookBean>();
					Connection conn=ConnectionPool.connectDB();
					String sql="select * from cash_book";
					try {
						Statement stmt=conn.createStatement();
						ResultSet rs=stmt.executeQuery(sql);
						while(rs.next()) {
							CashBookBean em=new CashBookBean();
							em.setAcid(rs.getInt("acid"));
							em.setAccount(rs.getString("account"));
							em.setTransaction_date(rs.getString("transaction_date"));				
							em.setAmount(rs.getDouble("amount"));
							em.setUserid(rs.getInt("userid"));
							em.setOperation(rs.getString("operation"));
							
							al.add(em);
							}
						conn.close();
					}	catch(SQLException e) {
							e.printStackTrace();
						}
				return al;
				}
				public CashBookBean  Find(int acid){
					CashBookBean em=new CashBookBean();
				Connection conn=ConnectionPool.connectDB();
					String sql="select * from cash_book  where acid='"+acid+"'";
					try {
						Statement stmt=conn.createStatement();
						ResultSet rs=stmt.executeQuery(sql);
						while(rs.next()) {
							em.setAcid(rs.getInt("acid"));
							em.setAccount(rs.getString("account"));
							em.setTransaction_date(rs.getString("transaction_date"));				
							em.setAmount(rs.getDouble("amount"));
							em.setUserid(rs.getInt("userid"));
							em.setOperation(rs.getString("operation"));
						
							}
						conn.close();
					}	catch(SQLException e) {
							e.printStackTrace();
						}
				return em;
				}
				public ArrayList<CashBookBean> findAllDateWise(String sdate,String edate,int userid) {
					ArrayList<CashBookBean> al=new ArrayList<CashBookBean>();
					Connection conn=ConnectionPool.connectDB();
					String sql="select * from cash_book where userid='"+userid+"'and transaction_date between '"+sdate+"' and '"+edate+"'";
					try {
						Statement stmt=conn.createStatement();
						ResultSet rs=stmt.executeQuery(sql);
						while(rs.next()) {
							CashBookBean em=new CashBookBean();
							em.setAcid(rs.getInt("acid"));
							em.setAccount(rs.getString("account"));
							em.setTransaction_date(rs.getString("transaction_date"));				
							em.setAmount(rs.getDouble("amount"));
							em.setUserid(rs.getInt("userid"));
							em.setOperation(rs.getString("operation"));
							al.add(em);
					}
						conn.close();
					}	catch(SQLException e) {
							e.printStackTrace();
						}
					
					
					return al;
				}
				public double closingBalance(int userid) throws SQLException {
					
					Connection conn=ConnectionPool.connectDB();
					String sql="SELECT (SELECT sum(amount)AS total_payment FROM cash_book WHERE userid='"+userid+"' AND operation='receive')-(SELECT sum(amount)AS total_receive FROM cash_book WHERE userid='"+userid+"' AND operation='pay')AS closing_balance FROM DUAL";
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					 double r=0;
					while(rs.next()) {
						
				    r= rs.getDouble("closing_balance");
				  
					}
					return r;
					
				}
	public double closingBalance(int userid,String sdate,String edate) throws SQLException {
					
					Connection conn=ConnectionPool.connectDB();
					String sql="SELECT (SELECT sum(amount)AS total_payment FROM cash_book WHERE userid='"+userid+"'and transaction_date between '"+sdate+"' and '"+edate+"' AND operation='receive')-(SELECT sum(amount)AS total_receive FROM cash_book WHERE userid='"+userid+"'and transaction_date between '"+sdate+"' and '"+edate+"' AND operation='pay')AS closing_balance FROM DUAL";
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					 double r=0;
					while(rs.next()) {
						
				    r= rs.getDouble("closing_balance");
				  
					}
					return r;
					
				}
			public static void main(String args[]) throws SQLException {
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
				CashBookBean em=new CashBookBean();
				CashBookDAO ex=new CashBookDAO();
				
				em.setAccount("Saving");
				em.setTransaction_date("2022-09-28");				
				em.setAmount(5000);
				em.setUserid(185354);
				em.setOperation("receive");
				int r=ex.Create(em);
				if(r>0) {
					System.out.println("Data add success");
					}
					else {
					System.out.println("Data not add");}
				/*IncomeBean ed=new IncomeBean();
					IncomeDAO ex=new IncomeDAO();
					ed.setInc_id(88844);
					ed.setInc_ac("Saving");
					ed.setUserid(646599);
					ed.setInc_catid(001);
					ed.setAmount(80000.00);
					ed.setTransaction_date("2022-08-20");
					ed.setReceivby("Cash");
					ed.setRemark("MarkCompany");
					int r=ex.Edit(ed);
					if(r>0) {
						System.out.println("Data add success");
						}
						else {
						System.out.println("Data not add");*/
					/*IncomeBean ed=new IncomeBean();
					IncomeDAO ex=new IncomeDAO();
					int r=ex.Remove(5465);
					if(r>0) {
					System.out.println("Deleted successfull");
					}
					else {
					System.out.println("Not Deleted successfull");*/
				/*	CashBookDAO ex=new CashBookDAO();
					ArrayList<CashBookBean>ax=ex.FindAll();
					
					for(CashBookBean eb:ax) {
					System.out.println(eb.getAcid()+"   "+eb.getAccount()+"   "+eb.getTransaction_date()+"   "+eb.getAmount()+"   "+eb.getOperation());
					}*/
					/*CashBookDAO ex=new CashBookDAO();
				    CashBookBean eb=ex.Find(418854);
					System.out.println(eb.getAcid()+"   "+eb.getAccount()+"   "+eb.getTransaction_date()+"   "+eb.getAmount()+"   "+eb.getOperation());
				*/
		/*	  CashBookDAO p=new CashBookDAO();
			    ArrayList<CashBookBean>ax=p.findAllDateWise("2022-08-02","2022-08-30",185324);
				
				for(CashBookBean eb:ax) {			
					System.out.println(eb.getAcid()+"   "+eb.getAccount()+"   "+eb.getTransaction_date()+"   "+eb.getAmount()+"   "+eb.getOperation());
				
		
				}
				CashBookDAO ex1=new CashBookDAO();
				    double eb=ex1.closingBalance(185324,"2022-08-01","2022-08-30");
				    System.out.println(eb);
			*/
		}
				 /* System.out.println(eb.getAccount()+"   "+eb.getTransaction_date()+"   "+eb.getAmount()+"   "+eb.getUserid()+"   "+eb.getOperation());
		}*/
		}
			
			

				





