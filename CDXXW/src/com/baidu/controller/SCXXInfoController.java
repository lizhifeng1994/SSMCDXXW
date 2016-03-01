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

import com.baidu.model.SCINFO;
import com.baidu.model.USERINFO;
import com.baidu.model.XXINFO;
import com.baidu.model.YHDTINFO;
import com.baidu.service.imp.SCXXInfoService;
import com.baidu.service.imp.XXInfoService;
import com.baidu.service.imp.YHDTInfoService;
import com.baidu.utils.UUIDPro;

//收藏信息
@Controller
@RequestMapping("/scxx/")
public class SCXXInfoController extends BaseController<SCINFO> {
	@Autowired
	private SCXXInfoService scxxInfoService;
	
	@Autowired
	private YHDTInfoService yhdtInfoService;
	
	@Autowired
	private XXInfoService xxInfoService;
	
//	进入收藏信息页面
	@RequestMapping(value="scxxlist")
	public String USER_SCXX(ModelMap map,HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		request.getSession().removeAttribute("scinfo");
		return sc_list(map, request);
	}
	
	@RequestMapping(value="list")
	public String sc_list(ModelMap map,HttpServletRequest request)
	{
		System.out.println("进来收藏信息！！！！！！！");
		HttpSession session = request.getSession();
		SCINFO scinfo= new SCINFO();
		
		if(session.getAttribute("scinfo")!=null)
		{
			scinfo = (SCINFO)session.getAttribute("scinfo");
		}
		String pageNow_jsp = request.getParameter("pageNow");
		
		int pageNow = 1;

		int pageSize = 10;
		
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
		List<SCINFO> scinfos;
		scinfos = scxxInfoService.getAll(scinfo);
		
		map.addAttribute("rowCount", scinfo.getRowCount());
		map.addAttribute("pageNow", pageNow);
		map.addAttribute("pageCount", scinfo.getPageCount());
		map.addAttribute("list", scinfos);
		return "cdxxw_ht/scxx-list";
	}
	
//	查询带分页
	@RequestMapping(value="query",method=RequestMethod.POST)
	public String query(HttpServletRequest request,ModelMap map)
	{
//		String test = "hahahha";
//		map.addAttribute("hehe",test);
//		当点击下一页时，查询条件不变，查询带分及成功
		System.out.println("进来查询！！！！！！！！！！");
		
		SCINFO scinfo = new SCINFO();
		String USER_NAME = request.getParameter("USER_NAME");
		String XX_TITLE = request.getParameter("XX_TITLE");
		String SC_TYPE = request.getParameter("SC_TYPE");
		
		scinfo.setUSER_NAME(USER_NAME);
		scinfo.setXX_TITLE(XX_TITLE);
		scinfo.setSC_TYPE(SC_TYPE);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("scinfo", scinfo);
		
		return sc_list(map, request);
	}
	
//	删除单个信息
	@ResponseBody
	@RequestMapping(value="del",method=RequestMethod.POST)
	public List<Integer> hdxx_del(ModelMap map,HttpServletRequest request)
	{
		SCINFO scinfo = new SCINFO();
		String SC_ID = request.getParameter("SC_ID");
		scinfo.setSC_ID(SC_ID);
		
		scxxInfoService.del(scinfo);
		
		int count = scxxInfoService.getCount(scinfo);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(count);
		return list;
	}
	
	
//	批量删除
	@RequestMapping(value="delAll")
	public String SCXX_delAll(ModelMap map,HttpServletRequest request)
	{
		SCINFO scinfo = new SCINFO();
		String SC_IDS = request.getParameter("SC_IDS");
		System.out.println(SC_IDS+"11111111111");
		if(SC_IDS!=null)
		{
			String SC_IDArr[] = SC_IDS.split(","); 
			for (String string : SC_IDArr) {
				scinfo.setSC_ID(string);
				scxxInfoService.del(scinfo);
			}
		}
		return sc_list(map, request);
	}
	
//	判断某人是否已经收藏
	@ResponseBody
	@RequestMapping(value="exits")
	public String exits(HttpServletRequest request)
	{
		String USER_NAME = request.getParameter("USER_NAME");
		String XX_ID = request.getParameter("XX_ID");
		SCINFO scinfo = new SCINFO();
		scinfo.setXX_ID(XX_ID);
		scinfo.setUSER_NAME(USER_NAME);
		
		if(scxxInfoService.exits(scinfo)!=0)
		{
			return "true";
		}
		return "false";
	}
	
//	添加收藏信息
	@ResponseBody
	@RequestMapping(value="add")
	public String sc_add(HttpServletRequest request)
	{
		String SC_ID = UUIDPro.getUUID();
		String XX_ID = request.getParameter("XX_ID");
		String XX_TITLE = request.getParameter("XX_TITLE");
		String USER_NAME = request.getParameter("USER_NAME");
		String SC_TYPE = request.getParameter("SC_TYPE");
		int XX_SC = Integer.parseInt(request.getParameter("XX_SC"));
		SCINFO scinfo = new SCINFO();
		scinfo.setSC_ID(SC_ID);
		scinfo.setXX_ID(XX_ID);
		scinfo.setXX_TITLE(XX_TITLE);
		scinfo.setUSER_NAME(USER_NAME);
		scinfo.setSC_TYPE(SC_TYPE);
		
		YHDTINFO yhdtinfo = new YHDTINFO();
		yhdtinfo.setYHDT_ID(UUIDPro.getUUID());
		yhdtinfo.setXX_ID(XX_ID);
		yhdtinfo.setXX_TITLE(XX_TITLE);
		yhdtinfo.setUSER_NAME(USER_NAME);
		yhdtinfo.setYHDT_TYPE("收藏");
		yhdtinfo.setXX_TYPE(SC_TYPE);
		
		XXINFO xxinfo = new XXINFO();
		xxinfo.setXX_ID(XX_ID);
		xxinfo.setXX_SC(String.valueOf((XX_SC+1)));
		
		if(scxxInfoService.add(scinfo)!=0)
		{
			if(yhdtInfoService.add(yhdtinfo)!=0)
			{
				if(xxInfoService.updateXX_SC(xxinfo)!=0)
				{
					return "true";
				}
			}
		}

		return "false";
	}
	
	
}
