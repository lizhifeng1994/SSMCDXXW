package com.baidu.dao.imp;

import org.springframework.stereotype.Repository;

import com.baidu.dao.BaseDao;
import com.baidu.model.JZMXINFO;
import com.baidu.model.XXINFO;
@Repository
public interface JZMXInfoDaoImp extends BaseDao<JZMXINFO>{
//	�õ���ְ��ϸ��Ϣ
	public JZMXINFO getJZMX(XXINFO xxinfo);

//	�༭��ְ��ϸ
	public int editJZMX(JZMXINFO jzmxinfo);
	
//	���Ӽ�ְ��ϸ
	public int addJZMX(JZMXINFO jzmxinfo);
}
