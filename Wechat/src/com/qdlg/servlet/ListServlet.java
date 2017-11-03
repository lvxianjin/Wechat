package com.qdlg.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qdlg.service.QueryService;


/**
 * @author 10184
 *2017年10月24日
 *处理用户请求
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {
        
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QueryService service = new QueryService();
		//设置编码
		request.setCharacterEncoding("utf-8");
		//获取参数的值
		String command = request.getParameter("command");
		String description = request.getParameter("description");
		//向页面传值
		request.setAttribute("command",command);
		request.setAttribute("description",description);
		request.setAttribute("messageList",service.queryMessage(command, description));
		request.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(request,response);
	}
        
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
