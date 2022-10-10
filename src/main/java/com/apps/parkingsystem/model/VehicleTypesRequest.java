package com.apps.parkingsystem.model;

public class VehicleTypesRequest{	
	
	private String vehicle;
	private Integer costPerHour;
	
	
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public Integer getCostPerHour() {
		return costPerHour;
	}
	public void setCostPerHour(Integer costPerHour) {
		this.costPerHour = costPerHour;
	}	
	
}
