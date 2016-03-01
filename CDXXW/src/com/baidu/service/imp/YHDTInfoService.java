package com.baidu.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.dao.imp.YHDTInfoDaoImp;
import com.baidu.model.YHDTINFO;
import com.baidu.service.BaseService;

@Service
public class YHDTInfoService extends BaseService<YHDTINFO> {
	@Autowired
	private YHDTInfoDaoImp daoImp;
}
