package com.baidu.dao.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baidu.dao.BaseDao;
import com.baidu.model.USERINFO;
@Repository
public interface USERInfoDaoImp extends BaseDao<USERINFO>{
	
//	判断用户名密码是否存在
	public int isByAdminUserAndAdminPwd(USERINFO model);

//	得到全部信息,除了管理员之外的全部用户信息列表
	public List<USERINFO> getUSERList(USERINFO userinfo);
	
//	得到用户信息的条数
	public int getUSERCount(USERINFO userinfo);
	
//	查看用户名是否存在
	public int USERExits(USERINFO userinfo);
	
//	查看邮箱是否存在
	public int EMAILExits(USERINFO userinfo);
	
//	增加用户
	public int addUSER(USERINFO userinfo);
	
//	得到用户的详细信息
	public USERINFO getUSER(USERINFO userinfo);
	
//	改变用户的状态
	public int updateUSER_WORk(USERINFO userinfo);
	
//	修改密码
	public int updateUSER_PWD(USERINFO userinfo);
	
//	编辑用户
	public int editUSER(USERINFO userinfo);
	
//	逻辑删除用户
	public int delUSER(USERINFO userinfo);
	
//	根据用户名得到用户明细
	public USERINFO getXXUSER(USERINFO userinfo);
	
//	前台登陆
	public int weblogin(USERINFO userinfo);
	
}
