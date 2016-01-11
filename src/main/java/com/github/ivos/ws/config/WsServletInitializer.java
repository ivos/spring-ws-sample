package com.github.ivos.ws.config;

import org.springframework.ws.transport.http.support.AbstractAnnotationConfigMessageDispatcherServletInitializer;

public class WsServletInitializer extends AbstractAnnotationConfigMessageDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{WsConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[0];
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/ws", "*.wsdl"};
	}

}
