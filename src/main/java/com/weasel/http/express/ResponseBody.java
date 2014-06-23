/**
 * ResponseBody.java
 */
package com.weasel.http.express;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/**快递100返回的数据
 * @author Dylan
 * @time 2013-3-17
 */
@XStreamAlias("xml")
public class ResponseBody {

	/**
	 * 消息体
	 */
	private String message;
	
	/**
	 * 	查询结果状态： 
	 * 0：运单暂无结果， 
	 * 1：查询成功， 
	 * 2：接口出现异常， 
	 * 408：验证码出错（仅适用于APICode url)
	 */
	private int status;
	
	/**
	 * 快递单当前的状态 ：　 
	 * 0：在途中, 
	 * 1：已发货， 
	 * 2：疑难件， 
	 * 3：已签收， 
	 * 4：已退货。 
	 */
	private int state;
	
	private String nu;
	
	private String com;
	
	private String condition;
	
	private int ischeck;
	
	/**
	 * 数据集合
	 */
	private List<Data> data;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

	public String getNu() {
		return nu;
	}

	public void setNu(String nu) {
		this.nu = nu;
	}

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getIscheck() {
		return ischeck;
	}

	public void setIscheck(int ischeck) {
		this.ischeck = ischeck;
	}
	
}


