package com.infotech.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.infotech.bean.MyBeanRemote;

public class Test {
	public static void main(String[] args) {

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
			String result = MyBeanRemote.welcome("Martin");
			System.out.println(result);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
