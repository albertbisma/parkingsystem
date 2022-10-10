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
import com.apps.parkingsystem.model.ParkingLotPutFilledLotRequest;
import com.apps.parkingsystem.model.ParkingLotResponse;
import com.apps.parkingsystem.service.ParkingLotService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "Update Data Parking Lot With Method PUT", tags = "Update Data Parking Lot With Method PUT")
@RequestMapping("parkingLot")
public class ParkingLotPutController {
	
	@Autowired
	private ParkingLotService parkingLotService;
	
	@PutMapping("/filledLot/{id}")
	public ResponseEntity<ParkingLotResponse> update(@RequestBody ParkingLotPutFilledLotRequest request, @PathVariable Integer id){		
		if (request.getFilledLot() == null) {
			return ResponseEntity.badRequest().body(generateResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), "Field filledLot is mandatory."));
		}
		
		try {
			parkingLotService.update(request, id);
		} catch (Exception e) {			
			throw e;
		}			
		
		return ResponseEntity.status(HttpStatus.OK).body(generateResponse(HttpStatus.OK.getReasonPhrase(), "Data has been updated successfully"));
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
