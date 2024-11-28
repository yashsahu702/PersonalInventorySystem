package com.personalinventorysystem.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.personalinventorysystem.bean.UsersBean;
import com.personalinventorysystem.utility.ConnectionPool;

public class UsersDAO {
	

	
	
		public int createUser(UsersBean i) {
			//Write SQL  and create instance of Connection
			Connection conn=ConnectionPool.connectDB();
			
			
			
			String sql="insert into users(username,password,name,address,mobile,email) values('"+i.getUsername()+"','"+i.getPassword()+"','"+i.getName()+"','"+i.getAddress()+"','"+i.getMobile()+"','"+i.getEmail()+"')";

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

			public int Edit(UsersBean ex) {
			//Write SQL Query and create instance ofConnection

			Connection conn=ConnectionPool.connectDB();
			String sql="update users set userid='"+ex.getUserid()+"',username='"+ex.getUsername()+"',password='"+ex.getPassword()+"',name='"+ex.getName()+"',address= '"+ex.getAddress()+"',mobile='"+ex.getMobile()+"', email='"+ex.getEmail()+"'where userid='"+ex.getUserid()+"'";

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

			public int Remove(int userid) {
			//Write SQL Query and create instance ofConnection

			Connection conn=ConnectionPool.connectDB();

			String sql="delete from users where userid='"+userid+"' ";
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
			public ArrayList<UsersBean>  FindAll(){
				ArrayList<UsersBean> al=new ArrayList<UsersBean>();
				Connection conn=ConnectionPool.connectDB();
				String sql="select * from users";
				try {
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next()) {
						UsersBean em=new UsersBean();
						em.setUserid(rs.getInt("userid"));
						em.setUsername(rs.getString("username"));
						em.setPassword(rs.getString("password"));
						em.setName(rs.getString("name"));
						em.setAddress(rs.getString("address"));
						em.setMobile(rs.getString("mobile"));
						em.setEmail(rs.getString("email"));
						
						al.add(em);
						}
					conn.close();
				}	catch(SQLException e) {
						e.printStackTrace();
					}
			return al;
			}
			public UsersBean  Find(int userid){
				UsersBean en=new UsersBean();
			Connection conn=ConnectionPool.connectDB();
				String sql="select * from users where userid='"+userid+"'";
				try {
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next()) {
						
						en.setUserid(rs.getInt("userid"));
						en.setUsername(rs.getString("username"));
						en.setPassword(rs.getString("password"));
						en.setName(rs.getString("name"));
						en.setAddress(rs.getString("address"));
						en.setMobile(rs.getString("mobile"));
						en.setEmail(rs.getString("email"));
						
					
						}
					conn.close();
				}	catch(SQLException e) {
						e.printStackTrace();
					}
		
			return en;
			}
			public UsersBean  Find(String username ){
				UsersBean en=new UsersBean();
			Connection conn=ConnectionPool.connectDB();
				String sql="select userid from users where username='"+username+"'";
				try {
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next()) {
						
						en.setUserid(rs.getInt("userid"));
					
						}
					conn.close();
				}	catch(SQLException e) {
						e.printStackTrace();
					}
		
			return en;
			}
			public int checkAvailability(String username) {
				Connection conn=ConnectionPool.connectDB();
				String sql="select userid from users where username='"+username+"'";
				Statement stmt = null;
				try {
					stmt = conn.createStatement();
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					int i=0;
					try {
				ResultSet rs =stmt.executeQuery(sql);
				
				while(rs.next()) {
					i=rs.getInt("userid");
				}}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return i;
			}
			
			public int checkAvailability(String username,String password) {
				Connection conn=ConnectionPool.connectDB();
				String sql="select userid from users where username='"+username+"' and password='"+password+"'";
				Statement stmt = null;
				try {
					stmt = conn.createStatement();
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
					int i=0;
					try {
				ResultSet rs =stmt.executeQuery(sql);
				
				while(rs.next()) {
					i=rs.getInt("userid");
				}}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return i;
			
			}
			
			public UsersBean authenticate(String username,String password) {
				 UsersBean en=new  UsersBean();
				Connection conn=ConnectionPool.connectDB();
				String sql="select * from users where username='"+username+"' and password='"+password+"'";
				
				try {
				Statement stmt = conn.createStatement();
				ResultSet rs =stmt.executeQuery(sql);
				
				while(rs.next()) {
					en.setUserid(rs.getInt("userid"));
					en.setUsername(rs.getString("username"));
					en.setPassword(rs.getString("password"));
					en.setName(rs.getString("name"));
					en.setAddress(rs.getString("address"));
					en.setMobile(rs.getString("mobile"));
					en.setEmail(rs.getString("email"));
					
				}}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return en ;
			
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
				UsersBean en=new UsersBean();
				UsersDAO ex=new UsersDAO();
				
				en.setUsername("Sahil1234");
				en.setPassword("95500sahil");
				en.setName(" Sahil Mishra");
				en.setAddress("Azad Ward ,Pipariya");
				en.setMobile("7895425158");
				en.setEmail("sahil736@gmail.com");
				int r=ex.createUser(en);
				if(r>0) {
					System.out.println("Data added");
					}
					else {
					System.out.println("Data not add");
					}
				/*IncomeBean ed=new IncomeBean();
				IncomeDAO ex=new IncomeDAO();
				int r=ex.Remove(5465);
				if(r>0) {
				System.out.println("Deleted successfull");
				}
				else {
				System.out.println("Not Deleted successfull");*/
			/*	UsersDAO ex=new UsersDAO();
			ArrayList<UsersBean>ax=ex.FindAll();
				
				for(UsersBean eb:ax) {
				System.out.println(eb.getUserid()+"   "+eb.getUsername()+"   "+eb.getPassword()+"   "+eb.getName()+"   "+eb.getAddress()+"   "+eb.getMobile()+"    "+eb.getEmail());
				}
				*/
		/*UsersDAO ep=new UsersDAO();
				UsersBean eb=ep.find("sahu1234","5424yash");
				System.out.println(eb.getUsername()+"   "+eb.getPassword()+"   "+eb.getName()+"   "+eb.getAddress()+"   "+eb.getMobile()+"    "+eb.getEmail());
			}*/
			/*UsersDAO ax=new UsersDAO();
			int a=ax.checkAvailability("Junior");
			if(a>0) {
				System.out.println(a);
			}else {
				System.out.println("User Not Available");
			}*/
		
		}
		}



