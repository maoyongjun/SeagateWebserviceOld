package org.foxconn.seagate.util;
/**
* @author:myz
* @version 1.0 
* 创建时间：2016年8月27日 下午7:52:09
*/
public class DataSourceHolder {
    //线程本地环境
    private static final ThreadLocal<String> dataSources = new ThreadLocal<String>();
    //设置数据源
    public static void setDataSource(String customerType) {
        dataSources.set(customerType);
    }
    //获取数据源
    public static String getDataSource() {
        return (String) dataSources.get();
    }
    //清除数据源
    public static void clearDataSource() {
        dataSources.remove();
    }
 
}