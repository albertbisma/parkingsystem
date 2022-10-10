package com.apps.parkingsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apps.parkingsystem.model.GenericResponse;
import com.apps.parkingsystem.model.PaymentMethodsRequest;
import com.apps.parkingsystem.model.PaymentMethodsResponse;
import com.apps.parkingsystem.service.PaymentMethodsService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "Insert Data Payment Methods With Method POST", tags = "Insert Data Payment Methods With Method POST")
@RequestMapping("paymentMethods")
public class PaymentMethodsPostController {
	
	@Autowired
	private PaymentMethodsService paymentMethodsService;
	
	@PostMapping("")
	public ResponseEntity<PaymentMethodsResponse> insert(@RequestBody PaymentMethodsRequest request){
		
		if(request.getCode().isEmpty()) {
			return ResponseEntity.badRequest().body(generateResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), "Field code is mandatory."));
		}
		
		if (request.getDescription().isEmpty()) {
			return ResponseEntity.badRequest().body(generateResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), "Field description is mandatory."));
		}
		
		try {
			paymentMethodsService.insert(request);
		} catch (Exception e) {			
			throw e;
		}			
		
		return ResponseEntity.status(HttpStatus.CREATED).body(generateResponse(HttpStatus.CREATED.getReasonPhrase(), "Data has been saved successfully"));
	}

	private PaymentMethodsResponse generateResponse(String code, String message) {
		GenericResponse genericResponse = new GenericResponse();
		PaymentMethodsResponse response = new PaymentMethodsResponse();
		
		genericResponse.setResponseCode(code);
		genericResponse.setResponseDesc(message);
		
		response.setGenericResponse(genericResponse);
		
		return response;
		
	}
}
