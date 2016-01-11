package com.github.ivos.ws.it.holiday.cancellation;

import com.github.ivos.ws.it.shared.WsTestBase;
import org.junit.Test;

public class HolidayCancellationIT extends WsTestBase {

	@Test
	public void test() {
		perform("request.xml", "response.xml");
	}

}
