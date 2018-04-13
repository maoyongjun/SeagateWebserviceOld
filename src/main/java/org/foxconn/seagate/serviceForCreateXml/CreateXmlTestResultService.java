package org.foxconn.seagate.serviceForCreateXml;

import org.apache.axis2.AxisFault;
import org.foxconn.seagate.entity.ResultMessage;

public interface CreateXmlTestResultService {
	public ResultMessage getAndCreateLocalXml(String strTransType,String strSSN,String stationName) ;
	public void checkUserPwd()  throws AxisFault;
	public String getXmlFromLocalDataBase(String strPlantCode, String strSSN, String strField1, String strField2, String strField3,
			String strLastEditBy,String stationName);
}
