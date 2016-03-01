package com.baidu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import com.baidu.model.SCINFO;
import com.baidu.model.USERINFO;
import com.baidu.model.XXINFO;
import com.baidu.model.YHDTINFO;
import com.baidu.model.ZNTZINFO;
import com.baidu.service.imp.ESMXInfoService;
import com.baidu.service.imp.HDMXInfoService;
import com.baidu.service.imp.SCXXInfoService;
import com.baidu.service.imp.USERInfoService;
import com.baidu.service.imp.XXInfoService;
import com.baidu.service.imp.YHDTInfoService;
import com.baidu.service.imp.ZNTZInfoService;
import com.baidu.vo.ESXXVO;
import com.baidu.vo.HDXXVO;
import com.baidu.vo.JZXXVO;
import com.baidu.vo.SCXXVO;
@Controller
@RequestMapping("/webzone/")
public class CDXXWZoneController extends BaseController<XXINFO> {
	@Autowired
	private XXInfoService xxInfoService;
	
	@Autowired
	private USERInfoService userInfoService ;
	
	@Autowired
	private SCXXInfoService scxxInfoService;
	
	@Autowired
	private YHDTInfoService yhdtInfoService;
	
	@Autowired
	private ESMXInfoService esmxInfoService;
	
	@Autowired
	private HDMXInfoService hdmxInfoService;
	
	@Autowired
	private ZNTZInfoService zntzInfoService;
	
	@RequestMapping(value="zone")
	public String xx_choice(HttpServletRequest request,ModelMap map)
	{
		HttpSession session = request.getSession();
		
		USERINFO userinfo = (USERINFO) session.getAttribute("webuser");
		
		XXINFO xxinfo = new XXINFO();
		xxinfo.setUSER_NAME(userinfo.getUSER_NAME());
		
		int XX_COUNT = xxInfoService.getXXCount(xxinfo);
		
		SCINFO scinfo = new SCINFO();
		scinfo.setUSER_NAME(userinfo.getUSER_NAME());
		int SC_COUNT = scxxInfoService.getCount(scinfo);
//		获取用户个人动态列表
		YHDTINFO yhdtinfo= new YHDTINFO();
		
		if(session.getAttribute("yhdtinfo")!=null)
		{
			yhdtinfo = (YHDTINFO)session.getAttribute("yhdtinfo");
		}
		String pageNow_jsp = request.getParameter("pageNow");
		
		System.out.println(pageNow_jsp+"0000000000000");
		int pageNow = 1;

		int pageSize = 7;
		
//		得到用户信息的条数
		
		yhdtinfo.setRowCount(yhdtInfoService.getCount(yhdtinfo));
		System.out.println(yhdtinfo.getRowCount()+"----------");
		
//		总共多少页
		yhdtinfo.setPageCount((yhdtinfo.getRowCount()-1)/pageSize+1);
		
		if (pageNow_jsp != null) {
			pageNow = Integer.parseInt(pageNow_jsp);
			yhdtinfo.setSqlPageSize((pageNow-1)*pageSize);
		} else {			
			pageNow = 1;			
			yhdtinfo.setSqlPageSize((pageNow-1)*pageSize);
		}
		yhdtinfo.setUSER_NAME(userinfo.getUSER_NAME());
		
		yhdtinfo.setPageSize(pageSize);
		List<YHDTINFO> yhdtinfos;
		yhdtinfos = yhdtInfoService.getAll(yhdtinfo);
		
		
		
		
		map.addAttribute("XX_COUNT", XX_COUNT);
		map.addAttribute("SC_COUNT", SC_COUNT);
		map.addAttribute("webuser", userinfo);
		
		map.addAttribute("rowCount", yhdtinfo.getRowCount());
		map.addAttribute("pageNow", pageNow);
		map.addAttribute("pageCount", yhdtinfo.getPageCount());
		map.addAttribute("list", yhdtinfos);
		
		return "cdxxw_qt/cdxxw_zone";
	}
	
	@RequestMapping(value="jzxx")
	public String zone_jzxx(HttpServletRequest request,ModelMap map)
	{
		HttpSession session = request.getSession();
		USERINFO userinfo = new USERINFO();
		userinfo = (USERINFO) session.getAttribute("webuser");
		XXINFO xxinfo = new XXINFO();
		System.out.println(session.getAttribute("xxinfo"));
		 
//		保存查询结果，以便分页
		
		if(session.getAttribute("xxinfo")!=null)
		{
			xxinfo = (XXINFO) session.getAttribute("xxinfo");
			System.out.println("传过来的"+xxinfo);
		}
		String pageNow_jsp = request.getParameter("pageNow");
		

		int pageNow = 1;

		int pageSize = 5;
//		二手信息的类型为‘2’
		xxinfo.setXX_TYPE("1");
		xxinfo.setUSER_NAME(userinfo.getUSER_NAME());
		
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

		List<JZXXVO> jzxxvoList = new ArrayList<JZXXVO>();
		
		for (XXINFO jzxx : xxinfos) {
			JZXXVO jzxxvo = new JZXXVO();
			jzxxvo.setUSER_NAME(userinfo.getUSER_NAME());
			jzxxvo.setXX_ID(jzxx.getXX_ID());
			jzxxvo.setXX_LL(xxinfo.getXX_LL());
			jzxxvo.setXX_SC(jzxx.getXX_SC());
			jzxxvo.setXX_TIME(jzxx.getXX_TIME());
			jzxxvo.setXX_TITLE(jzxx.getXX_TITLE());
			jzxxvo.setXXMX_TYPE(jzxx.getXXMX_TYPE());
			jzxxvo.setIMAGE_NAME(xxInfoService.getImage(jzxx).get(0).getIMAGE_NAME());
			
			jzxxvoList.add(jzxxvo);
		}
		map.addAttribute("rowCount", xxinfo.getRowCount());
		map.addAttribute("pageNow", pageNow);
		map.addAttribute("pageCount", xxinfo.getPageCount());
		map.addAttribute("jzxxvoList", jzxxvoList);
		return "cdxxw_qt/cdxxw_zone";
	}
	
	@RequestMapping(value="esxx")
	public String zone_esxx(HttpServletRequest request,ModelMap map)
	{
		
		HttpSession session = request.getSession();
		USERINFO userinfo = new USERINFO();
		userinfo = (USERINFO) session.getAttribute("webuser");
		XXINFO xxinfo = new XXINFO();
		System.out.println(session.getAttribute("xxinfo"));
		 
//		保存查询结果，以便分页
		
		if(session.getAttribute("xxinfo")!=null)
		{
			xxinfo = (XXINFO) session.getAttribute("xxinfo");
			System.out.println("传过来的"+xxinfo);
		}
		String pageNow_jsp = request.getParameter("pageNow");
		

		int pageNow = 1;

		int pageSize = 5;
//		二手信息的类型为‘2’
		xxinfo.setXX_TYPE("2");
		xxinfo.setUSER_NAME(userinfo.getUSER_NAME());
		
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
//		前台二手信息VO
		List<ESXXVO> esxxvoList = new ArrayList<ESXXVO>();
		
		for (XXINFO esxx : xxinfos) {
			ESXXVO esxxvo = new ESXXVO();
			esxxvo.setXX_ID(esxx.getXX_ID());
			esxxvo.setXX_TITLE(esxx.getXX_TITLE());
			esxxvo.setUSER_NAME(esxx.getUSER_NAME());
			esxxvo.setXX_TIME(esxx.getXX_TIME().substring(0, 16));
			esxxvo.setXXMX_TYPE(esxx.getXXMX_TYPE());
			esxxvo.setXX_LL(esxx.getXX_LL());
			esxxvo.setXX_SC(esxx.getXX_SC());

			esxxvo.setXX_STATE(esxx.getXX_STATE());
	
			esxxvo.setIMAGE_NAME(xxInfoService.getImage(esxx).get(0).getIMAGE_NAME());
			esxxvoList.add(esxxvo);
		}
		
		System.out.println(esxxvoList+"hahah");
		map.addAttribute("rowCount", xxinfo.getRowCount());
		map.addAttribute("pageNow", pageNow);
		map.addAttribute("pageCount", xxinfo.getPageCount());
		map.addAttribute("esxxvoList", esxxvoList);
		return "cdxxw_qt/cdxxw_zone";
	}
	
	@RequestMapping(value="hdxx")
	public String zone_hdxx(HttpServletRequest request,ModelMap map)
	{
		HttpSession session = request.getSession();
		 
		XXINFO xxinfo = new XXINFO();
		USERINFO userinfo = new USERINFO();
		userinfo = (USERINFO) session.getAttribute("webuser");
		 
//		保存查询结果，以便分页

		if(session.getAttribute("xxinfo")!=null)
		{
			xxinfo = (XXINFO) session.getAttribute("xxinfo");
			System.out.println("传过来的"+xxinfo);
		}

		String pageNow_jsp = request.getParameter("pageNow");		
		int pageNow = 1;

		int pageSize = 5;
//		活动信息信息的类型为‘2’
		xxinfo.setXX_TYPE("3");
		xxinfo.setUSER_NAME(userinfo.getUSER_NAME());
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

//		页面一条一条的信息包括的内容
		List<HDXXVO> hdxxvoList = new ArrayList<HDXXVO>();
		
//		页面显示内容
		for (XXINFO hdxx : xxinfos) {
			HDXXVO hdxxvo = new HDXXVO();
			
			hdxxvo.setXX_ID(hdxx.getXX_ID());
			hdxxvo.setUSER_NAME(hdxx.getUSER_NAME());
			hdxxvo.setXX_TITLE(hdxx.getXX_TITLE());
			hdxxvo.setXXMX_TYPE(hdxx.getXXMX_TYPE());
			hdxxvo.setXX_LL(hdxx.getXX_LL());
			hdxxvo.setXX_SC(hdxx.getXX_SC());
			hdxxvo.setXX_TIME(hdxx.getXX_TIME());
			hdxxvo.setXX_STATE(hdxx.getXX_STATE());
			hdxxvo.setHD_CONTENT(hdmxInfoService.getHDMX(hdxx).getHD_CONTENT());
			hdxxvo.setIMAGE_NAME(xxInfoService.getImage(hdxx).get(0).getIMAGE_NAME());
			hdxxvoList.add(hdxxvo);
		}
		map.addAttribute("hdxxvoList", hdxxvoList);
		map.addAttribute("pageNow", pageNow);
		map.addAttribute("pageCount", xxinfo.getPageCount());
		return "cdxxw_qt/cdxxw_zone";
	}
	
	@RequestMapping(value="scxx")
	public String zone_scxx(HttpServletRequest request,ModelMap map)
	{
		HttpSession session = request.getSession();
		
		USERINFO userinfo = (USERINFO) session.getAttribute("webuser");
		SCINFO scinfo= new SCINFO();
		
		if(session.getAttribute("scinfo")!=null)
		{
			scinfo = (SCINFO)session.getAttribute("scinfo");
		}
		String pageNow_jsp = request.getParameter("pageNow");
		
		int pageNow = 1;

		int pageSize = 6;
		
//		得到用户信息的条数
		
		scinfo.setRowCount(scxxInfoService.getCount(scinfo));
		System.out.println(scinfo.getRowCount()+"----------");
//		总共多少页
		scinfo.setPageCount((scinfo.getRowCount()-1)/pageSize+1);
		
		if (pageNow_jsp != null) {
			pageNow = Integer.parseInt(pageNow_jsp);
			scinfo.setSqlPageSize((pageNow-1)*pageSize);
		} else {			
			pageNow = 1;			
			scinfo.setSqlPageSize((pageNow-1)*pageSize);
		}
		
		scinfo.setPageSize(pageSize);
		scinfo.setUSER_NAME(userinfo.getUSER_NAME());
		
		List<SCINFO> scinfos;
		scinfos = scxxInfoService.getAll(scinfo);
		
		List<SCXXVO> scxxvoList = new ArrayList<SCXXVO>();
		for (SCINFO scxx : scinfos) {
			XXINFO xxinfo = new XXINFO();
			xxinfo.setXX_ID(scxx.getXX_ID());
			SCXXVO scxxvo = new SCXXVO();
			scxxvo.setIMAGE_NAME(xxInfoService.getImage(xxinfo).get(0).getIMAGE_NAME());
			scxxvo.setSC_ID(scxx.getSC_ID());
			scxxvo.setSC_TIME(scxx.getSC_TIME());
			scxxvo.setXX_ID(scxx.getXX_ID());
			scxxvo.setXX_TITLE(scxx.getXX_TITLE());
			scxxvo.setXX_TYPE(scxx.getSC_TYPE());
			scxxvoList.add(scxxvo);
		}
		
		map.addAttribute("rowCount", scinfo.getRowCount());
		map.addAttribute("pageNow", pageNow);
		map.addAttribute("pageCount", scinfo.getPageCount());
		map.addAttribute("scxxvoList", scxxvoList);
		return "cdxxw_qt/cdxxw_zone";
	}
	
	@RequestMapping(value="zntz")
	public String zone_zntz(HttpServletRequest request,ModelMap map)
	{

		HttpSession session = request.getSession();
		ZNTZINFO zntzinfo= new ZNTZINFO();
		USERINFO userinfo = (USERINFO) session.getAttribute("webuser");
		
		if(session.getAttribute("zntzinfo")!=null)
		{
			zntzinfo = (ZNTZINFO)session.getAttribute("zntzinfo");
		}
		String pageNow_jsp = request.getParameter("pageNow");
		
		int pageNow = 1;

		int pageSize = 5;
		
//		得到用户信息的条数
		zntzinfo.setUSER_NAME(userinfo.getUSER_NAME());
		zntzinfo.setZNTZ_STATE("1");
		zntzinfo.setRowCount(zntzInfoService.getCount(zntzinfo));
		System.out.println(zntzinfo.getRowCount()+"----------");
//		总共多少页
		zntzinfo.setPageCount((zntzinfo.getRowCount()-1)/pageSize+1);
		
		if (pageNow_jsp != null) {
			pageNow = Integer.parseInt(pageNow_jsp);
			zntzinfo.setSqlPageSize((pageNow-1)*pageSize);
		} else {			
			pageNow = 1;			
			zntzinfo.setSqlPageSize((pageNow-1)*pageSize);
		}
		
		zntzinfo.setPageSize(pageSize);
		List<ZNTZINFO> zntzinfos;
		zntzinfos = zntzInfoService.getAll(zntzinfo);
		System.out.println(zntzinfos+"hahah");
		map.addAttribute("rowCount", zntzinfo.getRowCount());
		map.addAttribute("pageNow", pageNow);
		map.addAttribute("pageCount", zntzinfo.getPageCount());
		map.addAttribute("zntzList", zntzinfos);
		return "cdxxw_qt/cdxxw_zone";
	}
	
	@RequestMapping(value="user")
	public String zone_user(HttpServletRequest request)
	{
		return "cdxxw_qt/cdxxw_zone";
		
	}
}
