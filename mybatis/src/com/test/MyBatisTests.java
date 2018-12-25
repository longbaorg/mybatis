package com.test;

import javassist.expr.NewArray;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.entity.Orders;
import com.entity.Person;
import com.entity.Product;
import com.entity.User;
import com.utils.MybatisUtils;

public class MyBatisTests {
	
	
	public static void main(String[] args) {
		MyBatisTests myBatisTestOneTo = new MyBatisTests();
//		myBatisTestOneTo.findPersonon1(); //һ��һ
//		myBatisTestOneTo.findPersonon2(); //һ�Զ�
		myBatisTestOneTo.findPersonon3(); //��Զ�
	}
	
	
	/*
	 * һ��һ��ѯ  Ƕ�ײ�ѯ  Ƕ�׽����������Ļ��Ƽ���
	 * IdCardMapper.xml        PersonMapper.xml  
	 * Ƕ�׽��
	 */
	public void findPersonon1() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		Person person = sqlSession.selectOne("com.mapper.PersonMapper.findPersonById2",new Integer(1));
		System.out.println(person);
		sqlSession.close();
	}
	
	/*
	 * һ�Զ�
	 */
	public void findPersonon2() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		User user = sqlSession.selectOne("com.mapper.UserMapper.findUserById",new Integer(1));
		System.out.println(user);
		for (Orders orders :user.getOrderslist()){
			System.out.println("����"+orders.getId()+"number��:"+orders.getNumber());
		}
		sqlSession.close();
	}
	
	/*
	 * ��Զ�
	 * Ƕ�׽��          ֻ����һ��Mappers�Ϳ���
	 */
	public void findPersonon3() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		Orders ordersr = sqlSession.selectOne("com.mapper.OrdersMapper.findOrdersWithPorduct",new Integer(1));
		System.out.println("����id�ǣ�"+ordersr.getId() +"    ,����number�ǣ�"+ordersr.getNumber());
		for (Product orProduct :ordersr.getProduct()){
			System.out.println("��Ʒid"+orProduct.getId()+"  ��Ʒname��:"+orProduct.getName()+"     ��Ʒ�۸�"+orProduct.getPrice());
		}
		sqlSession.close();
	}
}
