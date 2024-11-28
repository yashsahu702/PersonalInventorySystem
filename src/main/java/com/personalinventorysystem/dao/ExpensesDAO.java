package com.personalinventorysystem.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.personalinventorysystem.bean.ExpensesBean;
import com.personalinventorysystem.utility.ConnectionPool;

public class ExpensesDAO {

	
	
		public int Create(ExpensesBean ex) {
			//Write SQL  and create instance of Connection

			

			Connection conn=ConnectionPool.connectDB();
			String sql="insert into expenses(exp_ac,userid,exp_catid,amount,transaction_date,payby,remark) values('"+ex.getExp_ac()+"','"+ex.getUserid()+"','"+ex.getExp_catid()+"','"+ex.getAmount()+"','"+ex.getTransaction_date()+"','"+ex.getPayby()+"','"+ex.getRemark()+"')";

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

			public int Edit(ExpensesBean ex) {
			//Write SQL Query and create instance ofConnection

			Connection conn=ConnectionPool.connectDB();
			String sql="update expenses set exp_ac='"+ex.getExp_ac()+"',userid='"+ex.getUserid()+"',exp_catid='"+ex.getExp_catid()+"',amount='"+ex.getAmount()+"',transaction_date= '"+ex.getTransaction_date()+"',payby='"+ex.getPayby()+"', remark='"+ex.getRemark()+"'where exp_id='"+ex.getExp_id()+"'";

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

			public int Remove(int exp_id) {
			//Write SQL Query and create instance ofConnection

			Connection conn=ConnectionPool.connectDB();

			String sql="delete from expenses where exp_id='"+exp_id+"'";
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
			public ArrayList<ExpensesBean>  FindAll(){
				ArrayList<ExpensesBean> al=new ArrayList<ExpensesBean>();
				Connection conn=ConnectionPool.connectDB();
				String sql="select * from expenses";
				try {
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next()) {
						ExpensesBean em=new ExpensesBean();
						em.setExp_id(rs.getInt("exp_id"));
						em.setExp_ac(rs.getString("exp_ac"));
						em.setUserid(rs.getInt("userid"));
						em.setExp_catid(rs.getInt("exp_catid"));
						em.setAmount(rs.getDouble("amount"));
						em.setTransaction_date(rs.getString("transaction_date"));
						em.setPayby(rs.getString("payby"));
						em.setRemark(rs.getString("remark"));
						al.add(em);
						}
					conn.close();
				}	catch(SQLException e) {
						e.printStackTrace();
					}
			return al;
			}
			public ExpensesBean  Find(int exp_id){
				ExpensesBean em=new ExpensesBean();
			Connection conn=ConnectionPool.connectDB();
				String sql="select * from expenses where exp_id='"+exp_id+"'";
				try {
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next()) {
						
						em.setExp_id(rs.getInt("exp_id"));
						em.setExp_ac(rs.getString("exp_ac"));
						
						em.setExp_catid(rs.getInt("exp_catid"));
						em.setAmount(rs.getDouble("amount"));
						em.setTransaction_date(rs.getString("transaction_date"));
						em.setPayby(rs.getString("payby"));
						em.setRemark(rs.getString("remark"));
						
						
						}
					conn.close();
				}	catch(SQLException e) {
						e.printStackTrace();
					}
			return em;
			}
			public ArrayList<ExpensesBean>  findAll(int userid){
				ArrayList<ExpensesBean> al=new ArrayList<ExpensesBean>();
				Connection conn=ConnectionPool.connectDB();
				String sql="select * from expenses where userid='"+userid+"'";
				try {
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next()) {
						ExpensesBean em=new ExpensesBean();
						em.setExp_id(rs.getInt("exp_id"));
						em.setExp_ac(rs.getString("exp_ac"));
						em.setUserid(rs.getInt("userid"));
						em.setExp_catid(rs.getInt("exp_catid"));
						em.setAmount(rs.getDouble("amount"));
						em.setTransaction_date(rs.getString("transaction_date"));
						em.setPayby(rs.getString("payby"));
						em.setRemark(rs.getString("remark"));
						al.add(em);
						}
					conn.close();
				}	catch(SQLException e) {
						e.printStackTrace();
					}
			return al;
			}
			public ArrayList<ExpensesBean> findAllDateWise(String sdate,String edate,int userid) {
				ArrayList<ExpensesBean> al=new ArrayList<ExpensesBean>();
				Connection conn=ConnectionPool.connectDB();
				String sql="select * from expenses where userid='"+userid+"'and transaction_date between '"+sdate+"' and '"+edate+"'";
				try {
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next()) {
						ExpensesBean em=new ExpensesBean();
						em.setExp_id(rs.getInt("exp_id"));
						em.setExp_ac(rs.getString("exp_ac"));
						em.setUserid(rs.getInt("userid"));
						em.setExp_catid(rs.getInt("exp_catid"));
						em.setAmount(rs.getDouble("amount"));
						em.setTransaction_date(rs.getString("transaction_date"));
						em.setPayby(rs.getString("payby"));
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
			ExpensesBean ed=new ExpensesBean();
			ExpensesDAO ex=new ExpensesDAO();
			//ed.setExp_id(452244);
			ed.setExp_ac("Current");
			ed.setUserid(856599);
			//ed.setExp_catid(7867);
			ed.setAmount(88200.00);
			ed.setTransaction_date("2022-12-26");
			ed.setPayby("&Cash");
			ed.setRemark("OOSCompany");
			int r=ex.Create(ed);
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
				int r=ex.Remove(5465);
				if(r>0) {
				System.out.println("Deleted successfull");
				}
				else {
				System.out.println("Not Deleted successfull");*/
				ExpensesDAO ea=new ExpensesDAO();
				ArrayList<ExpensesBean>ax=ea.FindAll();
				
				for(ExpensesBean eb:ax) {
				System.out.println(eb.getExp_id()+"   "+eb.getExp_ac()+"   "+eb.getUserid()+"   "+eb.getExp_catid()+"   "+eb.getAmount()+"   "+eb.getTransaction_date()+"    "+eb.getPayby()+"   "+eb.getRemark());
				}
				/*ExpensesDAO ex=new ExpensesDAO();
				ExpensesBean eb=ex.Find(292244);
				System.out.println(eb.getExp_id()+"   "+eb.getExp_ac()+"   "+eb.getUserid()+"   "+eb.getExp_catid()+"   "+eb.getAmount()+"   "+eb.getTransaction_date()+"    "+eb.getPayby()+"   "+eb.getRemark());
				*//*ExpensesDAO ex=new ExpensesDAO();
				ArrayList<ExpensesBean>ax=ex.findAllDateWise("2022-05-01","2022-12-01",706599);
				
				for(ExpensesBean eb:ax) {
				System.out.println(eb.getExp_id()+"   "+eb.getExp_ac()+"   "+eb.getUserid()+"   "+eb.getExp_catid()+"   "+eb.getAmount()+"   "+eb.getTransaction_date()+"    "+eb.getPayby()+"   "+eb.getRemark());
				}*/
				//}
		
}

}



