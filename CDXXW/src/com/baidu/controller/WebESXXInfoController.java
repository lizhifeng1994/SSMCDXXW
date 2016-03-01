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

import com.baidu.model.ESMXINFO;
import com.baidu.model.IMAGEINFO;
import com.baidu.model.USERINFO;
import com.baidu.model.XXINFO;
import com.baidu.service.imp.ESMXInfoService;
import com.baidu.service.imp.XXInfoService;
import com.baidu.utils.UUIDPro;
import com.baidu.vo.ESXXVO;
@Controller
@RequestMapping("/webesxx/")
public class WebESXXInfoController extends BaseController<ESMXINFO> {
	@Autowired
	private XXInfoService xxInfoService;
	
	@Autowired
	private ESMXInfoService esmxInfoService;
//	活动，有分页，查询，明细，评论
	@RequestMapping(value="list")
	public String cdxxw_eslist(ModelMap map,HttpServletRequest request)
	{
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
		String XXMX_TYPE = request.getParameter("XXMX_TYPE");
		
		if(XXMX_TYPE.equals("0")==false)
		{
			xxinfo.setXXMX_TYPE(XXMX_TYPE);
		}
		String pageNow_jsp = request.getParameter("pageNow");
		

		int pageNow = 1;

		int pageSize = 9;
//		二手信息的类型为‘2’
		xxinfo.setXX_TYPE("2");
		
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
			esxxvo.setES_PRICE( esmxInfoService.getESMX(esxx).getES_PRICE());
			esxxvo.setIMAGE_NAME(xxInfoService.getImage(esxx).get(0).getIMAGE_NAME());
			esxxvoList.add(esxxvo);
		}
		

		map.addAttribute("rowCount", xxinfo.getRowCount());
		map.addAttribute("pageNow", pageNow);
		map.addAttribute("pageCount", xxinfo.getPageCount());
		map.addAttribute("XXMX_TYPE", XXMX_TYPE);
		map.addAttribute("esxxvoList", esxxvoList);
		return "cdxxw_qt/cdxxw_es";
	}
	
	@RequestMapping(value="esmx")
	public String webesmx(HttpServletRequest request,ModelMap map)
	{
		String XX_ID = request.getParameter("XX_ID");
		
		XXINFO xxinfo = new XXINFO();
		
		IMAGEINFO imageinfo = new IMAGEINFO();
		
		List<IMAGEINFO> IMAGEList = new ArrayList<IMAGEINFO>();
	
		List<XXINFO> xxinfoList = new ArrayList<XXINFO>();
		
		List<ESXXVO> esxxvoList = new ArrayList<ESXXVO>();
		
		xxinfo.setXX_ID(XX_ID);
		
		xxinfo.setXX_TYPE("2");
		
		IMAGEList = xxInfoService.getImage(xxinfo);
		
		ESMXINFO esmxinfo = esmxInfoService.getESMX(xxinfo);
		
		xxinfo = xxInfoService.getXXINFO(xxinfo);
		
//		浏览+1
		XXINFO xxinfo2 = new XXINFO();
		int  XX_LL = Integer.parseInt(xxinfo.getXX_LL());
		System.out.println(XX_LL+"####");
		XX_LL = XX_LL+1;
		xxinfo2.setXX_ID(xxinfo.getXX_ID());
		xxinfo2.setXX_LL(String.valueOf(XX_LL));
		
		xxInfoService.updateXX_LL(xxinfo2);
		
		xxinfoList = xxInfoService.getGROOMList(xxinfo);
		
		
		for (XXINFO esxx : xxinfoList) {
			ESXXVO esxxvo = new ESXXVO();
			esxxvo.setXX_ID(esxx.getXX_ID());
			esxxvo.setXX_TITLE(esxx.getXX_TITLE());
			esxxvo.setUSER_NAME(esxx.getUSER_NAME());
			esxxvo.setXX_TIME(esxx.getXX_TIME().substring(0, 15));
			esxxvo.setES_PRICE( esmxInfoService.getESMX(esxx).getES_PRICE());
			esxxvo.setIMAGE_NAME(xxInfoService.getImage(esxx).get(0).getIMAGE_NAME());
			esxxvoList.add(esxxvo);
		}
		
		map.addAttribute("IMAGEList", IMAGEList);
		map.addAttribute("XXINFO",xxinfo);
//		相关二手信息推荐，不包括自己
		map.addAttribute("esxxvoList", esxxvoList);

		
		map.addAttribute("esmxinfo", esmxinfo);
		
		return "cdxxw_qt/cdxxw_esmx";
	}
	
	@RequestMapping(value="add")
	public String turn_esxxadd(HttpServletRequest request,ModelMap map)
	{
		String XXMX_TYPE = request.getParameter("XXMX_TYPE");
		map.addAttribute("XXMX_TYPE", XXMX_TYPE);
		String XX_ID = UUIDPro.getUUID();
		HttpSession session = request.getSession();
		session.setAttribute("XX_ID", XX_ID);
		request.getSession().setAttribute("imageFlag", "0");
		return "cdxxw_qt/esxx_add"; 	
	}
	
	@ResponseBody
	@RequestMapping(value="esxxadd",method=RequestMethod.POST)
	public String esxxadd(HttpServletRequest request)
	{

		XXINFO xxinfo = new XXINFO();
		ESMXINFO esmxinfo = new ESMXINFO();
		USERINFO userinfo = new USERINFO();
		
		userinfo = (USERINFO) request.getSession().getAttribute("webuser");
		
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
		xxinfo.setUSER_NAME(userinfo.getUSER_NAME());
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
			return "true";
		}
		return "false";
	}
	
}
