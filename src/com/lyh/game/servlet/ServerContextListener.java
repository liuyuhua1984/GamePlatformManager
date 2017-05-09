
package com.lyh.game.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ClassName:ServerContextListener <br/>
 * Function: TODO (). <br/>
 * Reason: TODO (). <br/>
 * Date: 2017年5月9日 上午10:06:45 <br/>
 * 
 * @author lyh
 * @version
 * @see
 */
public class ServerContextListener implements ServletContextListener {
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		ServletContext sc = event.getServletContext();
		sc.setAttribute("path", sc.getContextPath());
	}
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
		// jsp上用法${path}/css/xx.css
		ServletContext sc = event.getServletContext();
		// JsSdkFileUtils.CONFIG_PATH = sc.getRealPath("/");
		sc.setAttribute("path", sc.getContextPath());
		System.out.println("进来了");
	}
	
}
