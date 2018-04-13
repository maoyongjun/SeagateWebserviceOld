package org.foxconn.seagate.entity;

public class UpdateSSNModel {
	String plantCode; 
	String ssn;
	String fixtureID;
	String testResult; 
	String errorCode;
	String failDetailReason; 
	String testDatatime; 
	String empID; 
	String diag;
	String curStation; 
	String lineName; 
	String field1;
	String field2; 
	String field3;
	public String getPlantCode() {
		return plantCode;
	}
	public void setPlantCode(String plantCode) {
		this.plantCode = plantCode;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getFixtureID() {
		return fixtureID;
	}
	public void setFixtureID(String fixtureID) {
		this.fixtureID = fixtureID;
	}
	public String getTestResult() {
		return testResult;
	}
	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getFailDetailReason() {
		return failDetailReason;
	}
	public void setFailDetailReason(String failDetailReason) {
		this.failDetailReason = failDetailReason;
	}
	public String getTestDatatime() {
		return testDatatime;
	}
	public void setTestDatatime(String testDatatime) {
		this.testDatatime = testDatatime;
	}
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public String getDiag() {
		return diag;
	}
	public void setDiag(String diag) {
		this.diag = diag;
	}
	public String getCurStation() {
		return curStation;
	}
	public void setCurStation(String curStation) {
		this.curStation = curStation;
	}
	public String getLineName() {
		return lineName;
	}
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public String getField2() {
		return field2;
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
	public String getField3() {
		return field3;
	}
	public void setField3(String field3) {
		this.field3 = field3;
	}
	@Override
	public String toString() {
		return "UpdateSSNModel [plantCode=" + plantCode + ", ssn=" + ssn + ", fixtureID=" + fixtureID + ", testResult="
				+ testResult + ", errorCode=" + errorCode + ", failDetailReason=" + failDetailReason + ", testDatatime="
				+ testDatatime + ", empID=" + empID + ", diag=" + diag + ", curStation=" + curStation + ", lineName="
				+ lineName + ", field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}
	
	
}
