package com.qdlg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qdlg.service.QueryService;


/**
 * 自动回复功能控制层
 */
@SuppressWarnings("serial")
public class AutoReplyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		QueryService queryService = new QueryService();
		out.write(queryService.queryByCommand(request.getParameter("content")));
		out.flush();
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest reqest, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(reqest, response);
	}
}
