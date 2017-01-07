package com.seven.service.collection;

import java.util.List;

import com.seven.model.Collection;
import com.seven.model.HouseInfo;
import com.seven.model.User;

public interface CollectionService {
	/**
	 * 添加收藏房屋信息
	 * @param houseInfo
	 * @return
	 */
	public boolean insert(Collection house);
	
	/**
	 * 删除房屋收藏信息
	 * @param houseInfo
	 * @return
	 */
	public boolean delete(Collection house);

	
	/**
	 * 查看用户收藏的所有房屋信息
	 * @param userId
	 * @return
	 */
	public List<HouseInfo> allCollectHouseInfo(int userId,int page_no,int page_size);
	
}
