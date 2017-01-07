package com.seven.controller.vo;

import java.sql.Timestamp;
import java.util.List;

import com.seven.model.SearchParam;

public class HouseParam {
	public int houseInfoId;// 房屋信息id
	public String name;// 用户名
	public int userId;// 房东id
	public String title;// 标题
	public String sketch;// 简述
	public String size;// 大小尺寸
	public int price;// 价格
	public String userName;// 房东姓名
	public String tel;// 房东电话
	public String village;// 小区名称
	public String floor;// 楼层（格式为：2/4）
	public String configuration;// 配置
	public String simpleAddress;// 简述地址（老区/新区）
	public String detailedAddress;// 详细地址
	public Timestamp publishDate;// 发布时间
	public int ifOrder;// 是否被预订了
	public int page_no;// 当前请求页数 默认为1
	public int page_size;// 每页的总数 20-100
	public String picture;// 房屋配图
	public List<SearchParam> searchParam;

	public boolean isValid() {
		if (this.houseInfoId == 0 || this.userId == 0 || this.price == 0 || this.size == null
				|| this.simpleAddress == null || this.publishDate == null || this.floor.equals("")
				|| this.userName.equals("") || this.title.equals("") || this.sketch.equals("")
				|| this.picture.equals("") || this.name.equals("") || this.searchParam == null
				|| this.searchParam.size() == 0) {
			return false;
		}
		return true;
	}

	public List<SearchParam> getSearchParam() {
		return searchParam;
	}

	public void setSearchParam(List<SearchParam> searchParam) {
		this.searchParam = searchParam;
	}

	public int getPage_no() {
		return page_no;
	}

	public void setPage_no(int page_no) {
		this.page_no = page_no;
	}

	public int getPage_size() {
		return page_size;
	}

	public void setPage_size(int page_size) {
		this.page_size = page_size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getSketch() {
		return sketch;
	}

	public void setSketch(String sketch) {
		this.sketch = sketch;
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

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
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

	public String getSimpleAddress() {
		return simpleAddress;
	}

	public void setSimpleAddress(String simpleAddress) {
		this.simpleAddress = simpleAddress;
	}

	public String getDetailedAddress() {
		return detailedAddress;
	}

	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
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
}
