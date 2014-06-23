/**
 * Data.java
 */
package com.weasel.http.express;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/**
 * @author Dylan
 * @time 2013-3-17
 */
@XStreamAlias("data")
public class Data {


	/**
	 * 每条数据的时间
	 */
	private String time;
	
	/**
	 * 每条数据的状态
	 */
	private String context;


	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}
