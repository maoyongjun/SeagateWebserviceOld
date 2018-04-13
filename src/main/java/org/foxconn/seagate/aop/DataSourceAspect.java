package org.foxconn.seagate.aop;

import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.foxconn.seagate.entity.StoreSPLinkWithDataSource;
import org.foxconn.seagate.util.DataSourceHolder;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order
public class DataSourceAspect {
	@Resource
	StoreSPLinkWithDataSource storeSPLinkWithDataSource;
	@Pointcut("execution(* org.foxconn.seagate.serviceInner..*(..)) or  execution(* org.springframework.transaction.annotation.Transactional(..))")
	public void aspect(){}
	@Before("aspect()")
	public void doBefore(JoinPoint point) throws Throwable{
		final MethodSignature methodSignature = (MethodSignature) point.getSignature();
		java.lang.reflect.Method method = methodSignature.getMethod();
		if(method.getDeclaringClass().isInterface()){
			method = point.getTarget().getClass().getMethod(method.getName(), method.getParameterTypes());
		}
		Object[] objects = point.getArgs();
		String Plant = null;
		if(null!=objects[0]&&("getSSNStatusByInput".equals(method.getName())||"updateSSNStatusByInput".equals(method.getName()))){
			Plant = objects[0].toString().trim();
		}else{
			Plant = "";
		}
		Map<String, String> map  = storeSPLinkWithDataSource.getLinkMap();
		String dataSourceId = null;

		if(null!=map){
			dataSourceId = map.get(method.getName()+"-"+Plant);
		}
		if(null==dataSourceId){
        	dataSourceId = map.get(method.getName());
        }
		if(null!=dataSourceId){
			DataSourceHolder.setDataSource(dataSourceId);
		}
		
	}
	@After("aspect()")
	public void doAfter(){
		DataSourceHolder.clearDataSource();
	}
}
