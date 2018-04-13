package org.foxconn.seagate.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
* @author:myz
* @version 1.0 
* 创建时间：2016年10月30日 下午3:43:25
*/
@XmlRootElement(name = "RESULT",namespace="org.foxconn.seagate.entity.resultMessage")
public class ResultMessage {
	int status;
	String msg;
	String nextStation;
	String xmlString;
	public String getNextStation() {
		return nextStation;
	}
	public void setNextStation(String nextStation) {
		this.nextStation = nextStation;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getXmlString() {
		return xmlString;
	}
	public void setXmlString(String xmlString) {
		this.xmlString = xmlString;
	}
	
}
