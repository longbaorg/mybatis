package com.entity;

public class Person {
	private int id;
	private String name; 
	private int age ;
	private String sex ;
	private IdCard cardId ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public IdCard getCard_id() {
		return cardId;
	}
	public void setCard_id(IdCard card_id) {
		this.cardId = card_id;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+" :������ "+name+" ,������ "+age+" ,�Ա��� "+sex + " ,���֤���� "+cardId+".";
	}
}
