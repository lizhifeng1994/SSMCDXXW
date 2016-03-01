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
	
//	得到兼职明细信息
	public JZMXINFO getJZMX(XXINFO xxinfo)
	{
		return daoImp.getJZMX(xxinfo);
	}
	
//	编辑兼职明细
	public int editJZMX(JZMXINFO jzmxinfo)
	{
		return daoImp.editJZMX(jzmxinfo);
	}
	
//	增加兼职明细
	public int addJZMX(JZMXINFO jzmxinfo)
	{
		return daoImp.addJZMX(jzmxinfo);
	}
}
