package com.apps.parkingsystem.model;

import java.util.List;

import com.apps.parkingsystem.entity.ParkingLot;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"GenericResponse", "parkingLot"})
@JsonInclude(Include.NON_NULL)
public class ParkingLotResponse extends BaseResponse{
	private ParkingLot parkingLot;
	private List<ParkingLot> parkingLotList;
	private Integer realTimeAvailableLot;

	public ParkingLot getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	public List<ParkingLot> getParkingLotList() {
		return parkingLotList;
	}

	public void setParkingLotList(List<ParkingLot> parkingLotList) {
		this.parkingLotList = parkingLotList;
	}

	public Integer getRealTimeAvailableLot() {
		return realTimeAvailableLot;
	}

	public void setRealTimeAvailableLot(Integer realTimeAvailableLot) {
		this.realTimeAvailableLot = realTimeAvailableLot;
	}	
	
}
