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
	
//	得到二手明细
	public ESMXINFO getESMX(XXINFO xxinfo)
	{
		return daoImp.getESMX(xxinfo);
	}
	
//	编辑二手明细信息
	public int editESMX(ESMXINFO esmxinfo)
	{
		return daoImp.editESMX(esmxinfo);
	}
	
//	添加二手详细信息
	public int addESMX(ESMXINFO esmxinfo)
	{
		return daoImp.addESMX(esmxinfo);
	}

//	改变二手交易状态
	public int editES_STATE(XXINFO xxinfo)
	{
		return daoImp.editES_STATE(xxinfo);
	}

}
