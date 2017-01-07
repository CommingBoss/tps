package com.seven.model;

import java.util.List;

public class User {

	private int userId;//用户id(方便数据库存储和查找用户数据)

	private String name;//用户名(用户登录账号)

	private String password;//密码
	
	private int type;// 0为游客  1为租客  2为房东 3为管理员
	
	private String tel;//联系电话
	
	private int cancel_flag;//0登录中  1不在线
	
	private int delete_flag;//标记删除 （0未删除  1删除）
	

	List<HouseInfo> collectionList;//收藏夹list
	
	List<HouseInfo> houseInfoLost;//用户发布的房屋信息list
	
	
	public int getDelete_flag() {
		return delete_flag;
	}

	public void setDelete_flag(int delete_flag) {
		this.delete_flag = delete_flag;
	}

	public List<HouseInfo> getHouseInfoLost() {
		return houseInfoLost;
	}

	public void setHouseInfoLost(List<HouseInfo> houseInfoLost) {
		this.houseInfoLost = houseInfoLost;
	}

	public List<HouseInfo> getCollectionList() {
		return collectionList;
	}

	public void setCollectionList(List<HouseInfo> collectionList) {
		this.collectionList = collectionList;
	}

	public int getCancel_flag() {
		return cancel_flag;
	}

	public void setCancel_flag(int cancel_flag) {
		this.cancel_flag = cancel_flag;
	}

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

	public boolean isVaild(){
		if(this.tel == null || this.password == null || this.name == null){
			return false;
		}
			
		else{
			return true;
		}
	}
	
	@Override
	public String toString(){
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + ", type=" + type
				+ ", tel=" + tel + ", cancel_flag=" + cancel_flag + ", delete_flag=" + delete_flag + "]";
	}
}
