package com.weasel.http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.weasel.helper.DocumentConverter;
import com.weasel.helper.JsonHelper;

/**
 * @author Dylan
 * @time 2015年9月24日
 */
public final class HttpClientSecretary {

	private final static CloseableHttpClient httpClient = HttpClients.createDefault();
	
	private HttpRequestBase request = null;
	
	public static HttpClientSecretary create(){
		return new HttpClientSecretary();
	}
	
	public HttpClientSecretary get(){
		
		request = new HttpGet();
		return this;
	}
	
	public HttpClientSecretary post(){
		
		request = new HttpPost();
		return this;
	}
	
	public HttpClientSecretary delete(){
		
		request = new HttpDelete();
		return this;
	}
	
	public HttpClientSecretary put(){
		
		request = new HttpPut();
		return this;
	}
	
	public HttpClientSecretary patch(){
	
		request = new HttpPatch();
		return this;
	}
	
	public HttpClientSecretary options(){
		
		request = new HttpOptions();
		return this;
	}
	
	public HttpClientSecretary trace(){
		
		request = new HttpTrace();
		return this;
	}
	
	public HttpClientSecretary withURI(String uri){
		try {
			this.request.setURI(new URI(uri));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public HttpClientSecretary addHeader(String name,String value){
		
		this.request.addHeader(name, value);
		return this;
	}
	
	public HttpClientSecretary withEntity(HttpEntity entity){
		
		if(this.request instanceof HttpEntityEnclosingRequestBase){
			((HttpEntityEnclosingRequestBase)request).setEntity(entity);
		}
		return this;
	}
	
	public HttpClientSecretary withStringEntity(Map<String,String> params){
		
		List<NameValuePair> _params = new ArrayList<>();
		
		params.forEach((k,v)->{
			
			NameValuePair param = new BasicNameValuePair(k, v);
			_params.add(param);
		});
		
		HttpEntity entity = new UrlEncodedFormEntity(_params,Consts.UTF_8);
		if(this.request instanceof HttpEntityEnclosingRequestBase){
			((HttpEntityEnclosingRequestBase)request).setEntity(entity);
		}
		
		return this;
	}
	
	public CloseableHttpResponse doIt(){
		
		try {
			CloseableHttpResponse response = httpClient.execute(this.request);
			return response;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public <T> T doItWithJson(final Class<T> clazz){
		
		try {
			return httpClient.execute(request, new ResponseHandler<T>() {

				@Override
				public T handleResponse(HttpResponse response)
						throws ClientProtocolException, IOException {
					
					final HttpEntity entity = response.getEntity();
					Charset charset = ContentType.getOrDefault(entity).getCharset();
					String json = EntityUtils.toString(entity, charset);
					return JsonHelper.fromJsonString(json, clazz);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public <T> T doItWithXml(final Class<T> clazz){
		
		try {
			return httpClient.execute(request, new ResponseHandler<T>() {

				@Override
				public T handleResponse(HttpResponse response)
						throws ClientProtocolException, IOException {
					
					final HttpEntity entity = response.getEntity();
					Charset charset = ContentType.getOrDefault(entity).getCharset();
					String xml = EntityUtils.toString(entity, charset);
					return DocumentConverter.xmlToEntity(xml, clazz);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * @param response
	 */
	public static void release(CloseableHttpResponse response){
		
		if(null == response){
			return;
		}
		
		final HttpEntity entity = response.getEntity();
        try {
			EntityUtils.consume(entity);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	private HttpClientSecretary(){}
}
