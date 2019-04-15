package com.alexura.baobao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
@MapperScan("com.alexura.baobao.mapper")
public class BaobaoApplication {



	public static void main(String[] args) {
		SpringApplication.run(BaobaoApplication.class, args);
	}



}
