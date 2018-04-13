package org.foxconn.seagate.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class MatchXsdUtil {
	public static boolean validate(String schemaLocaltion, String xmlStr)throws SAXException, IOException,SAXParseException {
		if(null==xmlStr||"".equals(xmlStr)){
			return false;
		}
	    //获取Schema工厂类，
	    //这里的XMLConstants.W3C_XML_SCHEMA_NS_URI的值就是：
	    //http://www.w3.org/2001/XMLSchema
	    SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.XMLNS_ATTRIBUTE_NS_URI);
	    // Schema实例
	    Schema schema = null;
	    //获取xsd文件，以流的方式读取到Source中xsd文件的位置相对于类文件位置
	    Source schemaSource = new StreamSource(MatchXsdUtil.class.getResourceAsStream(schemaLocaltion));
	    //实例化Schema对象
	    schema = factory.newSchema(schemaSource);
	    //这里是将一个DOM树对象转换成流对象，以便对DOM树对象验证
	    ByteArrayInputStream bais = new ByteArrayInputStream(xmlStr.getBytes("UTF-8"));
	    // 获取验证器，验证器的XML Schema源就是之前创建的Schema
	    Validator validator = schema.newValidator();
	    Source source = new StreamSource(bais);
	    // 执行验证
	    validator.validate(source);
	    return true;
	}
	
	public static boolean validate(String xmlStr)throws Exception {
		validate("/match.xsd",xmlStr);
	    return true;
	}
	public static void main(String[] args) throws Exception {
		MatchXsdUtil util = new MatchXsdUtil();
		String basePath = util.getpath();
		System.out.println(basePath+"test.xml");
		BufferedReader in = new BufferedReader(new FileReader(basePath+"test1.xml"));
		String line = null;
		String str="";
		while((line = in.readLine())!=null)
		{
		 str+=line;
		}
		System.out.println(str);
		
		try {
			System.out.println(MatchXsdUtil.validate(str));
		} catch (SAXParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			if(null!=e.getCause()){
				System.out.println(e.getCause().getMessage());
			}
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			if(null!=e.getCause()){
				System.out.println(e.getCause().getMessage());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			if(null!=e.getCause()){
				System.out.println(e.getCause().getMessage());
			}
		}
	}
	private String getpath(){
		URL str = Thread.currentThread().getContextClassLoader().getResource("");
		System.out.println(str);
		String path= this.getClass().getResource("/").getPath();
		return str.toString();
	}
}
