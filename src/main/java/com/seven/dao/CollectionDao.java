package com.seven.dao;

import java.util.List;

import com.seven.controller.vo.FindPageParam;
import com.seven.model.Collection;
import com.seven.model.HouseInfo;
import com.seven.model.User;

public interface CollectionDao {
	/**
	 * 增加用户的收藏信息
	 * @param collection
	 * @return
	 */
	public boolean insert(Collection collection);
	/**删除用户的收藏信息
	 * @param collection
	 * @return
	 */
	public boolean delete(Collection collection);
	
	/**
	 * 查看用户收藏的所有房屋信息
	 * @param userId
	 * @return
	 */
	public List<HouseInfo> allCollectHouseInfo(FindPageParam parmar,int userId);
		
}
