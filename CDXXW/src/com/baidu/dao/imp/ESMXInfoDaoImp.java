package com.baidu.dao.imp;

import org.springframework.stereotype.Repository;

import com.baidu.dao.BaseDao;
import com.baidu.model.ESMXINFO;
import com.baidu.model.XXINFO;

@Repository
public interface ESMXInfoDaoImp extends BaseDao<ESMXINFO> {
	
//	得到二手明细
	public ESMXINFO getESMX(XXINFO xxinfo);

//	编辑二手明细信息
	public int editESMX(ESMXINFO esmxinfo);
	
//	添加二手详细信息
	public int addESMX(ESMXINFO esmxinfo);
	
//	改变二手交易状态
	public int editES_STATE(XXINFO xxinfo);
}
