package com.weasel.http.handler;

import java.io.InputStream;

import org.apache.http.client.methods.CloseableHttpResponse;

/**
 * @author Dylan
 * @time 2015年9月24日
 */
public interface DownloadHandler {

	/**
	 * @param response
	 */
	public void handler(CloseableHttpResponse response,InputStream fileInputStream);
	
}
