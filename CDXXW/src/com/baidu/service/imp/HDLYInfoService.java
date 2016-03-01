package com.baidu.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.dao.imp.HDLYInfoDaoImp;
import com.baidu.model.HDLYINFO;
import com.baidu.model.XXINFO;
import com.baidu.service.BaseService;

@Service
public class HDLYInfoService extends BaseService<HDLYINFO> {
		@Autowired
		private HDLYInfoDaoImp daoImp;
		
//		�õ����ϸ
		public List<HDLYINFO> getHDLYList(XXINFO xxinfo)
		{
			return daoImp.getHDLYList(xxinfo);
		}
}
