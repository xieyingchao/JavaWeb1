package edu.csust.pro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import edu.csust.bean.User;
import edu.csust.dao.IUserDao;
import edu.csust.dao.impl.IUserDaoimpl;

public class run {
	private static Scanner sc = new Scanner(System.in);
	private static IUserDao iuserdao = new IUserDaoimpl();
	private static String path = "E:\\user.dat";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请选择：1.注册 2.登录");
		int type = sc.nextInt();
		switch(type) {
			case 1:{
				//注册
				boolean result = iuserdao.register_savelist(register_getlist(),path);
				if(result) {
					System.out.println("注册成功!");
					break;
				}else {
					System.out.println("注册失败!");
					break;
				}
			}
			case 2:{
				//登录
				User user = login_user();
				if(iuserdao.check_user(user, path)) {
					System.out.println("登录成功！");
					List<User> userlist = iuserdao.register_readlist(path);
					Comparator<User> reverseComparator = Collections.reverseOrder();
					Collections.sort(userlist,reverseComparator);
					for(User u:userlist) {
						System.out.println(u.toString());
					}
				}else {
					System.out.println("登录失败！");
				}
			}
		}
	}
	
	public static List<User> register_getlist() {
		// TODO Auto-generated method stub
		List<User> list = iuserdao.register_readlist(path);
		System.out.println("请输入用户名：");
		String name = sc.next();
		for(User u:list) {
			if(u.getName().equals(name)) {
				System.out.println("用户名已存在，请重新输入！");
				name = sc.next();
			}
		}
		System.out.println("请输入密码：");
		String pwd = sc.next();
		System.out.println("请输入年龄");
		int age = sc.nextInt();
		User user = new User(name,pwd,age,new Date());
		list.add(user);
		return list;
	}

	public static User login_user() {
		System.out.println("请输入用户名：");
		String name = sc.next();
		System.out.println("请输入密码：");
		String pwd = sc.next();
		User user = new User(name,pwd);
		return user;
		
	}
}
