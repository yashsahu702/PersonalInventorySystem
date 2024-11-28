package com.personalinventorysystem.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.personalinventorysystem.bean.BankBookBean;
import com.personalinventorysystem.utility.ConnectionPool;

public class BankBookDAO {



	
		public int Create(BankBookBean ex) {
			//Write SQL  and create instance of Connection

			

			Connection conn=ConnectionPool.connectDB();
			String sql="insert into bank_book values('"+ex.getAcid()+"','"+ex.getAccount()+"','"+ex.getTransaction_date()+"','"+ex.getAmount()+"','"+ex.getUserid()+"','"+ex.getOperation()+"')";

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

			public int Edit(BankBookBean ex) {
			//Write SQL Query and create instance ofConnection

			Connection conn=ConnectionPool.connectDB();
			String sql="update bank_book set account='"+ex.getAccount()+"',transaction_date='"+ex.getTransaction_date()+"',amount='"+ex.getAmount()+"', userid='"+ex.getUserid()+"',operation= '"+ex.getOperation()+"'where acid='"+ex.getAcid()+"'";

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

			String sql="delete from bank_book where acid='"+acid+"' ";
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
			public ArrayList<BankBookBean>  FindAll(){
				ArrayList<BankBookBean> al=new ArrayList<BankBookBean>();
				Connection conn=ConnectionPool.connectDB();
				String sql="select * from bank_book";
				try {
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next()) {
						BankBookBean em=new BankBookBean();
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
			public BankBookBean  Find(int acid){
				BankBookBean em=new BankBookBean();
			Connection conn=ConnectionPool.connectDB();
				String sql="select * from bank_book  where acid='"+acid+"'";
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
				public ArrayList<BankBookBean> findAllDateWise(String sdate,String edate,int userid) {
				ArrayList<BankBookBean> al=new ArrayList<BankBookBean>();
				Connection conn=ConnectionPool.connectDB();
				String sql="select * from bank_book where userid='"+userid+"'and transaction_date between '"+sdate+"' and '"+edate+"'";
				try {
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next()) {
						BankBookBean em=new BankBookBean();
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
				String sql="SELECT (SELECT sum(amount)AS total_payment FROM bank_book WHERE userid='"+userid+"' AND operation='receive')-(SELECT sum(amount)AS total_receive FROM bank_book WHERE userid='"+userid+"' AND operation='pay')AS closing_balance FROM DUAL";
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
				String sql="SELECT (SELECT sum(amount)AS total_payment FROM bank_book WHERE userid='"+userid+"'and transaction_date between '"+sdate+"' and '"+edate+"' AND operation='receive')-(SELECT sum(amount)AS total_receive FROM bank_book WHERE userid='"+userid+"'and transaction_date between '"+sdate+"' and '"+edate+"' AND operation='pay')AS closing_balance FROM DUAL";
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
			BankBookBean em=new BankBookBean();
			BankBookDAO ex=new BankBookDAO();
		//	em.setAcid(254654);
			em.setAccount("Saving");
			em.setTransaction_date("2022-09-28");				
			em.setAmount(4000);
			em.setUserid(185354);
			em.setOperation("pay");
			int r=ex.Create(em);
			if(r>0) {
				System.out.println("Data add success");
				}
				else {
				System.out.println("Data not add");}
			/*	IncomeBean ed=new IncomeBean();
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
				int r=ex.Remove(456854);
				if(r>0) {
				System.out.println("Deleted successfull");
				}
				else {
				System.out.println("Not Deleted successfull");*/
				/*BankBookDAO ex=new BankBookDAO();
				ArrayList<BankBookBean>ax=ex.FindAll();
				
				for(BankBookBean eb:ax) {
				System.out.println(eb.getAcid()+"   "+eb.getAccount()+"   "+eb.getTransaction_date()+"   "+eb.getAmount()+"   "+eb.getOperation());
				}*/
 BankBookDAO eu=new BankBookDAO();
ArrayList<BankBookBean>ax=eu.findAllDateWise("2021-06-02","2022-12-01",456522);
				
for(BankBookBean eb:ax) {			
System.out.println(eb.getAcid()+"   "+eb.getAccount()+"   "+eb.getTransaction_date()+"   "+eb.getAmount()+"   "+eb.getOperation());
				}
			
				
			/*	BankBookDAO ex1=new BankBookDAO();
				    double eb=ex1.closingBalance(476522,"2022-05-02","2022-12-02");
				    System.out.println(eb);
			*/
			
				 /* System.out.println(eb.getAccount()+"   "+eb.getTransaction_date()+"   "+eb.getAmount()+"   "+eb.getUserid()+"   "+eb.getOperation());
		}*/
							
					
			
		}
		}

			



