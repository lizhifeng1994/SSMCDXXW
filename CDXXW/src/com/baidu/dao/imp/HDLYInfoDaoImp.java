package com.baidu.dao.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baidu.dao.BaseDao;
import com.baidu.model.HDLYINFO;
import com.baidu.model.HDMXINFO;
import com.baidu.model.XXINFO;

@Repository
public interface HDLYInfoDaoImp extends BaseDao<HDLYINFO> {
//	得到活动明细
	public List<HDLYINFO> getHDLYList(XXINFO xxinfo);
}
