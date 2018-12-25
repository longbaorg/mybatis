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
	
//		 ��̬SQL���
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
		System.out.println("---------------�������ѯ���---------------");
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
			System.out.println("����ɹ���");
		}else {
			System.out.println("����ʧ��");
		}
		sqlSession.commit();
	}
	
	
	public void deleteCustomer() {
		int rows=sqlSession.update("com.mapper.CustomerMapper.deleteCustomer",4);
		if (rows>0) {
			System.out.println("ɾ���ɹ�");
		}else {
			System.out.println("update bad");
		}
		sqlSession.commit();
	}
	
	public void updateCustomer() {
		customer = new Customer();
		customer.setId(4);
		customer.setJobs("teacher");
		customer.setUsername("����");
		customer.setPhone("1566832549");
		int rows=sqlSession.update("com.mapper.CustomerMapper.updateCustomer",customer);
		if (rows>0) {
			System.out.println("�޸ĳɹ�");
		}else {
			System.out.println("�޸ĳɹ�");
		}
		sqlSession.commit();
	}
	
	
	/*
	 * if��ǵ�ʹ��  ���������ѯ���ʱֻҪ����һ���Ͱ�һ��������������в�ѯ
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
	 *choose when otherwiseԪ�ص�ʹ��
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
	 *setԪ�ص�ʹ��
	 */
	public void updateCusterset() {
		customer = new Customer();
		sqlSession = MybatisUtils.getSqlSession();
		customer.setId(1);
		customer.setPhone("2333333333");
		int rows = sqlSession.update("com.mapper.CustomerMapper.updateCustomerss", customer);
		if (rows>0) {
			System.out.println("���ɹ��޸���"+rows+"������");
		}else {
			System.out.println("setִ���޸ĵĲ���ʧ����");
		}
		sqlSession.commit();
	}
	
	/*
	 *foreachԪ�ص�ʹ��
	 */
	public void customeforeach() {
		sqlSession = MybatisUtils.getSqlSession();
		//����List����  ��װ��ѯID
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		
		//ִ��sqlserver�Ĳ�ѯ����  ���ؽ����
		List<Customer> customers = sqlSession.selectList("com.mapper.CustomerMapper.Customeforeach", ids);
		for (Customer cu : customers) {
			System.out.println(cu);
		}
	}
	
	/*
	 *bindԪ�ص�ʹ��
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
