/**
 * 
 */
package br.com.ravelino.ptm.exceptions;

import org.springframework.http.HttpStatus;

/**
 * @author ravelino
 *
 */
public class PTMException extends RuntimeException {
	
	private static final long serialVersionUID = 7573901541887755540L;

	private String message;
	
	private HttpStatus httpStatusCode;
	
	public PTMException(String message) {
		this.message = message;
	}

	public PTMException(String message, HttpStatus httpStatusCode) {
		this.message = message;
		this.httpStatusCode = httpStatusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(HttpStatus httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}
}
