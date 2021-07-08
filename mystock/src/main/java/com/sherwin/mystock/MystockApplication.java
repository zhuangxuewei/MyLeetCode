package com.sherwin.mystock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Frank.Huang on 2016/4/19.
 */

@EnableScheduling
@SpringBootApplication(scanBasePackages = { "com.sherwin.mystock" })

public class MystockApplication {
	private static final Logger logger = LoggerFactory.getLogger(MystockApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MystockApplication.class, args);
	}
}
