package com.apps.parkingsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apps.parkingsystem.model.GenericResponse;
import com.apps.parkingsystem.model.ParkingLotRequest;
import com.apps.parkingsystem.model.ParkingLotResponse;
import com.apps.parkingsystem.service.ParkingLotService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "Insert Data Parking Lot With Method POST", tags = "Insert Data Parking Lot With Method POST")
@RequestMapping("parkingLot")
public class ParkingLotPostController {
	
	@Autowired
	private ParkingLotService parkingLotService;
	
	@PostMapping("")
	public ResponseEntity<ParkingLotResponse> insert(@RequestBody ParkingLotRequest request){
		
		if(request.getAvailableLot() == null) {
			return ResponseEntity.badRequest().body(generateResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), "Field availableLot is mandatory."));
		}
		
		if (request.getFilledLot() == null) {
			return ResponseEntity.badRequest().body(generateResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), "Field filledLot is mandatory."));
		}
		
		try {
			parkingLotService.insert(request);
		} catch (Exception e) {			
			throw e;
		}			
		
		return ResponseEntity.status(HttpStatus.CREATED).body(generateResponse(HttpStatus.CREATED.getReasonPhrase(), "Data has been saved successfully"));
	}

	private ParkingLotResponse generateResponse(String code, String message) {
		GenericResponse genericResponse = new GenericResponse();
		ParkingLotResponse response = new ParkingLotResponse();
		
		genericResponse.setResponseCode(code);
		genericResponse.setResponseDesc(message);
		
		response.setGenericResponse(genericResponse);
		
		return response;
		
	}
}
