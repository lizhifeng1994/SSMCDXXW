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
//	��ҳ
//	��ʾ���������ŵĻ������������ģ��ҳ��ղ�����
//	�ҳ�10�����µĶ�����Ϣ
//	�ҳ�10�����µļ�ְ��Ϣ
//	����ѭ������
	@RequestMapping(value="cdxxw")
	public String cdxxw(HttpServletRequest request,ModelMap map) throws ParseException
	{
		
		HttpSession session = request.getSession();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:m:s");
//	���Ż��Ϣ
		List<XXINFO> hotHDXXList = new ArrayList<XXINFO>();
		
//	���¶�����Ϣ
		List<XXINFO> newESXXList = new ArrayList<XXINFO>();
		
//	���¼�ְ��Ϣ
		List<XXINFO> newJZXXList = new ArrayList<XXINFO>();
		
//		ͼƬ
//		����
//		����
//		����
//		������
		
		
		
//		���Ż��Ϣvo��
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
//			�õ������
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
	
//	�ж��û��Ƿ����session��
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
		 * 2��ͨ�û�
		3У���������
		4ϵ���������
		5���Ż������
		
		1��������
		2ϵ���
		3���Ż
		4���˷���
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
