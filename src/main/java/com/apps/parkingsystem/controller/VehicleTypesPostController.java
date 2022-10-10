package com.apps.parkingsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apps.parkingsystem.model.GenericResponse;
import com.apps.parkingsystem.model.VehicleTypesRequest;
import com.apps.parkingsystem.model.VehicleTypesResponse;
import com.apps.parkingsystem.service.VehicleTypesService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "Insert Data Vehicle Types With Method POST", tags = "Insert Data Vehicle Types With Method POST")
@RequestMapping("vehicleTypes")
public class VehicleTypesPostController {
	
	@Autowired
	private VehicleTypesService vehicleTypesService;
	
	@PostMapping("")
	public ResponseEntity<VehicleTypesResponse> insert(@RequestBody VehicleTypesRequest request){
		
		if(request.getVehicle().isEmpty()) {
			return ResponseEntity.badRequest().body(generateResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), "Field vehicle is mandatory."));
		}
		
		if (request.getCostPerHour() == null) {
			return ResponseEntity.badRequest().body(generateResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), "Field costPerHour is mandatory."));
		}
		
		try {
			vehicleTypesService.insert(request);
		} catch (Exception e) {			
			throw e;
		}			
		
		return ResponseEntity.status(HttpStatus.CREATED).body(generateResponse(HttpStatus.CREATED.getReasonPhrase(), "Data has been saved successfully"));
	}

	private VehicleTypesResponse generateResponse(String code, String message) {
		GenericResponse genericResponse = new GenericResponse();
		VehicleTypesResponse response = new VehicleTypesResponse();
		
		genericResponse.setResponseCode(code);
		genericResponse.setResponseDesc(message);
		
		response.setGenericResponse(genericResponse);
		
		return response;
		
	}
}
