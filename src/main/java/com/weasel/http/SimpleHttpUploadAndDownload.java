package com.weasel.http;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import com.weasel.http.handler.DownloadHandler;
import com.weasel.http.handler.UploadHandler;
import com.weasel.http.helper.HttpStatusHelper;


/**
 * @author Dylan
 * @time 2015年9月24日
 */
public final class SimpleHttpUploadAndDownload {

	
	
	/**
	 * @param uri
	 * @param file
	 * @param handler
	 */
	public static void upload(String uri,File file,UploadHandler handler){
		
		
		HttpEntity entity = MultipartEntityBuilder.create()
												  .addBinaryBody("upload_file", file)
												  .setCharset(Consts.UTF_8)
												  .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
												  .build();
		
		CloseableHttpResponse response = HttpClientSecretary.create()
															.post()
										    		        .withURI(uri)
										    		        .withEntity(entity)
										    		        .doIt();
		
		if(null != handler){
			handler.handler(response);
		}
		
		HttpClientSecretary.release(response);
	}
	
	
	
	/**
	 * @param uri
	 * @param handler
	 * @throws UnsupportedOperationException
	 * @throws IOException
	 */
	public static void download(String uri,DownloadHandler handler) throws UnsupportedOperationException, IOException{
		
		
		CloseableHttpResponse response = HttpClientSecretary.create()
														    .get()
													        .withURI(uri)
													        .doIt();
		
		
		if(HttpStatusHelper.isOK(response.getStatusLine().getStatusCode())){
			HttpEntity entity = response.getEntity();
			InputStream is = entity.getContent();
			if(null != handler){
				handler.handler(response,is);
			}
			is.close();
		}
		
		HttpClientSecretary.release(response);
	}
}
