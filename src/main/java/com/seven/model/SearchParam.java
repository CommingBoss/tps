package com.seven.model;

public class SearchParam {
	public int searchType;//查询房屋信息的类型  1：按价格    2：简易地址    3：大小    4：日期
	public String keyWord;//房屋查询的关键字
	public int getSearchType() {
		return searchType;
	}
	public void setSearchType(int searchType) {
		this.searchType = searchType;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
}
