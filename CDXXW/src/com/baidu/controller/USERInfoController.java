package com.baidu.controller;

import java.io.UnsupportedEncodingException;
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

import com.baidu.model.USERINFO;
import com.baidu.service.imp.USERInfoService;
import com.baidu.utils.UUIDPro;

@Controller
@RequestMapping("/user/")
public class USERInfoController extends BaseController<USERINFO> {
	@Autowired
	private USERInfoService userInfoService ;
	
	@RequestMapping(value="login")
		public String login()
		{

			return "cdxxw_ht/login";
		}
	
//	�û�����
		@RequestMapping(value="loginPOST",method=RequestMethod.POST)
		public String login(HttpServletRequest req,USERINFO userinfo)
		{
			HttpSession session = req.getSession();
//			String USER_NAME = req.getParameter("USER_NAME");
//			String USER_PWD = req.getParameter("USER_PWD");
			System.out.println(userinfo.getUSER_NAME()+"---------------"+userinfo.getUSER_PWD());
			if(userInfoService.isByAdminUserAndAdminPwd(userinfo)>0)
			{
//				System.out.println("service________________________");
//				�����½�ɹ�����ѹ���Ա�ŵ�
				session.setAttribute("admin",userinfo);
				return "cdxxw_ht/index";
			}
		
//			System.out.println(USER_NAME+"-----------"+USER_PWD);

				return "cdxxw_ht/login";

		}
		
		@RequestMapping(value="userlist")
		public String user(HttpServletRequest request,ModelMap map)
		{		
			HttpSession session = request.getSession();
			request.getSession().removeAttribute("userinfo");
			return user_list(map, request);
		}
		
//		�õ��û����б�
		@RequestMapping(value="list")
		public String user_list(ModelMap map,HttpServletRequest request)
		{
			HttpSession session = request.getSession();
			USERINFO userinfo = new USERINFO();
			
			if(session.getAttribute("userinfo")!=null)
			{
				userinfo = (USERINFO) session.getAttribute("userinfo");
			}
			String pageNow_jsp = request.getParameter("pageNow");
			
			int pageNow = 1;

			int pageSize = 10;
			
//			�õ��û���Ϣ������
			
			userinfo.setRowCount(userInfoService.getUSERCount(userinfo));
//			�ܹ�����ҳ
			userinfo.setPageCount((userinfo.getRowCount()-1)/pageSize+1);
			
			if (pageNow_jsp != null) {
				pageNow = Integer.parseInt(pageNow_jsp);
				userinfo.setSqlPageSize((pageNow-1)*pageSize);
			} else {			
				pageNow = 1;			
				userinfo.setSqlPageSize((pageNow-1)*pageSize);
			}
			
			userinfo.setPageSize(pageSize);
			List<USERINFO> userinfos;
			userinfos = userInfoService.getUSERList(userinfo);
			
			map.addAttribute("rowCount", userinfo.getRowCount());
			map.addAttribute("pageNow", pageNow);
			map.addAttribute("pageCount", userinfo.getPageCount());
			map.addAttribute("list", userinfos);
			
			return "cdxxw_ht/member-list";
		}		
		
//		��ѯ����ҳ
		@RequestMapping(value="query",method=RequestMethod.POST)
		public String query(HttpServletRequest request,ModelMap map)
		{
//			String test = "hahahha";
//			map.addAttribute("hehe",test);
//			�������һҳʱ����ѯ�������䣬��ѯ���ּ��ɹ�
			System.out.println("������ѯ��������������������");
			
			USERINFO userinfo = new USERINFO();
			
			String USER_NAME = request.getParameter("USER_NAME");
			String USER_EMAIL = request.getParameter("USER_EMAIL");
			String USER_TYPE = request.getParameter("USER_TYPE");
			String USER_WORK = request.getParameter("USER_WORK");
			
			userinfo.setUSER_NAME(USER_NAME);
			userinfo.setUSER_EMAIL(USER_EMAIL);
			userinfo.setUSER_TYPE(USER_TYPE);
			userinfo.setUSER_WORK(USER_WORK);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("userinfo", userinfo);
			
			System.out.println(userinfo);
			return user_list(map, request);
			
		}
		
//		��ת�������û�
		@RequestMapping(value="add")
		public String turnUSER(HttpServletRequest request)
		{
			
			String USER_ID = UUIDPro.getUUID();
			HttpSession session = request.getSession();
			session.setAttribute("USER_ID", USER_ID);
			return "cdxxw_ht/member-add";
		}
		

//		�ж��û����Ƿ����
//		����һ�£�name����input��name��param����input��ֵ
		@ResponseBody
		@RequestMapping(value="USER_NAMEexits",method=RequestMethod.POST)
		public String exitsUSER(String name,String param,HttpServletRequest request)
		{
			USERINFO userinfo = new USERINFO();
			String USER_NAME = param;
			String flag = request.getParameter("flag");
			System.out.println(flag);
			if(flag.equals("1"))
			{
				HttpSession session = request.getSession();
				session.getAttribute("USER_ID");
				String USER_ID = (String) session.getAttribute("USER_ID");
				userinfo.setUSER_ID(USER_ID);
				userinfo.setUSER_NAME(USER_NAME);
			}
			else
			{
				userinfo.setUSER_NAME(USER_NAME);
			}
//			String USER_NAME = request.getParameter("user-name");
			System.out.println(USER_NAME);
			
			
			if(userInfoService.USERExits(userinfo)!=0)
			{
				System.out.println("���ڸ��û�");
				return "���û��ѱ�ע��";
			}
			return "y";
		}
		
//		�ж��û����Ƿ����
		@ResponseBody
		@RequestMapping(value="USER_EMAILexits",method=RequestMethod.POST)
		public String exitsEMAIL(String name,String param,HttpServletRequest request)
		{
			String flag = request.getParameter("flag");
			USERINFO userinfo = new USERINFO();
			if(flag.equals("1"))
			{
				HttpSession session = request.getSession();
				session.getAttribute("USER_ID");
				String USER_ID = (String) session.getAttribute("USER_ID");
				userinfo.setUSER_ID(USER_ID);
			}
			
			String USER_EMAIL = param;
			userinfo.setUSER_EMAIL(USER_EMAIL);
			
			if(userInfoService.EMAILExits(userinfo)!=0)
			{
				return "�������ѱ�ע��";
			}
			return "y";
		}
		
//		�����û�
		@ResponseBody
		@RequestMapping(value="useradd",method=RequestMethod.POST)
		public String USERAdd(HttpServletRequest request)
		{
			System.out.println("��������û�");
			USERINFO userinfo = new USERINFO();
			HttpSession session = request.getSession();
			String USER_ID = (String) session.getAttribute("USER_ID");
			String USER_NAME = request.getParameter("user-name");
			String USER_PWD = request.getParameter("password");
			String USER_EMAIL = request.getParameter("email");
			String USER_TYPE = request.getParameter("admin-role");
			String USER_MARK = request.getParameter("USER_MARK");
			
			userinfo.setUSER_ID(USER_ID);
			userinfo.setUSER_NAME(USER_NAME);
			userinfo.setUSER_PWD(USER_PWD);
			userinfo.setUSER_EMAIL(USER_EMAIL);
			userinfo.setUSER_TYPE(USER_TYPE);
			userinfo.setUSER_MARK(USER_MARK);
			
			if(userInfoService.addUSER(userinfo)!=0)
			{
				System.out.println("����û��ɹ�������������������������");
				System.out.println(userinfo+"111111111111111111");
				session.removeAttribute("USER_ID");
				return "true";
			}
			return "false";
		}
		
		
//		�鿴�û���ϸ
		@RequestMapping(value="usermx")
		public String getUserMX(HttpServletRequest request,ModelMap map)
		{
			USERINFO userinfo = new USERINFO();
			String USER_ID = request.getParameter("USER_ID");
			userinfo.setUSER_ID(USER_ID);
			
			map.addAttribute("USERINFO",userInfoService.getUSER(userinfo));
			
			return "cdxxw_ht/member-show";
		}
		
//		�����û����õ��û���ϸ
		@RequestMapping(value="xxusermx")
		public String getXXUserMX(HttpServletRequest request,ModelMap map) throws UnsupportedEncodingException
		{
			 

			USERINFO userinfo = new USERINFO();
			String USER_NAME = request.getParameter("USER_NAME");
				
			USER_NAME=new String(USER_NAME.getBytes("ISO8859_1"), "UTF8");
			
			System.out.println(USER_NAME+"����˧B����������������");
			
			userinfo.setUSER_NAME(USER_NAME);
			
			map.addAttribute("USERINFO",userInfoService.getXXUSER(userinfo));
			
			return "cdxxw_ht/member-show";
		}
		
//		�ı��û���״̬
		@ResponseBody
		@RequestMapping(value="userwork")
		public String editUSER_WORK(HttpServletRequest request)
		{
			USERINFO userinfo = new USERINFO();
			
			String USER_ID = request.getParameter("USER_ID");
			String USER_WORK = request.getParameter("USER_WORK");
			
			userinfo.setUSER_ID(USER_ID);
			userinfo.setUSER_WORK(USER_WORK);
			
			System.out.println(USER_ID+"----"+USER_WORK);
			if(userInfoService.updateUSER_WORK(userinfo)!=0)
			{
				return "true";
			}
			return "false";
			
		}
		
//		�����޸�ҳ��
		@RequestMapping(value="change-password")
		public String PWDEdit(HttpServletRequest request,ModelMap map)
		{
			USERINFO userinfo = new USERINFO();
			String USER_ID = request.getParameter("USER_ID");
			HttpSession session = request.getSession();
			
			session.setAttribute("USER_ID", USER_ID);
			
			userinfo.setUSER_ID(USER_ID);
			
			userinfo = userInfoService.getUSER(userinfo);
			
			map.addAttribute("USER_NAME", userinfo.getUSER_NAME());
			map.addAttribute("USER_PWD", userinfo.getUSER_PWD());
			return "cdxxw_ht/change-password";
		}
		
//		�ж������Ƿ���ԭ����
		@ResponseBody
		@RequestMapping(value="USER_PWDexits",method=RequestMethod.POST)
		public String pwdEXITS(HttpServletRequest request,String p)
		{

			USERINFO userinfo = new USERINFO();
			
			HttpSession session = request.getSession();
			
			String USER_PWD = request.getParameter("USER_PWD");
			String USER_ID = (String) session.getAttribute("USER_ID");
			
			userinfo.setUSER_ID(USER_ID);
			
			
			userinfo = userInfoService.getUSER(userinfo);
			
			System.out.println(userinfo+"-------------");
			System.out.println(USER_PWD+"-----------------------");
			if(userinfo.getUSER_PWD().equals(USER_PWD))
			{
				return "true";
			}
			
			return "false";
		}
		
//		�޸�����
		@ResponseBody
		@RequestMapping(value="changePWD",method=RequestMethod.POST)
		public String changePWD(HttpServletRequest request)
		{
			System.out.println("�����޸�����");
			HttpSession session = request.getSession();
			USERINFO userinfo = new USERINFO();
			
			
			String USER_ID = (String) session.getAttribute("USER_ID");
			String USER_PWD = request.getParameter("USER_PWD");
			
			
			userinfo.setUSER_ID(USER_ID);
			System.out.println(userinfo+"-------------------");
			if(USER_PWD==null||USER_PWD=="")
			{
				userinfo.setUSER_PWD(userInfoService.getUSER(userinfo).getUSER_PWD());
			}
			else
			{
				userinfo.setUSER_PWD(USER_PWD);
			}
			if(userInfoService.updateUSER_PWD(userinfo)!=0)
			{
//				����֮���Ҫ�����Ƴ�
				session.removeAttribute("USER_ID");
				return "true";
			}
			return "false";
		}
		
//		��ת���༭ҳ��
		@RequestMapping(value="edit")
		public String editUSER(HttpServletRequest request,ModelMap map)
		{
			HttpSession session = request.getSession();
			
			USERINFO userinfo =  new USERINFO();
			String USER_ID = request.getParameter("USER_ID");
			
			session.setAttribute("USER_ID", USER_ID);
		
			userinfo.setUSER_ID(USER_ID);
			
			userinfo = userInfoService.getUSER(userinfo);
			
			map.addAttribute("user", userinfo);
			return "cdxxw_ht/member-xg";
		}
		
//		�༭�û�
		@ResponseBody
		@RequestMapping(value="useredit")
		public String userEDIT(HttpServletRequest request)
		{
			System.out.println("����������������������");
			HttpSession session =request.getSession();
			
			USERINFO userinfo = new USERINFO();
			String USER_ID = (String) session.getAttribute("USER_ID");
			String USER_NAME = request.getParameter("USER_NAME");
			String USER_EMAIL = request.getParameter("USER_EMAIL");
			String USER_MARK = request.getParameter("USER_MARK");
			
			userinfo.setUSER_ID(USER_ID);
			userinfo.setUSER_NAME(USER_NAME);
			userinfo.setUSER_EMAIL(USER_EMAIL);
			userinfo.setUSER_MARK(USER_MARK);
			
			
			System.out.println(userinfo);
			
			if(userInfoService.editUSER(userinfo)!=0)
			{
				System.out.println("�޸��û��ɹ�");
				session.removeAttribute("USER_ID");
				return "true";
			}
			return "false";
		}
		
//		ɾ��������Ϣ
		@ResponseBody
		@RequestMapping(value="del",method=RequestMethod.POST)
		public List<Integer> user_del(ModelMap map,HttpServletRequest request)
		{
			USERINFO userinfo = new USERINFO();
			String USER_ID = request.getParameter("USER_ID");
			
			userinfo.setUSER_ID(USER_ID);
			
			userInfoService.delUSER(userinfo);
				
			
			int count = userInfoService.getUSERCount(userinfo);
					
			List<Integer> list = new ArrayList<Integer>();
			list.add(count);
			
			return list;
		}
		
//		����ɾ��
		@RequestMapping(value="delAll")
		public String USER_delAll(ModelMap map,HttpServletRequest request)
		{
			USERINFO userinfo = new USERINFO();
			String USER_IDS = request.getParameter("USER_IDS");
			System.out.println(USER_IDS+"11111111111");
			if(USER_IDS!=null)
			{
				String USER_IDArr[] = USER_IDS.split(","); 
				for (String string : USER_IDArr) {
					userinfo.setUSER_ID(string);
					userInfoService.delUSER(userinfo);
				}
			}
			return user_list(map, request);
		}
		

}
