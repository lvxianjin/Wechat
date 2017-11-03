package com.qdlg.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qdlg.service.QueryService;


/**
 * @author 10184
 *2017��10��24��
 *�����û�����
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {
        
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QueryService service = new QueryService();
		//���ñ���
		request.setCharacterEncoding("utf-8");
		//��ȡ������ֵ
		String command = request.getParameter("command");
		String description = request.getParameter("description");
		//��ҳ�洫ֵ
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
