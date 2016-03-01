package com.baidu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.baidu.dao.BaseDao;

public abstract class BaseService<T> {
	@Autowired
	private BaseDao<T> dao;
	
	public int add(T model) {		
		return dao.add(model);
	}

	public int del(T model) {
		// TODO Auto-generated method stub
		return dao.del(model);
	}

	public int update(T model) {
		// TODO Auto-generated method stub
		return dao.update(model);
	}

	public T getModel(T model) {
		// TODO Auto-generated method stub
		return dao.getModel(model);
	}

	public List<T> getAll(T model) {
		// TODO Auto-generated method stub
		return dao.getAll(model);
	}

	public int getCount(T model) {
		// TODO Auto-generated method stub
		return dao.getCount(model);
	}
}
