package com.utils;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/*
 * actor:������
 * ������ִ�л�ȡsqlSessionFactory����  ����ִֻ��һ��
 */
public class MybatisUtils {
	
	private static SqlSessionFactory sqlSessionFactory = null;
	
	
	//��̬������������ִֻ��һ��
	static {
		try {
			InputStream inputStream  = Resources.getResourceAsStream("mybatis_config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	//ִ�л�ȡsqlsession
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}

}
