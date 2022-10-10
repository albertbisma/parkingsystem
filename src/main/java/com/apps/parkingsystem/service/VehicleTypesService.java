package com.apps.parkingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps.parkingsystem.entity.VehicleTypes;
import com.apps.parkingsystem.model.VehicleTypesRequest;
import com.apps.parkingsystem.repository.VehicleTypesRepository;

@Service
public class VehicleTypesService {
	
	@Autowired
	private VehicleTypesRepository vehicleTypesRepository;
	
	public VehicleTypes findById(Integer id) {
		return vehicleTypesRepository.findById(id).get();
	}		
	
	public VehicleTypes insert(VehicleTypesRequest request) {
		return vehicleTypesRepository.save(new VehicleTypes(request.getVehicle(), request.getCostPerHour()));
	}
	
	public void delete(Integer id) {
		vehicleTypesRepository.deleteById(id);
	}
	
}
