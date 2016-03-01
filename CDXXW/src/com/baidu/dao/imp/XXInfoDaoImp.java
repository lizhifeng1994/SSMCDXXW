package com.baidu.dao.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baidu.dao.BaseDao;
import com.baidu.model.IMAGEINFO;
import com.baidu.model.XXINFO;
@Repository
public interface XXInfoDaoImp extends BaseDao<XXINFO>{
	
//	得到信息列表
	public List<XXINFO> getXXList(XXINFO xxinfo);
	
//	得到单独的信息
	public XXINFO getXXINFO(XXINFO xxinfo);
	
//	得到信息的条数
	public int getXXCount(XXINFO xxinfo);
	
//	编辑信息
	public int editXX(XXINFO xxinfo);
	
//	删除信息-逻辑删除
	public int delXX(XXINFO xxinfo);
	
//	增加信息
	public int addXX(XXINFO xxinfo);
	
//	得到图片信息
	public List<IMAGEINFO> getImage(XXINFO xxinfo);
	
//	增加图片信息
	public int addImage(IMAGEINFO imageinfo);
	
//	删除图片信息
	public int delImage(IMAGEINFO imageinfo);
	
//	找出最热门的三个活动信息
	public List<XXINFO> getHotHDXXList(XXINFO xxinfo);
	
//	找出10条最新的的兼职信息
	public List<XXINFO> getNewJZXXList(XXINFO xxinfo);
	
//	找出10条最新的二手信息
	public List<XXINFO> getNEWESXXList(XXINFO xxinfo);
	
//	得到该信息的相关推荐,不包括自己
	public List<XXINFO> getGROOMList(XXINFO xxinfo);
	
//	得到10条热门的兼职信息
	public List<XXINFO> getHotJZXXlist(XXINFO xxinfo);
	
//	得到相关的兼职信息推荐5条
	public List<XXINFO> getGroomJzxxList(XXINFO xxinfo);
	
// 收藏信息+1
	public int updateXX_SC(XXINFO xxinfo);
	
// 浏览+1
	public int updateXX_LL(XXINFO xxinfo);

}
