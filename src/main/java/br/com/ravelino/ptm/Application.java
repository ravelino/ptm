/**
 * 
 */
package br.com.ravelino.ptm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author ravelino
 *
 */
@SpringBootApplication
@EnableJms
@EnableWebMvc
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
