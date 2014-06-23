/**
 * RequestParams.java
 */
package com.weasel.http.express;

/**传递给快递100的参数
 * @author Dylan
 * @time 2013-3-17
 */
public class RequestParams {

	/**
	 * 身份授权key
	 */
	private String id;
	
	/**
	 * 快递公司代码
	 */
	private String com;
	
	/**
	 * 要查询的快递单号
	 */
	private String nu;
	
	/**
	 * 查询快递的电话号码，目前只有佳吉物流需要这个参数，其他公司请忽略
	 */
	private String valicode;
	
	/**
	 * 返回类型： 
	 * 0：返回json字符串， 
     * 1：返回xml对象， 
     * 2：返回html对象， 
     * 3：返回text文本。 
     * 如果不填，默认返回json字符串。
	 */
	private String show;
	
	/**
	 * 	返回信息数量： 
	 * 1:返回多行完整的信息， 
	 * 0:只返回一行信息。 
	 * 不填默认返回多行。
	 */
	private String muti;
	
	/**
	 * 排序： 
	 * desc：按时间由新到旧排列， 
	 * asc：按时间由旧到新排列。 
	 * 不填默认返回倒序（大小写不敏感）
	 */
	private String order;

	public String getId() {
		return id;
	}

	public RequestParams setId(String id) {
		this.id = id;
		return this;
	}

	public String getCom() {
		return com;
	}

	public RequestParams setCom(String com) {
		this.com = com;
		return this;
	}

	public String getNu() {
		return nu;
	}

	public RequestParams setNu(String nu) {
		this.nu = nu;
		return this;
	}

	public String getValicode() {
		return valicode;
	}

	public RequestParams setValicode(String valicode) {
		this.valicode = valicode;
		return this;
	}

	public String getShow() {
		return show;
	}

	public RequestParams setShow(String show) {
		this.show = show;
		return this;
	}

	public String getMuti() {
		return muti;
	}

	public RequestParams setMuti(String muti) {
		this.muti = muti;
		return this;
	}

	public String getOrder() {
		return order;
	}

	public RequestParams setOrder(String order) {
		this.order = order;
		return this;
	}
	
	
}
