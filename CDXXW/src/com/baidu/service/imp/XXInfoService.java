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
	
//	�õ���Ϣ�б�
	public List<XXINFO> getXXList(XXINFO xxinfo)
	{
		return daoImp.getXXList(xxinfo);
	}
	
//	�õ���Ϣ������
	public int getXXCount(XXINFO xxinfo)
	{
		return daoImp.getXXCount(xxinfo);
	}
	
//	�õ���������Ϣ
	public XXINFO getXXINFO(XXINFO xxinfo)
	{
		return daoImp.getXXINFO(xxinfo);
	}
	
//	�༭��Ϣ
	public int editXX(XXINFO xxinfo)
	{
		return daoImp.editXX(xxinfo);
	}
	
//	ɾ����Ϣ-�߼�ɾ��
	public int delXX(XXINFO xxinfo)
	{
		return daoImp.delXX(xxinfo);
	}
	
//	������Ϣ
	public int addXX(XXINFO xxinfo)
	{
		return daoImp.addXX(xxinfo);
	}
	
//	�õ�ͼƬ��Ϣ
	public List<IMAGEINFO> getImage(XXINFO xxinfo)
	{
		return daoImp.getImage(xxinfo);
	}
	
//	����ͼƬ��Ϣ
	public int addImage(IMAGEINFO imageinfo)
	{
		return daoImp.addImage(imageinfo);
	}
	
//	ɾ��ͼƬ��Ϣ
	public int delImage(IMAGEINFO imageinfo)
	{
		return daoImp.delImage(imageinfo);
	}
	
//	�ҳ������ŵ��������Ϣ
	public List<XXINFO> getHotHDXXList(XXINFO xxinfo)
	{
		return daoImp.getHotHDXXList(xxinfo);
	}
	
//	�ҳ�10�����µĵļ�ְ��Ϣ
	public List<XXINFO> getNewJZXXList(XXINFO xxinfo)
	{
		return daoImp.getNewJZXXList(xxinfo);
	}
	
//	�ҳ�10�����µĶ�����Ϣ
	public List<XXINFO> getNEWESXXList(XXINFO xxinfo)
	{
		return daoImp.getNEWESXXList(xxinfo);
	}
	
//	�õ�����Ϣ������Ƽ�
	public List<XXINFO> getGROOMList(XXINFO xxinfo)
	{
		return daoImp.getGROOMList(xxinfo);
	}
	
//	�õ�10�������ŵļ�ְ��Ϣ
	public List<XXINFO> getHotJZXXlist(XXINFO xxinfo)
	{
		return daoImp.getHotJZXXlist(xxinfo);
	}
	
	
//	�õ���صļ�ְ��Ϣ�Ƽ�5��
	public List<XXINFO> getGroomJzxxList(XXINFO xxinfo)
	{
		return daoImp.getGroomJzxxList(xxinfo);
	}
	
// �ղ���Ϣ+1
	public int updateXX_SC(XXINFO xxinfo)
	{
		return daoImp.updateXX_SC(xxinfo);
	}

// �ղ���Ϣ+1
	public int updateXX_LL(XXINFO xxinfo)
	{
		return daoImp.updateXX_LL(xxinfo);
	}
}
