package com.springaop.demo;

import com.springaop.demo.processor.PrintInterface;
import com.springaop.demo.processor.PrintLoop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Arrays;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AopDemoApplication implements CommandLineRunner{

	@Autowired
	private ApplicationContext appContext;

	@Autowired
	private PrintInterface obj;

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	public void run(String... args) throws Exception {

//		String[] beans = appContext.getBeanDefinitionNames();
		obj.printLoop();
	}
}
