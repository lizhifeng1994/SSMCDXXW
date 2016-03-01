package com.baidu.dao.imp;

import org.springframework.stereotype.Repository;

import com.baidu.dao.BaseDao;
import com.baidu.model.ESMXINFO;
import com.baidu.model.XXINFO;

@Repository
public interface ESMXInfoDaoImp extends BaseDao<ESMXINFO> {
	
//	�õ�������ϸ
	public ESMXINFO getESMX(XXINFO xxinfo);

//	�༭������ϸ��Ϣ
	public int editESMX(ESMXINFO esmxinfo);
	
//	��Ӷ�����ϸ��Ϣ
	public int addESMX(ESMXINFO esmxinfo);
	
//	�ı���ֽ���״̬
	public int editES_STATE(XXINFO xxinfo);
}
