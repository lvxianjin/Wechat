package com.qdlg.db;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author 10184
 *2017��10��25��
 *��ȡxml�ļ����sql��������Ϣ
 */
public class SqlAccess {
	public SqlSession getSqlSession() throws IOException{
	//����mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
	Reader reader = Resources.getResourceAsReader("com/qdlg/config/Configuration.xml");			 
	//����sqlSession�Ĺ���
	SqlSessionFactory sqlsessionfactory = new SqlSessionFactoryBuilder().build(reader);
	//��һ��sql�Ự
	SqlSession sqlsession = sqlsessionfactory.openSession();
	return sqlsession;
	}
}
