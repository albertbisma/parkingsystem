package com.apps.parkingsystem.model;

public class ParkingLotPutFilledLotRequest{	
	public ParkingLotPutFilledLotRequest() {
		
	}
	
	public ParkingLotPutFilledLotRequest(Long filledLot) {
		this.filledLot = filledLot;
	}
	
	private Long filledLot;
	
	
	public Long getFilledLot() {
		return filledLot;
	}
	public void setFilledLot(Long filledLot) {
		this.filledLot = filledLot;
	}
	
	
}
