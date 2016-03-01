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
import com.baidu.model.YHDTINFO;
import com.baidu.service.imp.YHDTInfoService;

@Controller
@RequestMapping("/yhdt/")
public class YHDTInfoController extends BaseController<YHDTINFO>{
	
	@Autowired
	private YHDTInfoService yhdtInfoService;
	
	@RequestMapping(value="yhdtlist")
	public String yhdt(ModelMap map,HttpServletRequest request)
	{
		
		HttpSession session = request.getSession();
		request.getSession().removeAttribute("yhdtinfo");
		return yhdt_list(map, request);
	}
	
	@RequestMapping(value="list")
	public String yhdt_list(ModelMap map,HttpServletRequest request)
	{
		System.out.println("进来用户动态信息！！！！！！！");
		HttpSession session = request.getSession();
		YHDTINFO yhdtinfo= new YHDTINFO();
		
		if(session.getAttribute("yhdtinfo")!=null)
		{
			yhdtinfo = (YHDTINFO)session.getAttribute("yhdtinfo");
		}
		String pageNow_jsp = request.getParameter("pageNow");
		

		int pageNow = 1;

		int pageSize = 10;
		
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
		
		yhdtinfo.setPageSize(pageSize);
		List<YHDTINFO> yhdtinfos;
		yhdtinfos = yhdtInfoService.getAll(yhdtinfo);
		
		map.addAttribute("rowCount", yhdtinfo.getRowCount());
		map.addAttribute("pageCount", yhdtinfo.getPageCount());
		map.addAttribute("pageNow", pageNow);
		map.addAttribute("list", yhdtinfos);
		return "cdxxw_ht/yhdt-list";
	}
	
//	查询带分页
	@RequestMapping(value="query",method=RequestMethod.POST)
	public String query(HttpServletRequest request,ModelMap map)
	{
//		String test = "hahahha";
//		map.addAttribute("hehe",test);
//		当点击下一页时，查询条件不变，查询带分及成功
		System.out.println("进来查询！！！！！！！！！！");
		
		YHDTINFO yhdtinfo = new YHDTINFO();
		String USER_NAME = request.getParameter("USER_NAME");
		String XX_TITLE = request.getParameter("XX_TITLE");
		
		yhdtinfo.setUSER_NAME(USER_NAME);
		yhdtinfo.setXX_TITLE(XX_TITLE);	
		HttpSession session = request.getSession();
		
		session.setAttribute("yhdtinfo", yhdtinfo);
		return yhdt_list(map, request);
	}
	
	
//	删除单个信息
	@ResponseBody
	@RequestMapping(value="del",method=RequestMethod.POST)
	public List<Integer> hdxx_del(ModelMap map,HttpServletRequest request)
	{
		YHDTINFO yhdtinfo = new YHDTINFO();
		String YHDT_ID = request.getParameter("YHDT_ID");
		yhdtinfo.setYHDT_ID(YHDT_ID);
		
		yhdtInfoService.del(yhdtinfo);
		
		int count = yhdtInfoService.getCount(yhdtinfo);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(count);
		return list;
	}
	
//	批量删除
	@RequestMapping(value="delAll")
	public String SCXX_delAll(ModelMap map,HttpServletRequest request)
	{
		YHDTINFO yhdtinfo = new YHDTINFO();
		String YHDT_IDS = request.getParameter("YHDT_IDS");
		System.out.println(YHDT_IDS+"11111111111");
		if(YHDT_IDS!=null)
		{
			String YHDT_IDArr[] = YHDT_IDS.split(","); 
			for (String string : YHDT_IDArr) {
				yhdtinfo.setYHDT_ID(string);
				yhdtInfoService.del(yhdtinfo);
			}
		}
		return yhdt_list(map, request);
	}
	
}
