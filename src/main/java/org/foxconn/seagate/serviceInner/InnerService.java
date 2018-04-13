package org.foxconn.seagate.serviceInner;

import java.sql.SQLException;

import javax.jws.WebParam;

import org.apache.axis2.AxisFault;

public interface InnerService {
	 public String getSSNStatusByInput(@WebParam(name  = "StrPlantCode")String strPlantCode,@WebParam(name  = "StrSSN")String strSSN)  throws AxisFault;
	 public String updateSSNStatusByInput(String flag,@WebParam(name  = "PlantCode")String PlantCode,@WebParam(name  = "SSN")String SSN, @WebParam(name  = "FixtureID")String FixtureID,
			@WebParam(name  = "TestResult")String TestResult,@WebParam(name  = "ErrorCode")String ErrorCode,
			@WebParam(name  = "FailDetailReason")String FailDetailReason,@WebParam(name  = "TestDatatime")String TestDatatime,@WebParam(name  = "EMPID")String EMPID,
			@WebParam(name  = "DIAG")String DIAG, @WebParam(name  = "CurStation")String CurStation,@WebParam(name  = "LineName")String LineName,
			@WebParam(name  = "Field1")String Field1,@WebParam(name  = "Field2")String Field2,@WebParam(name  = "Field3")String Field3)  throws AxisFault;
	 public String sfcIstpXMLDataDetailEdit(String strTransType,
				String strSite,String strDataType,String strPART_NUMBER,
				String strSERIAL_NUMBER,String strFEATURE_CODE,String strMATERIAL_CLASS,
				String strCHARACTERISTIC,String strCOMPONENT_TYPE,String strWWN,
				String strCUST_SERIAL,String strPARENT_MATNR,String strPARENT_SERNR,
				String strECB_C,String strEQUIPMENT_NO,String strMAC_ADDR_C,String strSERVICE_TAG_C,
				String strPOSITION_TYPE,String strPOSITION_NO,String strCUST_PART,
				String strCUST_ECREV,String strVENDOR_PART,String strPOSITION_REQD,
				String xmlDetailNode,String retflag,String retmsg)throws SQLException;
}
