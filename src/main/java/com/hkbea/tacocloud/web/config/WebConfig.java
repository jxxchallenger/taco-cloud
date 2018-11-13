package com.hkbea.tacocloud.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
   *      如果一个controller足够简单，什么也不做，就是跳转/转发到一个视图页面，可以使用这种方式配置。例如HomeController可以改成这种方式
 * @author Chen
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
		//registry.addViewController("/error").setViewName("error");
	}

	
}
