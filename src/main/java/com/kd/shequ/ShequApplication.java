package com.kd.shequ;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kd.shequ.mapper")
public class ShequApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShequApplication.class, args);
	}
}
