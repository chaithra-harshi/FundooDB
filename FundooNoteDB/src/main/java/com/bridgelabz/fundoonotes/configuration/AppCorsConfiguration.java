package com.bridgelabz.fundoonotes.configuration;

/**
 * @CrossOrigin allows all origins, all headers, the HTTP methods specified in the.
 * CORS Filter is a generic solution for fitting Cross-Origin Resource Sharing (CORS) support to Java web applications. 
 *   CORS is a W3C standard for enabling cross-domain requests 
 *  from web browsers to servers and web APIs that opt in to handle them
 */
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
@Configuration
public class AppCorsConfiguration {
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	CorsConfiguration config = new CorsConfiguration();
	config.setAllowCredentials(true);
	config.addAllowedOrigin("*");
	config.addAllowedHeader("*");
	config.addAllowedMethod("*");
	source.registerCorsConfiguration("/**", config);
	FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
	bean.setOrder(0);
	return bean;
	}
}
