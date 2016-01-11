package com.github.ivos.ws.it.upper;

import com.github.ivos.ws.it.shared.WsTestBase;
import org.junit.Test;

public class UpperIT extends WsTestBase {

	@Test
	public void test() {
		perform("request.xml", "response.xml");
	}

}
