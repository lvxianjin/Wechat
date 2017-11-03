package com.qdlg.service;

import java.util.ArrayList;
import java.util.List;
import com.qdlg.dao.MessageDao;

/**
 * ��ָ����Ϣ��ά��(��ɾ��)
 * @author 10184
 *2017��10��25��
 */
public class MaintainMessageService {
	private MessageDao dao =new MessageDao();	
	/**
	 * ɾ����������
	 */
	public void deleteOne(String id){
		if(id!=null&&!id.trim().equals("")){
			dao.deleteOne(Integer.valueOf(id));
		}
	}
	/**
	 * ����ɾ��
	 */
	public void deleteBatch(String[] ids){
		List<Integer> idlist =new ArrayList<Integer>();
		for (String id : ids) {
			idlist.add(Integer.valueOf(id));
		}
		dao.deleteBatch(idlist);
	}
}
