package com.qdlg.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qdlg.service.MaintainMessageService;


/**
 * @author 10184
 *2017��10��25��
 *����ɾ��
 */
@SuppressWarnings("serial")
public class DeleteBatchServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MaintainMessageService service = new MaintainMessageService();
		//���ñ���
		request.setCharacterEncoding("utf-8");
		//��ȡ������ֵ
		String[] ids = request.getParameterValues("id");
		service.deleteBatch(ids);
		request.getRequestDispatcher("/list.action").forward(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
