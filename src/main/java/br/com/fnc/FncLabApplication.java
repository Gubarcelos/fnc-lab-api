package br.com.fnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "br.com.fnc.config", "br.com.fnc.services","br.com.fnc.resources"})
public class FncLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(FncLabApplication.class, args);
	}

}
