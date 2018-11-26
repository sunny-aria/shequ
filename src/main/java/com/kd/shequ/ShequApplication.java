package com.kd.shequ;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@Configuration
//@EnableScheduling
@SpringBootApplication
@MapperScan("com.kd.shequ.mapper")
public class ShequApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShequApplication.class, args);
	}

	/**
	 * 文件上传配置
	 *
	 * @return
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//文件最大
		factory.setMaxFileSize(DataSize.parse("1024MB")); //KB,MB

		// 设置总上传数据总大小
		factory.setMaxRequestSize(DataSize.parse("1024MB"));
		return factory.createMultipartConfig();
	}
}