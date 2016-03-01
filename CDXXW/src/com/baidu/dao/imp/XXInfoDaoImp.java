package com.baidu.dao.imp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.baidu.dao.BaseDao;
import com.baidu.model.IMAGEINFO;
import com.baidu.model.XXINFO;
@Repository
public interface XXInfoDaoImp extends BaseDao<XXINFO>{
	
//	�õ���Ϣ�б�
	public List<XXINFO> getXXList(XXINFO xxinfo);
	
//	�õ���������Ϣ
	public XXINFO getXXINFO(XXINFO xxinfo);
	
//	�õ���Ϣ������
	public int getXXCount(XXINFO xxinfo);
	
//	�༭��Ϣ
	public int editXX(XXINFO xxinfo);
	
//	ɾ����Ϣ-�߼�ɾ��
	public int delXX(XXINFO xxinfo);
	
//	������Ϣ
	public int addXX(XXINFO xxinfo);
	
//	�õ�ͼƬ��Ϣ
	public List<IMAGEINFO> getImage(XXINFO xxinfo);
	
//	����ͼƬ��Ϣ
	public int addImage(IMAGEINFO imageinfo);
	
//	ɾ��ͼƬ��Ϣ
	public int delImage(IMAGEINFO imageinfo);
	
//	�ҳ������ŵ��������Ϣ
	public List<XXINFO> getHotHDXXList(XXINFO xxinfo);
	
//	�ҳ�10�����µĵļ�ְ��Ϣ
	public List<XXINFO> getNewJZXXList(XXINFO xxinfo);
	
//	�ҳ�10�����µĶ�����Ϣ
	public List<XXINFO> getNEWESXXList(XXINFO xxinfo);
	
//	�õ�����Ϣ������Ƽ�,�������Լ�
	public List<XXINFO> getGROOMList(XXINFO xxinfo);
	
//	�õ�10�����ŵļ�ְ��Ϣ
	public List<XXINFO> getHotJZXXlist(XXINFO xxinfo);
	
//	�õ���صļ�ְ��Ϣ�Ƽ�5��
	public List<XXINFO> getGroomJzxxList(XXINFO xxinfo);
	
// �ղ���Ϣ+1
	public int updateXX_SC(XXINFO xxinfo);
	
// ���+1
	public int updateXX_LL(XXINFO xxinfo);

}
