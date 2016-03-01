package com.baidu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.model.ESMXINFO;
import com.baidu.model.IMAGEINFO;
import com.baidu.model.JZMXINFO;
import com.baidu.model.XXINFO;
import com.baidu.service.imp.ESMXInfoService;
import com.baidu.service.imp.JZMXInfoService;
import com.baidu.service.imp.XXInfoService;
import com.baidu.utils.UUIDPro;

@Controller
@RequestMapping("/esxx/")
public class ESXXInfoController extends BaseController<XXINFO> {
	
	@Autowired
	private ESMXInfoService esmxInfoService;
	
	@Autowired
	private XXInfoService xxInfoService;
	
//	��������ְ��Ϣ���Ǳ����ѯ���
	@RequestMapping(value="esxxlist")
	public String esxx(HttpServletRequest request,ModelMap map)
	{
		HttpSession session = request.getSession();
//		�ж����޸��е��ϴ���Ƭ����1   �����е��ϴ���Ƭ����0
		String imageFlag = "0";
		session.setAttribute("imageFlag", imageFlag);
		
		request.getSession().removeAttribute("xxinfo");
		return esxx_list(map, request);
		
	}
	
	
//	�õ�esxx���б�
	@RequestMapping(value="list")
	public String esxx_list(ModelMap map,HttpServletRequest request)
	{
		System.out.println("����������������������������������������");
		HttpSession session = request.getSession();
		 
		XXINFO xxinfo = new XXINFO();
		 
		System.out.println(session.getAttribute("xxinfo"));
		 
//		�����ѯ������Ա��ҳ

		if(session.getAttribute("xxinfo")!=null)
		{
			xxinfo = (XXINFO) session.getAttribute("xxinfo");
			System.out.println("��������"+xxinfo);
		}
//		System.out.println(map.get("xxinfo")+"***************");

//		System.out.println("test-------------"+map.get("xxinfo"));
		
//		System.out.println(request.getParameter("jzxx_title"));
		
		String pageNow_jsp = request.getParameter("pageNow");
		

		int pageNow = 1;

		int pageSize = 10;
//		������Ϣ������Ϊ��2��
		xxinfo.setXX_TYPE("2");
		
//		�õ���������¼
		xxinfo.setRowCount(xxInfoService.getXXCount(xxinfo));

//		�ܹ�����ҳ
		xxinfo.setPageCount((xxinfo.getRowCount()-1)/pageSize+1);

		if (pageNow_jsp != null) {
			pageNow = Integer.parseInt(pageNow_jsp);
			xxinfo.setSqlPageSize((pageNow-1)*pageSize);
		} else {			
			pageNow = 1;			
			xxinfo.setSqlPageSize((pageNow-1)*pageSize);

		}
		xxinfo.setPageSize(pageSize);
		List<XXINFO> xxinfos;
		

		xxinfos = xxInfoService.getXXList(xxinfo);
	
		map.addAttribute("rowCount", xxinfo.getRowCount());
		map.addAttribute("pageNow", pageNow);
		map.addAttribute("pageCount", xxinfo.getPageCount());
		map.addAttribute("list", xxinfos);
		return "cdxxw_ht/esxx-list";
 
	}
//	��ѯ����ҳ
	@RequestMapping(value="query",method=RequestMethod.POST)
	public String query(HttpServletRequest request,ModelMap map)
	{
//		String test = "hahahha";
//		map.addAttribute("hehe",test);
//		�������һҳʱ����ѯ�������䣬��ѯ���ּ��ɹ�
		System.out.println("������ѯ��������������������");
		String XXMX_TYPE = request.getParameter("esxx_type");
		String XX_TYPE = "2";
		String XX_TITLE =  request.getParameter("esxx_title");
		String XX_STATE = request.getParameter("XX_STATE");
		String USER_NAME = request.getParameter("user_name");
		String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
		
		XXINFO xxinfo = new XXINFO();
		xxinfo.setXX_TYPE(XX_TYPE);
		xxinfo.setXXMX_TYPE(XXMX_TYPE);
		xxinfo.setXX_TITLE(XX_TITLE);
		xxinfo.setXX_STATE(XX_STATE);
		xxinfo.setUSER_NAME(USER_NAME);
		
		xxinfo.setStart_time(start_time);
		xxinfo.setEnd_time(end_time);
		
		System.out.println(xxinfo+"------------------");
		HttpSession session = request.getSession();
		
		session.setAttribute("xxinfo", xxinfo);
		
		System.out.println(xxinfo);
		return esxx_list(map, request);
		
	}
	
	@RequestMapping(value="add")
	public String turnESXX(HttpServletRequest request)
	{

		String XX_ID = UUIDPro.getUUID();
		HttpSession session = request.getSession();
		session.setAttribute("XX_ID", XX_ID);
		return "cdxxw_ht/esxx-add";
	}
	
	@RequestMapping(value="upload")
	public void uploadESXX(@RequestParam("file")MultipartFile file,HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("�����ϴ�ͼƬ������������������������������������������");
		HttpSession session = request.getSession();
		
		String XX_ID = (String) request.getSession().getAttribute("XX_ID");
		IMAGEINFO imageinfo = new IMAGEINFO();		
				imageinfo.setXX_ID(XX_ID);
		   try {
//			   �ϴ���ְ��ϢͼƬ���ļ���
               super.upload(file, "/upload/esxx/",request);
//               �ļ�����
               String FileName = null;

               FileName = super.getFileName();
               System.out.println(FileName+"----------------");
               FileName = FileName.substring(FileName.lastIndexOf("/esxx")+6);
               
               imageinfo.setIMAGE_NAME(FileName);
               System.out.println(FileName+"---------------");
//              �ļ���ʽ
               String FileType = null;
               FileType = FileName.substring(FileName.lastIndexOf(".")+1);
               imageinfo.setIMAGE_TYPE(FileType);
               System.out.println(FileType+"-------------------");
               
               if(session.getAttribute("imageFlag").equals("0") )
               {
            	   if(xxInfoService.addImage(imageinfo)!=0)
            	   {
            		   System.out.println("�ϴ�ͼƬ�ɹ�--------------------------");
            	   }
            	   
               }
               if(session.getAttribute("imageFlag").equals("1"))
               {
//            	   ִ���޸���ӦID�е�ͼƬ,��ɾ�����ڲ���
            	   xxInfoService.delImage(imageinfo);
            	   xxInfoService.addImage(imageinfo);
            	   
               }
               response.getWriter().print(super.getFileName());
           } catch (Exception e) {
               e.printStackTrace();
           }
        	
	}
	
//	���Ӷ�����ϸ��Ϣ
	@RequestMapping(value="esxxadd",method=RequestMethod.POST)
	public void  addESXX(ModelMap map,HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		System.out.println("����������ְ��Ϣ����������������������������");
		XXINFO xxinfo = new XXINFO();
		ESMXINFO esmxinfo = new ESMXINFO();
			
		HttpSession session = request.getSession();

		String XX_ID = (String) session.getAttribute("XX_ID");
		String XX_TITLE = request.getParameter("XX_TITLE");
		String XXMX_TYPE = request.getParameter("XXMX_TYPE");
		
		String ES_CS = request.getParameter("ES_CS");
		String ES_PRICE = request.getParameter("ES_PRICE");
		String ES_PHONE = request.getParameter("ES_PHONE");
		String ES_QQ = request.getParameter("ES_QQ");
		String ES_CONTENT = request.getParameter("ES_CONTENT");
		
		
		xxinfo.setXX_ID(XX_ID);
		xxinfo.setXX_TITLE(XX_TITLE);
		xxinfo.setUSER_NAME("123");
		xxinfo.setXX_TYPE("2");
		xxinfo.setXXMX_TYPE(XXMX_TYPE);
		
		esmxinfo.setXX_ID(XX_ID);
		esmxinfo.setES_CS(ES_CS);
		esmxinfo.setES_PRICE(ES_PRICE);
		esmxinfo.setES_PHONE(ES_PHONE);
		esmxinfo.setES_QQ(ES_QQ);
		esmxinfo.setES_CONTENT(ES_CONTENT);
		
		if(xxInfoService.addXX(xxinfo)!=0&&esmxInfoService.addESMX(esmxinfo)!=0)
		{
			System.out.println("���Ӷ�����Ϣ�ɹ�����������������������");
		}		
	}
	
	@RequestMapping(value="esmx")
	public String getESXXMX(HttpServletRequest request,ModelMap map,String XX_ID )
	{
		XX_ID = request.getParameter("XX_ID");

		System.out.println("22222222222222222"+XX_ID);
		XXINFO xxinfo = new XXINFO();
		
		IMAGEINFO imageinfo = new IMAGEINFO();
		List<IMAGEINFO> IMAGEList = new ArrayList<IMAGEINFO>();
		
		
		xxinfo.setXX_ID(XX_ID);
		xxinfo.setXX_TYPE("2");
		
		IMAGEList =xxInfoService.getImage(xxinfo);
		
		ESMXINFO esmxinfo = esmxInfoService.getESMX(xxinfo);
		
		xxinfo = xxInfoService.getXXINFO(xxinfo);
				
		System.out.println("111111111111"+xxinfo);
		
//		System.out.println(IMAGEList+"ͼƬ������������������������������������������������-");
		
		map.addAttribute("IMAGEList", IMAGEList);
		
		map.addAttribute("XXINFO",xxinfo);
		
		map.addAttribute("ESMXINFO", esmxinfo);
		
		
//		
//		System.out.println("JZMX--------------"+jzmxinfo);
//		System.out.println("����JZMX------------------"+XX_ID);
		return "cdxxw_ht/esxx-mx";
	}
	
//	�༭������Ϣ
//	�����޸�+�޸�ͼƬ
	@RequestMapping(value="esxxedit")
	public String ESXXEdit(HttpServletRequest request,ModelMap map)
	{
		HttpSession session = request.getSession();		
//		����һ����־----��ʾ�޸��е��ϴ�ͼƬ
		session.setAttribute("imageFlag", "1");
		
		String XX_ID = request.getParameter("XX_ID");
		
		System.out.println("!!!!!!!!!!!!!!!!!!111"+XX_ID);
		session.setAttribute("XX_ID", XX_ID);
		getESXXMX(request, map, XX_ID);

		return "cdxxw_ht/esxx-xg";
	}
	
	
	@RequestMapping(value="realesxxedit",method=RequestMethod.POST)
	public void RealJZXXEdit(ModelMap map,HttpServletRequest request)
	{
		
		HttpSession session = request.getSession();
		
		XXINFO xxinfo = new XXINFO();
		ESMXINFO esmxinfo = new ESMXINFO();
		
		
		String XX_ID = (String) session.getAttribute("XX_ID");
		String XX_TITLE =  request.getParameter("XX_TITLE");
		String XXMX_TYPE = request.getParameter("XXMX_TYPE");
		String ES_CS = request.getParameter("ES_CS");
		String ES_PRICE = request.getParameter("ES_PRICE");
		String ES_PHONE = request.getParameter("ES_PHONE");
		String ES_QQ = request.getParameter("ES_QQ");
		String ES_CONTENT = request.getParameter("ES_CONTENT");

		xxinfo.setXX_ID(XX_ID);
		xxinfo.setXX_TITLE(XX_TITLE);
		xxinfo.setXXMX_TYPE(XXMX_TYPE);
		
		xxInfoService.editXX(xxinfo);
		
		esmxinfo.setXX_ID(XX_ID);
		esmxinfo.setES_CS(ES_CS);
		esmxinfo.setES_PRICE(ES_PRICE);
		esmxinfo.setES_PHONE(ES_PHONE);
		esmxinfo.setES_QQ(ES_QQ);
		esmxinfo.setES_CONTENT(ES_CONTENT);
		
		esmxInfoService.editESMX(esmxinfo);
	}
	
	@RequestMapping(value="del")
	public String esxx_del(ModelMap map,HttpServletRequest request)
	{
		System.out.println("����ɾ��������Ϣ");
		XXINFO xxinfo = new XXINFO();
		String XX_IDS = request.getParameter("XX_IDS");
		System.out.println(XX_IDS+"---------");
		String XX_ID = request.getParameter("XX_ID");
		if(XX_IDS!=null)
		{
			String XX_IDArr[] = XX_IDS.split(","); 
			for (String string : XX_IDArr) {
				xxinfo.setXX_ID(string);
				xxInfoService.delXX(xxinfo);
			}
		}
		else
		{
			xxinfo.setXX_ID(XX_ID);
			System.out.println(XX_ID+"!!!!!!!!!!!!!!!!");
			xxInfoService.delXX(xxinfo);
		}
		return esxx_list(map, request);
	
	
	}
	
//	�ı������Ϣ��״̬Ϊ�ѽ���
	@ResponseBody
	@RequestMapping(value="jy")
	public String esxx_yjy(ModelMap map,HttpServletRequest request)
	{
		XXINFO xxinfo = new XXINFO();
		String XX_STATE = request.getParameter("XX_STATE");
		String XX_ID = request.getParameter("XX_ID");
		
		xxinfo.setXX_ID(XX_ID);
		xxinfo.setXX_STATE(XX_STATE);
		 
		if(esmxInfoService.editES_STATE(xxinfo)!=0)
		{
			return "true";
		}
		else
		{
			return "false";
		}
	}
	
}
