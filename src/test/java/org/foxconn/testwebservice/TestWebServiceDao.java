package org.foxconn.testwebservice;

import java.util.HashMap;
import java.util.Map;

import org.foxconn.seagate.dao.Service1Dao;

public class TestWebServiceDao {
//	public static void main(String[] args) {
//		Service1Dao service1Dao= ContextUtil.getContext().getBean("service1Dao",Service1Dao.class);
//		TestWebServiceDao test = new TestWebServiceDao();
//		//test.testAdd(resourceDao); 
//		//test.testDel(resourceDao);
//		//test.testUpdate(resourceDao);
//		test.testQuery(service1Dao);
//	}

	private void testQuery(Service1Dao service1Dao){
		Map<String , String> map = new HashMap<String, String>();
		String  retmsg ="";
		map.put("strPlantCode", "GHUB");
		map.put("strSSN", "LWBSKA2D44911S");
		map.put("retflag", "0");
		map.put("retmsg", retmsg);
		System.out.println(service1Dao.getNextStation(map)); 
		System.out.println(map.get("retmsg"));
	}
}
