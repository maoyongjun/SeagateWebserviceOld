package org.foxconn.seagate.exception;
/**
* @author:myz
* @version 1.0 
* 创建时间：2016年10月30日 下午2:29:37
*/
public class ExceptionUtil {
	public static Exception  throwsException(Exception e){
		try {
			e.printStackTrace();
		} catch (Exception e2) {
			e.printStackTrace();
		}
		return e;
	}
}
