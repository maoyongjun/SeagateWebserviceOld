package org.foxconn.seagate.dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface GetXmlTestResultDao {
	public String getSSNStatusByInput(Map<String, String> map) throws DataAccessException;
	public String  getPathAndPassWord(String controlValue);	
	public String getXmlResult0996225_04(Map<String, String> map);
	
}
