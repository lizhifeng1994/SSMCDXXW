package com.baidu.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.dao.imp.ESMXInfoDaoImp;
import com.baidu.model.ESMXINFO;
import com.baidu.model.XXINFO;
import com.baidu.service.BaseService;

@Service
public class ESMXInfoService extends BaseService<ESMXINFO> {
	@Autowired
	private ESMXInfoDaoImp daoImp;
	
//	�õ�������ϸ
	public ESMXINFO getESMX(XXINFO xxinfo)
	{
		return daoImp.getESMX(xxinfo);
	}
	
//	�༭������ϸ��Ϣ
	public int editESMX(ESMXINFO esmxinfo)
	{
		return daoImp.editESMX(esmxinfo);
	}
	
//	��Ӷ�����ϸ��Ϣ
	public int addESMX(ESMXINFO esmxinfo)
	{
		return daoImp.addESMX(esmxinfo);
	}

//	�ı���ֽ���״̬
	public int editES_STATE(XXINFO xxinfo)
	{
		return daoImp.editES_STATE(xxinfo);
	}

}
