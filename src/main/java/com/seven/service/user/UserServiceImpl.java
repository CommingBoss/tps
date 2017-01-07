package com.seven.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.seven.controller.vo.FindPageParam;
import com.seven.dao.CollectionDao;
import com.seven.dao.HouseInfoDao;
import com.seven.dao.UserDao;
import com.seven.model.HouseInfo;
import com.seven.model.User;
import com.seven.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	@Autowired
	@Qualifier("collectionDao")
	private CollectionDao collectionDao;
	
	@Autowired
	@Qualifier("houseInfoDao")
	private HouseInfoDao houseInfoDao;

	User new_user = new User();
	FindPageParam parmar = new FindPageParam();
	//注册用户
	public boolean insert(User user) {
		String user_name = user.getName();
		//判断用户是否提交必要信息（用户名、密码、电话）
		if(user.isVaild()){
			//查看该用户名是否已经注册过
			new_user = userDao.selectByName(user_name);
			//System.out.println(new_user.toString());
			
			if(new_user != null){
				return false;
			}
			else{
				userDao.insert(user);
				return true;
			}
		}
		return false;
	}

	
	//更新用户信息
	public User update(User user) {
		String name = user.getName();
		String password = user.getPassword();
		String tel = user.getTel();
		
		new_user = userDao.selectByName(name);
		
		if(new_user != null){
			if(password !=null && !password.equals("")){
				new_user.setPassword(password);
				userDao.updatePassword(new_user);
			}
			if(tel != null && !tel.equals("")){
				new_user.setTel(tel);
				userDao.updateTel(new_user);
			}
			return new_user;
		}
		return null;
	}

	
	//注销该用户
	public boolean cancel(User user) {
		return userDao.cancel(user);
	}

	
	//根据用户名查找用户相关信息
	public User selectByName(String name) {
		if(name != null && !name.equals("")){
			new_user = userDao.selectByName(name);
			int userId = new_user.getUserId();
			int type = new_user.getType();
			parmar.setPagedelete(0);
			parmar.setPage_size(100);
			if(type >0 &&type<4){
				//游客以上的权限可以添加收藏夹
				List<HouseInfo> collectionList = collectionDao.allCollectHouseInfo(parmar, userId);
				new_user.setCollectionList(collectionList);
			}
			//房东发布的租房信息
			if(type == 2){
				List<HouseInfo> houseInfoList = houseInfoDao.allPublishHouseInfo(parmar, userId);
				new_user.setHouseInfoLost(houseInfoList);
			}
			return new_user;
		}
		return null;
	}

	
	
	public User selectById(int userId) {
		return userDao.selectById(userId);
	}


	//登录
	public int login(User user) {
		String name = user.getName();
		String password = user.getPassword();
		
		if(name!=null && !name.equals("") && password !=null && !password.equals("")){
			User return_user = userDao.selectByName(name);
			if(return_user == null){
				//用户名不存在
				return 1;
			}
			return_user = userDao.login(user);
			if(return_user == null){
				//登录失败，密码错误
				return 2;
			}
			else {
				if(userDao.setLogin(name,password))
					return 0;//登录成功
			}
		}
		return 3;
	}


	//设置用户的类型（暂时未用到）
	public User resetUserType(User user) {
		int type = user.getType();
		
		userDao.resetUserType(user);
		return null;
	}

	
	
}
