package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



public class EmpDAO {
	
	Connection getConnect() throws SQLException {
		String url="jdbc:oracle:thin:@localhost:1521:xe"; //오라클 디비 접속정보.
		String user="hr"; 
		String password="hr"; 
		Connection conn=null; 
		//커넥션 객체 만들기 
		try {	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return conn; 
		}//end of getConnect().
	
		//상세조회 
	public Employee selectEmp(int empNo) {
		String query="select * from tbl_employees "
				+"where emp_no=?";
		try {
			PreparedStatement stmt=getConnect().prepareStatement(query);
			stmt.setInt(1, empNo); 
			
			ResultSet rs=stmt.executeQuery(); //조회. 
			if(rs.next()) {//조회결과가 한건 있으면...
				Employee emp=new Employee(); 
				emp.setNum(rs.getInt("emp_no"));
				emp.setName(rs.getString("emp_name"));
				emp.setTel(rs.getString("tel_no"));
				emp.setDate(rs.getDate("hire_date"));
				emp.setMoney(rs.getInt("salary"));
				
				return emp; //반환 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return null; //조회된 결과가 없는 경우 
		
	}
	
	
//등록.  
public boolean registerEMP(Employee emp) {//등록. 
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
		String query="insert into tbl_employees ";
		query+="values ("+emp.getNum()
											+", '"+emp.getName()
											+"', '"+emp.getTel()
											+"', '"+sdf.format(emp.getDate())
											+"', "+emp.getMoney()
											+")"; 
		try {
			Statement stmt=getConnect().createStatement();
			int r=stmt.executeUpdate(query);
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}//end of resisterEmp(). 
	
	
	
public List<Employee> search(Employee emp) {
		List<Employee> empList=new ArrayList<>(); 
		String qry="select * from tbl_employees "+
				"where emp_name = nvl(?,emp_name) " //number ,varchar2에 따라처리 
				+"order by emp_no";
		try {
//			Statement stmt=getConnect().createStatement();
			PreparedStatement stmt=getConnect().prepareStatement(qry); 
			stmt.setString(1,emp.getName()); //첫번째 ?에 사원이름을 대입 
			ResultSet rs=stmt.executeQuery();
			//조회결과
			while(rs.next()) {
				Employee empl=new Employee();
				empl.setNum(rs.getInt("emp_no"));
				empl.setName(rs.getString("emp_name"));
				empl.setDate(rs.getDate("hire_date"));
				empl.setMoney(rs.getInt("salary"));
				empl.setTel(rs.getString("tel_no"));
				
				empList.add(empl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}
}
