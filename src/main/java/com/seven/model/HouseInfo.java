package com.seven.model;

import java.sql.Timestamp;

public class HouseInfo {
	public int houseInfoId;//房屋信息id
	public int userId;//房东id
	public String userName;//房东姓名
	public String tel;
	public String village;//小区名称
	public String floor;//楼层（格式为：2/4）
	public String title;//标题
	public String sketch;//简述
	public String size;//大小尺寸
	public int price;//价格
	public String configuration;//配置
	public String picture;//房屋配图
	public String simpleAdress;//简述地址（老区/新区）
	public String detailedAdress;//详细地址
	public Timestamp publishDate;//发布时间
	public int ifOrder;//是否被预订了 0未预订  1被预订
	
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public int getHouseInfoId() {
		return houseInfoId;
	}
	public void setHouseInfoId(int houseInfoId) {
		this.houseInfoId = houseInfoId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSketch() {
		return sketch;
	}
	public void setSketch(String sketch) {
		this.sketch = sketch;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getConfiguration() {
		return configuration;
	}
	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getSimpleAdress() {
		return simpleAdress;
	}
	public void setSimpleAdress(String simpleAdress) {
		this.simpleAdress = simpleAdress;
	}
	public String getDetailedAdress() {
		return detailedAdress;
	}
	public void setDetailedAdress(String detailedAdress) {
		this.detailedAdress = detailedAdress;
	}
	
	public Timestamp getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Timestamp publishDate) {
		this.publishDate = publishDate;
	}
	public int getIfOrder() {
		return ifOrder;
	}
	public void setIfOrder(int ifOrder) {
		this.ifOrder = ifOrder;
	}
	
	public boolean isVails(){
		if(this.userId == 0 || this.title ==null || this.size ==null || this.price == 0|| this.picture == null || this.simpleAdress == null
				||this.publishDate == null){
			return false;
		}
		return true;
	}
	
}
