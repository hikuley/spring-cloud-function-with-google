package com.kuleysoft.serverless;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class SpringCloudFunctionWithGoogleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFunctionWithGoogleApplication.class, args);
	}

	@Bean
	public Supplier<String> supplier() {
		return () -> "hello youtube";
	}

	@Bean
	public Function<String, String> function() {
		return input -> input;
	}

	@Bean
	public Consumer<String> consumer() {
		return input -> System.out.println(input);
	}

}
