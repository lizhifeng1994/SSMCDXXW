package com.baidu.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.dao.imp.JBXXInfoDaoImp;
import com.baidu.model.ZNTZINFO;
import com.baidu.service.BaseService;

@Service
public class ZNTZInfoService extends BaseService<ZNTZINFO> {
	@Autowired
	private JBXXInfoDaoImp daoImp;
}
