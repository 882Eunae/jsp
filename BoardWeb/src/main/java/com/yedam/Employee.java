package com.yedam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//참고 employee
/*
 * 사원번호(1001,1002)
 * 사원이름(홍길동,김민수)
 * 전화번호(654-1123,654-3434)
 * 입사일자(2020-02-04)
 */
public class Employee {

	private int num;  //사원번호
	private String name; //이름
    private String tel; //전화번호
    private Date date;  //
    private int money;
    
    
    public Employee() {
//    	
//    	this.num = 0;
//		this.name = "기본이름";
//		this.tel = "1111";
//		this.date=new Date(); //날짜 설정안했을경우 오늘날짜로 지정 
//		this.money=250;
//    	
//    	
    	
    } //기본생성자    
   
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
	
	
	//getter setter 
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	} 
    
    
    
	
}
