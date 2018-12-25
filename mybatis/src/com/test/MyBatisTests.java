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
//		myBatisTestOneTo.findPersonon1(); //一对一
//		myBatisTestOneTo.findPersonon2(); //一对多
		myBatisTestOneTo.findPersonon3(); //多对多
	}
	
	
	/*
	 * 一对一查询  嵌套查询  嵌套结果（数量多的话推荐）
	 * IdCardMapper.xml        PersonMapper.xml  
	 * 嵌套结果
	 */
	public void findPersonon1() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		Person person = sqlSession.selectOne("com.mapper.PersonMapper.findPersonById2",new Integer(1));
		System.out.println(person);
		sqlSession.close();
	}
	
	/*
	 * 一对多
	 */
	public void findPersonon2() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		User user = sqlSession.selectOne("com.mapper.UserMapper.findUserById",new Integer(1));
		System.out.println(user);
		for (Orders orders :user.getOrderslist()){
			System.out.println("订单"+orders.getId()+"number是:"+orders.getNumber());
		}
		sqlSession.close();
	}
	
	/*
	 * 多对多
	 * 嵌套结果          只定义一个Mappers就可以
	 */
	public void findPersonon3() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		Orders ordersr = sqlSession.selectOne("com.mapper.OrdersMapper.findOrdersWithPorduct",new Integer(1));
		System.out.println("订单id是："+ordersr.getId() +"    ,订单number是："+ordersr.getNumber());
		for (Product orProduct :ordersr.getProduct()){
			System.out.println("商品id"+orProduct.getId()+"  商品name是:"+orProduct.getName()+"     商品价格"+orProduct.getPrice());
		}
		sqlSession.close();
	}
}
