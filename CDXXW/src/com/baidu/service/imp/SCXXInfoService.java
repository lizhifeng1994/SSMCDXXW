package com.baidu.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.dao.imp.ESMXInfoDaoImp;
import com.baidu.dao.imp.SCXXInfoDaoImp;
import com.baidu.model.SCINFO;
import com.baidu.service.BaseService;

@Service
public class SCXXInfoService extends BaseService<SCINFO> {
	@Autowired
	private SCXXInfoDaoImp daoImp;	
	
	//���ĳ���Ƿ��ظ��ղ��˸���Ϣ	
		public int exits(SCINFO scinfo)
		{
			return daoImp.exits(scinfo);
		}
}
