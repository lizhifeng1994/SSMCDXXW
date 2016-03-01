package com.baidu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.ibatis.logging.commons.JakartaCommonsLoggingImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.model.JBXXINFO;
import com.baidu.model.SCINFO;
import com.baidu.model.USERINFO;
import com.baidu.model.XXINFO;
import com.baidu.model.YHDTINFO;
import com.baidu.service.imp.JBXXInfoService;
import com.baidu.service.imp.YHDTInfoService;
import com.baidu.utils.UUIDPro;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/jbxx/")
public class JBXXInfoController extends BaseController<JBXXINFO>{
	@Autowired
	private JBXXInfoService jbxxInfoService;

	@Autowired
	private YHDTInfoService yhdtInfoService;
	
	@RequestMapping(value="jbxxlist")
	public String jbxx(ModelMap map,HttpServletRequest request)
	{
		
		HttpSession session = request.getSession();
		request.getSession().removeAttribute("jbxxinfo");
		return jbxx_list(map, request);
	}
	
	@RequestMapping(value="list")
	public String jbxx_list(ModelMap map,HttpServletRequest request)
	{
		System.out.println("进来用户动态信息！！！！！！！");
		HttpSession session = request.getSession();
		JBXXINFO jbxxinfo= new JBXXINFO();
		
		if(session.getAttribute("jbxxinfo")!=null)
		{
			jbxxinfo = (JBXXINFO)session.getAttribute("jbxxinfo");
		}
		String pageNow_jsp = request.getParameter("pageNow");
		
		int pageNow = 1;

		int pageSize = 10;
		
//		得到用户信息的条数
		
		jbxxinfo.setRowCount(jbxxInfoService.getCount(jbxxinfo));
		System.out.println(jbxxinfo.getRowCount()+"----------");
//		总共多少页
		jbxxinfo.setPageCount((jbxxinfo.getRowCount()-1)/pageSize+1);
		
		if (pageNow_jsp != null) {
			pageNow = Integer.parseInt(pageNow_jsp);
			jbxxinfo.setSqlPageSize((pageNow-1)*pageSize);
		} else {			
			pageNow = 1;			
			jbxxinfo.setSqlPageSize((pageNow-1)*pageSize);
		}
		
		jbxxinfo.setPageSize(pageSize);
		List<JBXXINFO> jbxxinfos;
		jbxxinfos = jbxxInfoService.getAll(jbxxinfo);
		
		map.addAttribute("rowCount", jbxxinfo.getRowCount());
		map.addAttribute("pageNow", pageNow);
		map.addAttribute("pageCount", jbxxinfo.getPageCount());
		map.addAttribute("list", jbxxinfos);
		return "cdxxw_ht/jbxx-list";
	}
	
//	查询带分页
	@RequestMapping(value="query",method=RequestMethod.POST)
	public String query(HttpServletRequest request,ModelMap map)
	{
//		String test = "hahahha";
//		map.addAttribute("hehe",test);
//		当点击下一页时，查询条件不变，查询带分及成功
		System.out.println("进来查询！！！！！！！！！！");
		
		JBXXINFO jbxxinfo = new JBXXINFO();
		
		String USER_NAME = request.getParameter("USER_NAME");
		String XX_TITLE = request.getParameter("XX_TITLE");
		String JB_TYPE = request.getParameter("JB_TYPE");
		String JB_STATE = request.getParameter("JB_STATE");
		
		jbxxinfo.setUSER_NAME(USER_NAME);
		jbxxinfo.setXX_TITLE(XX_TITLE);
		jbxxinfo.setJB_TYPE(JB_TYPE);
		jbxxinfo.setJB_STATE(JB_STATE);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("jbxxinfo", jbxxinfo);
		return jbxx_list(map, request);
	}
	
//	删除单个信息
	@ResponseBody
	@RequestMapping(value="del",method=RequestMethod.POST)
	public List<Integer> jbxx_del(ModelMap map,HttpServletRequest request)
	{
		JBXXINFO jbxxinfo = new JBXXINFO();
		String JB_ID = request.getParameter("JB_ID");
		
		jbxxinfo.setJB_ID(JB_ID);
		
		jbxxInfoService.del(jbxxinfo);
		
		int count = jbxxInfoService.getCount(jbxxinfo);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(count);
		return list;
	}
	
//	批量删除
	@RequestMapping(value="delAll")
	public String jbxx_delAll(ModelMap map,HttpServletRequest request)
	{
		JBXXINFO jbxxinfo = new JBXXINFO();
		String JB_IDS = request.getParameter("JB_IDS");
		System.out.println(JB_IDS+"11111111111");
		if(JB_IDS!=null)
		{
			String	JB_IDArr[] = JB_IDS.split(","); 
			for (String string : JB_IDArr) {
				jbxxinfo.setJB_ID(string);;
				jbxxInfoService.del(jbxxinfo);
			}
		}
		return jbxx_list(map, request);
	}	
	
	@ResponseBody
	@RequestMapping(value="add")
	public String jbxx_add(HttpServletRequest request) 
	{  
		String XX_ID = request.getParameter("XX_ID");
		String XX_TITLE = request.getParameter("XX_TITLE");
		String USER_NAME = request.getParameter("USER_NAME");
		String JB_CONTENT = request.getParameter("JB_CONTENT");
		String JB_TYPE = request.getParameter("JB_TYPE");
		
		
		JBXXINFO jbxxinfo = new JBXXINFO();
		
		jbxxinfo.setXX_ID(XX_ID);
		jbxxinfo.setXX_TITLE(XX_TITLE);
		jbxxinfo.setUSER_NAME(USER_NAME);
		jbxxinfo.setJB_CONTENT(JB_CONTENT);
		jbxxinfo.setJB_TYPE(JB_TYPE);
		jbxxinfo.setJB_ID(UUIDPro.getUUID());
		
		YHDTINFO yhdtinfo = new YHDTINFO();
		yhdtinfo.setYHDT_ID(UUIDPro.getUUID());
		yhdtinfo.setXX_ID(XX_ID);
		yhdtinfo.setXX_TYPE(JB_TYPE);
		yhdtinfo.setXX_TITLE(XX_TITLE);
		yhdtinfo.setUSER_NAME(USER_NAME);
		yhdtinfo.setYHDT_TYPE("举报");
		
		System.out.println(USER_NAME+"111111");
		
		if(jbxxInfoService.add(jbxxinfo)!=0)
		{
				yhdtInfoService.add(yhdtinfo);
				return "true";
			
		}
		System.out.println("111111"+jbxxinfo);
		return "false";
	}
}
