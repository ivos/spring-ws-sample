package com.github.ivos.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;

@Configuration
@ComponentScan("com.github.ivos.ws")
@EnableWs
public class WsConfig {

	@Bean
	public SimpleWsdl11Definition hr() {
		return new SimpleWsdl11Definition(new ClassPathResource("wsdl/hr.wsdl"));
	}

}
