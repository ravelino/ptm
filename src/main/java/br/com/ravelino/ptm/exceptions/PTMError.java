/**
 * 
 */
package br.com.ravelino.ptm.exceptions;

/**
 * @author ravelino
 *
 */
public class PTMError {
	
	public static final String INTERNAL = "Ocorreu um erro inesperado.";
	
	private String message;
	
	
	public PTMError(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
