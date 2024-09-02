package com.squad2.locadoradeveiculos.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = 
{"com.squad2.locadoradeveiculos.model", 
		"com.squad2.locadoradeveiculos.service", 
		"com.squad2.locadoradeveiculos.controller",
		"com.squad2.locadoradeveiculos.dao",
		"com.squad2.locadoradeveiculos.repository"})
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
