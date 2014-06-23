/**
 * HttpException.java
 */
package com.weasel.http.exception;

/**http方法执行异常
 * @author Dylan
 * @time 2013-3-16
 */
public class HttpMethodExecuteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HttpMethodExecuteException(String message) {
		super(message);
	}
	
}
