package com.baidu.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.dao.imp.HDMXInfoDaoImp;
import com.baidu.model.HDMXINFO;
import com.baidu.model.XXINFO;
import com.baidu.service.BaseService;

@Service
public class HDMXInfoService extends BaseService<HDMXINFO> {
	@Autowired
	private HDMXInfoDaoImp daoImp;
	
//	�õ����ϸ
	public HDMXINFO getHDMX(XXINFO xxinfo)
	{
		return daoImp.getHDMX(xxinfo);
	}
	
//	�༭���ϸ��Ϣ
	public int editHDMX(HDMXINFO hdmxinfo)
	{
		return daoImp.editHDMX(hdmxinfo);
	}
	
//	��Ӷ�����ϸ��Ϣ
	public int addHDMX(HDMXINFO hdmxinfo)
	{
		return daoImp.addHDMX(hdmxinfo);
	}
	
//	�ı����״̬
	public int editHD_STATE(XXINFO xxinfo)
	{
		return daoImp.editHD_STATE(xxinfo);
	}
}
