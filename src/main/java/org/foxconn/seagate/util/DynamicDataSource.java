package org.foxconn.seagate.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
 
/**
 * 获取数据源（依赖于spring）
 * @author linhy
 */
public class DynamicDataSource extends AbstractRoutingDataSource{
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.getDataSource();
    }

}