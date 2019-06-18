package edu.csust.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.csust.bean.User;
import edu.csust.dao.IUserDao;

public class IUserDaoimpl implements IUserDao{
	
	public  boolean register_savelist(List<User> list,String path) {
		// TODO Auto-generated method stub
		ObjectOutputStream savelist = null;
		boolean flag=true;
		try {
			savelist = new ObjectOutputStream(new FileOutputStream(new File(path)));
			savelist.writeObject(list);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag=false;
		}finally {
			try {
				savelist.close();
			} catch (Exception e2) {
				// TODO: handle exception
				flag = false;
			}
		}
		return flag;
	}
	@SuppressWarnings("unchecked")
	public List<User> register_readlist(String path) {
		List<User> list = new ArrayList<User>();
		ObjectInputStream readlist = null;
		File file = new File(path);
		if(file.exists()) {
			try {
				readlist = new ObjectInputStream(new FileInputStream(new File(path)));
				list = (List<User>) readlist.readObject();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				try {
					readlist.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
		
		return list;
	}
	public boolean check_user(User user,String path) {
		List<User> list = register_readlist(path);
		for(User u:list) {
			if(u.getName().equals(user.getName())&&u.getPassword().equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}
}
