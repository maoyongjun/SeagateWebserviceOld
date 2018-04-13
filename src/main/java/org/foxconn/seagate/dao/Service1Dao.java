package org.foxconn.seagate.dao;

import java.util.Map;

import org.springframework.dao.DataAccessException;



public interface Service1Dao {
	public Map<String, String> getNextStation(Map<String, String> map);
	public Map<String, String> updateSSNStatusByInput(Map<String, String> map)  throws DataAccessException;
	public Map<String, String> sfcIstpXMLDataDetailEdit(Map<String, String> map)  throws DataAccessException;
}
