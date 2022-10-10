package com.apps.parkingsystem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.apps.parkingsystem.entity.ParkingLot;
import com.apps.parkingsystem.model.GenericResponse;
import com.apps.parkingsystem.model.ParkingLotResponse;
import com.apps.parkingsystem.service.ParkingLotService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "Get Data Parking Lot", tags = "Get Data Parking Lot")
@RequestMapping("parkingLot")
public class ParkingLotGetController {
	
	@Autowired
	private ParkingLotService parkingLotService;
	
	@GetMapping("")
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<ParkingLotResponse> getById(@RequestParam(required = false) Integer id){
		ParkingLot parkingLot = new ParkingLot();
		ParkingLotResponse response = new ParkingLotResponse();
		
		if(id == null || StringUtils.isEmpty(id)) {
			return ResponseEntity.badRequest().body(generateResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), "Field id is mandatory."));
		}
		
		try {
			parkingLot = parkingLotService.findById(id);
			
			response.setGenericResponse(null);
			response.setParkingLot(parkingLot);
		} catch (NoSuchElementException e) {			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(generateResponse(HttpStatus.NOT_FOUND.getReasonPhrase(), "Data is not found."));
		}	
		
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("/All")
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<ParkingLotResponse> getAll(){
		List<ParkingLot> parkingLotList = new ArrayList<>();
		ParkingLotResponse response = new ParkingLotResponse();
		
		try {
			parkingLotList = parkingLotService.findAll();
			
			response.setGenericResponse(null);
			response.setParkingLotList(parkingLotList);
		} catch (NoSuchElementException e) {			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(generateResponse(HttpStatus.NOT_FOUND.getReasonPhrase(), "Data is not found."));
		}	
		
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("/{idVehicleTypes}")
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<ParkingLotResponse> getByIdVehicleTypes(@PathVariable Integer idVehicleTypes){
		ParkingLot parkingLot = new ParkingLot();
		ParkingLotResponse response = new ParkingLotResponse();
		
		if(idVehicleTypes == null) {
			return ResponseEntity.badRequest().body(generateResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), "Field idVehicleTypes is mandatory."));
		}
		
		try {
			parkingLot = parkingLotService.findByIdVehicleTypes(idVehicleTypes);
			
			response.setGenericResponse(null);
			response.setParkingLot(parkingLot);
		} catch (NoSuchElementException e) {			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(generateResponse(HttpStatus.NOT_FOUND.getReasonPhrase(), "Data is not found."));
		}	
		
		return ResponseEntity.ok().body(response);
	}


	private ParkingLotResponse  generateResponse(String code, String message) {
		GenericResponse genericResponse = new GenericResponse();
		ParkingLotResponse response = new ParkingLotResponse();
		
		genericResponse.setResponseCode(code);
		genericResponse.setResponseDesc(message);
		
		response.setGenericResponse(genericResponse);
		
		return response;
	}			
}
