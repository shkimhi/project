/**
 * 
 */
package com.spring_boot_mybatis.project;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author se
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/images/**")
	.addResourceLocations("file:///C:/springWorkspace/product_images/",
						  "file:///C:/springWorkspace/upload/",
			     "file:///usr/local/project/product_images/");
	
	registry.addResourceHandler("/audio/**")
	.addResourceLocations("file:///C:/springWorkspace/upload/");

}
}
