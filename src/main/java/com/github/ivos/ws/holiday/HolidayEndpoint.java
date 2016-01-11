package com.github.ivos.ws.holiday;

import com.github.ivos.hr.schemas.HolidayCancellationRequest;
import com.github.ivos.hr.schemas.HolidayRequest;
import com.github.ivos.hr.schemas.HolidayResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;

@Endpoint
public class HolidayEndpoint {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@PayloadRoot(namespace = "http://ivos.github.com/hr/schemas", localPart = "HolidayRequest")
	@ResponsePayload
	public HolidayResponse requestHoliday(@RequestPayload HolidayRequest request) {
		HolidayResponse response = buildHolidayResponse(
				request.getEmployee().getLastName(),
				request.getHoliday().getStartDate(),
				request.getHoliday().getEndDate(),
				false);
		logger.info("For request {} returning response {}.", request, response);
		return response;
	}

	@PayloadRoot(namespace = "http://ivos.github.com/hr/schemas", localPart = "HolidayCancellationRequest")
	@ResponsePayload
	public HolidayResponse cancelHoliday(@RequestPayload HolidayCancellationRequest request) {
		HolidayResponse response = buildHolidayResponse(
				request.getEmployee().getLastName(),
				request.getHoliday().getStartDate(),
				request.getHoliday().getEndDate(),
				true);
		logger.info("For request {} returning response {}.", request, response);
		return response;
	}

	private HolidayResponse buildHolidayResponse(
			String lastName, XMLGregorianCalendar startDate, XMLGregorianCalendar endDate,
			boolean cancellation) {
		HolidayResponse response = new HolidayResponse();
		response.setHolidayId(new BigInteger("12345"));
		String token = lastName + "_" + startDate + "_" + endDate;
		if (cancellation) {
			token = "Cancellation_" + token;
		}
		response.setConfirmationToken(token);
		return response;
	}

}
