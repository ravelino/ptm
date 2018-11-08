/**
 * 
 */
package br.com.ravelino.ptm;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ravelino
 *
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {  

	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/cliente/v1/pagination?page=0&size=5");
    }
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/bootstrap/**", "/js/**")
                .addResourceLocations("classpath:/static/bootstrap/")
                .addResourceLocations("classpath:/static/js/");
    }

}
