package com.demo.basic_cache_with_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BasicCacheWithSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicCacheWithSpringbootApplication.class, args);
	}

}
