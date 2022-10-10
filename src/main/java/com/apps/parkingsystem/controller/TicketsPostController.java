package com.apps.parkingsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apps.parkingsystem.model.GenericResponse;
import com.apps.parkingsystem.model.TicketCheckOutRequest;
import com.apps.parkingsystem.model.TicketsRequest;
import com.apps.parkingsystem.model.TicketsResponse;
import com.apps.parkingsystem.service.TicketsService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "Generate Ticket With Method POST", tags = "Generate Ticket With Method POST")
@RequestMapping("Tickets")
public class TicketsPostController {
	
	@Autowired
	private TicketsService ticketsService;
	
	@PostMapping("CheckIn")
	public ResponseEntity<TicketsResponse> checkIn(@RequestBody TicketsRequest request){
		TicketsResponse response = new TicketsResponse();

		try {
			response = ticketsService.generateTicketCheckIn(request);
		} catch (Exception e) {			
			throw e;
		}			
		
		return ResponseEntity.status(HttpStatus.CREATED).body(generateResponse(HttpStatus.CREATED.getReasonPhrase(), "Ticket Generated Successfully", response));
	}
	
	@PostMapping("CheckOut")
	public ResponseEntity<TicketsResponse> checkOut(@RequestBody TicketCheckOutRequest request){
		TicketsResponse response = new TicketsResponse();

		try {
			response = ticketsService.generateTicketCheckOut(request);
		} catch (Exception e) {			
			throw e;
		}			
		
		return ResponseEntity.status(HttpStatus.CREATED).body(generateResponse(HttpStatus.CREATED.getReasonPhrase(), "Payment Successful", response));
	}

	private TicketsResponse generateResponse(String code, String message, TicketsResponse response) {
		GenericResponse genericResponse = new GenericResponse();
		
		genericResponse.setResponseCode(code);
		genericResponse.setResponseDesc(message);
		
		response.setGenericResponse(genericResponse);
		
		return response;
		
	}
}
