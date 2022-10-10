package com.apps.parkingsystem.model;

public class ParkingLotRequest{	
	
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
