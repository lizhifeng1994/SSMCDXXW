package com.baidu.test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/beans.xml","classpath:/config/springmvc.xml"})
public class TestBS {
	
	@Autowired
	private DataSource ds;
	
	@Test
	public void ds() throws SQLException
	{
		System.out.println(ds.getConnection()+"----------------");
	}
	
	@Test
	public void hehe()
	{
		String s = "2015-12-01 13:52:58--2015-12-29 13:53:00";
		

		System.out.println(s.substring(s.lastIndexOf("--")+2)+s.substring(0,s.indexOf("--")));
	}
	
	@Test
	public void haha()
	{
		String data = "12/小时";
		
	}
	
//	得到系统的当前时间
	@Test
	public void time()
	{
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(dateFormat.format(now));

	}
	
}
