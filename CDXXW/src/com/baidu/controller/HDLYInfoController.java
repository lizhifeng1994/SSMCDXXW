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
import com.baidu.model.SCINFO;
import com.baidu.model.YHDTINFO;
import com.baidu.service.imp.HDLYInfoService;
@Controller
@RequestMapping("/hdly/")
public class HDLYInfoController extends BaseController<HDLYINFO> {
	@Autowired
	private HDLYInfoService hdlyInfoService;
	
//	进入收藏信息页面
	@RequestMapping(value="hdlylist")
	public String USER_SCXX(ModelMap map,HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		request.getSession().removeAttribute("hdlyinfo");
		return hdly_list(map, request);
	}
	
	@RequestMapping(value="list")
	public String hdly_list(ModelMap map,HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		HDLYINFO hdlyinfo= new HDLYINFO();
		
		if(session.getAttribute("hdlyinfo")!=null)
		{
			hdlyinfo = (HDLYINFO)session.getAttribute("hdlyinfo");
			System.out.println(hdlyinfo);
		}
		String pageNow_jsp = request.getParameter("pageNow");
		
		int pageNow = 1;

		int pageSize = 10;
		
//		得到用户信息的条数
		
		hdlyinfo.setRowCount(hdlyInfoService.getCount(hdlyinfo));
		System.out.println(hdlyinfo.getRowCount()+"----------");
//		总共多少页
		hdlyinfo.setPageCount((hdlyinfo.getRowCount()-1)/pageSize+1);
		
		if (pageNow_jsp != null) {
			pageNow = Integer.parseInt(pageNow_jsp);
			hdlyinfo.setSqlPageSize((pageNow-1)*pageSize);
		} else {			
			pageNow = 1;			
			hdlyinfo.setSqlPageSize((pageNow-1)*pageSize);
		}
		
		hdlyinfo.setPageSize(pageSize);
		List<HDLYINFO> hdlyinfos;
		hdlyinfos = hdlyInfoService.getAll(hdlyinfo);
		
		map.addAttribute("rowCount", hdlyinfo.getRowCount());
		map.addAttribute("pageNow", pageNow);
		map.addAttribute("pageCount", hdlyinfo.getPageCount());
		map.addAttribute("list", hdlyinfos);
		return "cdxxw_ht/hdly-list";
	}
	
	
//	查询带分页
	@RequestMapping(value="query",method=RequestMethod.POST)
	public String query(HttpServletRequest request,ModelMap map)
	{
//		String test = "hahahha";
//		map.addAttribute("hehe",test);
//		当点击下一页时，查询条件不变，查询带分及成功
		System.out.println("进来查询！！！！！！！！！！");
		
		HDLYINFO hdlyinfo = new HDLYINFO();
	
		String XX_TITLE = request.getParameter("XX_TITLE");
		

		hdlyinfo.setXX_TITLE(XX_TITLE);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("hdlyinfo", hdlyinfo);
		return hdly_list(map, request);
	}
	
//	删除单个信息
	@ResponseBody
	@RequestMapping(value="del",method=RequestMethod.POST)
	public List<Integer> hdxx_del(ModelMap map,HttpServletRequest request)
	{
		HDLYINFO hdlyinfo = new HDLYINFO();
		
		
		String HDLY_ID = request.getParameter("HDLY_ID");

		hdlyinfo.setHDLY_ID(HDLY_ID);
		
		hdlyInfoService.del(hdlyinfo);
		
		int count = hdlyInfoService.getCount(hdlyinfo);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(count);
		return list;
	}
	
//	批量删除
	@RequestMapping(value="delAll")
	public String SCXX_delAll(ModelMap map,HttpServletRequest request)
	{
		HDLYINFO hdlyinfo = new HDLYINFO();
		String HDLY_IDS = request.getParameter("HDLY_IDS");
		System.out.println(HDLY_IDS+"11111111111");
		if(HDLY_IDS!=null)
		{
			String YHDT_IDArr[] = HDLY_IDS.split(","); 
			for (String string : YHDT_IDArr) {
				hdlyinfo.setHDLY_ID(string);
				hdlyInfoService.del(hdlyinfo);
			}
		}
		return hdly_list(map, request);
	}
}
