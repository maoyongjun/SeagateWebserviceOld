package org.foxconn.seagate.client;

import org.springframework.stereotype.Component;

@Component
public class ClientMain {
	public static void main(String args[]) throws Exception {
//		 JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();  
//	        org.apache.cxf.endpoint.Client client = dcf.createClient("http://localhost:8080/webservice/services/Service1?wsdl");  
//	        //url为调用webService的wsdl地址  
//	        QName name=new QName("http://service.seagate.foxconn.org/","getSSNStatusByInput");  
//	        //namespace是命名空间，methodName是方法名  
//	        String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"  
//	                 + "     <strPlantCode>"  
//	                 + "     	sdfsd"  
//	                 + "     </strPlantCode>"  
//	                 + "     <strSSN>"  
//	                 + "       sdfdsf"  
//	                 + "     </strSSN>"  ;
//	        
//	        
//	        xmlStr="<?xml version=\"1.0\" encoding=\"UTF-8\"?>" 
//	        	  +"<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
//			      +"	<soap:Body>"
//			      +"  <GetSSNStatusByInput xmlns=\"http://tempuri.org/\">"
//			      +"    <strPlantCode>string</strPlantCode>"
//			      +"    <strSSN>string</strSSN>"
//			      +"  </GetSSNStatusByInput>"
//			      +"</soap:Body>"
//			      +"</soap:Envelope>";
//	        //paramvalue为参数值  
//	        Object[] objects=client.invoke(name,xmlStr);   
//	        //调用web Service//输出调用结果  
//	        System.out.println(objects[0].toString());  
    }
	public   void test(){
		System.out.println("test");
	}
}
