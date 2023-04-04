package com.example.wihao;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 为道
@EnableBatchProcessing
@SpringBootApplication
public class WihaoApplication {
	public static void main(String[] args) {
		SpringApplication.run(WihaoApplication.class, args);
	}
}
