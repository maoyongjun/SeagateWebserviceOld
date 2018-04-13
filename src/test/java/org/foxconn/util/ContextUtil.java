package org.foxconn.util;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextUtil {
	public static ApplicationContext getContext(){
		return new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"}); 
	}
	
	public static BasicDataSource getDataSourceBean(){
		return getContext().getBean("db1",BasicDataSource.class);
	}
}
