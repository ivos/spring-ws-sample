package com.github.ivos.ws.upper;

import com.github.ivos.upper.schemas.UpperRequest;
import com.github.ivos.upper.schemas.UpperResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UpperEndpoint {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@PayloadRoot(namespace = "http://ivos.github.com/upper/schemas", localPart = "UpperRequest")
	@ResponsePayload
	public UpperResponse requestHoliday(@RequestPayload UpperRequest request) {
		UpperResponse response = new UpperResponse();
		response.setText(request.getText().toUpperCase());
		logger.info("For request {} returning response {}.", request, response);
		return response;
	}

}
