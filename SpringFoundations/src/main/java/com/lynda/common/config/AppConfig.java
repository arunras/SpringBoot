package com.lynda.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/application-${spring.profiles.active}.properties")
@ComponentScan(basePackages = {"com.lynda.common"})
public class AppConfig {
	private static int count;
	
	@Value("${greeting.preamble}")
	private String greetingPreamble;
	
	@Value("${greeting.text}")
	private String greetingText;
	
	@Value("#{new Boolean(environment['spring.profiles.active']=='dev')}")
	private boolean isDev;
	
	public class Worker {
		private String preamble;
		private String text;	
		
		public Worker(String preamble, String text) {
			this.preamble = preamble;
			this.text = text;
			System.out.println("New Instacne " + count);
			count = count + 1;
		}

		public void execute() {
			System.out.println(preamble + " " + text + " is dav: " + isDev);
		}
	}
	
	@Bean
	public Worker worker() {
		return new Worker(greetingPreamble, greetingText);
	}
 	
}
