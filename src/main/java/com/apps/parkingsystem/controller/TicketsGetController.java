package com.apps.parkingsystem.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.apps.parkingsystem.entity.Tickets;
import com.apps.parkingsystem.model.GenericResponse;
import com.apps.parkingsystem.model.TicketsResponse;
import com.apps.parkingsystem.service.TicketsService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "Get Data Tickets By Id", tags = "Get Data Tickets By Id")
@RequestMapping("tickets")
public class TicketsGetController {
	
	@Autowired
	private TicketsService ticketsService;
	
	@GetMapping("")
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<TicketsResponse> getById(@RequestParam(required = false) Integer id){
		Tickets tickets = new Tickets();
		TicketsResponse response = new TicketsResponse();
		
		if(id == null || StringUtils.isEmpty(id)) {
			return ResponseEntity.badRequest().body(generateResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), "Field id is mandatory."));
		}
		
		try {
			tickets = ticketsService.findById(id);
			
			response.setGenericResponse(null);
			response.setTickets(tickets);
		} catch (NoSuchElementException e) {			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(generateResponse(HttpStatus.NOT_FOUND.getReasonPhrase(), "Data is not found."));
		}	
		
		return ResponseEntity.ok().body(response);
	}


	private TicketsResponse  generateResponse(String code, String message) {
		GenericResponse genericResponse = new GenericResponse();
		TicketsResponse response = new TicketsResponse();
		
		genericResponse.setResponseCode(code);
		genericResponse.setResponseDesc(message);
		
		response.setGenericResponse(genericResponse);
		
		return response;
	}			
}
