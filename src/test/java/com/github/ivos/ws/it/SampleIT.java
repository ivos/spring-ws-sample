package com.github.ivos.ws.it;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;

import static org.junit.Assert.assertEquals;

public class SampleIT {

	private WebServiceTemplate template;

	@Before
	public void setUp() {
		template = new WebServiceTemplate();
	}


	@Test
	public void test() {
		StringSource source = new StringSource(FileUtils.load(this, "request.xml"));
		StringResult result = new StringResult();
		template.sendSourceAndReceiveToResult("http://localhost:8080/spring-ws-sample/ws/", source, result);
		String response = result.toString();
		assertEquals(XmlUtils.normalize(FileUtils.load(this, "response.xml")), XmlUtils.normalize(response));
	}

}
