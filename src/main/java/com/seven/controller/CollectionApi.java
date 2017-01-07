package com.seven.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seven.controller.vo.HouseParam;
import com.seven.model.Collection;
import com.seven.model.HouseInfo;
import com.seven.model.User;
import com.seven.service.collection.CollectionService;
import com.seven.service.houseInfo.HouseInfoService;
import com.seven.service.user.UserService;
import com.seven.view.JsonAndView;

@Controller
@RequestMapping(value = "collection")
public class CollectionApi {
	
	@Autowired
	CollectionService collectionService;
	
	@Autowired
	UserService userService;
	
	
	JsonAndView jsonAndView = new JsonAndView();
	User user = new User();
	List<HouseInfo> houseInfoList = new ArrayList<HouseInfo>();
	
	
	/**
	 * 收藏房屋信息
	 * @param collection
	 * @return
	 */
	@RequestMapping(value = "/collect", method = RequestMethod.POST)
	@ResponseBody
	public JsonAndView insert(Collection collection) {
		if (collection == null || !collection.isVaild()){
			return new JsonAndView(1,"房屋收藏信息参数非法");
		}
		
		boolean my_house = collectionService.insert(collection);
		if(my_house){
			return new JsonAndView("房屋收藏成功");
		}
		else{
			return new JsonAndView(1,"房屋收藏失败，请稍后重试");
		}
	}
	
	/**
	 * 取消房屋收藏
	 * @param house
	 * @return
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	@ResponseBody
	public JsonAndView delete(Collection collection) {
		if (collection == null || !collection.isVaild()){
			return new JsonAndView(1,"房屋取消收藏失败，参数不合法");
		}

		boolean my_house = collectionService.delete(collection);
		if(my_house){
			return new JsonAndView("房屋取消收藏成功");
		}
		else{
			return new JsonAndView(1,"房屋取消收藏失败。请稍后重试");
		}
	}
	
	/**
	 * 查看收藏的房屋信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/select/Collectiton", method = RequestMethod.POST)
	@ResponseBody
	public JsonAndView selectCollection(@RequestBody HouseParam houseParam,HttpServletRequest request) {
		//检查参数是否合法
		String name = houseParam.getName();//获取用户名
		if (houseParam == null || houseParam.isValid() || name.equals("")||name == null){
			return new JsonAndView(1,"房屋发布信息参数非法");
		}
				
		user = userService.selectByName(name);	
		
		houseInfoList = collectionService.allCollectHouseInfo(user.getUserId(),houseParam.getPage_no(),houseParam.getPage_size());
		
		jsonAndView.addData("houseInfoList", houseInfoList);
		return jsonAndView;
	}
}
