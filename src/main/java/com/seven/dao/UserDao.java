package com.seven.dao;

import com.seven.model.User;
public interface UserDao {
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	public boolean insert(User user);
	
	/**
	 * 用户修改电话号码
	 * @param user
	 * @return
	 */
	public User updateTel(User user);
	
	
	
	/**
	 * 用户修改密码
	 * @param user
	 * @return
	 */
	public User updatePassword(User user);
	
	/**
	 * 注销
	 * @param user
	 * 	             用户
	 * @return
	 */
	public boolean cancel(User user);
	/**
	 * 根据名字 查询该用户所有信息
	 * @param name
	 * @return
	 */
	public User selectByName(String name);
	
	/**
	 * 根据用户id 查询该用户的信息
	 * @param name
	 * @return
	 */
	public User selectById(int userId);
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public User login(User user);
	
	/**
	 * 设置登录状态
	 * @param user
	 * @return
	 */
	public boolean setLogin(String name,String password);
	
	/**
	 * 修改用户权限
	 * @param user
	 * @return
	 */
	public User resetUserType(User user);
	
}
