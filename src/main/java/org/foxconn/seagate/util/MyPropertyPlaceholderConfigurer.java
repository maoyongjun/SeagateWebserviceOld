package org.foxconn.seagate.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @author:myz
 * @version 1.0 创建时间：2017年1月13日 下午7:12:56
 */
public class MyPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, java.util.Properties props)
			throws BeansException {
		//获取加密后字符串
		String enCode = props.getProperty("jdbc.pwd") ;
		String enCodeCenter = props.getProperty("centerJdbc.pwd") ;
		String user = props.getProperty("jdbc.user") ;
		try {
			//解密
			String code = PasswordUtil.decode(enCode);
			String codeCenter = PasswordUtil.decode(enCodeCenter);
			//重新赋值密码
			props.setProperty("jdbc.pwd", code);
			props.setProperty("centerJdbc.pwd", codeCenter);
		} catch (Exception e){
			e.printStackTrace();
		}
		super.processProperties(beanFactoryToProcess, props);
	}
	/* protected String convertProperty(String propertyName, String propertyValue) {
		 if(propertyName.equals("jdbc.pwd")){
	        propertyValue = PasswordUtil.decode(propertyValue);;
		 }
		 return propertyValue;
	 }*/
}