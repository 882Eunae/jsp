package com.yedam;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.DataSource;
import com.yedam.common.SearchVO;
import com.yedam.mapper.BoardMapper;
import com.yedam.mapper.ReplyMapper;

public class STest {
	public static void main(String[] args) {
		
		
		 SqlSessionFactory sqlSessionFactory=DataSource.getInstance(); 
		 SqlSession sqlSession=	  sqlSessionFactory.openSession(); 
		 
		 ReplyMapper mapper= sqlSession.getMapper(ReplyMapper.class);
		 List<Map<String,Object>> list=mapper.fullData(); 
		  
		  Gson gson=new GsonBuilder().setPrettyPrinting().create(); 
		  System.out.println(gson.toJson(list));
		  
		
		 
		}
}
