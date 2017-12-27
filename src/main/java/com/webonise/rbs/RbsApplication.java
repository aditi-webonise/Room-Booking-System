package com.webonise.rbs;

import com.webonise.rbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/*@ComponentScan("com.webonise.rbs")*/
public class RbsApplication {

	public static void main(String[] args) {

		SpringApplication.run(RbsApplication.class, args);
	}
}
