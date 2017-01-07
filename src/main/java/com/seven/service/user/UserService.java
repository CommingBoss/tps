package com.seven.service.user;

import com.seven.model.User;

public interface UserService {
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	public boolean insert(User user);
	
	/**
	 * 用户修改个人信息
	 * @param user
	 * @return
	 */
	public User update(User user);
	
	/**
	 * 注销登录
	 * @param user
	 * 			用户
	 * @return
	 */
	public boolean cancel(User user);
	
	/**
	 * 根据用户名 查询该用户所有信息
	 * @param name
	 * @return
	 */
	public User selectByName(String name);
	
	/**
	 * 根据用户id 查询该用户
	 * @param userId
	 * @return
	 */
	public User selectById(int userId);
	
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public int login(User user);
	
	/**
	 * 修改用户权限
	 * @param user
	 * @return
	 */
	public User resetUserType(User user);
}
