package com.entity;

import java.util.List;

public class User {
	private int id;
	private String userName;
	private String address;
	
	
	//һ���û���Ӧһ������  ����һ����Ա��������ʾ�������
	//yһ�Զ�Ĺ�ϵҪ��������  �����ϵ ���ü�������ʾ
	private List<Orders> orderslist;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Orders> getOrderslist() {
		return orderslist;
	}

	public void setOrderslist(List<Orders> orderslist) {
		this.orderslist = orderslist;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id�ǣ�"+id +"    ,username�ǣ�"+userName+",      address�ǣ�"+address;
	}
}
