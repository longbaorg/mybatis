package com.entity;

import java.util.List;

public class User {
	private int id;
	private String userName;
	private String address;
	
	
	//一个用户对应一个订单  增加一个成员变量来表示多个订单
	//y一对多的关系要增加属性  多个关系 ，用集合来表示
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
		return "id是："+id +"    ,username是："+userName+",      address是："+address;
	}
}
