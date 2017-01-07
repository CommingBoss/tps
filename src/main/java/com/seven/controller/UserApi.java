package com.seven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seven.controller.vo.UserParam;
import com.seven.model.User;
import com.seven.service.user.UserService;
import com.seven.view.JsonAndView;

@Controller
@RequestMapping(value = "user")
public class UserApi {

	@Autowired
	UserService userService;
	
	User user = new User();
	JsonAndView jsonAndView = new JsonAndView();
	
	@RequestMapping(value = "")
	public String home() {
		return "index";
	}

	/**
	 * 根据用户名查询用户相关信息(基本联系方式，收藏夹，发布消息等)
	 * @param userParam
	 * @return
	 */
	@RequestMapping(value = "/getUser", method = RequestMethod.POST)
	@ResponseBody
	public JsonAndView selectByName(UserParam userParam) {
		String name = userParam.getName();
		if (name == null){
			return new JsonAndView(1,"查询的用户名为空");
		}
			
		user = userService.selectByName(name);
		if(user == null){
			return new JsonAndView(1,"无法查询到该用户相关信息，该用户名还未注册");
		}
	
		jsonAndView.addData("user", user);
		return jsonAndView;
	}

	/**
	 * 注册用户
	 * @param userParam
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public JsonAndView insert(UserParam userParam) {
		String name = userParam.getName();
		String password = userParam.getPassword();
		int type = userParam.getType();// 0为游客  1为租客  2为房东 3为管理员
		String tel = userParam.getTel();
		if (userParam == null || type<0 || type>3 || name.equals("") || name ==null || password.equals("") || password == null){
			return new JsonAndView(1,"提交的参数不合法");
		}
				
		user.setName(name);
		user.setTel(tel);
		user.setType(type);
		user.setPassword(password);	
		
		
		if (userService.insert(user)){
			return new JsonAndView("注册用户成功");
		}
		else {
			return new JsonAndView(1,"该用户名已经注册过");
		}
	}

	/**
	 * 更新用户相关信息(必须是已登录)
	 * @param userParam
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public JsonAndView update(UserParam userParam) {
		String password = userParam.getPassword();
		String tel = userParam.getTel();
		String name = userParam.getName();
		if (userParam == null || name.equals("") || name ==null || password.equals("") || password == null || tel.equals("") || tel == null){
			return new JsonAndView(1,"要修改用户信息的参数非法");
		}	
		
		user.setName(name);
		user.setPassword(password);
		user.setTel(tel);
		
		int ifLogin = userService.login(user);
		if(ifLogin == 0){
			User my_user = userService.update(user);
			if (my_user != null){
				return new JsonAndView("更新用户信息成功");
			}
			else {
				return new JsonAndView(1,"用户信息更新失败,请稍后再试");
			}
		}
		else{
			return new JsonAndView(1,"用户非法访问");
		}	
	}

	/**
	 * 用户登录
	 * @param userParam
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public JsonAndView login(UserParam userParam) {
		JsonAndView jsonAndView = new JsonAndView();
		if (userParam == null){
			return new JsonAndView(1,"用户的信息为空");
		}
		
		String name = userParam.getName();
		String password = userParam.getPassword();

		user.setPassword(password);
		user.setName(name);
		
		int loginType = userService.login(user);
		if(loginType ==0){
			//用户名和密码正确
			User new_user = userService.selectByName(name);
			if(new_user.getCancel_flag() == 0){
				return new JsonAndView(1,"用户正在登录中");
			}
			jsonAndView.addData("user", new_user);
			return jsonAndView;
		}
		else if(loginType == 1){
			return new JsonAndView(1,"用户名不存在");
		}
		else if(loginType == 2){
			return new JsonAndView(1,"密码错误,请确认后重新输入");
		}
		else {
			return new JsonAndView(1,"登录失败，请稍后重试");
		}
	}

	/**
	 * 用户注销登录
	 * @param userParam
	 * @return
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	@ResponseBody
	public JsonAndView cancel(UserParam userParam) {
		JsonAndView jsonAndView = new JsonAndView();
		if (userParam == null){
			return new JsonAndView(1,"用户信息为空");
		}
		
		String name = userParam.getName();
		user  = userService.selectByName(name);
		if(user.getCancel_flag() == 1){
			return new JsonAndView(1,"该用户已经注销了，不必再注销");
		}
		else if (user.getCancel_flag() == 0){
			if(userService.cancel(user)){
				return new JsonAndView("注销登录成功");
			}
			else {
				return new JsonAndView(1,"注销失败,请重试");
			}
		}
		return new JsonAndView(1,"无法注销,请重试");
	}
}
