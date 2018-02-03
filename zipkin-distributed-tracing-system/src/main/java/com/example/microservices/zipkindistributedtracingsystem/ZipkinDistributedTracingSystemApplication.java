package com.example.microservices.zipkindistributedtracingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

//@EnableDiscoveryClient
@SpringBootApplication
@EnableZipkinServer
public class ZipkinDistributedTracingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinDistributedTracingSystemApplication.class, args);
	}
}
