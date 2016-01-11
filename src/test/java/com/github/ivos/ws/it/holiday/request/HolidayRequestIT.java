package com.github.ivos.ws.it.holiday.request;

import com.github.ivos.ws.it.shared.WsTestBase;
import org.junit.Test;

public class HolidayRequestIT extends WsTestBase {

	@Test
	public void test() {
		perform("request.xml", "response.xml");
	}

}
