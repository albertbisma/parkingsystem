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

import com.apps.parkingsystem.entity.PaymentMethods;
import com.apps.parkingsystem.model.GenericResponse;
import com.apps.parkingsystem.model.PaymentMethodsResponse;
import com.apps.parkingsystem.service.PaymentMethodsService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "Get Data Payment Methods By Id", tags = "Get Data Payment Methods By Id")
@RequestMapping("paymentMethods")
public class PaymentMethodsGetController {
	
	@Autowired
	private PaymentMethodsService paymentMethodsService;
	
	@GetMapping("")
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<PaymentMethodsResponse> getById(@RequestParam(required = false) Integer id){
		PaymentMethods paymentMethods = new PaymentMethods();
		PaymentMethodsResponse response = new PaymentMethodsResponse();
		
		if(id == null || StringUtils.isEmpty(id)) {
			return ResponseEntity.badRequest().body(generateResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), "Field id is mandatory."));
		}
		
		try {
			paymentMethods = paymentMethodsService.findById(id);
			
			response.setGenericResponse(null);
			response.setPaymentMethods(paymentMethods);
		} catch (NoSuchElementException e) {			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(generateResponse(HttpStatus.NOT_FOUND.getReasonPhrase(), "Data is not found."));
		}	
		
		return ResponseEntity.ok().body(response);
	}


	private PaymentMethodsResponse  generateResponse(String code, String message) {
		GenericResponse genericResponse = new GenericResponse();
		PaymentMethodsResponse response = new PaymentMethodsResponse();
		
		genericResponse.setResponseCode(code);
		genericResponse.setResponseDesc(message);
		
		response.setGenericResponse(genericResponse);
		
		return response;
	}			
}
