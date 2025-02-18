package com.yedam.control;

import java.io.IOException;
import java.rmi.ServerException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Control {
	public void exec(HttpServletRequest req,HttpServletResponse resp) 
	throws IOException, ServletException; 
}
