package com.baidu.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.model.HDMXINFO;
import com.baidu.model.USERINFO;
import com.baidu.model.XXINFO;
import com.baidu.service.imp.HDMXInfoService;
import com.baidu.service.imp.USERInfoService;
import com.baidu.service.imp.XXInfoService;
import com.baidu.utils.ChangeTime;
import com.baidu.vo.HDXXVO;
import com.baidu.vo.USERVO;

@Controller
@RequestMapping("/web/")
public class CDXXWInfoController extends BaseController<XXINFO> {
	
	@Autowired
	private XXInfoService xxInfoService;
	
	@Autowired
	private HDMXInfoService hdmxInfoService;
	
	@Autowired
	private USERInfoService userInfoService;
	
	
	ChangeTime changeTime = new ChangeTime();
//	首页
//	显示三个最热门的活动，浏览里面最多的，找出收藏最多的
//	找出10条最新的二手信息
//	找出10条最新的兼职信息
//	进行循环滚动
	@RequestMapping(value="cdxxw")
	public String cdxxw(HttpServletRequest request,ModelMap map) throws ParseException
	{
		
		HttpSession session = request.getSession();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:m:s");
//	热门活动信息
		List<XXINFO> hotHDXXList = new ArrayList<XXINFO>();
		
//	最新二手信息
		List<XXINFO> newESXXList = new ArrayList<XXINFO>();
		
//	最新兼职信息
		List<XXINFO> newJZXXList = new ArrayList<XXINFO>();
		
//		图片
//		标题
//		内容
//		类型
//		发布人
		
		
		
//		热门活动信息vo层
		List<HDXXVO> hotHDMXList = new ArrayList<HDXXVO>();
		
		newESXXList = xxInfoService.getNEWESXXList(null);
		
		newJZXXList = xxInfoService.getNewJZXXList(null);
		
		hotHDXXList = xxInfoService.getHotHDXXList(null);
		
		for (XXINFO xxinfo : newJZXXList) {
			String dateTime = changeTime.format(dateFormat.parse(xxinfo.getXX_TIME()));
			xxinfo.setXX_TIME(dateTime);
		}
		
		for (XXINFO xxinfo : newESXXList) {
			String dateTime = changeTime.format(dateFormat.parse(xxinfo.getXX_TIME()));
			xxinfo.setXX_TIME(dateTime);
		}
		
		for (XXINFO xxinfo : hotHDXXList) {
			HDXXVO hdxxvo = new HDXXVO();
			hdxxvo.setXX_ID(xxinfo.getXX_ID());
			hdxxvo.setUSER_NAME(xxinfo.getUSER_NAME());
			hdxxvo.setXX_TITLE(xxinfo.getXX_TITLE());
			hdxxvo.setXXMX_TYPE(xxinfo.getXXMX_TYPE());
			hdxxvo.setXX_TIME(xxinfo.getXX_TIME().substring(0, 10));
//			得到活动类容
			hdxxvo.setHD_CONTENT(hdmxInfoService.getHDMX(xxinfo).getHD_CONTENT());
			hdxxvo.setIMAGE_NAME(xxInfoService.getImage(xxinfo).get(0).getIMAGE_NAME());
			
			hotHDMXList.add(hdxxvo);
		}
		
		map.addAttribute("hotHDMXList", hotHDMXList);
		map.addAttribute("newESXXList", newESXXList);
		map.addAttribute("newJZXXList", newJZXXList);
		
		session.setAttribute("hotHDMXList", hotHDMXList);

		return "cdxxw_qt/cdxxw";	
	}
	
//	判断用户是否存在session中
	@ResponseBody
	@RequestMapping(value="user_exits")
	public String user_exits(HttpServletRequest request)
	{
		USERINFO userinfo = new USERINFO();
		HttpSession session = request.getSession();
		userinfo = (USERINFO) session.getAttribute("webuser");
		if(userinfo!=null)
		{
			return "true";
		}
		return "false";
	}
	
	@RequestMapping(value="xx_choice")
	public String xx_choice(HttpServletRequest request,ModelMap map)
	{
		return "cdxxw_qt/xx_choice";
	}
	
	@ResponseBody
	@RequestMapping(value="user_power")
	public String user_power(HttpServletRequest request)
	{
		/**
		 * 2普通用户
		3校部活动负责人
		4系部活动负责人
		5社团活动负责人
		
		1长大主办
		2系部活动
		3社团活动
		4个人发起
		 */
		USERINFO userinfo = new USERINFO();
		userinfo = (USERINFO) request.getSession().getAttribute("webuser");
		
		System.out.println(userinfo+"11111");
		
		userinfo = userInfoService.getXXUSER(userinfo);
		
		int USER_TYPE = Integer.parseInt(userinfo.getUSER_TYPE());
		String XXMX_TYPE = request.getParameter("XXMX_TYPE");
		if(XXMX_TYPE.equals("4"))
		{
			return "true";
		}
		else
		{
			if(Math.abs((Integer.parseInt(XXMX_TYPE)-USER_TYPE))==2)
			{
				return "true";
			}
			else
			{
				return "false";
			}
		}
	}
}
