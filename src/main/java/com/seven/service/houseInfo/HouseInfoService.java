package com.seven.service.houseInfo;

import java.util.List;

import com.seven.controller.vo.HouseParam;
import com.seven.model.HouseInfo;
import com.seven.model.SearchParam;

public interface HouseInfoService {
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
	 * 查询房屋信息
	 * @param houseId
	 * @return
	 */
	public HouseInfo selectHouseInfo(int houseId);
	
	/**
	 * 查看房东发布的所有信息
	 * @param userId
	 * @return
	 */
	public List<HouseInfo> allPublishHouseInfo(int userId,int page_no,int page_size);

	
	/**
	 * 通过关键字查询房屋信息
	 * @param searchParamList
	 *                      List<SearchParam> 要联合查询的关键字类型和关键字
	 * @param page_no
	 *                      每页条数（设置最大条数）
	 * @param page_size 
	 *                      请求的页数
	 * @return
	 */
	public List<HouseInfo> selectHouseInfoList(List<SearchParam>searchParamList, int page_no, int page_size);
}
