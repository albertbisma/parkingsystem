package com.apps.parkingsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apps.parkingsystem.model.GenericResponse;
import com.apps.parkingsystem.model.TicketPutRequest;
import com.apps.parkingsystem.model.TicketsResponse;
import com.apps.parkingsystem.service.TicketsService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "Update Data Tickets With Method PUT", tags = "Update Data Tickets With Method PUT")
@RequestMapping("tickets")
public class TicketsPutController {
	
	@Autowired
	private TicketsService ticketsService;
	
	@PutMapping("/checkOut/{id}")
	public ResponseEntity<TicketsResponse> update(@RequestBody TicketPutRequest request, @PathVariable Integer id){		
		
		try {
			ticketsService.update(request, id);
		} catch (Exception e) {			
			throw e;
		}			
		
		return ResponseEntity.status(HttpStatus.OK).body(generateResponse(HttpStatus.OK.getReasonPhrase(), "Data has been updated successfully"));
	}

	private TicketsResponse generateResponse(String code, String message) {
		GenericResponse genericResponse = new GenericResponse();
		TicketsResponse response = new TicketsResponse();
		
		genericResponse.setResponseCode(code);
		genericResponse.setResponseDesc(message);
		
		response.setGenericResponse(genericResponse);
		
		return response;
		
	}
}
