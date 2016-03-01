package com.baidu.dao;

import java.util.List;

public interface BaseDao<T> {
	int add(T model);
	int del(T model);
	int update(T model);
	T getModel(T model);
	List<T> getAll(T model);
	int getCount(T model);
}
