package org.foxconn.seagate.aop;
import java.lang.annotation.*;
/**
* @author:myz
* @version 1.0 
* 创建时间：2016年8月27日 下午7:54:05
*/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default DataSource.master;
 
    public static String master = "dataSource2";
 
    public static String slave1 = "dataSource1";
 
    public static String slave2 = "dataSource3";
 
}