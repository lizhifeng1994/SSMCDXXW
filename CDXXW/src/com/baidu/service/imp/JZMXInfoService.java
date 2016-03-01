package com.baidu.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.dao.imp.JZMXInfoDaoImp;
import com.baidu.model.JZMXINFO;
import com.baidu.model.XXINFO;
import com.baidu.service.BaseService;

@Service
public class JZMXInfoService extends BaseService<JZMXINFO> {
	@Autowired
	private JZMXInfoDaoImp daoImp;
	
//	�õ���ְ��ϸ��Ϣ
	public JZMXINFO getJZMX(XXINFO xxinfo)
	{
		return daoImp.getJZMX(xxinfo);
	}
	
//	�༭��ְ��ϸ
	public int editJZMX(JZMXINFO jzmxinfo)
	{
		return daoImp.editJZMX(jzmxinfo);
	}
	
//	���Ӽ�ְ��ϸ
	public int addJZMX(JZMXINFO jzmxinfo)
	{
		return daoImp.addJZMX(jzmxinfo);
	}
}
