package com.baidu.dao.imp;

import org.springframework.stereotype.Repository;

import com.baidu.dao.BaseDao;
import com.baidu.model.SCINFO;

@Repository
public interface SCXXInfoDaoImp extends BaseDao<SCINFO>{

//检测某人是否重复收藏了该信息	
	public int exits(SCINFO scinfo);
}
