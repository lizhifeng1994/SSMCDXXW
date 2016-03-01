package com.baidu.dao.imp;

import org.springframework.stereotype.Repository;

import com.baidu.dao.BaseDao;
import com.baidu.model.ESMXINFO;
import com.baidu.model.HDMXINFO;
import com.baidu.model.XXINFO;

@Repository
public interface HDMXInfoDaoImp extends BaseDao<HDMXINFO> {
//	�õ����ϸ
	public HDMXINFO getHDMX(XXINFO xxinfo);
	
//	�༭���ϸ��Ϣ
	public int editHDMX(HDMXINFO hdmxinfo);
	
//	��ӻ��ϸ��Ϣ
	public int addHDMX(HDMXINFO hdmxinfo);
	
//	�ı����״̬
	public int editHD_STATE(XXINFO xxinfo);
}
