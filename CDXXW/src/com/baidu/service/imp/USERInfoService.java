package com.baidu.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.dao.imp.USERInfoDaoImp;
import com.baidu.model.USERINFO;
import com.baidu.service.BaseService;

@Service
public class USERInfoService extends BaseService<USERINFO>{
		@Autowired
		private USERInfoDaoImp daoImp;
		
//		管理员后台登陆
		public int isByAdminUserAndAdminPwd(USERINFO model)
		{	
			return daoImp.isByAdminUserAndAdminPwd(model);
		}
		 
//		得到全部信息,除了管理员之外的全部用户信息列表
		public List<USERINFO> getUSERList(USERINFO userinfo)
		{
			return daoImp.getUSERList(userinfo);
		}
		
//		得到用户信息的条数
		public int getUSERCount(USERINFO userinfo)
		{
			return daoImp.getUSERCount(userinfo);
		}
		
//		查看用户名是否存在
		public int USERExits(USERINFO userinfo)
		{
			return daoImp.USERExits(userinfo);
		}
		
//		查看邮箱是否存在
		public int EMAILExits(USERINFO userinfo)
		{
			return daoImp.EMAILExits(userinfo);
		}
		
//		增加用户
		public int addUSER(USERINFO userinfo)
		{
			return daoImp.addUSER(userinfo);
		}
		
//		得到用户的详细信息
		public USERINFO getUSER(USERINFO userinfo)
		{
			return daoImp.getUSER(userinfo);
		}
		
//		改变用户的状态
		public int updateUSER_WORK(USERINFO userinfo)
		{
			return daoImp.updateUSER_WORk(userinfo);
		}
		
//		修改密码
		public int updateUSER_PWD(USERINFO userinfo)
		{
			return daoImp.updateUSER_PWD(userinfo);
		}
		
//		编辑用户
		public int editUSER(USERINFO userinfo)
		{
			return daoImp.editUSER(userinfo);
		}
		
//		逻辑删除用户
		public int delUSER(USERINFO userinfo)
		{
			return daoImp.delUSER(userinfo);
		}
		
//		根据用户名得到用户明细
		public USERINFO getXXUSER(USERINFO userinfo)
		{
			return daoImp.getXXUSER(userinfo);
		}
		
//		前台登陆
		public int weblogin(USERINFO userinfo)
		{
			return daoImp.weblogin(userinfo);
		}
}
