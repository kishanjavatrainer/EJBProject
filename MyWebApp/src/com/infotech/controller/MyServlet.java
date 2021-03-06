package com.infotech.controller;

import java.io.IOException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotech.bean.MyBeanRemote;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("userName");
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		properties.put(Context.PROVIDER_URL, "t3://localhost:7001");
		properties.put(Context.SECURITY_PRINCIPAL, "weblogic"); // set Weblogic
		properties.put(Context.SECURITY_CREDENTIALS, "weblogic1"); // set
																	// PassWord
		try {
			InitialContext ctx = new InitialContext(properties);
			Object object = ctx.lookup("ejb/myBean#com.infotech.bean.MyBeanRemote");
			MyBeanRemote MyBeanRemote =(MyBeanRemote)object;
			String result = MyBeanRemote.welcome(userName);
			response.getWriter().println(result);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}

}
