package edu.csust.bean;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable,Comparable<User>{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	private int age;
	private Date regtime;
	
	public User() {
		super();
	}
	
	public User(String name, String password, int age, Date regtime) {
		super();
		this.name = name;
		this.password = password;
		this.age = age;
		this.regtime = regtime;
	}
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getRegtime() {
		return regtime;
	}
	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = String.format("name:%s,password:%s,age:%s,regtime:%s", this.getName(),this.getPassword(),this.getAge(),this.getRegtime());
		return str;
	}
	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return this.getAge()-o.getAge();
	}
}
