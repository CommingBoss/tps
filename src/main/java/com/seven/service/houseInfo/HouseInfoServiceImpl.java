package com.seven.service.houseInfo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Case;
import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.seven.controller.vo.FindPageParam;
import com.seven.dao.HouseInfoDao;
import com.seven.model.HouseInfo;
import com.seven.model.SearchParam;
import com.seven.service.houseInfo.HouseInfoService;
@Service
public class HouseInfoServiceImpl implements HouseInfoService {

	@Autowired
	@Qualifier("houseInfoDao")
	private HouseInfoDao houseInfoDao;
	
	List<HouseInfo> houseInfoList = new ArrayList<HouseInfo>();

	public boolean insert(HouseInfo house) {
		if(houseInfoDao.insert(house))
			return true;
		return false;
	}

	public boolean delete(HouseInfo house) {
		if(houseInfoDao.delete(house))
			return true;
		return false;
	}

	public HouseInfo update(HouseInfo house) {
		return houseInfoDao.update(house);
	}

	public List<HouseInfo> allPublishHouseInfo(int userId,int page_no,int page_size) {		
		// 扔掉的条数，例如当前查询第一页，最大量是20条，扔掉为0，第二页，当页显示20条，取出40条，扔掉前面20条，只显示后面20条即可
		Integer pagedelete = (page_no - 1) * page_size;
		FindPageParam parmar = new FindPageParam();
		parmar.setPagedelete(pagedelete);
		parmar.setPage_size(page_size);
		return houseInfoDao.allPublishHouseInfo(parmar,userId);
	}

	public List<HouseInfo> selectHouseInfoList(List<SearchParam>searchParamList, int page_no, int page_size) {
		if(page_no<0 || page_no> page_size){
			return null;
		}
		// 扔掉的条数，例如当前查询第一页，最大量是20条，扔掉为0，第二页，当页显示20条，取出40条，扔掉前面20条，只显示后面20条即可
		Integer pagedelete = (page_no - 1) * page_size;
		FindPageParam parmar = new FindPageParam();
		parmar.setPagedelete(pagedelete);
		parmar.setPage_size(page_size);
		for(int i =0;i<searchParamList.size();i++){
			//要查询的关键字
			String key_word = searchParamList.get(i).getKeyWord();
			//查询房屋信息的类型  1：按价格    2：简易地址    3：大小    4：日期
			int request_type = searchParamList.get(i).getSearchType();
			
			switch(request_type){
			case 1:
				houseInfoList = houseInfoDao.searchHouseInfoByPrice(parmar,Integer.parseInt(key_word));
				break;
			case 2:
				houseInfoList = houseInfoDao.searchHouseInfoBySimpleAdress(parmar,key_word);
				break;
			case 3:
				houseInfoList = houseInfoDao.searchHouseInfoBySize(parmar,key_word);
				break;
			case 4:
				houseInfoList = houseInfoDao.searchHouseInfoByPubliseDate(parmar,Timestamp.valueOf(key_word));
				break;
				default: return null;
			}		
		}
		
		//对list里面的数据查重
		for(int j=0;j<houseInfoList.size();j++){
			for(int k=j+1;k<houseInfoList.size();k++){
				if(houseInfoList.get(j).getUserId() == houseInfoList.get(k).getUserId()){
					houseInfoList.remove(k);
				}
			}
		}
		
		return houseInfoList;
		
	}

	public HouseInfo selectHouseInfo(int houseId) {
		return houseInfoDao.seleteHouseInfo(houseId);
	}
	
	

}
