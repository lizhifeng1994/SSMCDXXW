package com.baidu.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.dao.imp.XXInfoDaoImp;
import com.baidu.model.IMAGEINFO;
import com.baidu.model.XXINFO;
import com.baidu.service.BaseService;

@Service
public class XXInfoService extends BaseService<XXINFO> {
	@Autowired
	private XXInfoDaoImp daoImp;
	
//	得到信息列表
	public List<XXINFO> getXXList(XXINFO xxinfo)
	{
		return daoImp.getXXList(xxinfo);
	}
	
//	得到信息的条数
	public int getXXCount(XXINFO xxinfo)
	{
		return daoImp.getXXCount(xxinfo);
	}
	
//	得到单独的信息
	public XXINFO getXXINFO(XXINFO xxinfo)
	{
		return daoImp.getXXINFO(xxinfo);
	}
	
//	编辑信息
	public int editXX(XXINFO xxinfo)
	{
		return daoImp.editXX(xxinfo);
	}
	
//	删除信息-逻辑删除
	public int delXX(XXINFO xxinfo)
	{
		return daoImp.delXX(xxinfo);
	}
	
//	增加信息
	public int addXX(XXINFO xxinfo)
	{
		return daoImp.addXX(xxinfo);
	}
	
//	得到图片信息
	public List<IMAGEINFO> getImage(XXINFO xxinfo)
	{
		return daoImp.getImage(xxinfo);
	}
	
//	增加图片信息
	public int addImage(IMAGEINFO imageinfo)
	{
		return daoImp.addImage(imageinfo);
	}
	
//	删除图片信息
	public int delImage(IMAGEINFO imageinfo)
	{
		return daoImp.delImage(imageinfo);
	}
	
//	找出最热门的三个活动信息
	public List<XXINFO> getHotHDXXList(XXINFO xxinfo)
	{
		return daoImp.getHotHDXXList(xxinfo);
	}
	
//	找出10条最新的的兼职信息
	public List<XXINFO> getNewJZXXList(XXINFO xxinfo)
	{
		return daoImp.getNewJZXXList(xxinfo);
	}
	
//	找出10条最新的二手信息
	public List<XXINFO> getNEWESXXList(XXINFO xxinfo)
	{
		return daoImp.getNEWESXXList(xxinfo);
	}
	
//	得到该信息的相关推荐
	public List<XXINFO> getGROOMList(XXINFO xxinfo)
	{
		return daoImp.getGROOMList(xxinfo);
	}
	
//	得到10条最热门的兼职信息
	public List<XXINFO> getHotJZXXlist(XXINFO xxinfo)
	{
		return daoImp.getHotJZXXlist(xxinfo);
	}
	
	
//	得到相关的兼职信息推荐5条
	public List<XXINFO> getGroomJzxxList(XXINFO xxinfo)
	{
		return daoImp.getGroomJzxxList(xxinfo);
	}
	
// 收藏信息+1
	public int updateXX_SC(XXINFO xxinfo)
	{
		return daoImp.updateXX_SC(xxinfo);
	}

// 收藏信息+1
	public int updateXX_LL(XXINFO xxinfo)
	{
		return daoImp.updateXX_LL(xxinfo);
	}
}
