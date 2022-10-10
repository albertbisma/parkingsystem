package com.apps.parkingsystem.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ParkingLotRequest{	
	public ParkingLotRequest() {
		
	}
	
	public ParkingLotRequest(Integer idVehicleTypes, Long availableLot, Long filledLot) {
		this.idVehicleTypes = idVehicleTypes;
		this.availableLot = availableLot;
		this.filledLot = filledLot;
	}
	private Integer idVehicleTypes;
	private Long availableLot;
	private Long filledLot;
	
	public Integer getIdVehicleTypes() {
		return idVehicleTypes;
	}
	public void setIdVehicleTypes(Integer idVehicleTypes) {
		this.idVehicleTypes = idVehicleTypes;
	}
	public Long getAvailableLot() {
		return availableLot;
	}
	public void setAvailableLot(Long availableLot) {
		this.availableLot = availableLot;
	}
	public Long getFilledLot() {
		return filledLot;
	}
	public void setFilledLot(Long filledLot) {
		this.filledLot = filledLot;
	}
	
	
}
