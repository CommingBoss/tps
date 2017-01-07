package com.seven.dao;

import java.sql.Timestamp;
import java.util.List;

import com.seven.controller.vo.FindPageParam;
import com.seven.model.HouseInfo;
import com.seven.model.User;

public interface HouseInfoDao {
	/**
	 * 增加房屋
	 * @param house
	 * @return
	 */
	public boolean insert(HouseInfo house);
	/**
	 * 删除某条房屋信息
	 * @param house
	 * @return
	 */
	public boolean delete(HouseInfo house);
	
	/**
	 * 更新房屋信息
	 * @param house
	 * @return
	 */
	public HouseInfo update(HouseInfo house);
	
	/**
	 * 查看房东发布的所有信息
	 * @param userId
	 * @return
	 */
	public List<HouseInfo> allPublishHouseInfo(FindPageParam parmar,int userId);
	
	/**
	 * 通过价格查询房屋信息
	 * @param price
	 *            			价格
	 * @param page_no
	 *                      请求的页数
	 * @param page_size		 每页条数（设置最大条数）
	 *                      
	 * @return
	 */
	public List<HouseInfo> searchHouseInfoByPrice(FindPageParam parmar,int keyWord);
	
	public List<HouseInfo> searchHouseInfoBySimpleAdress(FindPageParam parmar,String keyWord);
	
	public List<HouseInfo> searchHouseInfoBySize(FindPageParam parmar,String keyWord);
	
	public List<HouseInfo> searchHouseInfoByPubliseDate(FindPageParam parmar,Timestamp publishDate);
	
	
	/**
	 * 通过id来查找到当前房子的信息
	 * @param date
	 * @return
	 */
	public HouseInfo seleteHouseInfo(int houseId);
}
