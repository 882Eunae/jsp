package com.yedam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.Student;

public class StudentDAO extends DAO {
	//등록 
	public boolean addStudent(Student student) {
		
		String sql="insert into tbl_student (student_no,student_name,phone,address)"
				+ "values(?,?,?,?)";
		
		try {
			psmt=getConnect().prepareStatement(sql);
			psmt.setString(1, student.getStudentNo());
			psmt.setString(2, student.getStudentName());
			psmt.setString(3, student.getPhone());
			psmt.setString(4, student.getAddress());
			//쿼리실행 
			int r=psmt.executeUpdate(); //처리된건수 반환 
			if(r>0) {
				return true;  //등록성공 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false; 
	}//END of addstudent 
	
	
	
	
	//학생목록 반환 메소드  참고)empDAO.search() 
	public List<Student> stuList(){
		
		List<Student> stuList=new ArrayList<>();
		
		String qry="select * from tbl_student "+
				"order by student_no";
		
		
		try {
			psmt=getConnect().prepareStatement(qry); 
			rs=psmt.executeQuery();
			//조회결과
			while(rs.next()) {
				Student stu=new Student();
				stu.setStudentNo(rs.getString("student_no"));
				stu.setStudentName(rs.getString("student_name"));
				stu.setPhone(rs.getString("phone"));
				stu.setAddress(rs.getString("address"));
				
				stuList.add(stu); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return stuList;
		
		
	}//end of studentList 
}
