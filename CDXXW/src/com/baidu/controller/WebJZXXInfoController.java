package com.baidu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.baidu.model.IMAGEINFO;
import com.baidu.model.JZMXINFO;
import com.baidu.model.USERINFO;
import com.baidu.model.XXINFO;
import com.baidu.service.imp.JZMXInfoService;
import com.baidu.service.imp.XXInfoService;
import com.baidu.utils.UUIDPro;

@Controller
@RequestMapping("/webjzxx/")
public class WebJZXXInfoController extends BaseController<XXINFO> {
	@Autowired
	private XXInfoService xxInfoService;
	
	@Autowired
	private JZMXInfoService jzmxInfoService;
	
	@RequestMapping(value="list")
	public String webjzxx_list(HttpServletRequest request,ModelMap map)
	{
		HttpSession session = request.getSession();
		 
		XXINFO xxinfo = new XXINFO();
		
		if(session.getAttribute("xxinfo")!=null)
		{
			xxinfo = (XXINFO) session.getAttribute("xxinfo");
			System.out.println("传过来的"+xxinfo);
		}
		
		String pageNow_jsp = request.getParameter("pageNow");
		
		String XXMX_TYPE = request.getParameter("XXMX_TYPE");
		

		if(XXMX_TYPE.equals("0")==false)
		{
			xxinfo.setXXMX_TYPE(XXMX_TYPE);
		}
		
		int pageNow = 1;

		int pageSize = 15;
		
		xxinfo.setXX_TYPE("1");
		
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
		List<XXINFO> jzxxList = new ArrayList<XXINFO>();
		
		List<XXINFO> hotjzxxList = new ArrayList<XXINFO>();
		
		jzxxList = xxInfoService.getXXList(xxinfo);
		
		
		hotjzxxList = xxInfoService.getHotJZXXlist(null);
		
		map.addAttribute("pageNow", pageNow);
		map.addAttribute("pageCount", xxinfo.getPageCount());
		map.addAttribute("XXMX_TYPE", XXMX_TYPE);
		map.addAttribute("jzxxList", jzxxList);
		map.addAttribute("hotjzxxList", hotjzxxList);
		
		return "cdxxw_qt/cdxxw_jz";
	}
	
	@RequestMapping(value="jzmx")
	public String web_jzmx(HttpServletRequest request,ModelMap map)
	{
		String XX_ID  = request.getParameter("XX_ID");
		List<XXINFO> groomJZXXList = new ArrayList<XXINFO>();
		
		XXINFO xxinfo = new XXINFO();
		IMAGEINFO imageinfo = new IMAGEINFO();
		List<IMAGEINFO> IMAGEList = new ArrayList<IMAGEINFO>();
		
		xxinfo.setXX_ID(XX_ID);
		xxinfo.setXX_TYPE("1");
		
		IMAGEList =xxInfoService.getImage(xxinfo);
		
		JZMXINFO jzmxinfo = jzmxInfoService.getJZMX(xxinfo);
		
		xxinfo = xxInfoService.getXXINFO(xxinfo);
		
//		浏览+1
		XXINFO xxinfo2 = new XXINFO();
		int  XX_LL = Integer.parseInt(xxinfo.getXX_LL());
		System.out.println(XX_LL+"####");
		XX_LL = XX_LL+1;
		xxinfo2.setXX_ID(xxinfo.getXX_ID());
		xxinfo2.setXX_LL(String.valueOf(XX_LL));
		
		xxInfoService.updateXX_LL(xxinfo2);
//		
		groomJZXXList = xxInfoService.getGroomJzxxList(xxinfo);
		
		map.addAttribute("IMAGEList", IMAGEList);
		
		map.addAttribute("XXINFO",xxinfo);
		
		map.addAttribute("jzmxinfo",jzmxinfo);
		
		map.addAttribute("groomJZXXList", groomJZXXList);
		
		return "cdxxw_qt/cdxxw_jzmx";
	}
	
	@RequestMapping(value="add")
	public String turn_jzxxadd(HttpServletRequest request,ModelMap map)
	{
		String XXMX_TYPE = request.getParameter("XXMX_TYPE");
		map.addAttribute("XXMX_TYPE", XXMX_TYPE);
		String XX_ID = UUIDPro.getUUID();
		HttpSession session = request.getSession();
		session.setAttribute("XX_ID", XX_ID);
		request.getSession().setAttribute("imageFlag", "0");
		return "cdxxw_qt/jzxx_add"; 	
	}
	
	@ResponseBody
	@RequestMapping(value="jzxxadd",method=RequestMethod.POST)
	public String jzxxadd(HttpServletRequest request)
	{
		
		XXINFO xxinfo = new XXINFO();
		JZMXINFO jzmxinfo = new JZMXINFO();
			HttpSession session = request.getSession();
			USERINFO userinfo = (USERINFO) session.getAttribute("webuser");
			
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
			xxinfo.setUSER_NAME(userinfo.getUSER_NAME());
			xxinfo.setXX_TYPE("1");
			xxinfo.setXXMX_TYPE(XXMX_TYPE);

			System.out.println(xxinfo+"前台兼职信息");
	
			
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
				return "true";
			}
			return "false";
		
	}
	
}
