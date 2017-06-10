package com.infotech.bean;

import javax.ejb.Remote;

@Remote
public interface MyBeanRemote {
	String welcome(String name);
}
