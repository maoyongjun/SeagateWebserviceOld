package org.foxconn.seagate.serviceForCreateXml.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;
import org.apache.axis2.context.MessageContext;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.foxconn.seagate.dao.GetXmlTestResultDao;
import org.foxconn.seagate.entity.ResultMessage;
import org.foxconn.seagate.exception.CreateAndUploadXMLException;
import org.foxconn.seagate.service.impl.Service1;
import org.foxconn.seagate.serviceForCreateXml.CreateXmlTestResultService;
import org.foxconn.seagate.serviceInner.InnerService;
import org.foxconn.seagate.util.UploadFile;
import org.springframework.stereotype.Service;

@Service
public class CreateXmlTestResultServiceImpl implements CreateXmlTestResultService {
	private String nextStation=null;
	private String strSSN = null;
	private static Logger logger = Logger.getLogger(CreateXmlTestResultServiceImpl.class);
	@Resource
	GetXmlTestResultDao getXmlTestResultDao;
	@Resource
	InnerService innerService;
	@Override
	public ResultMessage getAndCreateLocalXml(String strPlantCode, String strSSN,String stationName)  {
		ResultMessage  result = new ResultMessage();
		this.nextStation = stationName;
		this.strSSN = strSSN;
		//1、从数据库中获取xml字符串
		String xmlString;
		xmlString = getXmlFromLocalDataBase(strPlantCode, strSSN, "", "", "","",stationName);
		String centerXMLString ="";
		try {
			centerXMLString = innerService.sfcIstpXMLDataDetailEdit("SELECT", "TJ", "NORMAL", "", strSSN, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
		} catch (SQLException e) {
			logger.error(e.getMessage());
			centerXMLString=e.getErrorCode()+e.getMessage();
		}
		int index1 = centerXMLString.indexOf("|", 0);
		int index2 = centerXMLString.indexOf("|", index1+1);
		centerXMLString = centerXMLString.substring(index2+1,centerXMLString.length());
		
		if (centerXMLString.length()>0){
			xmlString = xmlString.replace("<DETAIL/>",centerXMLString).replace("<DETAIL />", centerXMLString);
		}

		//2、格式化字符串
		String formatxmlString;
		try {
			formatxmlString = formateXML(xmlString);
		} catch (Exception e1) {
			logger.info(e1.getMessage());
			formatxmlString = xmlString;
			result.setStatus(0);
			result.setMsg("ERROR:xmlString formate error!");
		}
		//3、校验xml是否符合规范
//		try {
//			if(MatchXsdUtil.validate(formatxmlString)){
//				result.setMsg("MSG:xmlString is matched to xsd!"+result.getMsg());
//			}
//		} catch (Exception e1) {
//			e1.printStackTrace();
//			result.setMsg("ERROR:xmlString is not matched to xsd!["+e1.getMessage()+"]"+result.getMsg());
//		}
		//4、写入本地磁盘
		if(writeXmlToLocalDisk(formatxmlString)){
			result.setStatus(0);
			result.setMsg("MSG:xmlString write to disk success!"+result.getMsg());
		}else{
			result.setMsg("ERROR:xmlString write to disk error!"+result.getMsg());
		}
		//5、写入ftp服务器
//		try {
//			if(upXmlToFtpServer(formatxmlString)){
//				result.setMsg("MSG:xmlString upload to ftp Server success!"+result.getMsg());
//			}else{
//				result.setStatus(0);
//				result.setMsg("ERROR:xmlString upload to ftp Server error!"+result.getMsg());
//			}
//		} catch (CreateAndUploadXMLException e) {
//			e.printStackTrace();
//			result.setStatus(0);
//			result.setMsg("ERROR:xmlString upload to ftp Server error!["+e.getMessage()+"],"+result.getMsg());
////			return result;
//		} 
		result.setStatus(0);
		result.setXmlString(xmlString);
		return result;
	}
	
	public String getXmlFromLocalDataBase(String strPlantCode, String strSSN, String strField1, String strField2, String strField3,
			String strLastEditBy,String stationName){
		String outputString="";
		Map<String, String> map = new HashMap<String, String>();
		map.put("strPlantCode", strPlantCode);
		map.put("strSSN", strSSN);
		map.put("strField1", strField1);
		map.put("strField2", strField2);
		map.put("strField3", strField3);
		map.put("strLastEditBy", strLastEditBy);
		map.put("retflag", "");
		map.put("retmsg", outputString);
		try {
			outputString = getXmlTestResultDao.getSSNStatusByInput(map);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return e.getMessage();
		}
		if("99".equals(map.get("retflag"))){
			return "99";
		}
		return map.get("retmsg");

	}
	
	//将xml字符串备份到本地
	private boolean writeXmlToLocalDisk(String xmlString){
		if(null==xmlString||"".equals(xmlString)){
			return false;
		}
		FileWriter fileWriter=null;
		try {
			if(null==nextStation||null==strSSN){
				return false;
			}
			if(nextStation.indexOf("ERROR")!=-1){
				nextStation="ErrorStation";
			}
			String[] strs = nextStation.split("\\|");
			nextStation =  strs[strs.length-1].replace('/', '-');
			String baseLocalDir = "c:\\textXmlBackUp\\"+nextStation;
			File file = new File(baseLocalDir);
			if(!file.exists()){
				file.mkdirs();
			}
			fileWriter = new FileWriter(baseLocalDir+"\\"+strSSN+".xml");
			fileWriter.write(xmlString);
			fileWriter.flush();
			fileWriter.close();
			return true;
		} catch (IOException e) {
			logger.error(e.getMessage());
		} catch (Exception e){
			logger.error(e.getMessage());
		} finally{
			try {
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
		return false;
	}
	//格式化xml
	private String formateXML(String xmlMsg) throws Exception{
		if(null==xmlMsg||"".equals(xmlMsg)){
			return xmlMsg;
		}
		XMLWriter writer = null;
		String paramXML = "";
		try {
		   SAXReader reader = new SAXReader();
		   Document _document = reader.read(new StringReader(xmlMsg));
		   OutputFormat format = OutputFormat.createPrettyPrint();
		   format.setEncoding("utf-8");            
		   ByteArrayOutputStream out = new ByteArrayOutputStream(); 
		   writer = new XMLWriter(out, format); 
		   writer.write(_document);
		   writer.flush();
		   writer.close();
		   paramXML = out.toString(format.getEncoding());
		} catch (UnsupportedEncodingException e) {
			logger.info(e.getMessage());
		} catch (IOException e) {
			logger.info(e.getMessage());
		} catch (DocumentException e) {
			logger.info(e.getMessage());
		} catch (Exception e){
			logger.info(e.getMessage());
		}finally{
			try {
				writer.close();
			} catch (IOException e) {
				logger.info(e.getMessage());
			}
		}
		return paramXML;
	}
	//将xml上传到Ftp服务器
	private boolean upXmlToFtpServer(String formatxmlString) throws CreateAndUploadXMLException{
		if(null==formatxmlString||"".equals(formatxmlString)){
			return false;
		}
		String ftpIp ="";
		int  port =80;
		String username ="";
		String password ="";
		String string  = getXmlTestResultDao.getPathAndPassWord("webservice-uploadpathAndPwd");
		String[] strings = string.split(",");
		Map<String,String> map = new HashMap<String, String>();
		if(strings.length==4){
			ftpIp =strings[0];
			port = Integer.parseInt( strings[1]);
			username = strings[2];
			password = strings[3];
		}else if(strings.length==2){
			ftpIp =strings[0];
			port = Integer.parseInt( strings[1]);
		}else{
			throw  new CreateAndUploadXMLException(string+":the value of \"webservice-uploadpathAndPwd\" in database is not valid");
		}
		try {
			InputStream  inputStream=  new ByteArrayInputStream(formatxmlString.getBytes());
			if(null == nextStation||null == strSSN){
				throw  new CreateAndUploadXMLException("nextStation or strSSN is null");
			}
			UploadFile.uploadFile(ftpIp, port,username,password, "/seagateTestXml/"+nextStation, strSSN.trim()+".xml",inputStream );
		} catch (Exception e) {
			throw  new CreateAndUploadXMLException(e.getMessage());
		}
//		upLoadFromProduction("10.67.70.95", 21, "it", "it", "/ftptest", "test2.txt", "C:\\Users\\Administrator\\Desktop\\新文字文件.txt");
//		deleteFile("10.67.70.95", 21, "it", "it", "/ftptest", "test2.txt");
		return true;
	}
	
	public void checkUserPwd() throws AxisFault{
		MessageContext messageContext = MessageContext.getCurrentMessageContext();
		Iterator  list = (Iterator) messageContext.getEnvelope().getHeader().getFirstElement().getChildren();
		String username = "";
		String passowrd = "";
		while(list.hasNext()){
			OMElement omElement = (OMElement) list.next();
			if(omElement.getLocalName().equals("Username")){
				username = omElement.getText();
			}
			if(omElement.getLocalName().equals("Password")){
				passowrd = omElement.getText();
			}
			if(!username.equals("admin")||!passowrd.equals("123")){
				throw new AxisFault("Authentication Fail!Check username/password");
			}
		}
	}
}
