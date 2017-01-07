package com.seven.service.collection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.seven.controller.vo.FindPageParam;
import com.seven.dao.CollectionDao;
import com.seven.model.Collection;
import com.seven.model.HouseInfo;

@Service
public class CollectionServiceImpl implements CollectionService {

	@Autowired
	@Qualifier("collectionDao")
	private CollectionDao collectionDao;

	//用户收藏房屋信息
	public boolean insert(Collection house) {
		if(house.getHouseInfoId()!=0 && house.getUserId() != 0){
			return collectionDao.insert(house);
		}
		return false;
	}

	//用户取消房屋收藏
	public boolean delete(Collection house) {
		if(house.getHouseInfoId()!=0 && house.getUserId() != 0){
			return collectionDao.delete(house);
		}
		return false;
	}

	public List<HouseInfo> allCollectHouseInfo(int userId,int page_no,int page_size) {
		// 扔掉的条数，例如当前查询第一页，最大量是20条，扔掉为0，第二页，当页显示20条，取出40条，扔掉前面20条，只显示后面20条即可
		Integer pagedelete = (page_no - 1) * page_size;
		FindPageParam parmar = new FindPageParam();
		parmar.setPagedelete(pagedelete);
		parmar.setPage_size(page_size);
		return collectionDao.allCollectHouseInfo(parmar,userId);
	}

}
