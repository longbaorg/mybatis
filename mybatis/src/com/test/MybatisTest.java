package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.entity.Customer;
import com.utils.MybatisUtils;

public class MybatisTest {
	
	private static SqlSession  sqlSession = null;
	private static Customer customer = null;
	
	public static void main(String[] args) {
		MybatisTest mybatisTest = new MybatisTest();
//		mybatisTest.selectCustomerOne();
//		mybatisTest.selectCustomerlist();
//		mybatisTest.AddCustomer();
//		mybatisTest.deleteCustomer();
//		mybatisTest.updateCustomer();
//		mybatisTest.selectCustomerlists();
	
//		 动态SQL标记
//		mybatisTest.selectCusterIF();
//		mybatisTest.selectCusterChoose();
//		mybatisTest.updateCusterset();
//		mybatisTest.customeforeach();
//		mybatisTest.customebind();
//		mybatisTest.custometrim();
	}
	
	@Test
	private void custometrim() {
		// TODO Auto-generated method stub
		customer = new Customer();
		sqlSession = MybatisUtils.getSqlSession();
		customer.setUsername("j");
		customer.setJobs("teacher");
		List<Customer> customers =  sqlSession.selectList("com.mapper.CustomerMapper.selecttrim",customer);
		for(Customer cu : customers){
			System.out.println(cu);
		}
	}
	
	
	public void selectCustomerlists() {
		// TODO Auto-generated method stub
		System.out.println("---------------操作后查询结果---------------");
		java.util.List<Customer> customers =sqlSession.selectList("com.mapper.CustomerMapper.findCustomerlist");
		for(Customer customer : customers){
			System.out.println(customer);
		}
	}

	public void selectCustomerOne() {
		customer = sqlSession.selectOne("com.mapper.CustomerMapper.findCustomerById",new Integer(4));
		System.out.println(customer.toString());
	}
	
	public void selectCustomerlist() {
		java.util.List<Customer> customers =sqlSession.selectList("com.mapper.CustomerMapper.findCustomerlist","j");
		for(Customer customer1 : customers){
			System.out.println(customer1);
		}
	}
	
	public void AddCustomer() {
		customer = new Customer();
		customer.setId(4);
		customer.setJobs("test");
		customer.setUsername("marke");
		customer.setPhone("15866579494");
		int rows = sqlSession.insert("com.mapper.CustomerMapper.insertCustomer",customer);
		if (rows>0) {
			System.out.println("插入成功！");
		}else {
			System.out.println("插入失败");
		}
		sqlSession.commit();
	}
	
	
	public void deleteCustomer() {
		int rows=sqlSession.update("com.mapper.CustomerMapper.deleteCustomer",4);
		if (rows>0) {
			System.out.println("删除成功");
		}else {
			System.out.println("update bad");
		}
		sqlSession.commit();
	}
	
	public void updateCustomer() {
		customer = new Customer();
		customer.setId(4);
		customer.setJobs("teacher");
		customer.setUsername("李四");
		customer.setPhone("1566832549");
		int rows=sqlSession.update("com.mapper.CustomerMapper.updateCustomer",customer);
		if (rows>0) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改成功");
		}
		sqlSession.commit();
	}
	
	
	/*
	 * if标记的使用  给定多个查询标记时只要输入一个就按一个输入的条件进行查询
	 */
	public void selectCusterIF() {
		customer = new Customer();
		sqlSession = MybatisUtils.getSqlSession();
		customer.setUsername("j");
		customer.setJobs("teacher");
		List<Customer> customers =  sqlSession.selectList("com.mapper.CustomerMapper.findActiveBlogif",customer);
		for(Customer cu : customers){
			System.out.println(cu);
		}
	}
	
	/*
	 *choose when otherwise元素的使用
	 */
	public void selectCusterChoose() {
		customer = new Customer();
		sqlSession = MybatisUtils.getSqlSession();
		customer.setUsername("");
		customer.setJobs("teacher");
		List<Customer> customers =  sqlSession.selectList("com.mapper.CustomerMapper.findActiveBlogchoose",customer);
		for(Customer cu : customers){
			System.out.println(cu);
		}
	}
	
	/*
	 *set元素的使用
	 */
	public void updateCusterset() {
		customer = new Customer();
		sqlSession = MybatisUtils.getSqlSession();
		customer.setId(1);
		customer.setPhone("2333333333");
		int rows = sqlSession.update("com.mapper.CustomerMapper.updateCustomerss", customer);
		if (rows>0) {
			System.out.println("您成功修改了"+rows+"条数据");
		}else {
			System.out.println("set执行修改的操作失败了");
		}
		sqlSession.commit();
	}
	
	/*
	 *foreach元素的使用
	 */
	public void customeforeach() {
		sqlSession = MybatisUtils.getSqlSession();
		//创建List集合  封装查询ID
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		
		//执行sqlserver的查询方法  返回结果集
		List<Customer> customers = sqlSession.selectList("com.mapper.CustomerMapper.Customeforeach", ids);
		for (Customer cu : customers) {
			System.out.println(cu);
		}
	}
	
	/*
	 *bind元素的使用
	 */
	public void customebind() {
		sqlSession = MybatisUtils.getSqlSession();
		customer = new Customer();
		customer.setUsername("j");
		List<Customer> customers = sqlSession.selectList("com.mapper.CustomerMapper.Customebind", customer);
		for (Customer cu : customers) {
			System.out.println(cu);
		}
		
	}
}
