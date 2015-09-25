package com.weasel.http.helper;
/**
 * @author Dylan
 * @time 2015年9月24日
 */
public final class HttpStatusHelper {

	
	
	
	private HttpStatusHelper(){}
	
	
	public static boolean isOK(int statusCode){
		
		return statusCode == org.apache.http.HttpStatus.SC_OK;
	}
	
}
