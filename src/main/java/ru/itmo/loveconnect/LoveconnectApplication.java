package ru.itmo.loveconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LoveconnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoveconnectApplication.class, args);
	}

}
