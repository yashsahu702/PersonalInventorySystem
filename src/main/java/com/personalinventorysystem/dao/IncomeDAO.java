package com.personalinventorysystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.personalinventorysystem.bean.IncomeBean;
import com.personalinventorysystem.utility.ConnectionPool;

public class IncomeDAO {
	public int Create(IncomeBean ex) {
		//Write SQL  and create instance of Connection

		

		Connection conn=ConnectionPool.connectDB();
		String sql="insert into incomes(inc_ac,userid,inc_catid,amount,transaction_date,receivby,remark) values('"+ex.getInc_ac()+"','"+ex.getUserid()+"','"+ex.getInc_catid()+"','"+ex.getAmount()+"','"+ex.getTransaction_date()+"','"+ex.getReceivby()+"','"+ex.getRemark()+"')";

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

		public int Edit(IncomeBean ex) {
		//Write SQL Query and create instance ofConnection

		Connection conn=ConnectionPool.connectDB();
		String sql="update incomes set inc_ac='"+ex.getInc_ac()+"', userid='"+ex.getUserid()+"',inc_catid='"+ex.getInc_catid()+"',amount='"+ex.getAmount()+"',transaction_date= '"+ex.getTransaction_date()+"',receivby='"+ex.getReceivby()+"', remark='"+ex.getRemark()+"'where inc_id='"+ex.getInc_id()+"'";

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

		public int Remove(int inc_id) {
		//Write SQL Query and create instance ofConnection

		Connection conn=ConnectionPool.connectDB();

		String sql="delete from incomes where inc_id='"+inc_id+"' ";
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
		public ArrayList<IncomeBean>  FindAll(){
			ArrayList<IncomeBean> al=new ArrayList<IncomeBean>();
			Connection conn=ConnectionPool.connectDB();
			String sql="select * from incomes";
			try {
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next()) {
					IncomeBean em=new IncomeBean();
					em.setInc_id(rs.getInt("inc_id"));
					em.setInc_ac(rs.getString("inc_ac"));
					em.setUserid(rs.getInt("userid"));
					em.setInc_catid(rs.getInt("inc_catid"));
					em.setAmount(rs.getDouble("amount"));
					em.setTransaction_date(rs.getString("transaction_date"));
					em.setReceivby(rs.getString("receivby"));
					em.setRemark(rs.getString("remark"));
					al.add(em);
					}
				conn.close();
			}	catch(SQLException e) {
					e.printStackTrace();
				}
		return al;
		}
		public IncomeBean  Find(int inc_id){
			IncomeBean em=new IncomeBean();
		Connection conn=ConnectionPool.connectDB();
			String sql="select * from incomes where inc_id='"+inc_id+"'";
			try {
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next()) {
					
					em.setInc_id(rs.getInt("inc_id"));
					em.setInc_ac(rs.getString("inc_ac"));
					em.setUserid(rs.getInt("userid"));
					em.setInc_catid(rs.getInt("inc_catid"));
					em.setAmount(rs.getDouble("amount"));
					em.setTransaction_date(rs.getString("transaction_date"));
					em.setReceivby(rs.getString("receivby"));
					em.setRemark(rs.getString("remark"));
					}
				conn.close();
			}	catch(SQLException e) {
					e.printStackTrace();
				}
		return em;
		}
		public ArrayList<IncomeBean>  findAll(int userid){
			ArrayList<IncomeBean> al=new ArrayList<IncomeBean>();
			Connection conn=ConnectionPool.connectDB();
			String sql="select * from incomes where userid='"+userid+"'";
			try {
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next()) {
					IncomeBean em=new IncomeBean();
					em.setInc_id(rs.getInt("inc_id"));
					em.setInc_ac(rs.getString("inc_ac"));
					em.setUserid(rs.getInt("userid"));
					em.setInc_catid(rs.getInt("inc_catid"));
					em.setAmount(rs.getDouble("amount"));
					em.setTransaction_date(rs.getString("transaction_date"));
					em.setReceivby(rs.getString("receivby"));
					em.setRemark(rs.getString("remark"));
					al.add(em);
					}
				conn.close();
			}	catch(SQLException e) {
					e.printStackTrace();
				}
		return al;
		}
		public ArrayList<IncomeBean> findAllDateWise(String sdate,String edate,int userid) {
			ArrayList<IncomeBean> al=new ArrayList<IncomeBean>();
			Connection conn=ConnectionPool.connectDB();
			String sql="select * from incomes where userid='"+userid+"'and transaction_date between '"+sdate+"' and '"+edate+"'";
			try {
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next()) {
					IncomeBean em=new IncomeBean();
					em.setInc_id(rs.getInt("inc_id"));
					em.setInc_ac(rs.getString("inc_ac"));
					em.setUserid(rs.getInt("userid"));
					em.setInc_catid(rs.getInt("inc_catid"));
					em.setAmount(rs.getDouble("amount"));
					em.setTransaction_date(rs.getString("transaction_date"));
					em.setReceivby(rs.getString("receivby"));
					em.setRemark(rs.getString("remark"));
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
		IncomeBean ed=new IncomeBean();
		IncomeDAO ex=new IncomeDAO();
		//ed.setInc_id(612244);
		ed.setInc_ac("Saving");
		ed.setUserid(656599);
		ed.setInc_catid(521);
		ed.setAmount(22000.00);
		ed.setTransaction_date("2022-09-15");
		ed.setReceivby("Check");
		ed.setRemark("TSTCompany");
		int r=ex.Create(ed);
		if(r>0) {
			System.out.println("Data add success");
			}
			else {
			System.out.println("Data not add");
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
			int r=ex.Remove(5465);
			if(r>0) {
			System.out.println("Deleted successfull");
			}
			else {
			System.out.println("Not Deleted successfull");*/
			/*IncomeDAO ex=new IncomeDAO();
			ArrayList<IncomeBean>ax=ex.FindAll();
			
			for(IncomeBean eb:ax) {
			System.out.println(eb.getInc_id()+"   "+eb.getInc_ac()+"   "+eb.getUserid()+"   "+eb.getInc_catid()+"   "+eb.getAmount()+"   "+eb.getTransaction_date()+"    "+eb.getReceivby()+"   "+eb.getRemark());
			}*/
			/*IncomeDAO ex=new IncomeDAO();
			IncomeBean eb=ex.Find(112244);
			System.out.println(eb.getInc_id()+"   "+eb.getInc_ac()+"   "+eb.getUserid()+"   "+eb.getInc_catid()+"   "+eb.getAmount()+"   "+eb.getTransaction_date()+"    "+eb.getReceivby()+"   "+eb.getRemark());
		*/
		/*	IncomeDAO ex=new IncomeDAO();
			ArrayList<IncomeBean>ax=ex.findAll(646599);
			
			for(IncomeBean eb:ax) {
			System.out.println(eb.getInc_id()+"   "+eb.getInc_ac()+"   "+eb.getUserid()+"   "+eb.getInc_catid()+"   "+eb.getAmount()+"   "+eb.getTransaction_date()+"    "+eb.getReceivby()+"   "+eb.getRemark());
			}*/
		/*	IncomeDAO ex=new IncomeDAO();
			ArrayList<IncomeBean>ax=ex.findAllDateWise("2022-08-01","2022-12-01",646599);
			
			for(IncomeBean eb:ax) {
			System.out.println(eb.getInc_id()+"   "+eb.getInc_ac()+"   "+eb.getUserid()+"   "+eb.getInc_catid()+"   "+eb.getAmount()+"   "+eb.getTransaction_date()+"    "+eb.getReceivby()+"   "+eb.getRemark());
			*/}
		}

		
}
