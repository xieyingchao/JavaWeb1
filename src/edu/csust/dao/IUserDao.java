package edu.csust.dao;

import java.util.List;

import edu.csust.bean.User;

public interface IUserDao {
	
	/**
	 * 将list写入到文件中
	 * @param list<User>,path
	 * @return true:写入成功
	 */
	public boolean register_savelist(List<User> list,String path);
	
	/**
	 * 如果文件存在，则将文件读入到list中
	 * @param path
	 * @return list
	 */
	public List<User> register_readlist(String path);
	
	/**
	 * 判断用户密码是否正确
	 * @param user
	 * @return true:正确
	 */
	public boolean check_user(User user,String path);
}
