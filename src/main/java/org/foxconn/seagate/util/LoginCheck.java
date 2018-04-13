package org.foxconn.seagate.util;

import java.util.Iterator;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;
import org.apache.axis2.context.MessageContext;

public class LoginCheck {
	public static void checkUserPwd() throws AxisFault{
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
