package com.baidu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.model.JBXXINFO;
import com.baidu.model.USERINFO;
import com.baidu.model.YHDTINFO;
import com.baidu.model.ZNTZINFO;
import com.baidu.service.imp.JBXXInfoService;
import com.baidu.service.imp.USERInfoService;
import com.baidu.service.imp.ZNTZInfoService;
import com.baidu.utils.UUIDPro;

@Controller
@RequestMapping("/zntz/")
public class ZNTZInfoController extends BaseController<ZNTZINFO>{
	@Autowired
	private ZNTZInfoService zntzInfoService;
	@Autowired
	private USERInfoService userInfoService;
	@Autowired
	private JBXXInfoService jbxxInfoService;
	@RequestMapping(value="zntzlist")
	public String yhdt(ModelMap map,HttpServletRequest request)
	{
		
		HttpSession session = request.getSession();
		request.getSession().removeAttribute("zntzinfo");
		return zntz_list(map, request);
	}
	
	@RequestMapping(value="list")
	public String zntz_list(ModelMap map,HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		ZNTZINFO zntzinfo= new ZNTZINFO();
		
		if(session.getAttribute("zntzinfo")!=null)
		{
			zntzinfo = (ZNTZINFO)session.getAttribute("zntzinfo");
		}
		String pageNow_jsp = request.getParameter("pageNow");
		
		int pageNow = 1;

		int pageSize = 10;
		
//		得到用户信息的条数
		
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
		
		map.addAttribute("rowCount", zntzinfo.getRowCount());
		map.addAttribute("pageNow", pageNow);
		map.addAttribute("pageCount", zntzinfo.getPageCount());
		map.addAttribute("list", zntzinfos);
		return "cdxxw_ht/zntz-list";
	}
	
//	查询带分页
	@RequestMapping(value="query",method=RequestMethod.POST)
	public String query(HttpServletRequest request,ModelMap map)
	{
//		String test = "hahahha";
//		map.addAttribute("hehe",test);
//		当点击下一页时，查询条件不变，查询带分及成功
		System.out.println("进来查询！！！！！！！！！！");
		
		ZNTZINFO zntzinfo = new ZNTZINFO();
		String USER_NAME = request.getParameter("USER_NAME");
		String ZNTZ_STATE = request.getParameter("ZNTZ_STATE");
		
		zntzinfo.setUSER_NAME(USER_NAME);
		zntzinfo.setZNTZ_STATE(ZNTZ_STATE);
		HttpSession session = request.getSession();
		
		session.setAttribute("zntzinfo", zntzinfo);
		return zntz_list(map, request);
	}
	
//	删除单个信息
	@ResponseBody
	@RequestMapping(value="del",method=RequestMethod.POST)
	public List<Integer> zntz_del(ModelMap map,HttpServletRequest request)
	{
		ZNTZINFO zntzinfo = new ZNTZINFO();
		String ZNTZ_ID = request.getParameter("ZNTZ_ID");
		
		zntzinfo.setZNTZ_ID(ZNTZ_ID);
		
		zntzInfoService.del(zntzinfo);
				
		int count = zntzInfoService.getCount(zntzinfo);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(count);
		return list;
	}

//	批量删除
	@RequestMapping(value="delAll")
	public String zntz_delAll(ModelMap map,HttpServletRequest request)
	{
		ZNTZINFO zntzinfo = new ZNTZINFO();
		String ZNTZ_IDS = request.getParameter("ZNTZ_IDS");
		System.out.println(ZNTZ_IDS+"11111111111");
		if(ZNTZ_IDS!=null)
		{
			String ZNTZ_IDArr[] = ZNTZ_IDS.split(","); 
			for (String string : ZNTZ_IDArr) {
				zntzinfo.setZNTZ_ID(string);
				zntzInfoService.del(zntzinfo);
			}
		}
		return zntz_list(map, request);
	}
	
//	跳转到增加页面
	@RequestMapping(value="add")
	public String zntz_add(ModelMap map,HttpServletRequest request)
	{
		
		return "cdxxw_ht/zntz-add";
	}
	
	@ResponseBody
	@RequestMapping(value="realadd")
	public String realAdd(ModelMap map,HttpServletRequest request)
	{
		System.out.println("进来！！！！！！！！！");
		ZNTZINFO zntzinfo = new ZNTZINFO();
		USERINFO userinfo = new USERINFO();
		String[] USER_TYPE = request.getParameterValues("USER_TYPE");
		String ZNTZ_CONTENT = request.getParameter("ZNTZ_CONTENT");
		
		for (String string : USER_TYPE) {
			System.out.println(string+"11111111111111");
			userinfo.setUSER_TYPE(string);
			List<USERINFO> list = userInfoService.getAll(userinfo);
			
			System.out.println(list.size()+"222222222222222");
			
			for (USERINFO userinfo2 : list) {
				zntzinfo.setZNTZ_ID(UUIDPro.getUUID());
				zntzinfo.setUSER_NAME(userinfo2.getUSER_NAME());
				zntzinfo.setZNTZ_CONTENT(ZNTZ_CONTENT);
				zntzInfoService.add(zntzinfo);
			}
		}
		
		System.out.println("进来！！"+USER_TYPE.length+"----"+ZNTZ_CONTENT);
		return "true";
	}
	
	@ResponseBody
	@RequestMapping(value="jbxx_add")
	public String fromjbxx(HttpServletRequest request)
	{
		ZNTZINFO zntzinfo = new ZNTZINFO();
		JBXXINFO jbxxinfo = new JBXXINFO();
		
		String USER_NAME = request.getParameter("USER_NAME");
		String ZNTZ_CONTENT = request.getParameter("ZNTZ_CONTENT");
		String JB_ID = request.getParameter("JB_ID");
		
		System.out.println(JB_ID+"11111111111");
		
		zntzinfo.setZNTZ_ID(UUIDPro.getUUID());
		zntzinfo.setUSER_NAME(USER_NAME);
		zntzinfo.setZNTZ_CONTENT(ZNTZ_CONTENT);
		
		jbxxinfo.setJB_ID(JB_ID);
		if((zntzInfoService.add(zntzinfo)!=0)&&(jbxxInfoService.update(jbxxinfo)!=0))
		{
			return "true";
		}
		return "err";
	}
}
