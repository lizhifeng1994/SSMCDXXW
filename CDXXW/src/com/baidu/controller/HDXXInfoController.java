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

import com.baidu.model.ESMXINFO;
import com.baidu.model.HDMXINFO;
import com.baidu.model.IMAGEINFO;
import com.baidu.model.XXINFO;
import com.baidu.service.imp.HDMXInfoService;
import com.baidu.service.imp.XXInfoService;
import com.baidu.utils.UUIDPro;

@Controller
@RequestMapping("/hdxx/")
public class HDXXInfoController extends BaseController<XXINFO> {
	@Autowired
	private HDMXInfoService hdmxInfoService;
	
	@Autowired
	private XXInfoService xxInfoService;
	
//	解决点击兼职信息还是保存查询结果
	@RequestMapping(value="hdxxlist")
	public String hdxx(HttpServletRequest request,ModelMap map)
	{
		HttpSession session = request.getSession();
//		判断是修改中的上传照片？？1   新增中的上传照片？？0
		String imageFlag = "0";
		session.setAttribute("imageFlag", imageFlag);
		
		request.getSession().removeAttribute("xxinfo");
		return hdxx_list(map, request);	
	}
	
//	得到esxx的列表
	@RequestMapping(value="list")
	public String hdxx_list(ModelMap map,HttpServletRequest request)
	{
		System.out.println("进来！！！！！！！！！！！！！！！！！！");
		HttpSession session = request.getSession();
		 
		XXINFO xxinfo = new XXINFO();
		 
		System.out.println(session.getAttribute("xxinfo"));
		 
//		保存查询结果，以便分页

		if(session.getAttribute("xxinfo")!=null)
		{
			xxinfo = (XXINFO) session.getAttribute("xxinfo");
			System.out.println("传过来的"+xxinfo);
		}
//		System.out.println(map.get("xxinfo")+"***************");

//		System.out.println("test-------------"+map.get("xxinfo"));
		
//		System.out.println(request.getParameter("jzxx_title"));
		
		String pageNow_jsp = request.getParameter("pageNow");
		

		int pageNow = 1;

		int pageSize = 10;
//		活动信息信息的类型为‘2’
		xxinfo.setXX_TYPE("3");
		
//		得到多少条记录
		xxinfo.setRowCount(xxInfoService.getXXCount(xxinfo));

//		总共多少页
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
		return "cdxxw_ht/hdxx-list";
 
	}
	
	@RequestMapping(value="add")
	public String turnHDXX(HttpServletRequest request)
	{
		String XX_ID = UUIDPro.getUUID();
		HttpSession session = request.getSession();
		session.setAttribute("XX_ID", XX_ID);
		return "cdxxw_ht/hdxx-add";
	}
	
//	附件和图片的上传都是用的这个方法
	@RequestMapping(value="upload")
	public void uploadHDXX(@RequestParam("file")MultipartFile file,HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("进来上传图片！！！！！！！！！！！！！！！！！！！！！");
		HttpSession session = request.getSession();
		
		String XX_ID = (String) request.getSession().getAttribute("XX_ID");
		IMAGEINFO imageinfo = new IMAGEINFO();		
				imageinfo.setXX_ID(XX_ID);
		   try {
//			   上传兼职信息图片的文件夹
               super.upload(file, "/upload/hdxx/",request);
//               文件名字
               String FileName = null;

               FileName = super.getFileName();
               System.out.println(FileName+"----------------");
               FileName = FileName.substring(FileName.lastIndexOf("/hdxx")+6);
               
               imageinfo.setIMAGE_NAME(FileName);
               System.out.println(FileName+"---------------");
//              文件格式
               String FileType = null;
               FileType = FileName.substring(FileName.lastIndexOf(".")+1);
               imageinfo.setIMAGE_TYPE(FileType);
               System.out.println(FileType+"-------------------");
               
               if(session.getAttribute("imageFlag").equals("0") )
               {
            	   if(xxInfoService.addImage(imageinfo)!=0)
            	   {
            		   System.out.println("上传图片成功--------------------------");
            	   }
            	   
               }
               if(session.getAttribute("imageFlag").equals("1"))
               {
//            	   执行修改相应ID中的图片,先删除，在插入
            	   xxInfoService.delImage(imageinfo);
            	   xxInfoService.addImage(imageinfo);
               }
               response.getWriter().print(super.getFileName());
           } catch (Exception e) {
               e.printStackTrace();
           }
        	
	}
	
//	增加二手明细信息
	@RequestMapping(value="hdxxadd",method=RequestMethod.POST)
	public void  addHDXX(ModelMap map,HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		System.out.println("进来增减兼职信息！！！！！！！！！！！！！！");
		XXINFO xxinfo = new XXINFO();
		HDMXINFO hdmxinfo = new HDMXINFO();
			
		HttpSession session = request.getSession();

		String XX_ID = (String) session.getAttribute("XX_ID");
		String XX_TITLE = request.getParameter("XX_TITLE");
		String XXMX_TYPE = request.getParameter("XXMX_TYPE");
		
		xxinfo.setXX_ID(XX_ID);
		xxinfo.setXX_TITLE(XX_TITLE);
		xxinfo.setUSER_NAME("123");
		xxinfo.setXX_TYPE("3");
		xxinfo.setXXMX_TYPE(XXMX_TYPE);

		
		String HD_PLACE = request.getParameter("HD_PLACE");
		String HD_START_TIME = request.getParameter("HD_START_TIME");
		String HD_END_TIME = request.getParameter("HD_END_TIME");
		String HD_PHONE = request.getParameter("HD_PHONE");
		String HD_QQ = request.getParameter("HD_QQ");
		String HD_WEB = request.getParameter("HD_WEB");
		String HD_CONTENT = request.getParameter("HD_CONTENT");
		
		
		hdmxinfo.setXX_ID(XX_ID);
		hdmxinfo.setHD_PLACE(HD_PLACE);
		hdmxinfo.setHD_START_TIME(HD_START_TIME);
		hdmxinfo.setHD_END_TIME(HD_END_TIME);
		hdmxinfo.setHD_PHONE(HD_PHONE);
		hdmxinfo.setHD_QQ(HD_QQ);
		hdmxinfo.setHD_WEB(HD_WEB);
		hdmxinfo.setHD_CONTENT(HD_CONTENT);
		
		if(xxInfoService.addXX(xxinfo)!=0&&hdmxInfoService.addHDMX(hdmxinfo)!=0)
		{
//			如果活动信息不是个人发起，则不需要审核
			if(XXMX_TYPE.equals("1")||XXMX_TYPE.equals("2")||XXMX_TYPE.equals("3"))
			{
				xxinfo.setXX_STATE("0");
				hdmxInfoService.editHD_STATE(xxinfo);
				xxinfo.getXX_STATE();
			}
			System.out.println("增加活动信息成功！！！！！！！！！！！");
		}	

	}
	
//	查询带分页
	@RequestMapping(value="query",method=RequestMethod.POST)
	public String query(HttpServletRequest request,ModelMap map)
	{
		String XXMX_TYPE = request.getParameter("hdxx_type");
		String XX_TYPE = "3";
		String XX_TITLE =  request.getParameter("hdxx_title");
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
		return hdxx_list(map, request);
		
	}
	
//	活动明细
	@RequestMapping(value="hdmx")
	public String getHDXXMX(HttpServletRequest request,ModelMap map,String XX_ID )
	{
		XX_ID = request.getParameter("XX_ID");
		
		XXINFO xxinfo = new XXINFO();
		
		IMAGEINFO imageinfo = new IMAGEINFO();
		List<IMAGEINFO> IMAGEList = new ArrayList<IMAGEINFO>();
		
		
		xxinfo.setXX_ID(XX_ID);
		xxinfo.setXX_TYPE("3");
		
		IMAGEList =xxInfoService.getImage(xxinfo);
		
		HDMXINFO hdmxinfo = hdmxInfoService.getHDMX(xxinfo);
		
		xxinfo = xxInfoService.getXXINFO(xxinfo);
				
		System.out.println("111111111111"+xxinfo);
		
//		System.out.println(IMAGEList+"图片————————————————————————-");
		
		map.addAttribute("IMAGEList", IMAGEList);
		
		map.addAttribute("XXINFO",xxinfo);
		
		map.addAttribute("HDMXINFO", hdmxinfo);
		return "cdxxw_ht/hdxx-mx";
	}
	
//	改变活动信息的状态为
	@ResponseBody
	@RequestMapping(value="sh")
	public String hdxx_sh(ModelMap map,HttpServletRequest request)
	{
		XXINFO xxinfo = new XXINFO();
		String XX_STATE = request.getParameter("XX_STATE");
		String XX_ID = request.getParameter("XX_ID");
		
		xxinfo.setXX_ID(XX_ID);
		xxinfo.setXX_STATE(XX_STATE);
		if(hdmxInfoService.editHD_STATE(xxinfo)!=0){
			return "true";
		}
		else{
			return "false";
		}
	}
	
	
//	编辑二手信息
	
//	进入修改+修改图片
	@RequestMapping(value="hdxxedit")
	public String HDXXEdit(HttpServletRequest request,ModelMap map)
	{
		
		
		HttpSession session = request.getSession();
		
		
//		这是一个标志----表示修改中的上传图片
		session.setAttribute("imageFlag", "1");
		
		String XX_ID = request.getParameter("XX_ID");
		
		System.out.println("!!!!!!!!!!!!!!!!!!111"+XX_ID);
		session.setAttribute("XX_ID", XX_ID);
		getHDXXMX(request, map, XX_ID);

		return "cdxxw_ht/hdxx-xg";
	}
	
//	编辑活动信息
	@RequestMapping(value="realhdxxedit",method=RequestMethod.POST)
	public void RealJZXXEdit(ModelMap map,HttpServletRequest request)
	{

		HttpSession session = request.getSession();
		
		XXINFO xxinfo = new XXINFO();
		HDMXINFO hdmxinfo = new HDMXINFO();
		
		String XX_ID = (String) session.getAttribute("XX_ID");
		String XX_TITLE =  request.getParameter("XX_TITLE");
		String XXMX_TYPE = request.getParameter("XXMX_TYPE");
		String HD_PLACE = request.getParameter("HD_PLACE");
		String HD_START_TIME = request.getParameter("HD_START_TIME");
		String HD_END_TIME = request.getParameter("HD_END_TIME");
		String HD_PHONE = request.getParameter("HD_PHONE");
		String HD_QQ = request.getParameter("HD_QQ");
		String HD_WEB = request.getParameter("HD_WEB");
		String HD_CONTENT = request.getParameter("HD_CONTENT");
		

		
		xxinfo.setXX_ID(XX_ID);
		xxinfo.setXX_TITLE(XX_TITLE);
		xxinfo.setXXMX_TYPE(XXMX_TYPE);
		
		xxInfoService.editXX(xxinfo);
		
		hdmxinfo.setXX_ID(XX_ID);
		hdmxinfo.setHD_PLACE(HD_PLACE);
		hdmxinfo.setHD_START_TIME(HD_START_TIME);
		hdmxinfo.setHD_END_TIME(HD_END_TIME);
		hdmxinfo.setHD_PHONE(HD_PHONE);
		hdmxinfo.setHD_QQ(HD_QQ);
		hdmxinfo.setHD_WEB(HD_WEB);
		hdmxinfo.setHD_CONTENT(HD_CONTENT);
		
		hdmxInfoService.editHDMX(hdmxinfo);
		
		if(XXMX_TYPE.equals("1")||XXMX_TYPE.equals("2")||XXMX_TYPE.equals("3"))
		{
			System.out.println(XXMX_TYPE+"22222222222222222222");
			xxinfo.setXX_STATE("0");
			hdmxInfoService.editHD_STATE(xxinfo);
		}
	}
	
//	删除单个信息
	@ResponseBody
	@RequestMapping(value="del",method=RequestMethod.POST)
	public List<Integer> hdxx_del(ModelMap map,HttpServletRequest request)
	{
		XXINFO xxinfo = new XXINFO();
		String XX_ID = request.getParameter("XX_ID");
		xxinfo.setXX_ID(XX_ID);
		xxinfo.setXX_TYPE("3");
		xxInfoService.delXX(xxinfo);		
		
		int count = xxInfoService.getXXCount(xxinfo);
		
		System.out.println(count+"1111111111111111111111111");
		List<Integer> list = new ArrayList<Integer>();
		list.add(count);
		return list;
	}
	
//	批量删除
	@RequestMapping(value="delAll")
	public String hdxx_delAll(ModelMap map,HttpServletRequest request)
	{
		XXINFO xxinfo = new XXINFO();
		String XX_IDS = request.getParameter("XX_IDS");
//		System.out.println(XX_IDS+"---------");
		if(XX_IDS!=null)
		{
			String XX_IDArr[] = XX_IDS.split(","); 
			for (String string : XX_IDArr) {
				xxinfo.setXX_ID(string);
				xxInfoService.delXX(xxinfo);
			}
		}
		return hdxx_list(map, request);
	}
	
}
