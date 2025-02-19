package com.yedam.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//참고 employee
/*
 * 사원번호(1001,1002)
 * 사원이름(홍길동,김민수)
 * 전화번호(654-1123,654-3434)
 * 입사일자(2020-02-04)
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private int num;  //emp_no 칼럼 
	private String name; //emp_name 
    private String tel; //tel_no 
    private Date date;  //hire_date
    private int money;//salary 
    
   
   
	public Employee(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
		this.date=new Date(); //날짜 설정안했을경우 오늘날짜로 지정 
		this.money=250; //기본급여
		
	} //사원번호,이름,사무실전화번호 

	public Employee(int num, String name, String tel, String date, int money) {
		this(num,name,tel);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.date=sdf.parse(date);
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		this.money=money; 
		
	}
	
	public String empInfo() {
		//사번  이름   연락처    급여
		//-----------------------
		//1001 홍길동 234-1234 250
		
		return num+" "+name+" "+tel +" "+money; 
	}
	
	
	
    
    
    
	
}
