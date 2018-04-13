package org.foxconn.seagate.util;

import java.util.Scanner;

/**
 * 加密和解密工具
 * @author Administrator
 *
 */
public class PasswordUtil {
	public static String  enCode(String inputStr){
		String encodeStr="";
		if(null==inputStr){
			inputStr="";
		}
		int indexAsc;
	    for(int i=0;i<inputStr.length();i++){
	    	indexAsc=inputStr.charAt(i);
	        if( indexAsc >32 && indexAsc <= 100){
	        	indexAsc = indexAsc + 22;
	        } else if( indexAsc > 100 && indexAsc <= 122){
	        	indexAsc = indexAsc - 100 + 32;
	        } 
	        encodeStr += (char)indexAsc;
	    }
	    return encodeStr;
	}
	public static String decode(String inputStr){
		if(null==inputStr){
			inputStr="";
		}
		String decodeStr="";
		int indexAsc;
	    for(int i=0;i< inputStr.length();i++){
	    	indexAsc=inputStr.charAt(i);
	        if (indexAsc > 54 && indexAsc <= 122){
	        	indexAsc = indexAsc - 22;
	        } else if(indexAsc > 32 && indexAsc <= 54 ){
	        	indexAsc = 100 + indexAsc - 32;
	        }
	        decodeStr  += String.valueOf((char)indexAsc);
	    }
	    return decodeStr;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("输入字符串");
		String str = scan.next();
		System.out.println("加密后："+enCode(str));
		System.out.println("解密后："+decode(str));
	}
}
