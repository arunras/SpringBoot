package com.lynda.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lynda.common.config.AppConfig;
import com.lynda.common.config.AppConfig.Worker;
import com.lynda.common.service.OrderService;

public class App {
	public static void main(String [] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Worker worker = context.getBean(Worker.class);
		worker.execute();
		
		OrderService orderService = context.getBean(OrderService.class);
	}
}
