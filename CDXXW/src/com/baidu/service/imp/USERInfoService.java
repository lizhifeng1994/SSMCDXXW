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
		
//		����Ա��̨��½
		public int isByAdminUserAndAdminPwd(USERINFO model)
		{	
			return daoImp.isByAdminUserAndAdminPwd(model);
		}
		 
//		�õ�ȫ����Ϣ,���˹���Ա֮���ȫ���û���Ϣ�б�
		public List<USERINFO> getUSERList(USERINFO userinfo)
		{
			return daoImp.getUSERList(userinfo);
		}
		
//		�õ��û���Ϣ������
		public int getUSERCount(USERINFO userinfo)
		{
			return daoImp.getUSERCount(userinfo);
		}
		
//		�鿴�û����Ƿ����
		public int USERExits(USERINFO userinfo)
		{
			return daoImp.USERExits(userinfo);
		}
		
//		�鿴�����Ƿ����
		public int EMAILExits(USERINFO userinfo)
		{
			return daoImp.EMAILExits(userinfo);
		}
		
//		�����û�
		public int addUSER(USERINFO userinfo)
		{
			return daoImp.addUSER(userinfo);
		}
		
//		�õ��û�����ϸ��Ϣ
		public USERINFO getUSER(USERINFO userinfo)
		{
			return daoImp.getUSER(userinfo);
		}
		
//		�ı��û���״̬
		public int updateUSER_WORK(USERINFO userinfo)
		{
			return daoImp.updateUSER_WORk(userinfo);
		}
		
//		�޸�����
		public int updateUSER_PWD(USERINFO userinfo)
		{
			return daoImp.updateUSER_PWD(userinfo);
		}
		
//		�༭�û�
		public int editUSER(USERINFO userinfo)
		{
			return daoImp.editUSER(userinfo);
		}
		
//		�߼�ɾ���û�
		public int delUSER(USERINFO userinfo)
		{
			return daoImp.delUSER(userinfo);
		}
		
//		�����û����õ��û���ϸ
		public USERINFO getXXUSER(USERINFO userinfo)
		{
			return daoImp.getXXUSER(userinfo);
		}
		
//		ǰ̨��½
		public int weblogin(USERINFO userinfo)
		{
			return daoImp.weblogin(userinfo);
		}
}
