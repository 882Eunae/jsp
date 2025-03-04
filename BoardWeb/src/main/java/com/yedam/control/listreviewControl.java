package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReviewVO;

public class listreviewControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//listreviewControl
		
		
		SqlSession sqlSesison=DataSource.getInstance().openSession(); 
		ReplyMapper mapper=sqlSesison.getMapper(ReplyMapper.class); 
		List<ReviewVO> rlist=mapper.reviewList();  //
		//rlist  
		req.setAttribute("rlist", rlist); 
		
		
		req.getRequestDispatcher("admin/listreview.tiles").forward(req, resp);
		
		
		
	}

}
