package com.baidu.dao.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baidu.dao.BaseDao;
import com.baidu.model.USERINFO;
@Repository
public interface USERInfoDaoImp extends BaseDao<USERINFO>{
	
//	�ж��û��������Ƿ����
	public int isByAdminUserAndAdminPwd(USERINFO model);

//	�õ�ȫ����Ϣ,���˹���Ա֮���ȫ���û���Ϣ�б�
	public List<USERINFO> getUSERList(USERINFO userinfo);
	
//	�õ��û���Ϣ������
	public int getUSERCount(USERINFO userinfo);
	
//	�鿴�û����Ƿ����
	public int USERExits(USERINFO userinfo);
	
//	�鿴�����Ƿ����
	public int EMAILExits(USERINFO userinfo);
	
//	�����û�
	public int addUSER(USERINFO userinfo);
	
//	�õ��û�����ϸ��Ϣ
	public USERINFO getUSER(USERINFO userinfo);
	
//	�ı��û���״̬
	public int updateUSER_WORk(USERINFO userinfo);
	
//	�޸�����
	public int updateUSER_PWD(USERINFO userinfo);
	
//	�༭�û�
	public int editUSER(USERINFO userinfo);
	
//	�߼�ɾ���û�
	public int delUSER(USERINFO userinfo);
	
//	�����û����õ��û���ϸ
	public USERINFO getXXUSER(USERINFO userinfo);
	
//	ǰ̨��½
	public int weblogin(USERINFO userinfo);
	
}
