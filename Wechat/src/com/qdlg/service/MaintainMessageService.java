package com.qdlg.service;

import java.util.ArrayList;
import java.util.List;
import com.qdlg.dao.MessageDao;

/**
 * 对指令信息的维护(增删改)
 * @author 10184
 *2017年10月25日
 */
public class MaintainMessageService {
	private MessageDao dao =new MessageDao();	
	/**
	 * 删除单条数据
	 */
	public void deleteOne(String id){
		if(id!=null&&!id.trim().equals("")){
			dao.deleteOne(Integer.valueOf(id));
		}
	}
	/**
	 * 批量删除
	 */
	public void deleteBatch(String[] ids){
		List<Integer> idlist =new ArrayList<Integer>();
		for (String id : ids) {
			idlist.add(Integer.valueOf(id));
		}
		dao.deleteBatch(idlist);
	}
}
