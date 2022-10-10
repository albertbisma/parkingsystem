package com.apps.parkingsystem.model;

import com.apps.parkingsystem.entity.ParkingLot;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"GenericResponse", "parkingLot"})
@JsonInclude(Include.NON_NULL)
public class ParkingLotResponse extends BaseResponse{
	private ParkingLot parkingLot;

	public ParkingLot getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}
	
	
}
