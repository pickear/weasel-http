package com.weasel.http.handler;

import org.apache.http.client.methods.CloseableHttpResponse;

/**
 * @author Dylan
 * @time 2015年9月24日
 */
public interface UploadHandler {

	
	/**
	 * @param response
	 */
	public void handler(CloseableHttpResponse response);
	
}
