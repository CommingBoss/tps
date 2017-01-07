package com.seven.controller;

import java.lang.reflect.Array;
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
import com.seven.model.HouseInfo;
import com.seven.model.SearchParam;
import com.seven.model.User;
import com.seven.service.houseInfo.HouseInfoService;
import com.seven.service.user.UserService;
import com.seven.view.JsonAndView;

@Controller
@RequestMapping(value = "houseInfo")
public class HouseApi {
	@Autowired
	HouseInfoService houseService;
	
	@Autowired
	UserService userService;
	
	JsonAndView jsonAndView = new JsonAndView();
	HouseInfo houseInfo = new HouseInfo();
	User user = new User();
	List<HouseInfo> houseInfoList = new ArrayList<HouseInfo>();
	/**
	 * 房东发布房屋信息
	 * @param houseParam
	 * @return
	 */
	@RequestMapping(value = "/publish", method = RequestMethod.POST)
	@ResponseBody
	public JsonAndView publishHouse(HouseParam houseParam) {
		//检查参数是否合法
		String name = houseParam.getName();//获取用户名
		if (houseParam == null || houseParam.isValid() || name.equals("")||name == null){
			return new JsonAndView(1,"房屋发布信息参数非法");
		}
		
		user = userService.selectByName(name);		
		
		//设置要插入数据库的obj
		houseInfo.setUserId(user.getUserId());
		houseInfo.setUserName(houseParam.getUserName());
		houseInfo.setTel(houseParam.getTel());
		houseInfo.setVillage(houseParam.getVillage());
		houseInfo.setFloor(houseParam.getFloor());
		houseInfo.setTitle(houseParam.getTitle());
		houseInfo.setSketch(houseParam.getSketch());
		houseInfo.setSize(houseParam.getSize());
		houseInfo.setPrice(houseParam.getPrice());
		houseInfo.setConfiguration(houseParam.getConfiguration());
		houseInfo.setPicture(houseParam.getPicture());
		houseInfo.setSimpleAdress(houseParam.getSimpleAddress());
		houseInfo.setDetailedAdress(houseParam.getDetailedAddress());
		houseInfo.setPublishDate(houseParam.getPublishDate());
		houseInfo.setIfOrder(0);
		
		//插入要发布的房屋数据
		boolean my_house = houseService.insert(houseInfo);

		if(my_house){
			return new JsonAndView("发布房屋信息成功");
		}
		else{
			return new JsonAndView(1,"发布房屋信息失败");
		}
	}
	
	
	/**
	 * 房东删除房屋信息
	 * @param houseParam
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonAndView deleteHouse(HouseParam houseParam) {
		String name = houseParam.getName();//获取用户名
		//检查参数是否合法
		if (houseParam == null || name == null ||name.equals("")){
			return new JsonAndView(1,"提交的参数不合法");
		}
		
		int houseId = houseParam.getHouseInfoId();
		user = userService.selectByName(name);
		houseInfo = houseService.selectHouseInfo(houseId);
		if(user.getUserId() ==houseInfo.getUserId()){
			if(houseService.delete(houseInfo)){
				return new JsonAndView("删除房屋信息成功");
			}
			else{
				return new JsonAndView(1,"删除房屋信息失败");
			}
		}
		else{
			return new JsonAndView(1,"不是该房屋信息发布者，无法删除该房屋信息");
		}
		
		
	}
	
	//房东更新房屋信息
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public JsonAndView login(HouseParam houseParam) {
		//检查参数是否合法
		if (houseParam == null || !houseParam.isValid()){
			return new JsonAndView(1,"房屋更改信息参数不合法");
		}

		String name = houseParam.getName();//获取用户名
		user = userService.selectByName(name);

		if(user.getUserId() == houseParam.getUserId()){
			HouseInfo my_house = houseService.update(houseInfo);
			
			if(my_house != null){
				return new JsonAndView("房屋信息更新成功");
			}
			else{
				return new JsonAndView(1,"房屋信息更新失败");
			}
		}
		else{
			return new JsonAndView(1,"不是该房屋信息的发布者,不能对房屋信息进行修改");
		}
	}

	
	/**
	 * 通过关键字查询房屋信息，服务器返回客户端对应房屋信息(存在问题)
	 * 
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public JsonAndView searchHouse(@RequestBody HouseParam houseParam,HttpServletRequest request) {
		//检查参数是否合法
		if (houseParam == null || !houseParam.isValid()){
			return new JsonAndView(1,"房屋更新信息参数不合法");
		}
			
		List<SearchParam>searchParamList = new ArrayList<SearchParam>();
		searchParamList = houseParam.getSearchParam();

		houseInfoList = houseService.selectHouseInfoList(searchParamList,houseParam.getPage_no(), houseParam.getPage_size());
		
		jsonAndView.addData("houseInfoList", houseInfoList);
		
		return jsonAndView;
	}
	
	
	/**
	 * 查看已发布的房屋信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/select/Publish", method = RequestMethod.POST)
	@ResponseBody
	public JsonAndView selectPublish(@RequestBody HouseParam houseParam,HttpServletRequest request) {
		//检查参数是否合法
		String name = houseParam.getName();//获取用户名
		if (houseParam == null || houseParam.isValid() || name.equals("")||name == null){
			return new JsonAndView(1,"房屋发布信息参数非法");
		}
				
		user = userService.selectByName(name);	
		
		houseInfoList = houseService.allPublishHouseInfo(user.getUserId(),houseParam.getPage_no(),houseParam.getPage_size());
		
		jsonAndView.addData("houseInfoList", houseInfoList);
		return jsonAndView;
	}
	
}
