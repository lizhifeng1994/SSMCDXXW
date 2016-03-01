package com.baidu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.model.IMAGEINFO;
import com.baidu.model.JZMXINFO;
import com.baidu.model.Page;
import com.baidu.model.USERINFO;
import com.baidu.model.XXINFO;
import com.baidu.service.imp.JZMXInfoService;
import com.baidu.service.imp.USERInfoService;
import com.baidu.service.imp.XXInfoService;
import com.baidu.utils.UUIDPro;
@Controller
@RequestMapping("/jzxx/")
public class JZXXInfoController extends BaseController<XXINFO>{
	
	
	@Autowired
	private JZMXInfoService jzmxInfoService;
	
	@Autowired
	private XXInfoService xxInfoService;
	
//	解决点击兼职信息还是保存查询结果
	@RequestMapping(value="jzxxlist")
	public String jzxx(HttpServletRequest request,ModelMap map)
	{
		HttpSession session = request.getSession();
//		判断是修改中的上传照片？？1   新增中的上传照片？？0
		String imageFlag = "0";
		session.setAttribute("imageFlag", imageFlag);
		
		
		request.getSession().removeAttribute("xxinfo");
		return jzxx_list(map, request);
		
	}
//	得到jzxx的列表
	@RequestMapping(value="list")
	public String jzxx_list(ModelMap map,HttpServletRequest request)
	{
		System.out.println("进来！！！！！！！！！！！！！！！！！！");
		HttpSession session = request.getSession();
		 
		XXINFO xxinfo = new XXINFO();
		 
		System.out.println(session.getAttribute("xxinfo"));
		 
//		保存查询结果，以便分页

		if(session.getAttribute("xxinfo")!=null)
		{
			xxinfo = (XXINFO) session.getAttribute("xxinfo");
		}
//		System.out.println(map.get("xxinfo")+"***************");

//		System.out.println("test-------------"+map.get("xxinfo"));
		
//		System.out.println(request.getParameter("jzxx_title"));
		
		String pageNow_jsp = request.getParameter("pageNow");
		

		int pageNow = 1;

		int pageSize = 10;
		xxinfo.setXX_TYPE("1");

//		得到多少条记录
		xxinfo.setRowCount(xxInfoService.getXXCount(xxinfo));

//		总共多少页
		xxinfo.setPageCount((xxinfo.getRowCount()-1)/pageSize+1);
		
//		兼职信息的XX_TYPE = '1'
		
		
		
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
		
//		System.out.println(xxInfoService.getCount(xxinfo)+"!!!!!!!!!!!!!!!");
		return "cdxxw_ht/jzxx-list";
 
	}
	
//	查询带分页
	@RequestMapping(value="query",method=RequestMethod.POST)
	public String query(HttpServletRequest request,ModelMap map)
	{
//		String test = "hahahha";
//		map.addAttribute("hehe",test);
//		当点击下一页时，查询条件不变，查询带分及成功
		String XXMX_TYPE = request.getParameter("jzxx_type");
//		String XXMX_TYPE = "1";
		String XX_TITLE =  request.getParameter("jzxx_title");
		String USER_NAME = request.getParameter("user_name");
		String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
		XXINFO xxinfo = new XXINFO();
		xxinfo.setXXMX_TYPE(XXMX_TYPE);
		xxinfo.setXX_TITLE(XX_TITLE);
		xxinfo.setUSER_NAME(USER_NAME);
		xxinfo.setStart_time(start_time);
		xxinfo.setEnd_time(end_time);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("xxinfo", xxinfo);
		
		System.out.println(xxinfo);
		return jzxx_list(map, request);
		
	}
	
	/*
	 * 今天利用url进行参数的传递/CDXXW/jzxx/jzmx?后面不能有空格，不然不能识别
	 */
	@RequestMapping(value="jzmx")
	public String getJZXXMX(HttpServletRequest request,ModelMap map,String XX_ID )
	{
		XX_ID = request.getParameter("XX_ID");
		XXINFO xxinfo = new XXINFO();
		
		IMAGEINFO imageinfo = new IMAGEINFO();
		List<IMAGEINFO> IMAGEList = new ArrayList<IMAGEINFO>();
		
		
		xxinfo.setXX_ID(XX_ID);
		xxinfo.setXX_TYPE("1");
		
		IMAGEList =xxInfoService.getImage(xxinfo);
		
		JZMXINFO jzmxinfo = jzmxInfoService.getJZMX(xxinfo);
		
		xxinfo = xxInfoService.getXXINFO(xxinfo);
		
		System.out.println(jzmxinfo.getJZJS_TYPE()+"-----------------");
		
		
//		System.out.println(IMAGEList+"图片————————————————————————-");
		
		map.addAttribute("IMAGEList", IMAGEList);
		
		map.addAttribute("XXINFO",xxinfo);
		
		map.addAttribute("JZMXINFO", jzmxinfo);
		
		
//		
//		System.out.println("JZMX--------------"+jzmxinfo);
//		System.out.println("进来JZMX------------------"+XX_ID);
		return "cdxxw_ht/jzxx-mx";
	}
	
//	跳转到新增兼职明细
	
	@RequestMapping(value="add")
	public String turnJZXX(HttpServletRequest request)
	{

		String XX_ID = UUIDPro.getUUID();
		HttpSession session = request.getSession();
		session.setAttribute("XX_ID", XX_ID);
		return "cdxxw_ht/jzxx-add";
	}
	

	@RequestMapping(value="upload")
	public void uploadJZXX(@RequestParam("file")MultipartFile file,HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		
		String XX_ID = (String) request.getSession().getAttribute("XX_ID");
		System.out.println("后台ID"+XX_ID);
		IMAGEINFO imageinfo = new IMAGEINFO();		
				imageinfo.setXX_ID(XX_ID);
		   try {
//			   上传兼职信息图片的文件夹
               super.upload(file, "/upload/jzxx/",request);
//               文件名字
               String FileName = null;

               FileName = super.getFileName();
               System.out.println(FileName+"----------------");
               FileName = FileName.substring(FileName.lastIndexOf("/jzxx")+6);
               
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
	
//	增加兼职信息

	@RequestMapping(value="jzxxadd",method=RequestMethod.POST)
	public void  addJZXX(ModelMap map,HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		System.out.println("进来增减兼职信息！！！！！！！！！！！！！！");
		XXINFO xxinfo = new XXINFO();
		JZMXINFO jzmxinfo = new JZMXINFO();
			HttpSession session = request.getSession();

			String XX_ID = (String) session.getAttribute("XX_ID");
			String XX_TITLE =  request.getParameter("XX_TITLE");
			String XXMX_TYPE = request.getParameter("XXMX_TYPE");
			String JZ_SALARY = request.getParameter("JZ_SALARY")+request.getParameter("JZ_SALARY_TYPE");
			
			String JZGZ_TIME = request.getParameter("START_TIME")+"--"+request.getParameter("END_TIME");
			String JZJS_TYPE = request.getParameter("JZJS_TYPE");
			
			
			String JZZP_NUMBER = request.getParameter("JZZP_NUMBER");
			String JZ_PHONE = request.getParameter("JZ_PHONE");
			String JZ_QQ = request.getParameter("JZ_QQ");
			String JZGZ_FIELD = request.getParameter("JZGZ_FIELD");
			String JZZW_MARK = request.getParameter("JZZW_MARK");
			String JZGS_MARK = request.getParameter("JZGS_MARK");
			
			xxinfo.setXX_ID(XX_ID);
			xxinfo.setXX_TITLE(XX_TITLE);
			xxinfo.setUSER_NAME("123");
			xxinfo.setXX_TYPE("1");
			xxinfo.setXXMX_TYPE(XXMX_TYPE);

	
			
			jzmxinfo.setXX_ID(XX_ID);			
			jzmxinfo.setJZ_SALARY(JZ_SALARY);
			jzmxinfo.setJZJS_TYPE(JZJS_TYPE);
			jzmxinfo.setJZGZ_TIME(JZGZ_TIME);
			jzmxinfo.setJZGZ_FIELD(JZGZ_FIELD);
			jzmxinfo.setJZZP_NUMBER(JZZP_NUMBER);
			jzmxinfo.setJZZW_MARK(JZZW_MARK);
			jzmxinfo.setJZGS_MARK(JZGS_MARK);
			jzmxinfo.setJZ_PHONE(JZ_PHONE);
			jzmxinfo.setJZ_QQ(JZ_QQ);
			
//			xxInfoService.addXX(xxinfo);
//			jzmxInfoService.addJZMX(jzmxinfo);
			if(xxInfoService.addXX(xxinfo)!=0&&jzmxInfoService.addJZMX(jzmxinfo)!=0)
			{
				System.out.println("增加信息成功！！！！！！！！！！！");
			}
	}
	
//	进入修改+修改图片
	@RequestMapping(value="jzxxedit")
	public String JZXXEdit(HttpServletRequest request,ModelMap map)
	{
		
		
		HttpSession session = request.getSession();
		
//		这是一个标志----表示修改中的上传图片
		session.setAttribute("imageFlag", "1");
		
		
		
		String XX_ID = request.getParameter("XX_ID");
		
		session.setAttribute("XX_ID", XX_ID);
		
		System.out.println("-----------------"+request.getParameter("XX_ID"));
		getJZXXMX(request, map, XX_ID);
		

		JZMXINFO jzmxinfo = (JZMXINFO) map.get("JZMXINFO");
		
		String JZ_SALARY = jzmxinfo.getJZ_SALARY();
		
		jzmxinfo.setJZ_SALARY(JZ_SALARY.substring(0,JZ_SALARY.indexOf('/')));
		
		String JZ_SALARY_TYPE = JZ_SALARY.substring(JZ_SALARY.lastIndexOf('/'));
		
		
		
		String JZGZ_TIME = jzmxinfo.getJZGZ_TIME();
		
		String START_TIME = JZGZ_TIME.substring(0, JZGZ_TIME.indexOf("--"));
		
		String END_TIME = JZGZ_TIME.substring(JZGZ_TIME.lastIndexOf("--")+2);		
		
		
		map.put("JZ_SALARY_TYPE", JZ_SALARY_TYPE);
		map.put("START_TIME", START_TIME);
		map.put("END_TIME", END_TIME);
		
		return "cdxxw_ht/jzxx-xg";
	}
	
	@RequestMapping(value="realjzxxedit",method=RequestMethod.POST)
	public void RealJZXXEdit(ModelMap map,HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		
		XXINFO xxinfo = new XXINFO();
		JZMXINFO jzmxinfo = new JZMXINFO();
		
		
		String XX_ID = (String) session.getAttribute("XX_ID");
		String XX_TITLE =  request.getParameter("XX_TITLE");
		String XXMX_TYPE = request.getParameter("XXMX_TYPE");
		String JZ_SALARY = request.getParameter("JZ_SALARY")+request.getParameter("JZ_SALARY_TYPE");
		String JZGZ_TIME = request.getParameter("START_TIME")+"--"+request.getParameter("END_TIME");
		String JZJS_TYPE = request.getParameter("JZJS_TYPE");
		String JZZP_NUMBER = request.getParameter("JZZP_NUMBER");
		String JZ_PHONE = request.getParameter("JZ_PHONE");
		String JZ_QQ = request.getParameter("JZ_QQ");
		String JZGZ_FIELD = request.getParameter("JZGZ_FIELD");
		String JZZW_MARK = request.getParameter("JZZW_MARK");
		String JZGS_MARK = request.getParameter("JZGS_MARK");
		
		xxinfo.setXX_ID(XX_ID);
		xxinfo.setXX_TITLE(XX_TITLE);
		xxinfo.setXXMX_TYPE(XXMX_TYPE);
		
		xxInfoService.editXX(xxinfo);
		
		jzmxinfo.setXX_ID(XX_ID);
		jzmxinfo.setJZ_SALARY(JZ_SALARY);
		jzmxinfo.setJZJS_TYPE(JZJS_TYPE);
		jzmxinfo.setJZGZ_TIME(JZGZ_TIME);
		jzmxinfo.setJZGZ_FIELD(JZGZ_FIELD);
		jzmxinfo.setJZZP_NUMBER(JZZP_NUMBER);
		jzmxinfo.setJZZW_MARK(JZZW_MARK);
		jzmxinfo.setJZGS_MARK(JZGS_MARK);
		jzmxinfo.setJZ_PHONE(JZ_PHONE);
		jzmxinfo.setJZ_QQ(JZ_QQ);
		
		jzmxInfoService.editJZMX(jzmxinfo);
		
//		return jzxx_list(map, request);
		
	}
	
	@RequestMapping(value="del")
	public String jzxx_del(ModelMap map,HttpServletRequest request)
	{
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
		return jzxx_list(map, request);
	
	
	}
}
