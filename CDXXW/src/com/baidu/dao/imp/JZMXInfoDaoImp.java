package com.baidu.dao.imp;

import org.springframework.stereotype.Repository;

import com.baidu.dao.BaseDao;
import com.baidu.model.JZMXINFO;
import com.baidu.model.XXINFO;
@Repository
public interface JZMXInfoDaoImp extends BaseDao<JZMXINFO>{
//	得到兼职明细信息
	public JZMXINFO getJZMX(XXINFO xxinfo);

//	编辑兼职明细
	public int editJZMX(JZMXINFO jzmxinfo);
	
//	增加兼职明细
	public int addJZMX(JZMXINFO jzmxinfo);
}
