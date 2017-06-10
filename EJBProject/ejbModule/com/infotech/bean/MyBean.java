package com.infotech.bean;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class MyBean
 */
@Stateless(mappedName="ejb/myBean")
public class MyBean implements MyBeanRemote {

	@Override
	public String welcome(String name) {
		return "Hello,"+name;
	}
}
