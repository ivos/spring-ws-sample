package com.github.ivos.ws;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mycompany.hr.schemas.HolidayRequest;
import com.mycompany.hr.schemas.HolidayResponse;

@Endpoint
public class SampleEndpoint {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@PayloadRoot(namespace = "http://mycompany.com/hr/schemas", localPart = "HolidayRequest")
	@ResponsePayload
	public HolidayResponse requestHoliday(@RequestPayload HolidayRequest request) {
		HolidayResponse response = new HolidayResponse();
		response.setHolidayId(new BigInteger("12345"));
		response.setConfirmationToken(request.getEmployee().getLastName() + "_" + request.getHoliday().getStartDate()
				+ "_" + request.getHoliday().getEndDate());
		logger.info("For request {} returning response {}.", request, response);
		return response;
	}

}
