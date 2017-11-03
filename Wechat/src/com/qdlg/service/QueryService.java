package com.qdlg.service;

import java.util.List;

import com.qdlg.dao.MessageDao;
import com.qdlg.model.Message;
import com.qdlg.util.Iconst;


/**
 * @author 10184
 *2017年10月26日
 *查询功能
 */
public class QueryService {
	
	public MessageDao dao = new MessageDao();
	
	/**
	 * ������ѯ
	 * @param command ָ��
	 * @param description ����
	 * @return List<Message>
	 */
	public List<Message> queryMessage(String command,String description){
		return dao.queryMessage(command, description);
	}
	/**
	 * ����ָ���ѯ
	 * @param command ָ��
	 * @return List<Message>
	 */
	public String queryByCommand(String command){
		List<Message> messageList;
		//ָ��Ϊ����ʱ���������Ϣ
		if(Iconst.HELP_COMMAND.equals(command)) {
			//��ѯ����ָ����Ϣ���ص�messageList
			messageList = dao.queryMessage(null, null);
			StringBuilder result = new StringBuilder();
			for(int i = 0; i < messageList.size(); i++) {
				if(i != 0) {
					result.append("<br/>");
				}
				result.append("指令[" + messageList.get(i).getCommand() + "描述" + messageList.get(i).getDescription());
			}
			return result.toString();
		}
		//ͨ��ָ���ѯ��Ϣ������ص�messageList
		messageList = dao.queryMessage(command, null);
		if(messageList.size() > 0) {
			return messageList.get(0).getContent();
		}
		else{
			return Iconst.NO_MATCHING_CONTENT;
		}
	}
}
