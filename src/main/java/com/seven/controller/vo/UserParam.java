package com.seven.controller.vo;

public class UserParam {
	private int userId;//用户id

	private String name;//用户名(用户登录账号)

	private String password;//密码
	
	private int type;// 0为游客  1为租客  2为房东 3为管理员
	
	private String tel;//联系电话
	
	private int cancel_flag;//0登录中  1不在线

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getCancel_flag() {
		return cancel_flag;
	}

	public void setCancel_flag(int cancel_flag) {
		this.cancel_flag = cancel_flag;
	}

	
	
	
}
