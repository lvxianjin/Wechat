package com.qdlg.dao;
import com.qdlg.db.SqlAccess;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.qdlg.model.Message;


/**
 * 与message表有关的操作
 * @author 10184
 *2017年10月29日
 */
public class MessageDao {
	/**
	 * 查询指令信息
	 */
	public List<Message> queryMessage(String command,String description){
		List<Message> messagelist = new ArrayList<Message>();
		SqlAccess access = new SqlAccess();
		SqlSession sqlsession = null;
		try {
			//获得SqlSession
			sqlsession = access.getSqlSession();
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			//ִ执行sql语句
			messagelist =sqlsession.selectList("Message.queryMessage",message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlsession.close();
		}
		return messagelist;
	}
	/**
	 * 通过id删除指令
	 */
	public void deleteOne(int id){
		SqlAccess access = new SqlAccess();
		SqlSession sqlsession = null;
		try {
			//获得SqlSession
			sqlsession = access.getSqlSession();
			//ִ执行sql语句
			sqlsession.delete("Message.deleteOne",id);
			//提交事务
			sqlsession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlsession.close();
		}
	}
	
	/**
	 * 批量删除
	 */
	public void deleteBatch(List<Integer> idlist){
		SqlAccess access = new SqlAccess();
		SqlSession sqlsession = null;
		try {
			//获得SqlSession
			sqlsession = access.getSqlSession();
			//执行sql语句
			sqlsession.delete("Message.deleteBatch",idlist);
			//提交事务
			sqlsession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			sqlsession.close();
		}
	}
	
	
//	/**
//	 * ��ѯָ�����Ϣ
//	 */
//	public List<Message> queryMessage(String command,String description){
//		List<Message> messagelist = new ArrayList<Message>();  
//		try {
//			//1.������������
//			Class.forName("com.mysql.jdbc.Driver");
//			//2.������ݿ������
//			Connection conn=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Wechar", "root", "lv3838438");
//			StringBuilder sql = new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from message where 1=1");
//			List<String> paraList = new ArrayList<String>();  
//			if(command != null && !"".equals(command.trim())){
//				sql.append(" and COMMAND=?");
//				paraList.add(command);
//			}
//			if(description!=null&&!description.trim().equals("")){
//				sql.append(" and DESCRIPTION like '%' ? '%'");
//				paraList.add(description);
//			}
//			PreparedStatement sta = conn.prepareStatement(sql.toString()); 
//			for(int i=0;i<paraList.size();i++){
//				sta.setString(i+1,paraList.get(i));
//			}
//			ResultSet rs =sta.executeQuery();
//			while(rs.next()){
//				Message message = new Message();
//				message.setId(rs.getString("ID"));
//				message.setCommand(rs.getString("COMMAND"));
//				message.setContent(rs.getString("CONTENT"));
//				message.setDescription(rs.getString("DESCRIPTION"));
//				messagelist.add(message);
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return messagelist;		
//	}
}
