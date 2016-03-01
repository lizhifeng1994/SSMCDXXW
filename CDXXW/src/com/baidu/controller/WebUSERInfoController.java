package com.baidu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baidu.model.USERINFO;
import com.baidu.service.imp.USERInfoService;
import com.baidu.service.imp.XXInfoService;
import com.baidu.utils.UUIDPro;
@Controller
@RequestMapping("/webuser/")
public class WebUSERInfoController extends BaseController<USERINFO> {
	@Autowired
	private USERInfoService userInfoService ;
	
	@RequestMapping(value="login")
	public String login(HttpServletRequest request,ModelMap map)
	{
//		获得请求之前的url
		String url = request.getHeader("Referer");
		map.addAttribute("url", url);
		
		return "cdxxw_qt/login";
	}
	
	@RequestMapping(value="register")
	public String register()
	{
		return "cdxxw_qt/register";
	}
	
	@ResponseBody
	@RequestMapping(value="add")
	public String add(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		USERINFO userinfo = new USERINFO();
		String USER_ID = UUIDPro.getUUID();
		
		String USER_NAME = request.getParameter("USER_NAME");
		
		String USER_EMAIL = request.getParameter("USER_EMAIL");
		
		String USER_PWD = request.getParameter("password");
		
		userinfo.setUSER_ID(USER_ID);
		userinfo.setUSER_NAME(USER_NAME);
		userinfo.setUSER_EMAIL(USER_EMAIL);
		userinfo.setUSER_PWD(USER_PWD);
		userinfo.setUSER_TYPE("2");
		if(userInfoService.addUSER(userinfo)!=0)
		{
			request.getSession().setAttribute("webuser", userinfo);
			return "true";
		}
		return "false";
	}
	
	@ResponseBody
	@RequestMapping(value="weblogin")
	public String weblogin(HttpServletRequest request)
	{
		USERINFO userinfo = new USERINFO();
		String USER_NAME = request.getParameter("USER_NAME");
		
		String USER_PWD = request.getParameter("USER_PWD");
	
		userinfo.setUSER_NAME(USER_NAME);
		userinfo.setUSER_PWD(USER_PWD);
		
		if(userInfoService.weblogin(userinfo)!=0)
		{
			USERINFO userinfo2 = new USERINFO();
			userinfo2 = userInfoService.getXXUSER(userinfo);
			request.getSession().setAttribute("webuser", userinfo2);
			return "true";
		}
		else
		{
			userinfo.setUSER_NAME(null);
			userinfo.setUSER_EMAIL(USER_NAME);
			if(userInfoService.weblogin(userinfo)!=0)
			{
				USERINFO userinfo3 = new USERINFO();
				userinfo3 = userInfoService.getXXUSER(userinfo);
				request.getSession().setAttribute("webuser", userinfo3);
				return "true";
			}
			else
			{
				return "false";
			}
		}
	}
	
	@ResponseBody
	@RequestMapping(value="userexit")
	public String userexit(HttpServletRequest request)
	{
		request.getSession().removeAttribute("webuser");
		return "true";
	}
		
}
