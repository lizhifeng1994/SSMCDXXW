package com.baidu.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.dao.imp.JBXXInfoDaoImp;
import com.baidu.model.JBXXINFO;
import com.baidu.service.BaseService;

@Service
public class JBXXInfoService extends BaseService<JBXXINFO> {
	@Autowired
	private JBXXInfoDaoImp daoImp;
}
