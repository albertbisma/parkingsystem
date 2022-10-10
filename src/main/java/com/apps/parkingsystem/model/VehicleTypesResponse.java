package com.apps.parkingsystem.model;

import com.apps.parkingsystem.entity.VehicleTypes;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"GenericResponse", "vehicleTypes"})
@JsonInclude(Include.NON_NULL)
public class VehicleTypesResponse extends BaseResponse{
	private VehicleTypes vehicleTypes;

	public VehicleTypes getVehicleTypes() {
		return vehicleTypes;
	}

	public void setVehicleTypes(VehicleTypes vehicleTypes) {
		this.vehicleTypes = vehicleTypes;
	}
	
}
