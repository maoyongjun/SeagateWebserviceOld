package org.foxconn.seagate.serviceInner.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;
import org.foxconn.seagate.dao.Service1Dao;
import org.foxconn.seagate.entity.ResultMessage;
import org.foxconn.seagate.serviceForCreateXml.CreateXmlTestResultService;
import org.foxconn.seagate.serviceForCreateXml.impl.CreateXmlTestResultServiceImpl;
import org.foxconn.seagate.serviceInner.InnerService;
import org.springframework.stereotype.Service;
@Service
public class InnerServiceImpl implements InnerService{
	@Resource
	Service1Dao service1Dao;
	@Resource
	CreateXmlTestResultService createXmlTestResultService;
	private static Logger logger = Logger.getLogger(CreateXmlTestResultServiceImpl.class);
	public String sfcIstpXMLDataDetailEdit(String strTransType,
			String strSite,String strDataType,String strPART_NUMBER,
			String strSERIAL_NUMBER,String strFEATURE_CODE,String strMATERIAL_CLASS,
			String strCHARACTERISTIC,String strCOMPONENT_TYPE,String strWWN,
			String strCUST_SERIAL,String strPARENT_MATNR,String strPARENT_SERNR,
			String strECB_C,String strEQUIPMENT_NO,String strMAC_ADDR_C,String strSERVICE_TAG_C,
			String strPOSITION_TYPE,String strPOSITION_NO,String strCUST_PART,
			String strCUST_ECREV,String strVENDOR_PART,String strPOSITION_REQD,
			String xmlDetailNode,String retflag,String retmsg) {
		if (null != strTransType) {
			strTransType = strTransType.trim();
		}
		if (null != strSite) {
			strSite = strSite.trim();
		}
		if (null != strDataType) {
			strDataType = strDataType.trim();
		}
		if (null != strPART_NUMBER) {
			strPART_NUMBER = strPART_NUMBER.trim();
		}
		if (null != strSERIAL_NUMBER) {
			strSERIAL_NUMBER = strSERIAL_NUMBER.trim();
		}
		if (null != strFEATURE_CODE) {
			strFEATURE_CODE = strFEATURE_CODE.trim();
		}
		if (null != strMATERIAL_CLASS) {
			strMATERIAL_CLASS = strMATERIAL_CLASS.trim();
		}
		if (null != strCHARACTERISTIC) {
			strCHARACTERISTIC = strCHARACTERISTIC.trim();
		}
		if (null != strCOMPONENT_TYPE) {
			strCOMPONENT_TYPE = strCOMPONENT_TYPE.trim();
		}
		if (null != strWWN) {
			strWWN = strWWN.trim();
		}
		if (null != strCUST_SERIAL) {
			strCUST_SERIAL = strCUST_SERIAL.trim();
		}
		if (null != strPARENT_MATNR) {
			strPARENT_MATNR = strPARENT_MATNR.trim();
		}
		if (null != strPARENT_SERNR) {
			strPARENT_SERNR = strPARENT_SERNR.trim();
		}
		if (null != strECB_C) {
			strECB_C = strECB_C.trim();
		}
		if (null != strEQUIPMENT_NO) {
			strEQUIPMENT_NO = strEQUIPMENT_NO.trim();
		}
		if (null != strMAC_ADDR_C) {
			strMAC_ADDR_C = strMAC_ADDR_C.trim();
		}
		if (null != strSERVICE_TAG_C) {
			strSERVICE_TAG_C = strSERVICE_TAG_C.trim();
		}
		if (null != strPOSITION_TYPE) {
			strPOSITION_TYPE = strPOSITION_TYPE.trim();
		}
		if (null != strPOSITION_NO) {
			strPOSITION_NO = strPOSITION_NO.trim();
		}
		if (null != strCUST_PART) {
			strCUST_PART = strCUST_PART.trim();
		}
		if (null != strCUST_ECREV) {
			strCUST_ECREV = strCUST_ECREV.trim();
		}
		if (null != strVENDOR_PART) {
			strVENDOR_PART = strVENDOR_PART.trim();
		}
		if (null != strPOSITION_REQD) {
			strPOSITION_REQD = strPOSITION_REQD.trim();
		}
		if (null != xmlDetailNode) {
			xmlDetailNode = xmlDetailNode.trim();
		}
		if (null != retflag) {
			retflag = retflag.trim();
		}
		if (null != retmsg) {
			retmsg = retmsg.trim();
		}
		Map<String,String> map = new HashMap<String,String>();
		map.put("strTransType",strTransType);
		map.put("strSite",strSite);
		map.put("strDataType",strDataType);
		map.put("strPART_NUMBER",strPART_NUMBER);
		map.put("strSERIAL_NUMBER",strSERIAL_NUMBER);
		map.put("strFEATURE_CODE",strFEATURE_CODE);
		map.put("strMATERIAL_CLASS",strMATERIAL_CLASS);
		map.put("strCHARACTERISTIC",strCHARACTERISTIC);
		map.put("strCOMPONENT_TYPE",strCOMPONENT_TYPE);
		map.put("strWWN",strWWN);
		map.put("strCUST_SERIAL",strCUST_SERIAL);
		map.put("strPARENT_MATNR",strPARENT_MATNR);
		map.put("strPARENT_SERNR",strPARENT_SERNR);
		map.put("strECB_C",strECB_C);
		map.put("strEQUIPMENT_NO",strEQUIPMENT_NO);
		map.put("strMAC_ADDR_C",strMAC_ADDR_C);
		map.put("strSERVICE_TAG_C",strSERVICE_TAG_C);
		map.put("strPOSITION_TYPE",strPOSITION_TYPE);
		map.put("strPOSITION_NO",strPOSITION_NO);
		map.put("strCUST_PART",strCUST_PART);
		map.put("strCUST_ECREV",strCUST_ECREV);
		map.put("strVENDOR_PART",strVENDOR_PART);
		map.put("strPOSITION_REQD",strPOSITION_REQD);
		map.put("xmlDetailNode",xmlDetailNode);
		map.put("retflag",retflag);
		map.put("retmsg",retmsg);
		retflag="0";
		try {
			service1Dao.sfcIstpXMLDataDetailEdit(map);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
    	System.out.println(map.get("xmlDetailNode"));
		return map.get("retflag")+'|'+map.get("retmsg")+'|'+map.get("xmlDetailNode");
	}
	
	public String getSSNStatusByInput(String strPlantCode, String strSSN){
		String nextStation = "";
//    	Map<String, String> nextStationMap =  getNextStation(strPlantCode,strSSN);
//    	nextStation = nextStationMap.get("retmsg");
//    	String status = nextStationMap.get("retflag");
//    	createXmlTestResultService.checkUserPwd();
    	ResultMessage msg = createXmlTestResultService.getAndCreateLocalXml(strPlantCode, strSSN,nextStation);
    	
    	ResultMessage resultMessage =new ResultMessage();
    	resultMessage.setMsg(msg.getMsg());
    	resultMessage.setXmlString(msg.getXmlString());
    	resultMessage.setStatus(0);
    	resultMessage.setNextStation(nextStation);
		return resultMessage.getNextStation()+resultMessage.getXmlString();
	}
   

    public String updateSSNStatusByInput(String flag,String PlantCode, String SSN, String FixtureID, String TestResult, String ErrorCode,
    		String FailDetailReason, String TestDatatime, String EMPID, String DIAG, String CurStation, String LineName, 
    		String Field1, String Field2, String Field3)  throws AxisFault
    {
    	if(null!=PlantCode){
    		PlantCode=PlantCode.trim();
    	}
    	if(null!=SSN){
    		SSN=SSN.trim();
    	}
    	if(null!=FixtureID){
    		FixtureID=FixtureID.trim();
    	}
    	if(null!=TestResult){
    		TestResult=TestResult.trim();
    	}
    	if(null!=ErrorCode){
    		ErrorCode=ErrorCode.trim();
    	}
    	if(null!=FailDetailReason){
    		FailDetailReason=FailDetailReason.trim();
    	}
    	if(null!=TestDatatime){
    		TestDatatime=TestDatatime.trim();
    	}
    	if(null!=EMPID){
    		EMPID=EMPID.trim();
    	}
    	if(null!=DIAG){
    		DIAG=DIAG.trim();
    	}
    	if(null!=CurStation){
    		CurStation=CurStation.trim();
    	}
    	if(null!=LineName){
    		LineName=LineName.trim();
    	}
    	if(null!=Field1){
    		Field1=Field1.trim();
    	}
    	if(null!=Field2){
    		Field2=Field2.trim();
    	}
    	if(null!=Field3){
    		Field3=Field3.trim();
    	}
    	Map<String,String> map = new HashMap<String,String>();
    	String retmsg ="";
		map.put("plantCode",PlantCode);
		map.put("ssn", SSN);
		map.put("fixtureID", FixtureID);
		map.put("testResult", TestResult);
		map.put("errorCode", ErrorCode);
		map.put("failDetailReason", FailDetailReason);
		map.put("testDatatime", TestDatatime);
		map.put("empID", EMPID);
		map.put("diag", DIAG);
		map.put("curStation", CurStation);
		map.put("lineName", LineName);
		map.put("field1", Field1);
		map.put("field2", Field2);
		map.put("field3", Field3);
//		map.put("actionCode", ActionCode);
//		map.put("actionDesc", ActionDesc);
//		map.put("replacePN", ReplacePN);
//		map.put("failCSN", FailCSN);
//		map.put("newCSN", NewCSN);
//		map.put("field4", Field4);
//		map.put("field5", Field5);
//		map.put("field6", Field6);
		map.put("retflag", "");
		map.put("retmsg", retmsg);
		String beginLog = map.toString();
		try {
			service1Dao.updateSSNStatusByInput(map);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
    	
    	if("99".equals(map.get("retflag"))){
    		return "99";
		}
		
    	FileWriter fileWriter=null;
    	String baseLocalDir = "c:\\textXmlBackUp\\log";
		File file = new File(baseLocalDir);
		if(!file.exists()){
			file.mkdirs();
		}
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			fileWriter = new FileWriter(baseLocalDir+"\\"+sdf.format(new Date())+".txt",true);
			fileWriter.write(System.getProperty("line.separator")+sdf1.format(new Date())+"Ben:"+ beginLog.toString());
			fileWriter.write(System.getProperty("line.separator")+sdf1.format(new Date())+"End:"+ map.toString());
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception e) {
			logger.info(e.getMessage());
		} finally{
			if(null!=fileWriter){
				try {
					fileWriter.close();
				} catch (IOException e) {
					logger.info(e.getMessage());
				}
			}
			
		}
    	return map.get("retmsg");
    }
    


	private Map<String,String> getNextStation(String strPlantCode, String strSSN){
		Map<String,String> map = new HashMap<String,String>();
    	String retmsg ="";
		map.put("strPlantCode",strPlantCode);
		map.put("strSSN", strSSN);
		map.put("retflag", "0");
		map.put("retmsg", retmsg);
    	service1Dao.getNextStation(map);
    	return map;
	}

}
