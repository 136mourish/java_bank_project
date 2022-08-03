package javabankproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
	
	static Connection con;
	Statement st;
	String sql;
	
	public void connection() {
		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url= "jdbc:oracle:thin:@localhost:1521:orcl";
			String username="scott";
			String password="tiger";
			
			
			
			 con = DriverManager.getConnection(url,username,password);			
			st = con.createStatement();
		}
		catch (Exception e) {
			System.out.println("connection Failed");
			
		}
	}
		
		
	public int create(String name, String type, int balance, int pin) 
	{
		int ac_no = 0;
		
		sql=" insert into accounts values ( a_id.NEXTVAL,'"+name+"',"+balance+","+pin+",'"+type+"')";
		
		try {
			if(st.executeUpdate(sql)==1) {
				ResultSet rs = st.executeQuery("select * from accounts order by ac_no desc ");
				
				while(rs.next()) {
					ac_no=rs.getInt(1);
					break;
			
								}
	}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return ac_no;
		
	}
		
		
	public int 	check(int ac_no , int pin) {
		int balance = -1;
		
		sql= " select balance from accounts where ac_no="+ac_no+" and pin="+pin;
		
		try {
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				balance =rs.getInt(1);
				
			
				}
		}
			
			
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return balance;
		
	}
	
	public int withdrawal(int ac_no,int pin,int amnt) {
		
		int balance = 0;
	
		sql= " select balance from accounts where ac_no="+ac_no+" and pin="+pin ;
		
		try {
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				balance =rs.getInt(1);
				if(balance<amnt) {
					System.out.println("Insufficient balance");
					
				}
				else {
					
					System.out.println("withdrawn amount:"+amnt);
					balance = balance-amnt;
					sql = " update accounts set balance="+balance+" where ac_no="+ac_no;
					if(st.executeUpdate(sql)== 1) {
						System.out.println("amount debited");
						
					}
					else
					{ balance=-1;
					
					}
				}
				
			
			
				}
		}
			
			
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		return balance;
		
	}
	
public int depo(int ac_no,int pin,int amnt) {
		
		int balance = 0;
	
		sql= " select balance from accounts where ac_no="+ac_no+" and pin="+pin ;
		
		try {
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				balance =rs.getInt(1);
				
					
					System.out.println("deposit amount:"+amnt);
					balance = balance+amnt;
					sql = " update accounts set balance="+balance+" where ac_no="+ac_no;
					if(st.executeUpdate(sql)==1) {
						System.out.println("amount added"); 
						
					}
					else
					{ balance=-1;
					
					}
					
					
				
				
				
			
				}
		}
			
			
		 catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		
		
		
		return balance;
		
	}
	
	
	
	
		
		
		
		
	}
	
	

