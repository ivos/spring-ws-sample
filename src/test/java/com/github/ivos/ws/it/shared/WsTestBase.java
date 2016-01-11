package com.github.ivos.ws.it.shared;

import com.github.ivos.ws.it.util.FileUtils;
import com.github.ivos.ws.it.util.XmlUtils;
import org.junit.Assert;
import org.junit.Before;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;

public class WsTestBase {

	private WebServiceTemplate template;

	@Before
	public void setUp() {
		template = new WebServiceTemplate();
	}

	public void perform(String request, String response) {
		StringSource source = new StringSource(FileUtils.load(this, request));
		StringResult result = new StringResult();
		template.sendSourceAndReceiveToResult("http://localhost:8080/spring-ws-sample/ws/", source, result);
		String responseContent = result.toString();
		Assert.assertEquals(XmlUtils.normalize(FileUtils.load(this, response)), XmlUtils.normalize(responseContent));
	}

}
