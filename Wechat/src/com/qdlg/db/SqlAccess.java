package com.qdlg.db;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author 10184
 *2017年10月25日
 *获取xml文件里的sql的连接信息
 */
public class SqlAccess {
	public SqlSession getSqlSession() throws IOException{
	//加载mybatis的配置文件（它也加载关联的映射文件）
	Reader reader = Resources.getResourceAsReader("com/qdlg/config/Configuration.xml");			 
	//构建sqlSession的工厂
	SqlSessionFactory sqlsessionfactory = new SqlSessionFactoryBuilder().build(reader);
	//打开一个sql会话
	SqlSession sqlsession = sqlsessionfactory.openSession();
	return sqlsession;
	}
}
