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
	
//	得到活动明细
	public HDMXINFO getHDMX(XXINFO xxinfo)
	{
		return daoImp.getHDMX(xxinfo);
	}
	
//	编辑活动明细信息
	public int editHDMX(HDMXINFO hdmxinfo)
	{
		return daoImp.editHDMX(hdmxinfo);
	}
	
//	添加二手详细信息
	public int addHDMX(HDMXINFO hdmxinfo)
	{
		return daoImp.addHDMX(hdmxinfo);
	}
	
//	改变活动审核状态
	public int editHD_STATE(XXINFO xxinfo)
	{
		return daoImp.editHD_STATE(xxinfo);
	}
}
