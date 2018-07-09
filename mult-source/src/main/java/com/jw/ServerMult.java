package com.jw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ServerMult {

	private static final Logger log = LoggerFactory.getLogger(ServerMult.class);

	public static void main(String[] args) {

		// SpringApplication.run(Server.class, args);//只是启动的话，此句与下边的一样

		SpringApplication app = new SpringApplication(ServerMult.class);

		Environment env = app.run(args).getEnvironment();
		log.info("\n----------------------------------------------------------\n\t"
				+ "Application {} is running! Access URLs:\n\t" + // 大括号1
				"Local: \t\thttp://localhost:{}\n\t" + // 大括号2
				"{}\n\t" + // 大括号3
				"\n----------------------------------------------------------",

		env.getProperty("spring.application.name"), // 大括号1对应的内容
				env.getProperty("server.port"), // 大括号2对应的内容
				"Thank You!"// 大括号3对应的内容

		);

	}
}
