package com.seven.model;

import java.sql.Timestamp;

public class Collection {
	public int collectionId;//收藏号
	public int userId;//收藏人
	public int houseInfoId;//收藏房屋号
	public Timestamp date;//收藏日期
	public int deleteFlag;//删除收藏信息标记  0存在   1已删除
	public boolean isVaild(){
		if(houseInfoId == 0 || userId == 0){
			return false;
		}
		return true;
	}
	
	
	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}


	public int getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getHouseInfoId() {
		return houseInfoId;
	}
	public void setHouseInfoId(int houseInfoId) {
		this.houseInfoId = houseInfoId;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
}
