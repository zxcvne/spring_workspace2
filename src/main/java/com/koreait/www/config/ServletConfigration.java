package com.koreait.www.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@ComponentScan(basePackages = {
		"com.koreait.www.controller",
		"com.koreait.www.service",
		"com.koreait.www.handler"
})
@EnableWebMvc
@EnableScheduling
@EnableAspectJAutoProxy // 트랜젝션 매니저
@Configuration
public class ServletConfigration implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 외부 경로 설정
		registry.addResourceHandler("/resources/**")
		.addResourceLocations("/resources/");
		// 파일이랑 실제 연결되는 경로는 경로 뒤에 \\ 추가
		registry.addResourceHandler("/upload/**")
		.addResourceLocations("file:///D:\\web_0826_nhs\\_myProject\\_java\\_fileUpload\\");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		
		registry.viewResolver(viewResolver);
	} 
	
	// 멀티파트 리졸버도 나중에 추가
	// 빈 이름이 반드시 multipartResolver 이어야 함
	@Bean(name = "multipartResolver")
	public MultipartResolver getMuliMultipartResolver() {
		StandardServletMultipartResolver multipartResolver = 
				new StandardServletMultipartResolver();		
		return multipartResolver;
	}
	
}
