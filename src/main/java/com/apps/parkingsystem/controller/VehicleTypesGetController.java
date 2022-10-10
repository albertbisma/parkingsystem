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

import com.apps.parkingsystem.entity.VehicleTypes;
import com.apps.parkingsystem.model.GenericResponse;
import com.apps.parkingsystem.model.VehicleTypesResponse;
import com.apps.parkingsystem.service.VehicleTypesService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "Get Data Vehicle Types By Id", tags = "Get Data Vehicle Types By Id")
@RequestMapping("vehicleTypes")
public class VehicleTypesGetController {
	
	@Autowired
	private VehicleTypesService vehicleTypesService;
	
	@GetMapping("")
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<VehicleTypesResponse> getById(@RequestParam(required = false) Integer id){
		VehicleTypes vehicleTypes = new VehicleTypes();
		VehicleTypesResponse response = new VehicleTypesResponse();
		
		if(id == null || StringUtils.isEmpty(id)) {
			return ResponseEntity.badRequest().body(generateResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), "Field id is mandatory."));
		}
		
		try {
			vehicleTypes = vehicleTypesService.findById(id);
			
			response.setGenericResponse(null);
			response.setVehicleTypes(vehicleTypes);
		} catch (NoSuchElementException e) {			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(generateResponse(HttpStatus.NOT_FOUND.getReasonPhrase(), "Data is not found."));
		}	
		
		return ResponseEntity.ok().body(response);
	}


	private VehicleTypesResponse  generateResponse(String code, String message) {
		GenericResponse genericResponse = new GenericResponse();
		VehicleTypesResponse response = new VehicleTypesResponse();
		
		genericResponse.setResponseCode(code);
		genericResponse.setResponseDesc(message);
		
		response.setGenericResponse(genericResponse);
		
		return response;
	}			
}
