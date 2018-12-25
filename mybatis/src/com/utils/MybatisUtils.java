package com.utils;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/*
 * actor:许龙豹
 * 该类是执行获取sqlSessionFactory的类  并且只执行一次
 */
public class MybatisUtils {
	
	private static SqlSessionFactory sqlSessionFactory = null;
	
	
	//静态方法整个过程只执行一次
	static {
		try {
			InputStream inputStream  = Resources.getResourceAsStream("mybatis_config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	//执行获取sqlsession
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}

}
