package com.baidu.dao.imp;

import org.springframework.stereotype.Repository;

import com.baidu.dao.BaseDao;
import com.baidu.model.SCINFO;

@Repository
public interface SCXXInfoDaoImp extends BaseDao<SCINFO>{

//���ĳ���Ƿ��ظ��ղ��˸���Ϣ	
	public int exits(SCINFO scinfo);
}
