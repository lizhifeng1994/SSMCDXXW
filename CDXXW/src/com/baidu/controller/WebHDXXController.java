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

import com.baidu.model.HDLYINFO;
import com.baidu.model.HDMXINFO;
import com.baidu.model.IMAGEINFO;
import com.baidu.model.USERINFO;
import com.baidu.model.XXINFO;
import com.baidu.service.imp.HDLYInfoService;
import com.baidu.service.imp.HDMXInfoService;
import com.baidu.service.imp.XXInfoService;
import com.baidu.utils.UUIDPro;
import com.baidu.vo.HDXXVO;


@Controller
@RequestMapping("/webhdxx/")
public class WebHDXXController extends BaseController<HDMXINFO> {
	
	@Autowired
	private XXInfoService xxInfoService;
	
	@Autowired
	private HDMXInfoService hdmxInfoService;
	
	@Autowired
	private HDLYInfoService hdlyInfoService;
	


//	活动，有分页，查询，明细，评论
	@RequestMapping(value="hdxxlist")
	public String cdxxw_htlist(ModelMap map,HttpServletRequest request)
	{
		return webhdxx_list(map, request);
	}
	
	@RequestMapping(value="list")
	public String webhdxx_list(ModelMap map,HttpServletRequest request)
	{
		
		HttpSession session = request.getSession();
		 
		XXINFO xxinfo = new XXINFO();
		
		 
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
		
		String XXMX_TYPE = request.getParameter("XXMX_TYPE");
		xxinfo.setXX_STATE("0");
		if(XXMX_TYPE.equals("0")==false)
		{
			xxinfo.setXXMX_TYPE(XXMX_TYPE);
		}
		int pageNow = 1;

		int pageSize = 4;
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

//		页面一条一条的信息包括的内容
		List<HDXXVO> hdxxvoList = new ArrayList<HDXXVO>();
		
//		页面显示内容
		for (XXINFO hdxx : xxinfos) {
			HDXXVO hdxxvo = new HDXXVO();
			HDLYINFO hdlyinfo = new HDLYINFO();
			hdlyinfo.setXX_ID(hdxx.getXX_ID());
			
			hdxxvo.setXX_ID(hdxx.getXX_ID());
			hdxxvo.setUSER_NAME(hdxx.getUSER_NAME());
			hdxxvo.setXX_TITLE(hdxx.getXX_TITLE());
			hdxxvo.setXXMX_TYPE(hdxx.getXXMX_TYPE());
			hdxxvo.setXX_LL(hdxx.getXX_LL());
			hdxxvo.setXX_SC(hdxx.getXX_SC());
			hdxxvo.setXX_TIME(hdxx.getXX_TIME());
			hdxxvo.setHD_CONTENT(hdmxInfoService.getHDMX(hdxx).getHD_CONTENT());
			hdxxvo.setXX_HDLY(String.valueOf(hdlyInfoService.getCount(hdlyinfo)));
			hdxxvo.setIMAGE_NAME(xxInfoService.getImage(hdxx).get(0).getIMAGE_NAME());
			hdxxvoList.add(hdxxvo);
		}
	

//		热门活动信息
			List<XXINFO> hotHDXXList = new ArrayList<XXINFO>();
			hotHDXXList = xxInfoService.getHotHDXXList(null);
			
		List<HDXXVO> hotHDMXList = new ArrayList<HDXXVO>();
		
		for (XXINFO hotHDXX : hotHDXXList) {
			HDXXVO hdxxvo = new HDXXVO();
			hdxxvo.setXX_ID(hotHDXX.getXX_ID());
			hdxxvo.setXX_TITLE(hotHDXX.getXX_TITLE());
			hdxxvo.setXXMX_TYPE(hotHDXX.getXXMX_TYPE());
			hdxxvo.setXX_TIME(hotHDXX.getXX_TIME().substring(0, 10));
			hdxxvo.setIMAGE_NAME(xxInfoService.getImage(hotHDXX).get(0).getIMAGE_NAME());
			
			hotHDMXList.add(hdxxvo);
		}
		
		map.addAttribute("hdxxvoList", hdxxvoList);
		map.addAttribute("pageNow", pageNow);
		map.addAttribute("pageCount", xxinfo.getPageCount());
		map.addAttribute("XXMX_TYPE", XXMX_TYPE);
		map.addAttribute("hotHDMXList", hotHDMXList);
		return "cdxxw_qt/cdxxw_hd";
	}
	
	@RequestMapping(value="hdmx")
	public String webhdxx_hdmx(ModelMap map,HttpServletRequest request)
	{
		String XX_ID  = request.getParameter("XX_ID");
		
		
		List<XXINFO> xxinfoList = new ArrayList<XXINFO>();
		
		List<HDXXVO> hdxxvoList = new ArrayList<HDXXVO>();
		
		XXINFO xxinfo = new XXINFO();
		IMAGEINFO imageinfo = new IMAGEINFO();
		List<IMAGEINFO> IMAGEList = new ArrayList<IMAGEINFO>();
		
		xxinfo.setXX_ID(XX_ID);
		xxinfo.setXX_TYPE("3");

		IMAGEList =xxInfoService.getImage(xxinfo);
		
		HDMXINFO hdmxinfo = hdmxInfoService.getHDMX(xxinfo);
		
		xxinfo = xxInfoService.getXXINFO(xxinfo);
		
//		浏览+1
		XXINFO xxinfo2 = new XXINFO();
		int  XX_LL = Integer.parseInt(xxinfo.getXX_LL());
		System.out.println(XX_LL+"####");
		XX_LL = XX_LL+1;
		xxinfo2.setXX_ID(xxinfo.getXX_ID());
		xxinfo2.setXX_LL(String.valueOf(XX_LL));
		
		xxInfoService.updateXX_LL(xxinfo2);
		
//		得到不包括该活动信息在类的三条推荐信息
		xxinfoList = xxInfoService.getGROOMList(xxinfo);
		
		for (XXINFO temp : xxinfoList) {
			HDXXVO hdxxvo = new HDXXVO();
			hdxxvo.setXX_ID(temp.getXX_ID());
			hdxxvo.setXX_TITLE(temp.getXX_TITLE());
			hdxxvo.setXXMX_TYPE(temp.getXXMX_TYPE());
			hdxxvo.setXX_TIME(temp.getXX_TIME().substring(0,10));
			hdxxvo.setIMAGE_NAME(xxInfoService.getImage(temp).get(0).getIMAGE_NAME());
			hdxxvoList.add(hdxxvo);
		}
		
		xxinfo.setXX_TIME(xxinfo.getXX_TIME().substring(0, 16));
		
		
//		System.out.println(IMAGEList+"图片————————————————————————-");
		
//		取得该活动信息的留言列表
		List<HDLYINFO> hdlyinfoList = new ArrayList<HDLYINFO>();

		hdlyinfoList = hdlyInfoService.getHDLYList(xxinfo);
//		留言评论多少
		int size = 0;
		for (HDLYINFO hdlyinfo : hdlyinfoList) {
			if(hdlyinfo.getHF_NAME()!=null)
			{
				size++;
			}
		}
		
		size  = size + hdlyinfoList.size();

//		图片信息
		map.addAttribute("IMAGEList", IMAGEList);
		
		
		map.addAttribute("XXINFO",xxinfo);
		
		map.addAttribute("HDMXINFO", hdmxinfo);
		
//		相关活动信息推荐，不包括自己
		map.addAttribute("hdxxvoList", hdxxvoList);
				
//		活动信息的留言列表
		map.addAttribute("hdlyinfoList", hdlyinfoList);
		
		map.addAttribute("size", size);
		
		return "cdxxw_qt/cdxxw_hdmx";
	}
	
	@RequestMapping(value="add")
	public String turn_hdxxadd(HttpServletRequest request,ModelMap map)
	{
		String XXMX_TYPE = request.getParameter("XXMX_TYPE");
		String flag= request.getParameter("flag");
		map.addAttribute("XXMX_TYPE", XXMX_TYPE);
		String XX_ID = UUIDPro.getUUID();
		HttpSession session = request.getSession();
		session.setAttribute("XX_ID", XX_ID);
		request.getSession().setAttribute("imageFlag", "0");
		map.addAttribute("flag", flag);
		return "cdxxw_qt/hdxx_add"; 	
	}
	
	@ResponseBody
	@RequestMapping(value="hdxxadd",method=RequestMethod.POST)
	public String hdxxadd(HttpServletRequest request)
	{
		XXINFO xxinfo = new XXINFO();
		HDMXINFO hdmxinfo = new HDMXINFO();
		USERINFO userinfo = new USERINFO();
		
		
		HttpSession session = request.getSession();
		
		userinfo = (USERINFO) session.getAttribute("webuser");
		
		String XX_ID = (String) session.getAttribute("XX_ID");
		String XX_TITLE = request.getParameter("XX_TITLE");
		String XXMX_TYPE = request.getParameter("XXMX_TYPE");
		
		xxinfo.setXX_ID(XX_ID);
		xxinfo.setXX_TITLE(XX_TITLE);
		xxinfo.setUSER_NAME(userinfo.getUSER_NAME());
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
				return "11";
			}
			else
			{
				return "22";
			}

		}
		else
		{
			return "false";
		}
	}
}
