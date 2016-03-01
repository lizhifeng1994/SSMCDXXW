package com.baidu.dao.imp;

import org.springframework.stereotype.Repository;

import com.baidu.dao.BaseDao;
import com.baidu.model.ESMXINFO;
import com.baidu.model.HDMXINFO;
import com.baidu.model.XXINFO;

@Repository
public interface HDMXInfoDaoImp extends BaseDao<HDMXINFO> {
//	得到活动明细
	public HDMXINFO getHDMX(XXINFO xxinfo);
	
//	编辑活动明细信息
	public int editHDMX(HDMXINFO hdmxinfo);
	
//	添加活动详细信息
	public int addHDMX(HDMXINFO hdmxinfo);
	
//	改变活动审核状态
	public int editHD_STATE(XXINFO xxinfo);
}
