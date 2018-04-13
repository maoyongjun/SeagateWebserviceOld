package org.foxconn.seagate.service.impl;


import java.sql.SQLException;

import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;
import org.foxconn.seagate.dao.GetXmlTestResultDao;
import org.foxconn.seagate.service.ServiceI1;
import org.foxconn.seagate.serviceForCreateXml.CreateXmlTestResultService;
import org.foxconn.seagate.serviceInner.InnerService;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;


public class Service1 implements ServiceI1{
		InnerService innerService;
		CreateXmlTestResultService createXmlTestResultService;
		private static Logger logger = Logger.getLogger(Service1.class);
		public String sfcIstpXMLDataDetailEdit(String strTransType,
				String strSite,String strDataType,String strPART_NUMBER,
				String strSERIAL_NUMBER,String strFEATURE_CODE,String strMATERIAL_CLASS,
				String strCHARACTERISTIC,String strCOMPONENT_TYPE,String strWWN,
				String strCUST_SERIAL,String strPARENT_MATNR,String strPARENT_SERNR,
				String strECB_C,String strEQUIPMENT_NO,String strMAC_ADDR_C,String strSERVICE_TAG_C,
				String strPOSITION_TYPE,String strPOSITION_NO,String strCUST_PART,
				String strCUST_ECREV,String strVENDOR_PART,String strPOSITION_REQD,
				String xmlDetailNode,String retflag,String retmsg){
			if(null==innerService){
				setInnerService();
			}
			String result ="";
			try {
				result = innerService.sfcIstpXMLDataDetailEdit(strTransType, strSite, strDataType, strPART_NUMBER, strSERIAL_NUMBER, strFEATURE_CODE, strMATERIAL_CLASS, strCHARACTERISTIC, strCOMPONENT_TYPE, strWWN, strCUST_SERIAL, strPARENT_MATNR, strPARENT_SERNR, strECB_C, strEQUIPMENT_NO, strMAC_ADDR_C, strSERVICE_TAG_C, strPOSITION_TYPE, strPOSITION_NO, strCUST_PART, strCUST_ECREV, strVENDOR_PART, strPOSITION_REQD, xmlDetailNode, retflag, retmsg);
			} catch (SQLException e) {
				result ="0"+'|'+e.getErrorCode()+e.getMessage()+'|'+e.getCause();
				logger.info(e.getMessage());
			}
			
			return result;
		}
		
		public String getSSNStatusByInput( String strSSN)  throws AxisFault{
			if(null==innerService){
				setInnerService();
			}
			if(null==createXmlTestResultService){
				setCreateXmlTestResultService();
			}
			if("99".equals(createXmlTestResultService.getXmlFromLocalDataBase("", strSSN, "", "", "", "", ""))){
				return innerService.getSSNStatusByInput("99", strSSN);
			}else{
				return innerService.getSSNStatusByInput("", strSSN);
			}
			
			
		}
       

        public String updateSSNStatusByInput(String PlantCode, String SSN, String FixtureID, String TestResult, String ErrorCode,
        		String FailDetailReason, String TestDatatime, String EMPID, String DIAG, String CurStation, String LineName, 
        		String Field1, String Field2, String Field3)  throws AxisFault{
        	if(null==innerService){
				setInnerService();
			}
        	
        	String result = innerService.updateSSNStatusByInput("",PlantCode, SSN, FixtureID, TestResult, ErrorCode, FailDetailReason, TestDatatime, EMPID, DIAG, CurStation, LineName, Field1, Field2, Field3);
        	if("99".equals(result)&&!"99".equals(PlantCode)){
        		return innerService.updateSSNStatusByInput("99",PlantCode, SSN, FixtureID, TestResult, ErrorCode, FailDetailReason, TestDatatime, EMPID, DIAG, CurStation, LineName, Field1, Field2, Field3);
        	}else{
        		return result;
        	}
        	
        }
        

		public String sayHi(String name) {
			logger.info("debugSayHi");
			return "welcome"+name;
		}
		
		private void setInnerService() {
			WebApplicationContext context=ContextLoader.getCurrentWebApplicationContext();
			innerService = (InnerService)context.getBean("innerServiceImpl");
		}
		private void setCreateXmlTestResultService() {
			WebApplicationContext context=ContextLoader.getCurrentWebApplicationContext();
			createXmlTestResultService = (CreateXmlTestResultService)context.getBean("createXmlTestResultServiceImpl");
		}
		

}
